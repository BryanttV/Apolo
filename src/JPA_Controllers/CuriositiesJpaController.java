/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.Curiosities;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.LearningTopics;
import java.util.ArrayList;
import java.util.List;
import Entities.HistoryTopics;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class CuriositiesJpaController implements Serializable {

    public CuriositiesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curiosities curiosities) throws PreexistingEntityException, Exception {
        if (curiosities.getLearningTopicsList() == null) {
            curiosities.setLearningTopicsList(new ArrayList<LearningTopics>());
        }
        if (curiosities.getHistoryTopicsList() == null) {
            curiosities.setHistoryTopicsList(new ArrayList<HistoryTopics>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<LearningTopics> attachedLearningTopicsList = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListLearningTopicsToAttach : curiosities.getLearningTopicsList()) {
                learningTopicsListLearningTopicsToAttach = em.getReference(learningTopicsListLearningTopicsToAttach.getClass(), learningTopicsListLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsList.add(learningTopicsListLearningTopicsToAttach);
            }
            curiosities.setLearningTopicsList(attachedLearningTopicsList);
            List<HistoryTopics> attachedHistoryTopicsList = new ArrayList<HistoryTopics>();
            for (HistoryTopics historyTopicsListHistoryTopicsToAttach : curiosities.getHistoryTopicsList()) {
                historyTopicsListHistoryTopicsToAttach = em.getReference(historyTopicsListHistoryTopicsToAttach.getClass(), historyTopicsListHistoryTopicsToAttach.getHistoryTopicCode());
                attachedHistoryTopicsList.add(historyTopicsListHistoryTopicsToAttach);
            }
            curiosities.setHistoryTopicsList(attachedHistoryTopicsList);
            em.persist(curiosities);
            for (LearningTopics learningTopicsListLearningTopics : curiosities.getLearningTopicsList()) {
                Curiosities oldCuriosityCodeOfLearningTopicsListLearningTopics = learningTopicsListLearningTopics.getCuriosityCode();
                learningTopicsListLearningTopics.setCuriosityCode(curiosities);
                learningTopicsListLearningTopics = em.merge(learningTopicsListLearningTopics);
                if (oldCuriosityCodeOfLearningTopicsListLearningTopics != null) {
                    oldCuriosityCodeOfLearningTopicsListLearningTopics.getLearningTopicsList().remove(learningTopicsListLearningTopics);
                    oldCuriosityCodeOfLearningTopicsListLearningTopics = em.merge(oldCuriosityCodeOfLearningTopicsListLearningTopics);
                }
            }
            for (HistoryTopics historyTopicsListHistoryTopics : curiosities.getHistoryTopicsList()) {
                Curiosities oldCuriosityCodeOfHistoryTopicsListHistoryTopics = historyTopicsListHistoryTopics.getCuriosityCode();
                historyTopicsListHistoryTopics.setCuriosityCode(curiosities);
                historyTopicsListHistoryTopics = em.merge(historyTopicsListHistoryTopics);
                if (oldCuriosityCodeOfHistoryTopicsListHistoryTopics != null) {
                    oldCuriosityCodeOfHistoryTopicsListHistoryTopics.getHistoryTopicsList().remove(historyTopicsListHistoryTopics);
                    oldCuriosityCodeOfHistoryTopicsListHistoryTopics = em.merge(oldCuriosityCodeOfHistoryTopicsListHistoryTopics);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCuriosities(curiosities.getCuriosityCode()) != null) {
                throw new PreexistingEntityException("Curiosities " + curiosities + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curiosities curiosities) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curiosities persistentCuriosities = em.find(Curiosities.class, curiosities.getCuriosityCode());
            List<LearningTopics> learningTopicsListOld = persistentCuriosities.getLearningTopicsList();
            List<LearningTopics> learningTopicsListNew = curiosities.getLearningTopicsList();
            List<HistoryTopics> historyTopicsListOld = persistentCuriosities.getHistoryTopicsList();
            List<HistoryTopics> historyTopicsListNew = curiosities.getHistoryTopicsList();
            List<String> illegalOrphanMessages = null;
            for (LearningTopics learningTopicsListOldLearningTopics : learningTopicsListOld) {
                if (!learningTopicsListNew.contains(learningTopicsListOldLearningTopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LearningTopics " + learningTopicsListOldLearningTopics + " since its curiosityCode field is not nullable.");
                }
            }
            for (HistoryTopics historyTopicsListOldHistoryTopics : historyTopicsListOld) {
                if (!historyTopicsListNew.contains(historyTopicsListOldHistoryTopics)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistoryTopics " + historyTopicsListOldHistoryTopics + " since its curiosityCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<LearningTopics> attachedLearningTopicsListNew = new ArrayList<LearningTopics>();
            for (LearningTopics learningTopicsListNewLearningTopicsToAttach : learningTopicsListNew) {
                learningTopicsListNewLearningTopicsToAttach = em.getReference(learningTopicsListNewLearningTopicsToAttach.getClass(), learningTopicsListNewLearningTopicsToAttach.getLearningTopicCode());
                attachedLearningTopicsListNew.add(learningTopicsListNewLearningTopicsToAttach);
            }
            learningTopicsListNew = attachedLearningTopicsListNew;
            curiosities.setLearningTopicsList(learningTopicsListNew);
            List<HistoryTopics> attachedHistoryTopicsListNew = new ArrayList<HistoryTopics>();
            for (HistoryTopics historyTopicsListNewHistoryTopicsToAttach : historyTopicsListNew) {
                historyTopicsListNewHistoryTopicsToAttach = em.getReference(historyTopicsListNewHistoryTopicsToAttach.getClass(), historyTopicsListNewHistoryTopicsToAttach.getHistoryTopicCode());
                attachedHistoryTopicsListNew.add(historyTopicsListNewHistoryTopicsToAttach);
            }
            historyTopicsListNew = attachedHistoryTopicsListNew;
            curiosities.setHistoryTopicsList(historyTopicsListNew);
            curiosities = em.merge(curiosities);
            for (LearningTopics learningTopicsListNewLearningTopics : learningTopicsListNew) {
                if (!learningTopicsListOld.contains(learningTopicsListNewLearningTopics)) {
                    Curiosities oldCuriosityCodeOfLearningTopicsListNewLearningTopics = learningTopicsListNewLearningTopics.getCuriosityCode();
                    learningTopicsListNewLearningTopics.setCuriosityCode(curiosities);
                    learningTopicsListNewLearningTopics = em.merge(learningTopicsListNewLearningTopics);
                    if (oldCuriosityCodeOfLearningTopicsListNewLearningTopics != null && !oldCuriosityCodeOfLearningTopicsListNewLearningTopics.equals(curiosities)) {
                        oldCuriosityCodeOfLearningTopicsListNewLearningTopics.getLearningTopicsList().remove(learningTopicsListNewLearningTopics);
                        oldCuriosityCodeOfLearningTopicsListNewLearningTopics = em.merge(oldCuriosityCodeOfLearningTopicsListNewLearningTopics);
                    }
                }
            }
            for (HistoryTopics historyTopicsListNewHistoryTopics : historyTopicsListNew) {
                if (!historyTopicsListOld.contains(historyTopicsListNewHistoryTopics)) {
                    Curiosities oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics = historyTopicsListNewHistoryTopics.getCuriosityCode();
                    historyTopicsListNewHistoryTopics.setCuriosityCode(curiosities);
                    historyTopicsListNewHistoryTopics = em.merge(historyTopicsListNewHistoryTopics);
                    if (oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics != null && !oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics.equals(curiosities)) {
                        oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics.getHistoryTopicsList().remove(historyTopicsListNewHistoryTopics);
                        oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics = em.merge(oldCuriosityCodeOfHistoryTopicsListNewHistoryTopics);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = curiosities.getCuriosityCode();
                if (findCuriosities(id) == null) {
                    throw new NonexistentEntityException("The curiosities with id " + id + " no longer exists.");
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
            Curiosities curiosities;
            try {
                curiosities = em.getReference(Curiosities.class, id);
                curiosities.getCuriosityCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curiosities with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LearningTopics> learningTopicsListOrphanCheck = curiosities.getLearningTopicsList();
            for (LearningTopics learningTopicsListOrphanCheckLearningTopics : learningTopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Curiosities (" + curiosities + ") cannot be destroyed since the LearningTopics " + learningTopicsListOrphanCheckLearningTopics + " in its learningTopicsList field has a non-nullable curiosityCode field.");
            }
            List<HistoryTopics> historyTopicsListOrphanCheck = curiosities.getHistoryTopicsList();
            for (HistoryTopics historyTopicsListOrphanCheckHistoryTopics : historyTopicsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Curiosities (" + curiosities + ") cannot be destroyed since the HistoryTopics " + historyTopicsListOrphanCheckHistoryTopics + " in its historyTopicsList field has a non-nullable curiosityCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(curiosities);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curiosities> findCuriositiesEntities() {
        return findCuriositiesEntities(true, -1, -1);
    }

    public List<Curiosities> findCuriositiesEntities(int maxResults, int firstResult) {
        return findCuriositiesEntities(false, maxResults, firstResult);
    }

    private List<Curiosities> findCuriositiesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curiosities.class));
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

    public Curiosities findCuriosities(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curiosities.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuriositiesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curiosities> rt = cq.from(Curiosities.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
