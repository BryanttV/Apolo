/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Questionnaires;
import Entities.Questions;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class QuestionsJpaController implements Serializable {

    public QuestionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Questions questions) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questionnaires questionnaireId = questions.getQuestionnaireId();
            if (questionnaireId != null) {
                questionnaireId = em.getReference(questionnaireId.getClass(), questionnaireId.getQuestionnaireId());
                questions.setQuestionnaireId(questionnaireId);
            }
            em.persist(questions);
            if (questionnaireId != null) {
                questionnaireId.getQuestionsList().add(questions);
                questionnaireId = em.merge(questionnaireId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findQuestions(questions.getQuestionId()) != null) {
                throw new PreexistingEntityException("Questions " + questions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Questions questions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questions persistentQuestions = em.find(Questions.class, questions.getQuestionId());
            Questionnaires questionnaireIdOld = persistentQuestions.getQuestionnaireId();
            Questionnaires questionnaireIdNew = questions.getQuestionnaireId();
            if (questionnaireIdNew != null) {
                questionnaireIdNew = em.getReference(questionnaireIdNew.getClass(), questionnaireIdNew.getQuestionnaireId());
                questions.setQuestionnaireId(questionnaireIdNew);
            }
            questions = em.merge(questions);
            if (questionnaireIdOld != null && !questionnaireIdOld.equals(questionnaireIdNew)) {
                questionnaireIdOld.getQuestionsList().remove(questions);
                questionnaireIdOld = em.merge(questionnaireIdOld);
            }
            if (questionnaireIdNew != null && !questionnaireIdNew.equals(questionnaireIdOld)) {
                questionnaireIdNew.getQuestionsList().add(questions);
                questionnaireIdNew = em.merge(questionnaireIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = questions.getQuestionId();
                if (findQuestions(id) == null) {
                    throw new NonexistentEntityException("The questions with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questions questions;
            try {
                questions = em.getReference(Questions.class, id);
                questions.getQuestionId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The questions with id " + id + " no longer exists.", enfe);
            }
            Questionnaires questionnaireId = questions.getQuestionnaireId();
            if (questionnaireId != null) {
                questionnaireId.getQuestionsList().remove(questions);
                questionnaireId = em.merge(questionnaireId);
            }
            em.remove(questions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Questions> findQuestionsEntities() {
        return findQuestionsEntities(true, -1, -1);
    }

    public List<Questions> findQuestionsEntities(int maxResults, int firstResult) {
        return findQuestionsEntities(false, maxResults, firstResult);
    }

    private List<Questions> findQuestionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Questions.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Questions findQuestions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Questions.class, id);
        } finally {
            em.close();
        }
    }

    public int getQuestionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Questions> rt = cq.from(Questions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
