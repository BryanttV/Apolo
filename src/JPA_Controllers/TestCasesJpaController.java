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
import Entities.Exercises;
import Entities.TestCases;
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
public class TestCasesJpaController implements Serializable {

    public TestCasesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TestCases testCases) throws PreexistingEntityException, Exception {
        if (testCases.getExercisesList() == null) {
            testCases.setExercisesList(new ArrayList<Exercises>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Exercises> attachedExercisesList = new ArrayList<Exercises>();
            for (Exercises exercisesListExercisesToAttach : testCases.getExercisesList()) {
                exercisesListExercisesToAttach = em.getReference(exercisesListExercisesToAttach.getClass(), exercisesListExercisesToAttach.getExerciseCode());
                attachedExercisesList.add(exercisesListExercisesToAttach);
            }
            testCases.setExercisesList(attachedExercisesList);
            em.persist(testCases);
            for (Exercises exercisesListExercises : testCases.getExercisesList()) {
                TestCases oldTestCasesCodeOfExercisesListExercises = exercisesListExercises.getTestCasesCode();
                exercisesListExercises.setTestCasesCode(testCases);
                exercisesListExercises = em.merge(exercisesListExercises);
                if (oldTestCasesCodeOfExercisesListExercises != null) {
                    oldTestCasesCodeOfExercisesListExercises.getExercisesList().remove(exercisesListExercises);
                    oldTestCasesCodeOfExercisesListExercises = em.merge(oldTestCasesCodeOfExercisesListExercises);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTestCases(testCases.getTestCasesCode()) != null) {
                throw new PreexistingEntityException("TestCases " + testCases + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TestCases testCases) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TestCases persistentTestCases = em.find(TestCases.class, testCases.getTestCasesCode());
            List<Exercises> exercisesListOld = persistentTestCases.getExercisesList();
            List<Exercises> exercisesListNew = testCases.getExercisesList();
            List<String> illegalOrphanMessages = null;
            for (Exercises exercisesListOldExercises : exercisesListOld) {
                if (!exercisesListNew.contains(exercisesListOldExercises)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Exercises " + exercisesListOldExercises + " since its testCasesCode field is not nullable.");
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
            testCases.setExercisesList(exercisesListNew);
            testCases = em.merge(testCases);
            for (Exercises exercisesListNewExercises : exercisesListNew) {
                if (!exercisesListOld.contains(exercisesListNewExercises)) {
                    TestCases oldTestCasesCodeOfExercisesListNewExercises = exercisesListNewExercises.getTestCasesCode();
                    exercisesListNewExercises.setTestCasesCode(testCases);
                    exercisesListNewExercises = em.merge(exercisesListNewExercises);
                    if (oldTestCasesCodeOfExercisesListNewExercises != null && !oldTestCasesCodeOfExercisesListNewExercises.equals(testCases)) {
                        oldTestCasesCodeOfExercisesListNewExercises.getExercisesList().remove(exercisesListNewExercises);
                        oldTestCasesCodeOfExercisesListNewExercises = em.merge(oldTestCasesCodeOfExercisesListNewExercises);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = testCases.getTestCasesCode();
                if (findTestCases(id) == null) {
                    throw new NonexistentEntityException("The testCases with id " + id + " no longer exists.");
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
            TestCases testCases;
            try {
                testCases = em.getReference(TestCases.class, id);
                testCases.getTestCasesCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The testCases with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Exercises> exercisesListOrphanCheck = testCases.getExercisesList();
            for (Exercises exercisesListOrphanCheckExercises : exercisesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TestCases (" + testCases + ") cannot be destroyed since the Exercises " + exercisesListOrphanCheckExercises + " in its exercisesList field has a non-nullable testCasesCode field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(testCases);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TestCases> findTestCasesEntities() {
        return findTestCasesEntities(true, -1, -1);
    }

    public List<TestCases> findTestCasesEntities(int maxResults, int firstResult) {
        return findTestCasesEntities(false, maxResults, firstResult);
    }

    private List<TestCases> findTestCasesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TestCases.class));
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

    public TestCases findTestCases(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TestCases.class, id);
        } finally {
            em.close();
        }
    }

    public int getTestCasesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TestCases> rt = cq.from(TestCases.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
