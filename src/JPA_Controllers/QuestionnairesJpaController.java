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
import Entities.Questions;
import java.util.ArrayList;
import java.util.List;
import Entities.LearningTopics;
import Entities.Questionnaires;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class QuestionnairesJpaController implements Serializable {

    public QuestionnairesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Questionnaires questionnaires) throws PreexistingEntityException, Exception {
        if (questionnaires.getQuestionsList() == null) {
            questionnaires.setQuestionsList(new ArrayList<Questions>());
        }
        if (questionnaires.getLearningTopicsList() == null) {
            questionnaires.setLearningTopicsList(new ArrayList<LearningTopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Questions> attachedQuestionsList = new ArrayList<Questions>();
            for (Questions questionsListQuestionsToAttach : questionnaires.getQuestionsList()) {
                questionsListQuestionsToAttach = em.getReference(questionsListQuestionsToAttach.getClass(), questionsListQuestionsToAttach.getQuestionId());
                attachedQuestionsList.add(questionsListQuestionsToAttach);
            }
            questionnaires.setQuestionsList(attachedQuestionsList);
            List<LearningTopics> attachedLearningTopicsList = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListLearningTopicsToAttach : questionnaires.getLearningTopicsList()) {
                learningTopicsListLearningTopicsToAttach = em.getReference(learningTopicsListLearningTopicsToAttach.getClass(), learningTopicsListLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsList.add(learningTopicsListLearningTopicsToAttach);
            }
            questionnaires.setLearningTopicsList(attachedLearningTopicsList);
            em.persist(questionnaires);
            for (Questions questionsListQuestions : questionnaires.getQuestionsList()) {
                Questionnaires oldQuestionnaireIdOfQuestionsListQuestions = questionsListQuestions.getQuestionnaireId();
                questionsListQuestions.setQuestionnaireId(questionnaires);
                questionsListQuestions = em.merge(questionsListQuestions);
                if (oldQuestionnaireIdOfQuestionsListQuestions != null) {
                    oldQuestionnaireIdOfQuestionsListQuestions.getQuestionsList().remove(questionsListQuestions);
                    oldQuestionnaireIdOfQuestionsListQuestions = em.merge(oldQuestionnaireIdOfQuestionsListQuestions);
                }
            }
            for (LearningTopics learningTopicsListLearningTopics : questionnaires.getLearningTopicsList()) {
                Questionnaires oldQuestionnaireIdOfLearningTopicsListLearningTopics = learningTopicsListLearningTopics.getQuestionnaireId();
                learningTopicsListLearningTopics.setQuestionnaireId(questionnaires);
                learningTopicsListLearningTopics = em.merge(learningTopicsListLearningTopics);
                if (oldQuestionnaireIdOfLearningTopicsListLearningTopics != null) {
                    oldQuestionnaireIdOfLearningTopicsListLearningTopics.getLearningTopicsList().remove(learningTopicsListLearningTopics);
                    oldQuestionnaireIdOfLearningTopicsListLearningTopics = em.merge(oldQuestionnaireIdOfLearningTopicsListLearningTopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findQuestionnaires(questionnaires.getQuestionnaireId()) != null) {
                throw new PreexistingEntityException("Questionnaires " + questionnaires + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Questionnaires questionnaires) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questionnaires persistentQuestionnaires = em.find(Questionnaires.class, questionnaires.getQuestionnaireId());
            List<Questions> questionsListOld = persistentQuestionnaires.getQuestionsList();
            List<Questions> questionsListNew = questionnaires.getQuestionsList();
            List<LearningTopics> learningTopicsListOld = persistentQuestionnaires.getLearningTopicsList();
            List<LearningTopics> learningTopicsListNew = questionnaires.getLearningTopicsList();
            List<String> illegalOrphanMessages = null;
            for (Questions questionsListOldQuestions : questionsListOld) {
                if (!questionsListNew.contains(questionsListOldQuestions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Questions " + questionsListOldQuestions + " since its questionnaireId field is not nullable.");
                }
            }
            for (LearningTopics learningTopicsListOldLearningTopics : learningTopicsListOld) {
                if (!learningTopicsListNew.contains(learningTopicsListOldLearningTopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LearningTopics " + learningTopicsListOldLearningTopics + " since its questionnaireId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Questions> attachedQuestionsListNew = new ArrayList<Questions>();
            for (Questions questionsListNewQuestionsToAttach : questionsListNew) {
                questionsListNewQuestionsToAttach = em.getReference(questionsListNewQuestionsToAttach.getClass(), questionsListNewQuestionsToAttach.getQuestionId());
                attachedQuestionsListNew.add(questionsListNewQuestionsToAttach);
            }
            questionsListNew = attachedQuestionsListNew;
            questionnaires.setQuestionsList(questionsListNew);
            List<LearningTopics> attachedLearningTopicsListNew = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListNewLearningTopicsToAttach : learningTopicsListNew) {
                learningTopicsListNewLearningTopicsToAttach = em.getReference(learningTopicsListNewLearningTopicsToAttach.getClass(), learningTopicsListNewLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsListNew.add(learningTopicsListNewLearningTopicsToAttach);
            }
            learningTopicsListNew = attachedLearningTopicsListNew;
            questionnaires.setLearningTopicsList(learningTopicsListNew);
            questionnaires = em.merge(questionnaires);
            for (Questions questionsListNewQuestions : questionsListNew) {
                if (!questionsListOld.contains(questionsListNewQuestions)) {
                    Questionnaires oldQuestionnaireIdOfQuestionsListNewQuestions = questionsListNewQuestions.getQuestionnaireId();
                    questionsListNewQuestions.setQuestionnaireId(questionnaires);
                    questionsListNewQuestions = em.merge(questionsListNewQuestions);
                    if (oldQuestionnaireIdOfQuestionsListNewQuestions != null && !oldQuestionnaireIdOfQuestionsListNewQuestions.equals(questionnaires)) {
                        oldQuestionnaireIdOfQuestionsListNewQuestions.getQuestionsList().remove(questionsListNewQuestions);
                        oldQuestionnaireIdOfQuestionsListNewQuestions = em.merge(oldQuestionnaireIdOfQuestionsListNewQuestions);
                    }
                }
            }
            for (LearningTopics learningTopicsListNewLearningTopics : learningTopicsListNew) {
                if (!learningTopicsListOld.contains(learningTopicsListNewLearningTopics)) {
                    Questionnaires oldQuestionnaireIdOfLearningTopicsListNewLearningTopics = learningTopicsListNewLearningTopics.getQuestionnaireId();
                    learningTopicsListNewLearningTopics.setQuestionnaireId(questionnaires);
                    learningTopicsListNewLearningTopics = em.merge(learningTopicsListNewLearningTopics);
                    if (oldQuestionnaireIdOfLearningTopicsListNewLearningTopics != null && !oldQuestionnaireIdOfLearningTopicsListNewLearningTopics.equals(questionnaires)) {
                        oldQuestionnaireIdOfLearningTopicsListNewLearningTopics.getLearningTopicsList().remove(learningTopicsListNewLearningTopics);
                        oldQuestionnaireIdOfLearningTopicsListNewLearningTopics = em.merge(oldQuestionnaireIdOfLearningTopicsListNewLearningTopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = questionnaires.getQuestionnaireId();
                if (findQuestionnaires(id) == null) {
                    throw new NonexistentEntityException("The questionnaires with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Questionnaires questionnaires;
            try {
                questionnaires = em.getReference(Questionnaires.class, id);
                questionnaires.getQuestionnaireId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The questionnaires with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Questions> questionsListOrphanCheck = questionnaires.getQuestionsList();
            for (Questions questionsListOrphanCheckQuestions : questionsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Questionnaires (" + questionnaires + ") cannot be destroyed since the Questions " + questionsListOrphanCheckQuestions + " in its questionsList field has a non-nullable questionnaireId field.");
            }
            List<LearningTopics> learningTopicsListOrphanCheck = questionnaires.getLearningTopicsList();
            for (LearningTopics learningTopicsListOrphanCheckLearningTopics : learningTopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Questionnaires (" + questionnaires + ") cannot be destroyed since the LearningTopics " + learningTopicsListOrphanCheckLearningTopics + " in its learningTopicsList field has a non-nullable questionnaireId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(questionnaires);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Questionnaires> findQuestionnairesEntities() {
        return findQuestionnairesEntities(true, -1, -1);
    }

    public List<Questionnaires> findQuestionnairesEntities(int maxResults, int firstResult) {
        return findQuestionnairesEntities(false, maxResults, firstResult);
    }

    private List<Questionnaires> findQuestionnairesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Questionnaires.class));
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

    public Questionnaires findQuestionnaires(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Questionnaires.class, id);
        } finally {
            em.close();
        }
    }

    public int getQuestionnairesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Questionnaires> rt = cq.from(Questionnaires.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
