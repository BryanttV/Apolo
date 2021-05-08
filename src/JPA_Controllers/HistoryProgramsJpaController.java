/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.HistoryPrograms;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.ProgrammingLanguages;
import Entities.HistoryTopics;
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
public class HistoryProgramsJpaController implements Serializable {

    public HistoryProgramsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoryPrograms historyPrograms) throws PreexistingEntityException, Exception {
        if (historyPrograms.getHistoryTopicsList() == null) {
            historyPrograms.setHistoryTopicsList(new ArrayList<HistoryTopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProgrammingLanguages languageId = historyPrograms.getLanguageId();
            if (languageId != null) {
                languageId = em.getReference(languageId.getClass(), languageId.getLanguageId());
                historyPrograms.setLanguageId(languageId);
            }
            List<HistoryTopics> attachedHistoryTopicsList = new ArrayList<HistoryTopics>();
            for (HistoryTopics historyTopicsListHistoryTopicsToAttach : historyPrograms.getHistoryTopicsList()) {
                historyTopicsListHistoryTopicsToAttach = em.getReference(historyTopicsListHistoryTopicsToAttach.getClass(), historyTopicsListHistoryTopicsToAttach.getHistoryTopicCode());
                attachedHistoryTopicsList.add(historyTopicsListHistoryTopicsToAttach);
            }
            historyPrograms.setHistoryTopicsList(attachedHistoryTopicsList);
            em.persist(historyPrograms);
            if (languageId != null) {
                languageId.getHistoryProgramsList().add(historyPrograms);
                languageId = em.merge(languageId);
            }
            for (HistoryTopics historyTopicsListHistoryTopics : historyPrograms.getHistoryTopicsList()) {
                HistoryPrograms oldHistoryProgramCodeOfHistoryTopicsListHistoryTopics = historyTopicsListHistoryTopics.getHistoryProgramCode();
                historyTopicsListHistoryTopics.setHistoryProgramCode(historyPrograms);
                historyTopicsListHistoryTopics = em.merge(historyTopicsListHistoryTopics);
                if (oldHistoryProgramCodeOfHistoryTopicsListHistoryTopics != null) {
                    oldHistoryProgramCodeOfHistoryTopicsListHistoryTopics.getHistoryTopicsList().remove(historyTopicsListHistoryTopics);
                    oldHistoryProgramCodeOfHistoryTopicsListHistoryTopics = em.merge(oldHistoryProgramCodeOfHistoryTopicsListHistoryTopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoryPrograms(historyPrograms.getHistoryProgramCode()) != null) {
                throw new PreexistingEntityException("HistoryPrograms " + historyPrograms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoryPrograms historyPrograms) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistoryPrograms persistentHistoryPrograms = em.find(HistoryPrograms.class, historyPrograms.getHistoryProgramCode());
            ProgrammingLanguages languageIdOld = persistentHistoryPrograms.getLanguageId();
            ProgrammingLanguages languageIdNew = historyPrograms.getLanguageId();
            List<HistoryTopics> historyTopicsListOld = persistentHistoryPrograms.getHistoryTopicsList();
            List<HistoryTopics> historyTopicsListNew = historyPrograms.getHistoryTopicsList();
            List<String> illegalOrphanMessages = null;
            for (HistoryTopics historyTopicsListOldHistoryTopics : historyTopicsListOld) {
                if (!historyTopicsListNew.contains(historyTopicsListOldHistoryTopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistoryTopics " + historyTopicsListOldHistoryTopics + " since its historyProgramCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (languageIdNew != null) {
                languageIdNew = em.getReference(languageIdNew.getClass(), languageIdNew.getLanguageId());
                historyPrograms.setLanguageId(languageIdNew);
            }
            List<HistoryTopics> attachedHistoryTopicsListNew = new ArrayList<HistoryTopics>();
            for (HistoryTopics historyTopicsListNewHistoryTopicsToAttach : historyTopicsListNew) {
                historyTopicsListNewHistoryTopicsToAttach = em.getReference(historyTopicsListNewHistoryTopicsToAttach.getClass(), historyTopicsListNewHistoryTopicsToAttach.getHistoryTopicCode());
                attachedHistoryTopicsListNew.add(historyTopicsListNewHistoryTopicsToAttach);
            }
            historyTopicsListNew = attachedHistoryTopicsListNew;
            historyPrograms.setHistoryTopicsList(historyTopicsListNew);
            historyPrograms = em.merge(historyPrograms);
            if (languageIdOld != null && !languageIdOld.equals(languageIdNew)) {
                languageIdOld.getHistoryProgramsList().remove(historyPrograms);
                languageIdOld = em.merge(languageIdOld);
            }
            if (languageIdNew != null && !languageIdNew.equals(languageIdOld)) {
                languageIdNew.getHistoryProgramsList().add(historyPrograms);
                languageIdNew = em.merge(languageIdNew);
            }
            for (HistoryTopics historyTopicsListNewHistoryTopics : historyTopicsListNew) {
                if (!historyTopicsListOld.contains(historyTopicsListNewHistoryTopics)) {
                    HistoryPrograms oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics = historyTopicsListNewHistoryTopics.getHistoryProgramCode();
                    historyTopicsListNewHistoryTopics.setHistoryProgramCode(historyPrograms);
                    historyTopicsListNewHistoryTopics = em.merge(historyTopicsListNewHistoryTopics);
                    if (oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics != null && !oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics.equals(historyPrograms)) {
                        oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics.getHistoryTopicsList().remove(historyTopicsListNewHistoryTopics);
                        oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics = em.merge(oldHistoryProgramCodeOfHistoryTopicsListNewHistoryTopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historyPrograms.getHistoryProgramCode();
                if (findHistoryPrograms(id) == null) {
                    throw new NonexistentEntityException("The historyPrograms with id " + id + " no longer exists.");
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
            HistoryPrograms historyPrograms;
            try {
                historyPrograms = em.getReference(HistoryPrograms.class, id);
                historyPrograms.getHistoryProgramCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historyPrograms with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<HistoryTopics> historyTopicsListOrphanCheck = historyPrograms.getHistoryTopicsList();
            for (HistoryTopics historyTopicsListOrphanCheckHistoryTopics : historyTopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This HistoryPrograms (" + historyPrograms + ") cannot be destroyed since the HistoryTopics " + historyTopicsListOrphanCheckHistoryTopics + " in its historyTopicsList field has a non-nullable historyProgramCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ProgrammingLanguages languageId = historyPrograms.getLanguageId();
            if (languageId != null) {
                languageId.getHistoryProgramsList().remove(historyPrograms);
                languageId = em.merge(languageId);
            }
            em.remove(historyPrograms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoryPrograms> findHistoryProgramsEntities() {
        return findHistoryProgramsEntities(true, -1, -1);
    }

    public List<HistoryPrograms> findHistoryProgramsEntities(int maxResults, int firstResult) {
        return findHistoryProgramsEntities(false, maxResults, firstResult);
    }

    private List<HistoryPrograms> findHistoryProgramsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoryPrograms.class));
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

    public HistoryPrograms findHistoryPrograms(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoryPrograms.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoryProgramsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoryPrograms> rt = cq.from(HistoryPrograms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
