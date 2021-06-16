/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.Codes;
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
public class CodesJpaController implements Serializable {

    public CodesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Codes codes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningSubtopics learningSubId = codes.getLearningSubId();
            if (learningSubId != null) {
                learningSubId = em.getReference(learningSubId.getClass(), learningSubId.getLearningSubId());
                codes.setLearningSubId(learningSubId);
            }
            em.persist(codes);
            if (learningSubId != null) {
                learningSubId.getCodesList().add(codes);
                learningSubId = em.merge(learningSubId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCodes(codes.getCodeId()) != null) {
                throw new PreexistingEntityException("Codes " + codes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Codes codes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Codes persistentCodes = em.find(Codes.class, codes.getCodeId());
            LearningSubtopics learningSubIdOld = persistentCodes.getLearningSubId();
            LearningSubtopics learningSubIdNew = codes.getLearningSubId();
            if (learningSubIdNew != null) {
                learningSubIdNew = em.getReference(learningSubIdNew.getClass(), learningSubIdNew.getLearningSubId());
                codes.setLearningSubId(learningSubIdNew);
            }
            codes = em.merge(codes);
            if (learningSubIdOld != null && !learningSubIdOld.equals(learningSubIdNew)) {
                learningSubIdOld.getCodesList().remove(codes);
                learningSubIdOld = em.merge(learningSubIdOld);
            }
            if (learningSubIdNew != null && !learningSubIdNew.equals(learningSubIdOld)) {
                learningSubIdNew.getCodesList().add(codes);
                learningSubIdNew = em.merge(learningSubIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = codes.getCodeId();
                if (findCodes(id) == null) {
                    throw new NonexistentEntityException("The codes with id " + id + " no longer exists.");
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
            Codes codes;
            try {
                codes = em.getReference(Codes.class, id);
                codes.getCodeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The codes with id " + id + " no longer exists.", enfe);
            }
            LearningSubtopics learningSubId = codes.getLearningSubId();
            if (learningSubId != null) {
                learningSubId.getCodesList().remove(codes);
                learningSubId = em.merge(learningSubId);
            }
            em.remove(codes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Codes> findCodesEntities() {
        return findCodesEntities(true, -1, -1);
    }

    public List<Codes> findCodesEntities(int maxResults, int firstResult) {
        return findCodesEntities(false, maxResults, firstResult);
    }

    private List<Codes> findCodesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Codes.class));
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

    public Codes findCodes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Codes.class, id);
        } finally {
            em.close();
        }
    }

    public int getCodesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Codes> rt = cq.from(Codes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
