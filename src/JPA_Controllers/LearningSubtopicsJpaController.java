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
import Entities.LearningTopics;
import Entities.Codes;
import java.util.ArrayList;
import java.util.List;
import Entities.LearningImages;
import Entities.LearningSubtopics;
import JPA_Controllers.exceptions.IllegalOrphanException;
import JPA_Controllers.exceptions.NonexistentEntityException;
import JPA_Controllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author david
 */
public class LearningSubtopicsJpaController implements Serializable {

    public LearningSubtopicsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LearningSubtopics learningSubtopics) throws PreexistingEntityException, Exception {
        if (learningSubtopics.getCodesList() == null) {
            learningSubtopics.setCodesList(new ArrayList<Codes>());
        }
        if (learningSubtopics.getLearningImagesList() == null) {
            learningSubtopics.setLearningImagesList(new ArrayList<LearningImages>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningTopics learningTopicCode = learningSubtopics.getLearningTopicCode();
            if (learningTopicCode != null) {
                learningTopicCode = em.getReference(learningTopicCode.getClass(), learningTopicCode.getLearningTopicCode());
                learningSubtopics.setLearningTopicCode(learningTopicCode);
            }
            List<Codes> attachedCodesList = new ArrayList<Codes>();
            for (Codes codesListCodesToAttach : learningSubtopics.getCodesList()) {
                codesListCodesToAttach = em.getReference(codesListCodesToAttach.getClass(), codesListCodesToAttach.getCodeId());
                attachedCodesList.add(codesListCodesToAttach);
            }
            learningSubtopics.setCodesList(attachedCodesList);
            List<LearningImages> attachedLearningImagesList = new ArrayList<LearningImages>();
            for (LearningImages learningImagesListLearningImagesToAttach : learningSubtopics.getLearningImagesList()) {
                learningImagesListLearningImagesToAttach = em.getReference(learningImagesListLearningImagesToAttach.getClass(), learningImagesListLearningImagesToAttach.getLearningImageId());
                attachedLearningImagesList.add(learningImagesListLearningImagesToAttach);
            }
            learningSubtopics.setLearningImagesList(attachedLearningImagesList);
            em.persist(learningSubtopics);
            if (learningTopicCode != null) {
                learningTopicCode.getLearningSubtopicsList().add(learningSubtopics);
                learningTopicCode = em.merge(learningTopicCode);
            }
            for (Codes codesListCodes : learningSubtopics.getCodesList()) {
                LearningSubtopics oldLearningSubIdOfCodesListCodes = codesListCodes.getLearningSubId();
                codesListCodes.setLearningSubId(learningSubtopics);
                codesListCodes = em.merge(codesListCodes);
                if (oldLearningSubIdOfCodesListCodes != null) {
                    oldLearningSubIdOfCodesListCodes.getCodesList().remove(codesListCodes);
                    oldLearningSubIdOfCodesListCodes = em.merge(oldLearningSubIdOfCodesListCodes);
                }
            }
            for (LearningImages learningImagesListLearningImages : learningSubtopics.getLearningImagesList()) {
                LearningSubtopics oldLearningSubIdOfLearningImagesListLearningImages = learningImagesListLearningImages.getLearningSubId();
                learningImagesListLearningImages.setLearningSubId(learningSubtopics);
                learningImagesListLearningImages = em.merge(learningImagesListLearningImages);
                if (oldLearningSubIdOfLearningImagesListLearningImages != null) {
                    oldLearningSubIdOfLearningImagesListLearningImages.getLearningImagesList().remove(learningImagesListLearningImages);
                    oldLearningSubIdOfLearningImagesListLearningImages = em.merge(oldLearningSubIdOfLearningImagesListLearningImages);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLearningSubtopics(learningSubtopics.getLearningSubId()) != null) {
                throw new PreexistingEntityException("LearningSubtopics " + learningSubtopics + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LearningSubtopics learningSubtopics) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LearningSubtopics persistentLearningSubtopics = em.find(LearningSubtopics.class, learningSubtopics.getLearningSubId());
            LearningTopics learningTopicCodeOld = persistentLearningSubtopics.getLearningTopicCode();
            LearningTopics learningTopicCodeNew = learningSubtopics.getLearningTopicCode();
            List<Codes> codesListOld = persistentLearningSubtopics.getCodesList();
            List<Codes> codesListNew = learningSubtopics.getCodesList();
            List<LearningImages> learningImagesListOld = persistentLearningSubtopics.getLearningImagesList();
            List<LearningImages> learningImagesListNew = learningSubtopics.getLearningImagesList();
            List<String> illegalOrphanMessages = null;
            for (Codes codesListOldCodes : codesListOld) {
                if (!codesListNew.contains(codesListOldCodes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Codes " + codesListOldCodes + " since its learningSubId field is not nullable.");
                }
            }
            for (LearningImages learningImagesListOldLearningImages : learningImagesListOld) {
                if (!learningImagesListNew.contains(learningImagesListOldLearningImages)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LearningImages " + learningImagesListOldLearningImages + " since its learningSubId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (learningTopicCodeNew != null) {
                learningTopicCodeNew = em.getReference(learningTopicCodeNew.getClass(), learningTopicCodeNew.getLearningTopicCode());
                learningSubtopics.setLearningTopicCode(learningTopicCodeNew);
            }
            List<Codes> attachedCodesListNew = new ArrayList<Codes>();
            for (Codes codesListNewCodesToAttach : codesListNew) {
                codesListNewCodesToAttach = em.getReference(codesListNewCodesToAttach.getClass(), codesListNewCodesToAttach.getCodeId());
                attachedCodesListNew.add(codesListNewCodesToAttach);
            }
            codesListNew = attachedCodesListNew;
            learningSubtopics.setCodesList(codesListNew);
            List<LearningImages> attachedLearningImagesListNew = new ArrayList<LearningImages>();
            for (LearningImages learningImagesListNewLearningImagesToAttach : learningImagesListNew) {
                learningImagesListNewLearningImagesToAttach = em.getReference(learningImagesListNewLearningImagesToAttach.getClass(), learningImagesListNewLearningImagesToAttach.getLearningImageId());
                attachedLearningImagesListNew.add(learningImagesListNewLearningImagesToAttach);
            }
            learningImagesListNew = attachedLearningImagesListNew;
            learningSubtopics.setLearningImagesList(learningImagesListNew);
            learningSubtopics = em.merge(learningSubtopics);
            if (learningTopicCodeOld != null && !learningTopicCodeOld.equals(learningTopicCodeNew)) {
                learningTopicCodeOld.getLearningSubtopicsList().remove(learningSubtopics);
                learningTopicCodeOld = em.merge(learningTopicCodeOld);
            }
            if (learningTopicCodeNew != null && !learningTopicCodeNew.equals(learningTopicCodeOld)) {
                learningTopicCodeNew.getLearningSubtopicsList().add(learningSubtopics);
                learningTopicCodeNew = em.merge(learningTopicCodeNew);
            }
            for (Codes codesListNewCodes : codesListNew) {
                if (!codesListOld.contains(codesListNewCodes)) {
                    LearningSubtopics oldLearningSubIdOfCodesListNewCodes = codesListNewCodes.getLearningSubId();
                    codesListNewCodes.setLearningSubId(learningSubtopics);
                    codesListNewCodes = em.merge(codesListNewCodes);
                    if (oldLearningSubIdOfCodesListNewCodes != null && !oldLearningSubIdOfCodesListNewCodes.equals(learningSubtopics)) {
                        oldLearningSubIdOfCodesListNewCodes.getCodesList().remove(codesListNewCodes);
                        oldLearningSubIdOfCodesListNewCodes = em.merge(oldLearningSubIdOfCodesListNewCodes);
                    }
                }
            }
            for (LearningImages learningImagesListNewLearningImages : learningImagesListNew) {
                if (!learningImagesListOld.contains(learningImagesListNewLearningImages)) {
                    LearningSubtopics oldLearningSubIdOfLearningImagesListNewLearningImages = learningImagesListNewLearningImages.getLearningSubId();
                    learningImagesListNewLearningImages.setLearningSubId(learningSubtopics);
                    learningImagesListNewLearningImages = em.merge(learningImagesListNewLearningImages);
                    if (oldLearningSubIdOfLearningImagesListNewLearningImages != null && !oldLearningSubIdOfLearningImagesListNewLearningImages.equals(learningSubtopics)) {
                        oldLearningSubIdOfLearningImagesListNewLearningImages.getLearningImagesList().remove(learningImagesListNewLearningImages);
                        oldLearningSubIdOfLearningImagesListNewLearningImages = em.merge(oldLearningSubIdOfLearningImagesListNewLearningImages);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = learningSubtopics.getLearningSubId();
                if (findLearningSubtopics(id) == null) {
                    throw new NonexistentEntityException("The learningSubtopics with id " + id + " no longer exists.");
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
            LearningSubtopics learningSubtopics;
            try {
                learningSubtopics = em.getReference(LearningSubtopics.class, id);
                learningSubtopics.getLearningSubId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The learningSubtopics with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Codes> codesListOrphanCheck = learningSubtopics.getCodesList();
            for (Codes codesListOrphanCheckCodes : codesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LearningSubtopics (" + learningSubtopics + ") cannot be destroyed since the Codes " + codesListOrphanCheckCodes + " in its codesList field has a non-nullable learningSubId field.");
            }
            List<LearningImages> learningImagesListOrphanCheck = learningSubtopics.getLearningImagesList();
            for (LearningImages learningImagesListOrphanCheckLearningImages : learningImagesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LearningSubtopics (" + learningSubtopics + ") cannot be destroyed since the LearningImages " + learningImagesListOrphanCheckLearningImages + " in its learningImagesList field has a non-nullable learningSubId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            LearningTopics learningTopicCode = learningSubtopics.getLearningTopicCode();
            if (learningTopicCode != null) {
                learningTopicCode.getLearningSubtopicsList().remove(learningSubtopics);
                learningTopicCode = em.merge(learningTopicCode);
            }
            em.remove(learningSubtopics);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LearningSubtopics> findLearningSubtopicsEntities() {
        return findLearningSubtopicsEntities(true, -1, -1);
    }

    public List<LearningSubtopics> findLearningSubtopicsEntities(int maxResults, int firstResult) {
        return findLearningSubtopicsEntities(false, maxResults, firstResult);
    }

    private List<LearningSubtopics> findLearningSubtopicsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LearningSubtopics.class));
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

    public LearningSubtopics findLearningSubtopics(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LearningSubtopics.class, id);
        } finally {
            em.close();
        }
    }

    public int getLearningSubtopicsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LearningSubtopics> rt = cq.from(LearningSubtopics.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
