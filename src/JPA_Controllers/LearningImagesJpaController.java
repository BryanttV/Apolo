/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.LearningImages;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.LearningSubtopics;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class LearningImagesJpaController implements Serializable {

    public LearningImagesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LearningImages learningImages) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningSubtopics learningSubId = learningImages.getLearningSubId();
            if (learningSubId != null) {
                learningSubId = em.getReference(learningSubId.getClass(), learningSubId.getLearningSubId());
                learningImages.setLearningSubId(learningSubId);
            }
            em.persist(learningImages);
            if (learningSubId != null) {
                learningSubId.getLearningImagesList().add(learningImages);
                learningSubId = em.merge(learningSubId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLearningImages(learningImages.getLearningImageId()) != null) {
                throw new PreexistingEntityException("LearningImages " + learningImages + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LearningImages learningImages) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningImages persistentLearningImages = em.find(LearningImages.class, learningImages.getLearningImageId());
            LearningSubtopics learningSubIdOld = persistentLearningImages.getLearningSubId();
            LearningSubtopics learningSubIdNew = learningImages.getLearningSubId();
            if (learningSubIdNew != null) {
                learningSubIdNew = em.getReference(learningSubIdNew.getClass(), learningSubIdNew.getLearningSubId());
                learningImages.setLearningSubId(learningSubIdNew);
            }
            learningImages = em.merge(learningImages);
            if (learningSubIdOld != null && !learningSubIdOld.equals(learningSubIdNew)) {
                learningSubIdOld.getLearningImagesList().remove(learningImages);
                learningSubIdOld = em.merge(learningSubIdOld);
            }
            if (learningSubIdNew != null && !learningSubIdNew.equals(learningSubIdOld)) {
                learningSubIdNew.getLearningImagesList().add(learningImages);
                learningSubIdNew = em.merge(learningSubIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = learningImages.getLearningImageId();
                if (findLearningImages(id) == null) {
                    throw new NonexistentEntityException("The learningImages with id " + id + " no longer exists.");
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
            LearningImages learningImages;
            try {
                learningImages = em.getReference(LearningImages.class, id);
                learningImages.getLearningImageId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The learningImages with id " + id + " no longer exists.", enfe);
            }
            LearningSubtopics learningSubId = learningImages.getLearningSubId();
            if (learningSubId != null) {
                learningSubId.getLearningImagesList().remove(learningImages);
                learningSubId = em.merge(learningSubId);
            }
            em.remove(learningImages);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LearningImages> findLearningImagesEntities() {
        return findLearningImagesEntities(true, -1, -1);
    }

    public List<LearningImages> findLearningImagesEntities(int maxResults, int firstResult) {
        return findLearningImagesEntities(false, maxResults, firstResult);
    }

    private List<LearningImages> findLearningImagesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LearningImages.class));
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

    public LearningImages findLearningImages(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LearningImages.class, id);
        } finally {
            em.close();
        }
    }

    public int getLearningImagesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LearningImages> rt = cq.from(LearningImages.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
