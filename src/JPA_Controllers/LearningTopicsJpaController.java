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
import Entities.Curiosities;
import Entities.Questionnaires;
import Entities.StudyPrograms;
import Entities.LearningSubtopics;
import Entities.LearningTopics;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class LearningTopicsJpaController implements Serializable {

    public LearningTopicsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LearningTopics learningTopics) throws PreexistingEntityException, Exception {
        if (learningTopics.getLearningSubtopicsList() == null) {
            learningTopics.setLearningSubtopicsList(new ArrayList<LearningSubtopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curiosities curiosityCode = learningTopics.getCuriosityCode();
            if (curiosityCode != null) {
                curiosityCode = em.getReference(curiosityCode.getClass(), curiosityCode.getCuriosityCode());
                learningTopics.setCuriosityCode(curiosityCode);
            }
            Questionnaires questionnaireId = learningTopics.getQuestionnaireId();
            if (questionnaireId != null) {
                questionnaireId = em.getReference(questionnaireId.getClass(), questionnaireId.getQuestionnaireId());
                learningTopics.setQuestionnaireId(questionnaireId);
            }
            StudyPrograms studyProgramCode = learningTopics.getStudyProgramCode();
            if (studyProgramCode != null) {
                studyProgramCode = em.getReference(studyProgramCode.getClass(), studyProgramCode.getStudyProgramCode());
                learningTopics.setStudyProgramCode(studyProgramCode);
            }
            List<LearningSubtopics> attachedLearningSubtopicsList = new ArrayList<LearningSubtopics>();
            for (LearningSubtopics learningSubtopicsListLearningSubtopicsToAttach : learningTopics.getLearningSubtopicsList()) {
                learningSubtopicsListLearningSubtopicsToAttach = em.getReference(learningSubtopicsListLearningSubtopicsToAttach.getClass(), learningSubtopicsListLearningSubtopicsToAttach.getLearningSubId());
                attachedLearningSubtopicsList.add(learningSubtopicsListLearningSubtopicsToAttach);
            }
            learningTopics.setLearningSubtopicsList(attachedLearningSubtopicsList);
            em.persist(learningTopics);
            if (curiosityCode != null) {
                curiosityCode.getLearningTopicsList().add(learningTopics);
                curiosityCode = em.merge(curiosityCode);
            }
            if (questionnaireId != null) {
                questionnaireId.getLearningTopicsList().add(learningTopics);
                questionnaireId = em.merge(questionnaireId);
            }
            if (studyProgramCode != null) {
                studyProgramCode.getLearningTopicsList().add(learningTopics);
                studyProgramCode = em.merge(studyProgramCode);
            }
            for (LearningSubtopics learningSubtopicsListLearningSubtopics : learningTopics.getLearningSubtopicsList()) {
                LearningTopics oldLearningTopicCodeOfLearningSubtopicsListLearningSubtopics = learningSubtopicsListLearningSubtopics.getLearningTopicCode();
                learningSubtopicsListLearningSubtopics.setLearningTopicCode(learningTopics);
                learningSubtopicsListLearningSubtopics = em.merge(learningSubtopicsListLearningSubtopics);
                if (oldLearningTopicCodeOfLearningSubtopicsListLearningSubtopics != null) {
                    oldLearningTopicCodeOfLearningSubtopicsListLearningSubtopics.getLearningSubtopicsList().remove(learningSubtopicsListLearningSubtopics);
                    oldLearningTopicCodeOfLearningSubtopicsListLearningSubtopics = em.merge(oldLearningTopicCodeOfLearningSubtopicsListLearningSubtopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLearningTopics(learningTopics.getLearningTopicCode()) != null) {
                throw new PreexistingEntityException("LearningTopics " + learningTopics + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LearningTopics learningTopics) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningTopics persistentLearningTopics = em.find(LearningTopics.class, learningTopics.getLearningTopicCode());
            Curiosities curiosityCodeOld = persistentLearningTopics.getCuriosityCode();
            Curiosities curiosityCodeNew = learningTopics.getCuriosityCode();
            Questionnaires questionnaireIdOld = persistentLearningTopics.getQuestionnaireId();
            Questionnaires questionnaireIdNew = learningTopics.getQuestionnaireId();
            StudyPrograms studyProgramCodeOld = persistentLearningTopics.getStudyProgramCode();
            StudyPrograms studyProgramCodeNew = learningTopics.getStudyProgramCode();
            List<LearningSubtopics> learningSubtopicsListOld = persistentLearningTopics.getLearningSubtopicsList();
            List<LearningSubtopics> learningSubtopicsListNew = learningTopics.getLearningSubtopicsList();
            List<String> illegalOrphanMessages = null;
            for (LearningSubtopics learningSubtopicsListOldLearningSubtopics : learningSubtopicsListOld) {
                if (!learningSubtopicsListNew.contains(learningSubtopicsListOldLearningSubtopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LearningSubtopics " + learningSubtopicsListOldLearningSubtopics + " since its learningTopicCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (curiosityCodeNew != null) {
                curiosityCodeNew = em.getReference(curiosityCodeNew.getClass(), curiosityCodeNew.getCuriosityCode());
                learningTopics.setCuriosityCode(curiosityCodeNew);
            }
            if (questionnaireIdNew != null) {
                questionnaireIdNew = em.getReference(questionnaireIdNew.getClass(), questionnaireIdNew.getQuestionnaireId());
                learningTopics.setQuestionnaireId(questionnaireIdNew);
            }
            if (studyProgramCodeNew != null) {
                studyProgramCodeNew = em.getReference(studyProgramCodeNew.getClass(), studyProgramCodeNew.getStudyProgramCode());
                learningTopics.setStudyProgramCode(studyProgramCodeNew);
            }
            List<LearningSubtopics> attachedLearningSubtopicsListNew = new ArrayList<LearningSubtopics>();
            for (LearningSubtopics learningSubtopicsListNewLearningSubtopicsToAttach : learningSubtopicsListNew) {
                learningSubtopicsListNewLearningSubtopicsToAttach = em.getReference(learningSubtopicsListNewLearningSubtopicsToAttach.getClass(), learningSubtopicsListNewLearningSubtopicsToAttach.getLearningSubId());
                attachedLearningSubtopicsListNew.add(learningSubtopicsListNewLearningSubtopicsToAttach);
            }
            learningSubtopicsListNew = attachedLearningSubtopicsListNew;
            learningTopics.setLearningSubtopicsList(learningSubtopicsListNew);
            learningTopics = em.merge(learningTopics);
            if (curiosityCodeOld != null && !curiosityCodeOld.equals(curiosityCodeNew)) {
                curiosityCodeOld.getLearningTopicsList().remove(learningTopics);
                curiosityCodeOld = em.merge(curiosityCodeOld);
            }
            if (curiosityCodeNew != null && !curiosityCodeNew.equals(curiosityCodeOld)) {
                curiosityCodeNew.getLearningTopicsList().add(learningTopics);
                curiosityCodeNew = em.merge(curiosityCodeNew);
            }
            if (questionnaireIdOld != null && !questionnaireIdOld.equals(questionnaireIdNew)) {
                questionnaireIdOld.getLearningTopicsList().remove(learningTopics);
                questionnaireIdOld = em.merge(questionnaireIdOld);
            }
            if (questionnaireIdNew != null && !questionnaireIdNew.equals(questionnaireIdOld)) {
                questionnaireIdNew.getLearningTopicsList().add(learningTopics);
                questionnaireIdNew = em.merge(questionnaireIdNew);
            }
            if (studyProgramCodeOld != null && !studyProgramCodeOld.equals(studyProgramCodeNew)) {
                studyProgramCodeOld.getLearningTopicsList().remove(learningTopics);
                studyProgramCodeOld = em.merge(studyProgramCodeOld);
            }
            if (studyProgramCodeNew != null && !studyProgramCodeNew.equals(studyProgramCodeOld)) {
                studyProgramCodeNew.getLearningTopicsList().add(learningTopics);
                studyProgramCodeNew = em.merge(studyProgramCodeNew);
            }
            for (LearningSubtopics learningSubtopicsListNewLearningSubtopics : learningSubtopicsListNew) {
                if (!learningSubtopicsListOld.contains(learningSubtopicsListNewLearningSubtopics)) {
                    LearningTopics oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics = learningSubtopicsListNewLearningSubtopics.getLearningTopicCode();
                    learningSubtopicsListNewLearningSubtopics.setLearningTopicCode(learningTopics);
                    learningSubtopicsListNewLearningSubtopics = em.merge(learningSubtopicsListNewLearningSubtopics);
                    if (oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics != null && !oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics.equals(learningTopics)) {
                        oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics.getLearningSubtopicsList().remove(learningSubtopicsListNewLearningSubtopics);
                        oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics = em.merge(oldLearningTopicCodeOfLearningSubtopicsListNewLearningSubtopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = learningTopics.getLearningTopicCode();
                if (findLearningTopics(id) == null) {
                    throw new NonexistentEntityException("The learningTopics with id " + id + " no longer exists.");
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
            LearningTopics learningTopics;
            try {
                learningTopics = em.getReference(LearningTopics.class, id);
                learningTopics.getLearningTopicCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The learningTopics with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LearningSubtopics> learningSubtopicsListOrphanCheck = learningTopics.getLearningSubtopicsList();
            for (LearningSubtopics learningSubtopicsListOrphanCheckLearningSubtopics : learningSubtopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LearningTopics (" + learningTopics + ") cannot be destroyed since the LearningSubtopics " + learningSubtopicsListOrphanCheckLearningSubtopics + " in its learningSubtopicsList field has a non-nullable learningTopicCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Curiosities curiosityCode = learningTopics.getCuriosityCode();
            if (curiosityCode != null) {
                curiosityCode.getLearningTopicsList().remove(learningTopics);
                curiosityCode = em.merge(curiosityCode);
            }
            Questionnaires questionnaireId = learningTopics.getQuestionnaireId();
            if (questionnaireId != null) {
                questionnaireId.getLearningTopicsList().remove(learningTopics);
                questionnaireId = em.merge(questionnaireId);
            }
            StudyPrograms studyProgramCode = learningTopics.getStudyProgramCode();
            if (studyProgramCode != null) {
                studyProgramCode.getLearningTopicsList().remove(learningTopics);
                studyProgramCode = em.merge(studyProgramCode);
            }
            em.remove(learningTopics);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LearningTopics> findLearningTopicsEntities() {
        return findLearningTopicsEntities(true, -1, -1);
    }

    public List<LearningTopics> findLearningTopicsEntities(int maxResults, int firstResult) {
        return findLearningTopicsEntities(false, maxResults, firstResult);
    }

    private List<LearningTopics> findLearningTopicsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LearningTopics.class));
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

    public LearningTopics findLearningTopics(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LearningTopics.class, id);
        } finally {
            em.close();
        }
    }

    public int getLearningTopicsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LearningTopics> rt = cq.from(LearningTopics.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
