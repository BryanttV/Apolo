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
import Entities.HistoryTopics;
import Entities.HistoryImages;
import Entities.HistorySubtopics;
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
public class HistorySubtopicsJpaController implements Serializable {

    public HistorySubtopicsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistorySubtopics historySubtopics) throws PreexistingEntityException, Exception {
        if (historySubtopics.getHistoryImagesList() == null) {
            historySubtopics.setHistoryImagesList(new ArrayList<HistoryImages>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistoryTopics historyTopicCode = historySubtopics.getHistoryTopicCode();
            if (historyTopicCode != null) {
                historyTopicCode = em.getReference(historyTopicCode.getClass(), historyTopicCode.getHistoryTopicCode());
                historySubtopics.setHistoryTopicCode(historyTopicCode);
            }
            List<HistoryImages> attachedHistoryImagesList = new ArrayList<HistoryImages>();
            for (HistoryImages historyImagesListHistoryImagesToAttach : historySubtopics.getHistoryImagesList()) {
                historyImagesListHistoryImagesToAttach = em.getReference(historyImagesListHistoryImagesToAttach.getClass(), historyImagesListHistoryImagesToAttach.getHistoryImageId());
                attachedHistoryImagesList.add(historyImagesListHistoryImagesToAttach);
            }
            historySubtopics.setHistoryImagesList(attachedHistoryImagesList);
            em.persist(historySubtopics);
            if (historyTopicCode != null) {
                historyTopicCode.getHistorySubtopicsList().add(historySubtopics);
                historyTopicCode = em.merge(historyTopicCode);
            }
            for (HistoryImages historyImagesListHistoryImages : historySubtopics.getHistoryImagesList()) {
                HistorySubtopics oldHistorySubIdOfHistoryImagesListHistoryImages = historyImagesListHistoryImages.getHistorySubId();
                historyImagesListHistoryImages.setHistorySubId(historySubtopics);
                historyImagesListHistoryImages = em.merge(historyImagesListHistoryImages);
                if (oldHistorySubIdOfHistoryImagesListHistoryImages != null) {
                    oldHistorySubIdOfHistoryImagesListHistoryImages.getHistoryImagesList().remove(historyImagesListHistoryImages);
                    oldHistorySubIdOfHistoryImagesListHistoryImages = em.merge(oldHistorySubIdOfHistoryImagesListHistoryImages);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistorySubtopics(historySubtopics.getHistorySubId()) != null) {
                throw new PreexistingEntityException("HistorySubtopics " + historySubtopics + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistorySubtopics historySubtopics) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistorySubtopics persistentHistorySubtopics = em.find(HistorySubtopics.class, historySubtopics.getHistorySubId());
            HistoryTopics historyTopicCodeOld = persistentHistorySubtopics.getHistoryTopicCode();
            HistoryTopics historyTopicCodeNew = historySubtopics.getHistoryTopicCode();
            List<HistoryImages> historyImagesListOld = persistentHistorySubtopics.getHistoryImagesList();
            List<HistoryImages> historyImagesListNew = historySubtopics.getHistoryImagesList();
            List<String> illegalOrphanMessages = null;
            for (HistoryImages historyImagesListOldHistoryImages : historyImagesListOld) {
                if (!historyImagesListNew.contains(historyImagesListOldHistoryImages)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HistoryImages " + historyImagesListOldHistoryImages + " since its historySubId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (historyTopicCodeNew != null) {
                historyTopicCodeNew = em.getReference(historyTopicCodeNew.getClass(), historyTopicCodeNew.getHistoryTopicCode());
                historySubtopics.setHistoryTopicCode(historyTopicCodeNew);
            }
            List<HistoryImages> attachedHistoryImagesListNew = new ArrayList<HistoryImages>();
            for (HistoryImages historyImagesListNewHistoryImagesToAttach : historyImagesListNew) {
                historyImagesListNewHistoryImagesToAttach = em.getReference(historyImagesListNewHistoryImagesToAttach.getClass(), historyImagesListNewHistoryImagesToAttach.getHistoryImageId());
                attachedHistoryImagesListNew.add(historyImagesListNewHistoryImagesToAttach);
            }
            historyImagesListNew = attachedHistoryImagesListNew;
            historySubtopics.setHistoryImagesList(historyImagesListNew);
            historySubtopics = em.merge(historySubtopics);
            if (historyTopicCodeOld != null && !historyTopicCodeOld.equals(historyTopicCodeNew)) {
                historyTopicCodeOld.getHistorySubtopicsList().remove(historySubtopics);
                historyTopicCodeOld = em.merge(historyTopicCodeOld);
            }
            if (historyTopicCodeNew != null && !historyTopicCodeNew.equals(historyTopicCodeOld)) {
                historyTopicCodeNew.getHistorySubtopicsList().add(historySubtopics);
                historyTopicCodeNew = em.merge(historyTopicCodeNew);
            }
            for (HistoryImages historyImagesListNewHistoryImages : historyImagesListNew) {
                if (!historyImagesListOld.contains(historyImagesListNewHistoryImages)) {
                    HistorySubtopics oldHistorySubIdOfHistoryImagesListNewHistoryImages = historyImagesListNewHistoryImages.getHistorySubId();
                    historyImagesListNewHistoryImages.setHistorySubId(historySubtopics);
                    historyImagesListNewHistoryImages = em.merge(historyImagesListNewHistoryImages);
                    if (oldHistorySubIdOfHistoryImagesListNewHistoryImages != null && !oldHistorySubIdOfHistoryImagesListNewHistoryImages.equals(historySubtopics)) {
                        oldHistorySubIdOfHistoryImagesListNewHistoryImages.getHistoryImagesList().remove(historyImagesListNewHistoryImages);
                        oldHistorySubIdOfHistoryImagesListNewHistoryImages = em.merge(oldHistorySubIdOfHistoryImagesListNewHistoryImages);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historySubtopics.getHistorySubId();
                if (findHistorySubtopics(id) == null) {
                    throw new NonexistentEntityException("The historySubtopics with id " + id + " no longer exists.");
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
            HistorySubtopics historySubtopics;
            try {
                historySubtopics = em.getReference(HistorySubtopics.class, id);
                historySubtopics.getHistorySubId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historySubtopics with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<HistoryImages> historyImagesListOrphanCheck = historySubtopics.getHistoryImagesList();
            for (HistoryImages historyImagesListOrphanCheckHistoryImages : historyImagesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This HistorySubtopics (" + historySubtopics + ") cannot be destroyed since the HistoryImages " + historyImagesListOrphanCheckHistoryImages + " in its historyImagesList field has a non-nullable historySubId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            HistoryTopics historyTopicCode = historySubtopics.getHistoryTopicCode();
            if (historyTopicCode != null) {
                historyTopicCode.getHistorySubtopicsList().remove(historySubtopics);
                historyTopicCode = em.merge(historyTopicCode);
            }
            em.remove(historySubtopics);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistorySubtopics> findHistorySubtopicsEntities() {
        return findHistorySubtopicsEntities(true, -1, -1);
    }

    public List<HistorySubtopics> findHistorySubtopicsEntities(int maxResults, int firstResult) {
        return findHistorySubtopicsEntities(false, maxResults, firstResult);
    }

    private List<HistorySubtopics> findHistorySubtopicsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistorySubtopics.class));
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

    public HistorySubtopics findHistorySubtopics(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistorySubtopics.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorySubtopicsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistorySubtopics> rt = cq.from(HistorySubtopics.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
