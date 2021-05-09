/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_Controllers;

import Entities.AlternativeSolutions;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Exercises;
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
public class AlternativeSolutionsJpaController implements Serializable {

    public AlternativeSolutionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AlternativeSolutions alternativeSolutions) throws PreexistingEntityException, Exception {
        if (alternativeSolutions.getExercisesList() == null) {
            alternativeSolutions.setExercisesList(new ArrayList<Exercises>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Exercises> attachedExercisesList = new ArrayList<Exercises>();
            for (Exercises exercisesListExercisesToAttach : alternativeSolutions.getExercisesList()) {
                exercisesListExercisesToAttach = em.getReference(exercisesListExercisesToAttach.getClass(), exercisesListExercisesToAttach.getExerciseCode());
                attachedExercisesList.add(exercisesListExercisesToAttach);
            }
            alternativeSolutions.setExercisesList(attachedExercisesList);
            em.persist(alternativeSolutions);
            for (Exercises exercisesListExercises : alternativeSolutions.getExercisesList()) {
                AlternativeSolutions oldSolutionCodeOfExercisesListExercises = exercisesListExercises.getSolutionCode();
                exercisesListExercises.setSolutionCode(alternativeSolutions);
                exercisesListExercises = em.merge(exercisesListExercises);
                if (oldSolutionCodeOfExercisesListExercises != null) {
                    oldSolutionCodeOfExercisesListExercises.getExercisesList().remove(exercisesListExercises);
                    oldSolutionCodeOfExercisesListExercises = em.merge(oldSolutionCodeOfExercisesListExercises);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlternativeSolutions(alternativeSolutions.getSolutionCode()) != null) {
                throw new PreexistingEntityException("AlternativeSolutions " + alternativeSolutions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlternativeSolutions alternativeSolutions) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlternativeSolutions persistentAlternativeSolutions = em.find(AlternativeSolutions.class, alternativeSolutions.getSolutionCode());
            List<Exercises> exercisesListOld = persistentAlternativeSolutions.getExercisesList();
            List<Exercises> exercisesListNew = alternativeSolutions.getExercisesList();
            List<String> illegalOrphanMessages = null;
            for (Exercises exercisesListOldExercises : exercisesListOld) {
                if (!exercisesListNew.contains(exercisesListOldExercises)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Exercises " + exercisesListOldExercises + " since its solutionCode field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Exercises> attachedExercisesListNew = new ArrayList<Exercises>();
            for (Exercises exercisesListNewExercisesToAttach : exercisesListNew) {
                exercisesListNewExercisesToAttach = em.getReference(exercisesListNewExercisesToAttach.getClass(), exercisesListNewExercisesToAttach.getExerciseCode());
                attachedExercisesListNew.add(exercisesListNewExercisesToAttach);
            }
            exercisesListNew = attachedExercisesListNew;
            alternativeSolutions.setExercisesList(exercisesListNew);
            alternativeSolutions = em.merge(alternativeSolutions);
            for (Exercises exercisesListNewExercises : exercisesListNew) {
                if (!exercisesListOld.contains(exercisesListNewExercises)) {
                    AlternativeSolutions oldSolutionCodeOfExercisesListNewExercises = exercisesListNewExercises.getSolutionCode();
                    exercisesListNewExercises.setSolutionCode(alternativeSolutions);
                    exercisesListNewExercises = em.merge(exercisesListNewExercises);
                    if (oldSolutionCodeOfExercisesListNewExercises != null && !oldSolutionCodeOfExercisesListNewExercises.equals(alternativeSolutions)) {
                        oldSolutionCodeOfExercisesListNewExercises.getExercisesList().remove(exercisesListNewExercises);
                        oldSolutionCodeOfExercisesListNewExercises = em.merge(oldSolutionCodeOfExercisesListNewExercises);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alternativeSolutions.getSolutionCode();
                if (findAlternativeSolutions(id) == null) {
                    throw new NonexistentEntityException("The alternativeSolutions with id " + id + " no longer exists.");
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
            AlternativeSolutions alternativeSolutions;
            try {
                alternativeSolutions = em.getReference(AlternativeSolutions.class, id);
                alternativeSolutions.getSolutionCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alternativeSolutions with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Exercises> exercisesListOrphanCheck = alternativeSolutions.getExercisesList();
            for (Exercises exercisesListOrphanCheckExercises : exercisesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This AlternativeSolutions (" + alternativeSolutions + ") cannot be destroyed since the Exercises " + exercisesListOrphanCheckExercises + " in its exercisesList field has a non-nullable solutionCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alternativeSolutions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlternativeSolutions> findAlternativeSolutionsEntities() {
        return findAlternativeSolutionsEntities(true, -1, -1);
    }

    public List<AlternativeSolutions> findAlternativeSolutionsEntities(int maxResults, int firstResult) {
        return findAlternativeSolutionsEntities(false, maxResults, firstResult);
    }

    private List<AlternativeSolutions> findAlternativeSolutionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlternativeSolutions.class));
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

    public AlternativeSolutions findAlternativeSolutions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlternativeSolutions.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlternativeSolutionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlternativeSolutions> rt = cq.from(AlternativeSolutions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
