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
import Entities.StudyPrograms;
import java.util.ArrayList;
import java.util.List;
import Entities.HistoryPrograms;
import Entities.ProgrammingLanguages;
import Entities.Progress;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class ProgrammingLanguagesJpaController implements Serializable {

    public ProgrammingLanguagesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProgrammingLanguages programmingLanguages) {
        if (programmingLanguages.getStudyProgramsList() == null) {
            programmingLanguages.setStudyProgramsList(new ArrayList<StudyPrograms>());
        }
        if (programmingLanguages.getHistoryProgramsList() == null) {
            programmingLanguages.setHistoryProgramsList(new ArrayList<HistoryPrograms>());
        }
        if (programmingLanguages.getProgressList() == null) {
            programmingLanguages.setProgressList(new ArrayList<Progress>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<StudyPrograms> attachedStudyProgramsList = new ArrayList<StudyPrograms>();
            for (StudyPrograms studyProgramsListStudyProgramsToAttach : programmingLanguages.getStudyProgramsList()) {
                studyProgramsListStudyProgramsToAttach = em.getReference(studyProgramsListStudyProgramsToAttach.getClass(), studyProgramsListStudyProgramsToAttach.getStudyProgramCode());
                attachedStudyProgramsList.add(studyProgramsListStudyProgramsToAttach);
            }
            programmingLanguages.setStudyProgramsList(attachedStudyProgramsList);
            List<HistoryPrograms> attachedHistoryProgramsList = new ArrayList<HistoryPrograms>();
            for (HistoryPrograms historyProgramsListHistoryProgramsToAttach : programmingLanguages.getHistoryProgramsList()) {
                historyProgramsListHistoryProgramsToAttach = em.getReference(historyProgramsListHistoryProgramsToAttach.getClass(), historyProgramsListHistoryProgramsToAttach.getHistoryProgramCode());
                attachedHistoryProgramsList.add(historyProgramsListHistoryProgramsToAttach);
            }
            programmingLanguages.setHistoryProgramsList(attachedHistoryProgramsList);
            List<Progress> attachedProgressList = new ArrayList<Progress>();
            for (Progress progressListProgressToAttach : programmingLanguages.getProgressList()) {
                progressListProgressToAttach = em.getReference(progressListProgressToAttach.getClass(), progressListProgressToAttach.getRecordId());
                attachedProgressList.add(progressListProgressToAttach);
            }
            programmingLanguages.setProgressList(attachedProgressList);
            em.persist(programmingLanguages);
            for (StudyPrograms studyProgramsListStudyPrograms : programmingLanguages.getStudyProgramsList()) {
                ProgrammingLanguages oldLanguageIdOfStudyProgramsListStudyPrograms = studyProgramsListStudyPrograms.getLanguageId();
                studyProgramsListStudyPrograms.setLanguageId(programmingLanguages);
                studyProgramsListStudyPrograms = em.merge(studyProgramsListStudyPrograms);
                if (oldLanguageIdOfStudyProgramsListStudyPrograms != null) {
                    oldLanguageIdOfStudyProgramsListStudyPrograms.getStudyProgramsList().remove(studyProgramsListStudyPrograms);
                    oldLanguageIdOfStudyProgramsListStudyPrograms = em.merge(oldLanguageIdOfStudyProgramsListStudyPrograms);
                }
            }
            for (HistoryPrograms historyProgramsListHistoryPrograms : programmingLanguages.getHistoryProgramsList()) {
                ProgrammingLanguages oldLanguageIdOfHistoryProgramsListHistoryPrograms = historyProgramsListHistoryPrograms.getLanguageId();
                historyProgramsListHistoryPrograms.setLanguageId(programmingLanguages);
                historyProgramsListHistoryPrograms = em.merge(historyProgramsListHistoryPrograms);
                if (oldLanguageIdOfHistoryProgramsListHistoryPrograms != null) {
                    oldLanguageIdOfHistoryProgramsListHistoryPrograms.getHistoryProgramsList().remove(historyProgramsListHistoryPrograms);
                    oldLanguageIdOfHistoryProgramsListHistoryPrograms = em.merge(oldLanguageIdOfHistoryProgramsListHistoryPrograms);
                }
            }
            for (Progress progressListProgress : programmingLanguages.getProgressList()) {
                ProgrammingLanguages oldLanguageIdOfProgressListProgress = progressListProgress.getLanguageId();
                progressListProgress.setLanguageId(programmingLanguages);
                progressListProgress = em.merge(progressListProgress);
                if (oldLanguageIdOfProgressListProgress != null) {
                    oldLanguageIdOfProgressListProgress.getProgressList().remove(progressListProgress);
                    oldLanguageIdOfProgressListProgress = em.merge(oldLanguageIdOfProgressListProgress);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProgrammingLanguages programmingLanguages) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProgrammingLanguages persistentProgrammingLanguages = em.find(ProgrammingLanguages.class, programmingLanguages.getLanguageId());
            List<StudyPrograms> studyProgramsListOld = persistentProgrammingLanguages.getStudyProgramsList();
            List<StudyPrograms> studyProgramsListNew = programmingLanguages.getStudyProgramsList();
            List<HistoryPrograms> historyProgramsListOld = persistentProgrammingLanguages.getHistoryProgramsList();
            List<HistoryPrograms> historyProgramsListNew = programmingLanguages.getHistoryProgramsList();
            List<Progress> progressListOld = persistentProgrammingLanguages.getProgressList();
            List<Progress> progressListNew = programmingLanguages.getProgressList();
            List<String> illegalOrphanMessages = null;
            for (StudyPrograms studyProgramsListOldStudyPrograms : studyProgramsListOld) {
                if (!studyProgramsListNew.contains(studyProgramsListOldStudyPrograms)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain StudyPrograms " + studyProgramsListOldStudyPrograms + " since its languageId field is not nullable.");
                }
            }
            for (Progress progressListOldProgress : progressListOld) {
                if (!progressListNew.contains(progressListOldProgress)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Progress " + progressListOldProgress + " since its languageId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<StudyPrograms> attachedStudyProgramsListNew = new ArrayList<StudyPrograms>();
            for (StudyPrograms studyProgramsListNewStudyProgramsToAttach : studyProgramsListNew) {
                studyProgramsListNewStudyProgramsToAttach = em.getReference(studyProgramsListNewStudyProgramsToAttach.getClass(), studyProgramsListNewStudyProgramsToAttach.getStudyProgramCode());
                attachedStudyProgramsListNew.add(studyProgramsListNewStudyProgramsToAttach);
            }
            studyProgramsListNew = attachedStudyProgramsListNew;
            programmingLanguages.setStudyProgramsList(studyProgramsListNew);
            List<HistoryPrograms> attachedHistoryProgramsListNew = new ArrayList<HistoryPrograms>();
            for (HistoryPrograms historyProgramsListNewHistoryProgramsToAttach : historyProgramsListNew) {
                historyProgramsListNewHistoryProgramsToAttach = em.getReference(historyProgramsListNewHistoryProgramsToAttach.getClass(), historyProgramsListNewHistoryProgramsToAttach.getHistoryProgramCode());
                attachedHistoryProgramsListNew.add(historyProgramsListNewHistoryProgramsToAttach);
            }
            historyProgramsListNew = attachedHistoryProgramsListNew;
            programmingLanguages.setHistoryProgramsList(historyProgramsListNew);
            List<Progress> attachedProgressListNew = new ArrayList<Progress>();
            for (Progress progressListNewProgressToAttach : progressListNew) {
                progressListNewProgressToAttach = em.getReference(progressListNewProgressToAttach.getClass(), progressListNewProgressToAttach.getRecordId());
                attachedProgressListNew.add(progressListNewProgressToAttach);
            }
            progressListNew = attachedProgressListNew;
            programmingLanguages.setProgressList(progressListNew);
            programmingLanguages = em.merge(programmingLanguages);
            for (StudyPrograms studyProgramsListNewStudyPrograms : studyProgramsListNew) {
                if (!studyProgramsListOld.contains(studyProgramsListNewStudyPrograms)) {
                    ProgrammingLanguages oldLanguageIdOfStudyProgramsListNewStudyPrograms = studyProgramsListNewStudyPrograms.getLanguageId();
                    studyProgramsListNewStudyPrograms.setLanguageId(programmingLanguages);
                    studyProgramsListNewStudyPrograms = em.merge(studyProgramsListNewStudyPrograms);
                    if (oldLanguageIdOfStudyProgramsListNewStudyPrograms != null && !oldLanguageIdOfStudyProgramsListNewStudyPrograms.equals(programmingLanguages)) {
                        oldLanguageIdOfStudyProgramsListNewStudyPrograms.getStudyProgramsList().remove(studyProgramsListNewStudyPrograms);
                        oldLanguageIdOfStudyProgramsListNewStudyPrograms = em.merge(oldLanguageIdOfStudyProgramsListNewStudyPrograms);
                    }
                }
            }
            for (HistoryPrograms historyProgramsListOldHistoryPrograms : historyProgramsListOld) {
                if (!historyProgramsListNew.contains(historyProgramsListOldHistoryPrograms)) {
                    historyProgramsListOldHistoryPrograms.setLanguageId(null);
                    historyProgramsListOldHistoryPrograms = em.merge(historyProgramsListOldHistoryPrograms);
                }
            }
            for (HistoryPrograms historyProgramsListNewHistoryPrograms : historyProgramsListNew) {
                if (!historyProgramsListOld.contains(historyProgramsListNewHistoryPrograms)) {
                    ProgrammingLanguages oldLanguageIdOfHistoryProgramsListNewHistoryPrograms = historyProgramsListNewHistoryPrograms.getLanguageId();
                    historyProgramsListNewHistoryPrograms.setLanguageId(programmingLanguages);
                    historyProgramsListNewHistoryPrograms = em.merge(historyProgramsListNewHistoryPrograms);
                    if (oldLanguageIdOfHistoryProgramsListNewHistoryPrograms != null && !oldLanguageIdOfHistoryProgramsListNewHistoryPrograms.equals(programmingLanguages)) {
                        oldLanguageIdOfHistoryProgramsListNewHistoryPrograms.getHistoryProgramsList().remove(historyProgramsListNewHistoryPrograms);
                        oldLanguageIdOfHistoryProgramsListNewHistoryPrograms = em.merge(oldLanguageIdOfHistoryProgramsListNewHistoryPrograms);
                    }
                }
            }
            for (Progress progressListNewProgress : progressListNew) {
                if (!progressListOld.contains(progressListNewProgress)) {
                    ProgrammingLanguages oldLanguageIdOfProgressListNewProgress = progressListNewProgress.getLanguageId();
                    progressListNewProgress.setLanguageId(programmingLanguages);
                    progressListNewProgress = em.merge(progressListNewProgress);
                    if (oldLanguageIdOfProgressListNewProgress != null && !oldLanguageIdOfProgressListNewProgress.equals(programmingLanguages)) {
                        oldLanguageIdOfProgressListNewProgress.getProgressList().remove(progressListNewProgress);
                        oldLanguageIdOfProgressListNewProgress = em.merge(oldLanguageIdOfProgressListNewProgress);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = programmingLanguages.getLanguageId();
                if (findProgrammingLanguages(id) == null) {
                    throw new NonexistentEntityException("The programmingLanguages with id " + id + " no longer exists.");
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
            ProgrammingLanguages programmingLanguages;
            try {
                programmingLanguages = em.getReference(ProgrammingLanguages.class, id);
                programmingLanguages.getLanguageId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The programmingLanguages with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<StudyPrograms> studyProgramsListOrphanCheck = programmingLanguages.getStudyProgramsList();
            for (StudyPrograms studyProgramsListOrphanCheckStudyPrograms : studyProgramsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ProgrammingLanguages (" + programmingLanguages + ") cannot be destroyed since the StudyPrograms " + studyProgramsListOrphanCheckStudyPrograms + " in its studyProgramsList field has a non-nullable languageId field.");
            }
            List<Progress> progressListOrphanCheck = programmingLanguages.getProgressList();
            for (Progress progressListOrphanCheckProgress : progressListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ProgrammingLanguages (" + programmingLanguages + ") cannot be destroyed since the Progress " + progressListOrphanCheckProgress + " in its progressList field has a non-nullable languageId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<HistoryPrograms> historyProgramsList = programmingLanguages.getHistoryProgramsList();
            for (HistoryPrograms historyProgramsListHistoryPrograms : historyProgramsList) {
                historyProgramsListHistoryPrograms.setLanguageId(null);
                historyProgramsListHistoryPrograms = em.merge(historyProgramsListHistoryPrograms);
            }
            em.remove(programmingLanguages);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProgrammingLanguages> findProgrammingLanguagesEntities() {
        return findProgrammingLanguagesEntities(true, -1, -1);
    }

    public List<ProgrammingLanguages> findProgrammingLanguagesEntities(int maxResults, int firstResult) {
        return findProgrammingLanguagesEntities(false, maxResults, firstResult);
    }

    private List<ProgrammingLanguages> findProgrammingLanguagesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProgrammingLanguages.class));
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

    public ProgrammingLanguages findProgrammingLanguages(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProgrammingLanguages.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgrammingLanguagesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProgrammingLanguages> rt = cq.from(ProgrammingLanguages.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
