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
import Entities.Progress;
import JPA_Controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class ProgressJpaController implements Serializable {

    public ProgressJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Progress progress) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProgrammingLanguages languageId = progress.getLanguageId();
            if (languageId != null) {
                languageId = em.getReference(languageId.getClass(), languageId.getLanguageId());
                progress.setLanguageId(languageId);
            }
            em.persist(progress);
            if (languageId != null) {
                languageId.getProgressList().add(progress);
                languageId = em.merge(languageId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Progress progress) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Progress persistentProgress = em.find(Progress.class, progress.getRecordId());
            ProgrammingLanguages languageIdOld = persistentProgress.getLanguageId();
            ProgrammingLanguages languageIdNew = progress.getLanguageId();
            if (languageIdNew != null) {
                languageIdNew = em.getReference(languageIdNew.getClass(), languageIdNew.getLanguageId());
                progress.setLanguageId(languageIdNew);
            }
            progress = em.merge(progress);
            if (languageIdOld != null && !languageIdOld.equals(languageIdNew)) {
                languageIdOld.getProgressList().remove(progress);
                languageIdOld = em.merge(languageIdOld);
            }
            if (languageIdNew != null && !languageIdNew.equals(languageIdOld)) {
                languageIdNew.getProgressList().add(progress);
                languageIdNew = em.merge(languageIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = progress.getRecordId();
                if (findProgress(id) == null) {
                    throw new NonexistentEntityException("The progress with id " + id + " no longer exists.");
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
            Progress progress;
            try {
                progress = em.getReference(Progress.class, id);
                progress.getRecordId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The progress with id " + id + " no longer exists.", enfe);
            }
            ProgrammingLanguages languageId = progress.getLanguageId();
            if (languageId != null) {
                languageId.getProgressList().remove(progress);
                languageId = em.merge(languageId);
            }
            em.remove(progress);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Progress> findProgressEntities() {
        return findProgressEntities(true, -1, -1);
    }

    public List<Progress> findProgressEntities(int maxResults, int firstResult) {
        return findProgressEntities(false, maxResults, firstResult);
    }

    private List<Progress> findProgressEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Progress.class));
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

    public Progress findProgress(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Progress.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgressCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Progress> rt = cq.from(Progress.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
