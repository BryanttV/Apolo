/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.HistoryImages;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.HistorySubtopics;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class HistoryImagesJpaController implements Serializable {

    public HistoryImagesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoryImages historyImages) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistorySubtopics historySubId = historyImages.getHistorySubId();
            if (historySubId != null) {
                historySubId = em.getReference(historySubId.getClass(), historySubId.getHistorySubId());
                historyImages.setHistorySubId(historySubId);
            }
            em.persist(historyImages);
            if (historySubId != null) {
                historySubId.getHistoryImagesList().add(historyImages);
                historySubId = em.merge(historySubId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoryImages(historyImages.getHistoryImageId()) != null) {
                throw new PreexistingEntityException("HistoryImages " + historyImages + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoryImages historyImages) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistoryImages persistentHistoryImages = em.find(HistoryImages.class, historyImages.getHistoryImageId());
            HistorySubtopics historySubIdOld = persistentHistoryImages.getHistorySubId();
            HistorySubtopics historySubIdNew = historyImages.getHistorySubId();
            if (historySubIdNew != null) {
                historySubIdNew = em.getReference(historySubIdNew.getClass(), historySubIdNew.getHistorySubId());
                historyImages.setHistorySubId(historySubIdNew);
            }
            historyImages = em.merge(historyImages);
            if (historySubIdOld != null && !historySubIdOld.equals(historySubIdNew)) {
                historySubIdOld.getHistoryImagesList().remove(historyImages);
                historySubIdOld = em.merge(historySubIdOld);
            }
            if (historySubIdNew != null && !historySubIdNew.equals(historySubIdOld)) {
                historySubIdNew.getHistoryImagesList().add(historyImages);
                historySubIdNew = em.merge(historySubIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historyImages.getHistoryImageId();
                if (findHistoryImages(id) == null) {
                    throw new NonexistentEntityException("The historyImages with id " + id + " no longer exists.");
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
            HistoryImages historyImages;
            try {
                historyImages = em.getReference(HistoryImages.class, id);
                historyImages.getHistoryImageId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historyImages with id " + id + " no longer exists.", enfe);
            }
            HistorySubtopics historySubId = historyImages.getHistorySubId();
            if (historySubId != null) {
                historySubId.getHistoryImagesList().remove(historyImages);
                historySubId = em.merge(historySubId);
            }
            em.remove(historyImages);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoryImages> findHistoryImagesEntities() {
        return findHistoryImagesEntities(true, -1, -1);
    }

    public List<HistoryImages> findHistoryImagesEntities(int maxResults, int firstResult) {
        return findHistoryImagesEntities(false, maxResults, firstResult);
    }

    private List<HistoryImages> findHistoryImagesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoryImages.class));
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

    public HistoryImages findHistoryImages(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoryImages.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoryImagesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoryImages> rt = cq.from(HistoryImages.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
