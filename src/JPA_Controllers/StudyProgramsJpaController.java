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
import Entities.ProgrammingLanguages;
import Entities.LearningTopics;
import Entities.StudyPrograms;
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
public class StudyProgramsJpaController implements Serializable {

    public StudyProgramsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StudyPrograms studyPrograms) throws PreexistingEntityException, Exception {
        if (studyPrograms.getLearningTopicsList() == null) {
            studyPrograms.setLearningTopicsList(new ArrayList<LearningTopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProgrammingLanguages languageId = studyPrograms.getLanguageId();
            if (languageId != null) {
                languageId = em.getReference(languageId.getClass(), languageId.getLanguageId());
                studyPrograms.setLanguageId(languageId);
            }
            List<LearningTopics> attachedLearningTopicsList = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListLearningTopicsToAttach : studyPrograms.getLearningTopicsList()) {
                learningTopicsListLearningTopicsToAttach = em.getReference(learningTopicsListLearningTopicsToAttach.getClass(), learningTopicsListLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsList.add(learningTopicsListLearningTopicsToAttach);
            }
            studyPrograms.setLearningTopicsList(attachedLearningTopicsList);
            em.persist(studyPrograms);
            if (languageId != null) {
                languageId.getStudyProgramsList().add(studyPrograms);
                languageId = em.merge(languageId);
            }
            for (LearningTopics learningTopicsListLearningTopics : studyPrograms.getLearningTopicsList()) {
                StudyPrograms oldStudyProgramCodeOfLearningTopicsListLearningTopics = learningTopicsListLearningTopics.getStudyProgramCode();
                learningTopicsListLearningTopics.setStudyProgramCode(studyPrograms);
                learningTopicsListLearningTopics = em.merge(learningTopicsListLearningTopics);
                if (oldStudyProgramCodeOfLearningTopicsListLearningTopics != null) {
                    oldStudyProgramCodeOfLearningTopicsListLearningTopics.getLearningTopicsList().remove(learningTopicsListLearningTopics);
                    oldStudyProgramCodeOfLearningTopicsListLearningTopics = em.merge(oldStudyProgramCodeOfLearningTopicsListLearningTopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStudyPrograms(studyPrograms.getStudyProgramCode()) != null) {
                throw new PreexistingEntityException("StudyPrograms " + studyPrograms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StudyPrograms studyPrograms) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StudyPrograms persistentStudyPrograms = em.find(StudyPrograms.class, studyPrograms.getStudyProgramCode());
            ProgrammingLanguages languageIdOld = persistentStudyPrograms.getLanguageId();
            ProgrammingLanguages languageIdNew = studyPrograms.getLanguageId();
            List<LearningTopics> learningTopicsListOld = persistentStudyPrograms.getLearningTopicsList();
            List<LearningTopics> learningTopicsListNew = studyPrograms.getLearningTopicsList();
            List<String> illegalOrphanMessages = null;
            for (LearningTopics learningTopicsListOldLearningTopics : learningTopicsListOld) {
                if (!learningTopicsListNew.contains(learningTopicsListOldLearningTopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LearningTopics " + learningTopicsListOldLearningTopics + " since its studyProgramCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (languageIdNew != null) {
                languageIdNew = em.getReference(languageIdNew.getClass(), languageIdNew.getLanguageId());
                studyPrograms.setLanguageId(languageIdNew);
            }
            List<LearningTopics> attachedLearningTopicsListNew = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListNewLearningTopicsToAttach : learningTopicsListNew) {
                learningTopicsListNewLearningTopicsToAttach = em.getReference(learningTopicsListNewLearningTopicsToAttach.getClass(), learningTopicsListNewLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsListNew.add(learningTopicsListNewLearningTopicsToAttach);
            }
            learningTopicsListNew = attachedLearningTopicsListNew;
            studyPrograms.setLearningTopicsList(learningTopicsListNew);
            studyPrograms = em.merge(studyPrograms);
            if (languageIdOld != null && !languageIdOld.equals(languageIdNew)) {
                languageIdOld.getStudyProgramsList().remove(studyPrograms);
                languageIdOld = em.merge(languageIdOld);
            }
            if (languageIdNew != null && !languageIdNew.equals(languageIdOld)) {
                languageIdNew.getStudyProgramsList().add(studyPrograms);
                languageIdNew = em.merge(languageIdNew);
            }
            for (LearningTopics learningTopicsListNewLearningTopics : learningTopicsListNew) {
                if (!learningTopicsListOld.contains(learningTopicsListNewLearningTopics)) {
                    StudyPrograms oldStudyProgramCodeOfLearningTopicsListNewLearningTopics = learningTopicsListNewLearningTopics.getStudyProgramCode();
                    learningTopicsListNewLearningTopics.setStudyProgramCode(studyPrograms);
                    learningTopicsListNewLearningTopics = em.merge(learningTopicsListNewLearningTopics);
                    if (oldStudyProgramCodeOfLearningTopicsListNewLearningTopics != null && !oldStudyProgramCodeOfLearningTopicsListNewLearningTopics.equals(studyPrograms)) {
                        oldStudyProgramCodeOfLearningTopicsListNewLearningTopics.getLearningTopicsList().remove(learningTopicsListNewLearningTopics);
                        oldStudyProgramCodeOfLearningTopicsListNewLearningTopics = em.merge(oldStudyProgramCodeOfLearningTopicsListNewLearningTopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = studyPrograms.getStudyProgramCode();
                if (findStudyPrograms(id) == null) {
                    throw new NonexistentEntityException("The studyPrograms with id " + id + " no longer exists.");
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
            StudyPrograms studyPrograms;
            try {
                studyPrograms = em.getReference(StudyPrograms.class, id);
                studyPrograms.getStudyProgramCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The studyPrograms with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LearningTopics> learningTopicsListOrphanCheck = studyPrograms.getLearningTopicsList();
            for (LearningTopics learningTopicsListOrphanCheckLearningTopics : learningTopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This StudyPrograms (" + studyPrograms + ") cannot be destroyed since the LearningTopics " + learningTopicsListOrphanCheckLearningTopics + " in its learningTopicsList field has a non-nullable studyProgramCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ProgrammingLanguages languageId = studyPrograms.getLanguageId();
            if (languageId != null) {
                languageId.getStudyProgramsList().remove(studyPrograms);
                languageId = em.merge(languageId);
            }
            em.remove(studyPrograms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StudyPrograms> findStudyProgramsEntities() {
        return findStudyProgramsEntities(true, -1, -1);
    }

    public List<StudyPrograms> findStudyProgramsEntities(int maxResults, int firstResult) {
        return findStudyProgramsEntities(false, maxResults, firstResult);
    }

    private List<StudyPrograms> findStudyProgramsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StudyPrograms.class));
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

    public StudyPrograms findStudyPrograms(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StudyPrograms.class, id);
        } finally {
            em.close();
        }
    }

    public int getStudyProgramsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StudyPrograms> rt = cq.from(StudyPrograms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
