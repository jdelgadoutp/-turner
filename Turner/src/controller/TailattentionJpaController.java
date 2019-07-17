/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.Tailattention;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ANDRES
 */
public class TailattentionJpaController implements Serializable {

    public TailattentionJpaController() {
    }

    public TailattentionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tailattention tailattention) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tailattention);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTailattention(tailattention.getService()) != null) {
                throw new PreexistingEntityException("Tailattention " + tailattention + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tailattention tailattention) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = tailattention.getService();
            if (findTailattention(id) == null) {
                throw new NonexistentEntityException("The tailattention with id " + id + " no longer exists.");
            }
            tailattention = em.merge(tailattention);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
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
            Tailattention tailattention;
            try {
                tailattention = em.getReference(Tailattention.class, id);
                tailattention.getService();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tailattention with id " + id + " no longer exists.", enfe);
            }
            em.remove(tailattention);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tailattention> findTailattentionEntities() {
        return findTailattentionEntities(true, -1, -1);
    }

    public List<Tailattention> findTailattentionEntities(int maxResults, int firstResult) {
        return findTailattentionEntities(false, maxResults, firstResult);
    }

    private List<Tailattention> findTailattentionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tailattention.class));
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

    public Tailattention findTailattention(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tailattention.class, id);
        } finally {
            em.close();
        }
    }

    public int getTailattentionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tailattention> rt = cq.from(Tailattention.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
