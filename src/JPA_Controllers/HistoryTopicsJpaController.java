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
import Entities.HistoryPrograms;
import Entities.HistorySubtopics;
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
public class HistoryTopicsJpaController implements Serializable {

    public HistoryTopicsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoryTopics historyTopics) throws PreexistingEntityException, Exception {
        if (historyTopics.getHistorySubtopicsList() == null) {
            historyTopics.setHistorySubtopicsList(new ArrayList<HistorySubtopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curiosities curiosityCode = historyTopics.getCuriosityCode();
            if (curiosityCode != null) {
                curiosityCode = em.getReference(curiosityCode.getClass(), curiosityCode.getCuriosityCode());
                historyTopics.setCuriosityCode(curiosityCode);
            }
            HistoryPrograms historyProgramCode = historyTopics.getHistoryProgramCode();
            if (historyProgramCode != null) {
                historyProgramCode = em.getReference(historyProgramCode.getClass(), historyProgramCode.getHistoryProgramCode());
                historyTopics.setHistoryProgramCode(historyProgramCode);
            }
            List<HistorySubtopics> attachedHistorySubtopicsList = new ArrayList<HistorySubtopics>();
            for (HistorySubtopics historySubtopicsListHistorySubtopicsToAttach : historyTopics.getHistorySubtopicsList()) {
                historySubtopicsListHistorySubtopicsToAttach = em.getReference(historySubtopicsListHistorySubtopicsToAttach.getClass(), historySubtopicsListHistorySubtopicsToAttach.getHistorySubId());
                attachedHistorySubtopicsList.add(historySubtopicsListHistorySubtopicsToAttach);
            }
            historyTopics.setHistorySubtopicsList(attachedHistorySubtopicsList);
            em.persist(historyTopics);
            if (curiosityCode != null) {
                curiosityCode.getHistoryTopicsList().add(historyTopics);
                curiosityCode = em.merge(curiosityCode);
            }
            if (historyProgramCode != null) {
                historyProgramCode.getHistoryTopicsList().add(historyTopics);
                historyProgramCode = em.merge(historyProgramCode);
            }
            for (HistorySubtopics historySubtopicsListHistorySubtopics : historyTopics.getHistorySubtopicsList()) {
                HistoryTopics oldHistoryTopicCodeOfHistorySubtopicsListHistorySubtopics = historySubtopicsListHistorySubtopics.getHistoryTopicCode();
                historySubtopicsListHistorySubtopics.setHistoryTopicCode(historyTopics);
                historySubtopicsListHistorySubtopics = em.merge(historySubtopicsListHistorySubtopics);
                if (oldHistoryTopicCodeOfHistorySubtopicsListHistorySubtopics != null) {
                    oldHistoryTopicCodeOfHistorySubtopicsListHistorySubtopics.getHistorySubtopicsList().remove(historySubtopicsListHistorySubtopics);
                    oldHistoryTopicCodeOfHistorySubtopicsListHistorySubtopics = em.merge(oldHistoryTopicCodeOfHistorySubtopicsListHistorySubtopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoryTopics(historyTopics.getHistoryTopicCode()) != null) {
                throw new PreexistingEntityException("HistoryTopics " + historyTopics + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoryTopics historyTopics) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistoryTopics persistentHistoryTopics = em.find(HistoryTopics.class, historyTopics.getHistoryTopicCode());
            Curiosities curiosityCodeOld = persistentHistoryTopics.getCuriosityCode();
            Curiosities curiosityCodeNew = historyTopics.getCuriosityCode();
            HistoryPrograms historyProgramCodeOld = persistentHistoryTopics.getHistoryProgramCode();
            HistoryPrograms historyProgramCodeNew = historyTopics.getHistoryProgramCode();
            List<HistorySubtopics> historySubtopicsListOld = persistentHistoryTopics.getHistorySubtopicsList();
            List<HistorySubtopics> historySubtopicsListNew = historyTopics.getHistorySubtopicsList();
            List<String> illegalOrphanMessages = null;
            for (HistorySubtopics historySubtopicsListOldHistorySubtopics : historySubtopicsListOld) {
                if (!historySubtopicsListNew.contains(historySubtopicsListOldHistorySubtopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistorySubtopics " + historySubtopicsListOldHistorySubtopics + " since its historyTopicCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (curiosityCodeNew != null) {
                curiosityCodeNew = em.getReference(curiosityCodeNew.getClass(), curiosityCodeNew.getCuriosityCode());
                historyTopics.setCuriosityCode(curiosityCodeNew);
            }
            if (historyProgramCodeNew != null) {
                historyProgramCodeNew = em.getReference(historyProgramCodeNew.getClass(), historyProgramCodeNew.getHistoryProgramCode());
                historyTopics.setHistoryProgramCode(historyProgramCodeNew);
            }
            List<HistorySubtopics> attachedHistorySubtopicsListNew = new ArrayList<HistorySubtopics>();
            for (HistorySubtopics historySubtopicsListNewHistorySubtopicsToAttach : historySubtopicsListNew) {
                historySubtopicsListNewHistorySubtopicsToAttach = em.getReference(historySubtopicsListNewHistorySubtopicsToAttach.getClass(), historySubtopicsListNewHistorySubtopicsToAttach.getHistorySubId());
                attachedHistorySubtopicsListNew.add(historySubtopicsListNewHistorySubtopicsToAttach);
            }
            historySubtopicsListNew = attachedHistorySubtopicsListNew;
            historyTopics.setHistorySubtopicsList(historySubtopicsListNew);
            historyTopics = em.merge(historyTopics);
            if (curiosityCodeOld != null && !curiosityCodeOld.equals(curiosityCodeNew)) {
                curiosityCodeOld.getHistoryTopicsList().remove(historyTopics);
                curiosityCodeOld = em.merge(curiosityCodeOld);
            }
            if (curiosityCodeNew != null && !curiosityCodeNew.equals(curiosityCodeOld)) {
                curiosityCodeNew.getHistoryTopicsList().add(historyTopics);
                curiosityCodeNew = em.merge(curiosityCodeNew);
            }
            if (historyProgramCodeOld != null && !historyProgramCodeOld.equals(historyProgramCodeNew)) {
                historyProgramCodeOld.getHistoryTopicsList().remove(historyTopics);
                historyProgramCodeOld = em.merge(historyProgramCodeOld);
            }
            if (historyProgramCodeNew != null && !historyProgramCodeNew.equals(historyProgramCodeOld)) {
                historyProgramCodeNew.getHistoryTopicsList().add(historyTopics);
                historyProgramCodeNew = em.merge(historyProgramCodeNew);
            }
            for (HistorySubtopics historySubtopicsListNewHistorySubtopics : historySubtopicsListNew) {
                if (!historySubtopicsListOld.contains(historySubtopicsListNewHistorySubtopics)) {
                    HistoryTopics oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics = historySubtopicsListNewHistorySubtopics.getHistoryTopicCode();
                    historySubtopicsListNewHistorySubtopics.setHistoryTopicCode(historyTopics);
                    historySubtopicsListNewHistorySubtopics = em.merge(historySubtopicsListNewHistorySubtopics);
                    if (oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics != null && !oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics.equals(historyTopics)) {
                        oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics.getHistorySubtopicsList().remove(historySubtopicsListNewHistorySubtopics);
                        oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics = em.merge(oldHistoryTopicCodeOfHistorySubtopicsListNewHistorySubtopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historyTopics.getHistoryTopicCode();
                if (findHistoryTopics(id) == null) {
                    throw new NonexistentEntityException("The historyTopics with id " + id + " no longer exists.");
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
            HistoryTopics historyTopics;
            try {
                historyTopics = em.getReference(HistoryTopics.class, id);
                historyTopics.getHistoryTopicCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historyTopics with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<HistorySubtopics> historySubtopicsListOrphanCheck = historyTopics.getHistorySubtopicsList();
            for (HistorySubtopics historySubtopicsListOrphanCheckHistorySubtopics : historySubtopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This HistoryTopics (" + historyTopics + ") cannot be destroyed since the HistorySubtopics " + historySubtopicsListOrphanCheckHistorySubtopics + " in its historySubtopicsList field has a non-nullable historyTopicCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Curiosities curiosityCode = historyTopics.getCuriosityCode();
            if (curiosityCode != null) {
                curiosityCode.getHistoryTopicsList().remove(historyTopics);
                curiosityCode = em.merge(curiosityCode);
            }
            HistoryPrograms historyProgramCode = historyTopics.getHistoryProgramCode();
            if (historyProgramCode != null) {
                historyProgramCode.getHistoryTopicsList().remove(historyTopics);
                historyProgramCode = em.merge(historyProgramCode);
            }
            em.remove(historyTopics);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoryTopics> findHistoryTopicsEntities() {
        return findHistoryTopicsEntities(true, -1, -1);
    }

    public List<HistoryTopics> findHistoryTopicsEntities(int maxResults, int firstResult) {
        return findHistoryTopicsEntities(false, maxResults, firstResult);
    }

    private List<HistoryTopics> findHistoryTopicsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoryTopics.class));
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

    public HistoryTopics findHistoryTopics(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoryTopics.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoryTopicsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoryTopics> rt = cq.from(HistoryTopics.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
