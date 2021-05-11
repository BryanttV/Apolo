/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.Sequence;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author david
 */
public class SequenceJpaController implements Serializable {

    public SequenceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sequence sequence) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sequence);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSequence(sequence.getSeqName()) != null) {
                throw new PreexistingEntityException("Sequence " + sequence + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sequence sequence) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sequence = em.merge(sequence);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sequence.getSeqName();
                if (findSequence(id) == null) {
                    throw new NonexistentEntityException("The sequence with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sequence sequence;
            try {
                sequence = em.getReference(Sequence.class, id);
                sequence.getSeqName();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sequence with id " + id + " no longer exists.", enfe);
            }
            em.remove(sequence);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sequence> findSequenceEntities() {
        return findSequenceEntities(true, -1, -1);
    }

    public List<Sequence> findSequenceEntities(int maxResults, int firstResult) {
        return findSequenceEntities(false, maxResults, firstResult);
    }

    private List<Sequence> findSequenceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sequence.class));
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

    public Sequence findSequence(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sequence.class, id);
        } finally {
            em.close();
        }
    }

    public int getSequenceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sequence> rt = cq.from(Sequence.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
