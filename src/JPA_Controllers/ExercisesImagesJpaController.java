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
import Entities.ExercisesContent;
import Entities.ExercisesImages;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class ExercisesImagesJpaController implements Serializable {

    public ExercisesImagesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ExercisesImages exercisesImages) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ExercisesContent exerciseContentCode = exercisesImages.getExerciseContentCode();
            if (exerciseContentCode != null) {
                exerciseContentCode = em.getReference(exerciseContentCode.getClass(), exerciseContentCode.getExerciseContentCode());
                exercisesImages.setExerciseContentCode(exerciseContentCode);
            }
            em.persist(exercisesImages);
            if (exerciseContentCode != null) {
                exerciseContentCode.getExercisesImagesList().add(exercisesImages);
                exerciseContentCode = em.merge(exerciseContentCode);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExercisesImages(exercisesImages.getExerciseImageId()) != null) {
                throw new PreexistingEntityException("ExercisesImages " + exercisesImages + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ExercisesImages exercisesImages) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ExercisesImages persistentExercisesImages = em.find(ExercisesImages.class, exercisesImages.getExerciseImageId());
            ExercisesContent exerciseContentCodeOld = persistentExercisesImages.getExerciseContentCode();
            ExercisesContent exerciseContentCodeNew = exercisesImages.getExerciseContentCode();
            if (exerciseContentCodeNew != null) {
                exerciseContentCodeNew = em.getReference(exerciseContentCodeNew.getClass(), exerciseContentCodeNew.getExerciseContentCode());
                exercisesImages.setExerciseContentCode(exerciseContentCodeNew);
            }
            exercisesImages = em.merge(exercisesImages);
            if (exerciseContentCodeOld != null && !exerciseContentCodeOld.equals(exerciseContentCodeNew)) {
                exerciseContentCodeOld.getExercisesImagesList().remove(exercisesImages);
                exerciseContentCodeOld = em.merge(exerciseContentCodeOld);
            }
            if (exerciseContentCodeNew != null && !exerciseContentCodeNew.equals(exerciseContentCodeOld)) {
                exerciseContentCodeNew.getExercisesImagesList().add(exercisesImages);
                exerciseContentCodeNew = em.merge(exerciseContentCodeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = exercisesImages.getExerciseImageId();
                if (findExercisesImages(id) == null) {
                    throw new NonexistentEntityException("The exercisesImages with id " + id + " no longer exists.");
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
            ExercisesImages exercisesImages;
            try {
                exercisesImages = em.getReference(ExercisesImages.class, id);
                exercisesImages.getExerciseImageId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The exercisesImages with id " + id + " no longer exists.", enfe);
            }
            ExercisesContent exerciseContentCode = exercisesImages.getExerciseContentCode();
            if (exerciseContentCode != null) {
                exerciseContentCode.getExercisesImagesList().remove(exercisesImages);
                exerciseContentCode = em.merge(exerciseContentCode);
            }
            em.remove(exercisesImages);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ExercisesImages> findExercisesImagesEntities() {
        return findExercisesImagesEntities(true, -1, -1);
    }

    public List<ExercisesImages> findExercisesImagesEntities(int maxResults, int firstResult) {
        return findExercisesImagesEntities(false, maxResults, firstResult);
    }

    private List<ExercisesImages> findExercisesImagesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ExercisesImages.class));
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

    public ExercisesImages findExercisesImages(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ExercisesImages.class, id);
        } finally {
            em.close();
        }
    }

    public int getExercisesImagesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ExercisesImages> rt = cq.from(ExercisesImages.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
