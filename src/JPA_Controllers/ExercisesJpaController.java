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
import Entities.AlternativeSolutions;
import Entities.Exercises;
import Entities.ExercisesContent;
import Entities.TestCases;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class ExercisesJpaController implements Serializable {

    public ExercisesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Exercises exercises) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlternativeSolutions solutionCode = exercises.getSolutionCode();
            if (solutionCode != null) {
                solutionCode = em.getReference(solutionCode.getClass(), solutionCode.getSolutionCode());
                exercises.setSolutionCode(solutionCode);
            }
            ExercisesContent exerciseContentCode = exercises.getExerciseContentCode();
            if (exerciseContentCode != null) {
                exerciseContentCode = em.getReference(exerciseContentCode.getClass(), exerciseContentCode.getExerciseContentCode());
                exercises.setExerciseContentCode(exerciseContentCode);
            }
            TestCases testCasesCode = exercises.getTestCasesCode();
            if (testCasesCode != null) {
                testCasesCode = em.getReference(testCasesCode.getClass(), testCasesCode.getTestCasesCode());
                exercises.setTestCasesCode(testCasesCode);
            }
            em.persist(exercises);
            if (solutionCode != null) {
                solutionCode.getExercisesList().add(exercises);
                solutionCode = em.merge(solutionCode);
            }
            if (exerciseContentCode != null) {
                exerciseContentCode.getExercisesList().add(exercises);
                exerciseContentCode = em.merge(exerciseContentCode);
            }
            if (testCasesCode != null) {
                testCasesCode.getExercisesList().add(exercises);
                testCasesCode = em.merge(testCasesCode);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExercises(exercises.getExerciseCode()) != null) {
                throw new PreexistingEntityException("Exercises " + exercises + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Exercises exercises) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Exercises persistentExercises = em.find(Exercises.class, exercises.getExerciseCode());
            AlternativeSolutions solutionCodeOld = persistentExercises.getSolutionCode();
            AlternativeSolutions solutionCodeNew = exercises.getSolutionCode();
            ExercisesContent exerciseContentCodeOld = persistentExercises.getExerciseContentCode();
            ExercisesContent exerciseContentCodeNew = exercises.getExerciseContentCode();
            TestCases testCasesCodeOld = persistentExercises.getTestCasesCode();
            TestCases testCasesCodeNew = exercises.getTestCasesCode();
            if (solutionCodeNew != null) {
                solutionCodeNew = em.getReference(solutionCodeNew.getClass(), solutionCodeNew.getSolutionCode());
                exercises.setSolutionCode(solutionCodeNew);
            }
            if (exerciseContentCodeNew != null) {
                exerciseContentCodeNew = em.getReference(exerciseContentCodeNew.getClass(), exerciseContentCodeNew.getExerciseContentCode());
                exercises.setExerciseContentCode(exerciseContentCodeNew);
            }
            if (testCasesCodeNew != null) {
                testCasesCodeNew = em.getReference(testCasesCodeNew.getClass(), testCasesCodeNew.getTestCasesCode());
                exercises.setTestCasesCode(testCasesCodeNew);
            }
            exercises = em.merge(exercises);
            if (solutionCodeOld != null && !solutionCodeOld.equals(solutionCodeNew)) {
                solutionCodeOld.getExercisesList().remove(exercises);
                solutionCodeOld = em.merge(solutionCodeOld);
            }
            if (solutionCodeNew != null && !solutionCodeNew.equals(solutionCodeOld)) {
                solutionCodeNew.getExercisesList().add(exercises);
                solutionCodeNew = em.merge(solutionCodeNew);
            }
            if (exerciseContentCodeOld != null && !exerciseContentCodeOld.equals(exerciseContentCodeNew)) {
                exerciseContentCodeOld.getExercisesList().remove(exercises);
                exerciseContentCodeOld = em.merge(exerciseContentCodeOld);
            }
            if (exerciseContentCodeNew != null && !exerciseContentCodeNew.equals(exerciseContentCodeOld)) {
                exerciseContentCodeNew.getExercisesList().add(exercises);
                exerciseContentCodeNew = em.merge(exerciseContentCodeNew);
            }
            if (testCasesCodeOld != null && !testCasesCodeOld.equals(testCasesCodeNew)) {
                testCasesCodeOld.getExercisesList().remove(exercises);
                testCasesCodeOld = em.merge(testCasesCodeOld);
            }
            if (testCasesCodeNew != null && !testCasesCodeNew.equals(testCasesCodeOld)) {
                testCasesCodeNew.getExercisesList().add(exercises);
                testCasesCodeNew = em.merge(testCasesCodeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = exercises.getExerciseCode();
                if (findExercises(id) == null) {
                    throw new NonexistentEntityException("The exercises with id " + id + " no longer exists.");
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
            Exercises exercises;
            try {
                exercises = em.getReference(Exercises.class, id);
                exercises.getExerciseCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The exercises with id " + id + " no longer exists.", enfe);
            }
            AlternativeSolutions solutionCode = exercises.getSolutionCode();
            if (solutionCode != null) {
                solutionCode.getExercisesList().remove(exercises);
                solutionCode = em.merge(solutionCode);
            }
            ExercisesContent exerciseContentCode = exercises.getExerciseContentCode();
            if (exerciseContentCode != null) {
                exerciseContentCode.getExercisesList().remove(exercises);
                exerciseContentCode = em.merge(exerciseContentCode);
            }
            TestCases testCasesCode = exercises.getTestCasesCode();
            if (testCasesCode != null) {
                testCasesCode.getExercisesList().remove(exercises);
                testCasesCode = em.merge(testCasesCode);
            }
            em.remove(exercises);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Exercises> findExercisesEntities() {
        return findExercisesEntities(true, -1, -1);
    }

    public List<Exercises> findExercisesEntities(int maxResults, int firstResult) {
        return findExercisesEntities(false, maxResults, firstResult);
    }

    private List<Exercises> findExercisesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Exercises.class));
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

    public Exercises findExercises(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Exercises.class, id);
        } finally {
            em.close();
        }
    }

    public int getExercisesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Exercises> rt = cq.from(Exercises.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
