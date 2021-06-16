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
import Entities.ExercisesImages;
import java.util.ArrayList;
import java.util.List;
import Entities.Exercises;
import Entities.ExercisesContent;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class ExercisesContentJpaController implements Serializable {

    public ExercisesContentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ExercisesContent exercisesContent) throws PreexistingEntityException, Exception {
        if (exercisesContent.getExercisesImagesList() == null) {
            exercisesContent.setExercisesImagesList(new ArrayList<ExercisesImages>());
        }
        if (exercisesContent.getExercisesList() == null) {
            exercisesContent.setExercisesList(new ArrayList<Exercises>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ExercisesImages> attachedExercisesImagesList = new ArrayList<ExercisesImages>();
            for (ExercisesImages exercisesImagesListExercisesImagesToAttach : exercisesContent.getExercisesImagesList()) {
                exercisesImagesListExercisesImagesToAttach = em.getReference(exercisesImagesListExercisesImagesToAttach.getClass(), exercisesImagesListExercisesImagesToAttach.getExerciseImageId());
                attachedExercisesImagesList.add(exercisesImagesListExercisesImagesToAttach);
            }
            exercisesContent.setExercisesImagesList(attachedExercisesImagesList);
            List<Exercises> attachedExercisesList = new ArrayList<Exercises>();
            for (Exercises exercisesListExercisesToAttach : exercisesContent.getExercisesList()) {
                exercisesListExercisesToAttach = em.getReference(exercisesListExercisesToAttach.getClass(), exercisesListExercisesToAttach.getExerciseCode());
                attachedExercisesList.add(exercisesListExercisesToAttach);
            }
            exercisesContent.setExercisesList(attachedExercisesList);
            em.persist(exercisesContent);
            for (ExercisesImages exercisesImagesListExercisesImages : exercisesContent.getExercisesImagesList()) {
                ExercisesContent oldExerciseContentCodeOfExercisesImagesListExercisesImages = exercisesImagesListExercisesImages.getExerciseContentCode();
                exercisesImagesListExercisesImages.setExerciseContentCode(exercisesContent);
                exercisesImagesListExercisesImages = em.merge(exercisesImagesListExercisesImages);
                if (oldExerciseContentCodeOfExercisesImagesListExercisesImages != null) {
                    oldExerciseContentCodeOfExercisesImagesListExercisesImages.getExercisesImagesList().remove(exercisesImagesListExercisesImages);
                    oldExerciseContentCodeOfExercisesImagesListExercisesImages = em.merge(oldExerciseContentCodeOfExercisesImagesListExercisesImages);
                }
            }
            for (Exercises exercisesListExercises : exercisesContent.getExercisesList()) {
                ExercisesContent oldExerciseContentCodeOfExercisesListExercises = exercisesListExercises.getExerciseContentCode();
                exercisesListExercises.setExerciseContentCode(exercisesContent);
                exercisesListExercises = em.merge(exercisesListExercises);
                if (oldExerciseContentCodeOfExercisesListExercises != null) {
                    oldExerciseContentCodeOfExercisesListExercises.getExercisesList().remove(exercisesListExercises);
                    oldExerciseContentCodeOfExercisesListExercises = em.merge(oldExerciseContentCodeOfExercisesListExercises);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExercisesContent(exercisesContent.getExerciseContentCode()) != null) {
                throw new PreexistingEntityException("ExercisesContent " + exercisesContent + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ExercisesContent exercisesContent) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ExercisesContent persistentExercisesContent = em.find(ExercisesContent.class, exercisesContent.getExerciseContentCode());
            List<ExercisesImages> exercisesImagesListOld = persistentExercisesContent.getExercisesImagesList();
            List<ExercisesImages> exercisesImagesListNew = exercisesContent.getExercisesImagesList();
            List<Exercises> exercisesListOld = persistentExercisesContent.getExercisesList();
            List<Exercises> exercisesListNew = exercisesContent.getExercisesList();
            List<String> illegalOrphanMessages = null;
            for (ExercisesImages exercisesImagesListOldExercisesImages : exercisesImagesListOld) {
                if (!exercisesImagesListNew.contains(exercisesImagesListOldExercisesImages)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ExercisesImages " + exercisesImagesListOldExercisesImages + " since its exerciseContentCode field is not nullable.");
                }
            }
            for (Exercises exercisesListOldExercises : exercisesListOld) {
                if (!exercisesListNew.contains(exercisesListOldExercises)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Exercises " + exercisesListOldExercises + " since its exerciseContentCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ExercisesImages> attachedExercisesImagesListNew = new ArrayList<ExercisesImages>();
            for (ExercisesImages exercisesImagesListNewExercisesImagesToAttach : exercisesImagesListNew) {
                exercisesImagesListNewExercisesImagesToAttach = em.getReference(exercisesImagesListNewExercisesImagesToAttach.getClass(), exercisesImagesListNewExercisesImagesToAttach.getExerciseImageId());
                attachedExercisesImagesListNew.add(exercisesImagesListNewExercisesImagesToAttach);
            }
            exercisesImagesListNew = attachedExercisesImagesListNew;
            exercisesContent.setExercisesImagesList(exercisesImagesListNew);
            List<Exercises> attachedExercisesListNew = new ArrayList<Exercises>();
            for (Exercises exercisesListNewExercisesToAttach : exercisesListNew) {
                exercisesListNewExercisesToAttach = em.getReference(exercisesListNewExercisesToAttach.getClass(), exercisesListNewExercisesToAttach.getExerciseCode());
                attachedExercisesListNew.add(exercisesListNewExercisesToAttach);
            }
            exercisesListNew = attachedExercisesListNew;
            exercisesContent.setExercisesList(exercisesListNew);
            exercisesContent = em.merge(exercisesContent);
            for (ExercisesImages exercisesImagesListNewExercisesImages : exercisesImagesListNew) {
                if (!exercisesImagesListOld.contains(exercisesImagesListNewExercisesImages)) {
                    ExercisesContent oldExerciseContentCodeOfExercisesImagesListNewExercisesImages = exercisesImagesListNewExercisesImages.getExerciseContentCode();
                    exercisesImagesListNewExercisesImages.setExerciseContentCode(exercisesContent);
                    exercisesImagesListNewExercisesImages = em.merge(exercisesImagesListNewExercisesImages);
                    if (oldExerciseContentCodeOfExercisesImagesListNewExercisesImages != null && !oldExerciseContentCodeOfExercisesImagesListNewExercisesImages.equals(exercisesContent)) {
                        oldExerciseContentCodeOfExercisesImagesListNewExercisesImages.getExercisesImagesList().remove(exercisesImagesListNewExercisesImages);
                        oldExerciseContentCodeOfExercisesImagesListNewExercisesImages = em.merge(oldExerciseContentCodeOfExercisesImagesListNewExercisesImages);
                    }
                }
            }
            for (Exercises exercisesListNewExercises : exercisesListNew) {
                if (!exercisesListOld.contains(exercisesListNewExercises)) {
                    ExercisesContent oldExerciseContentCodeOfExercisesListNewExercises = exercisesListNewExercises.getExerciseContentCode();
                    exercisesListNewExercises.setExerciseContentCode(exercisesContent);
                    exercisesListNewExercises = em.merge(exercisesListNewExercises);
                    if (oldExerciseContentCodeOfExercisesListNewExercises != null && !oldExerciseContentCodeOfExercisesListNewExercises.equals(exercisesContent)) {
                        oldExerciseContentCodeOfExercisesListNewExercises.getExercisesList().remove(exercisesListNewExercises);
                        oldExerciseContentCodeOfExercisesListNewExercises = em.merge(oldExerciseContentCodeOfExercisesListNewExercises);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = exercisesContent.getExerciseContentCode();
                if (findExercisesContent(id) == null) {
                    throw new NonexistentEntityException("The exercisesContent with id " + id + " no longer exists.");
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
            ExercisesContent exercisesContent;
            try {
                exercisesContent = em.getReference(ExercisesContent.class, id);
                exercisesContent.getExerciseContentCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The exercisesContent with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ExercisesImages> exercisesImagesListOrphanCheck = exercisesContent.getExercisesImagesList();
            for (ExercisesImages exercisesImagesListOrphanCheckExercisesImages : exercisesImagesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ExercisesContent (" + exercisesContent + ") cannot be destroyed since the ExercisesImages " + exercisesImagesListOrphanCheckExercisesImages + " in its exercisesImagesList field has a non-nullable exerciseContentCode field.");
            }
            List<Exercises> exercisesListOrphanCheck = exercisesContent.getExercisesList();
            for (Exercises exercisesListOrphanCheckExercises : exercisesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ExercisesContent (" + exercisesContent + ") cannot be destroyed since the Exercises " + exercisesListOrphanCheckExercises + " in its exercisesList field has a non-nullable exerciseContentCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(exercisesContent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ExercisesContent> findExercisesContentEntities() {
        return findExercisesContentEntities(true, -1, -1);
    }

    public List<ExercisesContent> findExercisesContentEntities(int maxResults, int firstResult) {
        return findExercisesContentEntities(false, maxResults, firstResult);
    }

    private List<ExercisesContent> findExercisesContentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ExercisesContent.class));
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

    public ExercisesContent findExercisesContent(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ExercisesContent.class, id);
        } finally {
            em.close();
        }
    }

    public int getExercisesContentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ExercisesContent> rt = cq.from(ExercisesContent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
