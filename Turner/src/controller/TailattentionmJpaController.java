/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.Tailattentionm;
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
public class TailattentionmJpaController implements Serializable {

    public TailattentionmJpaController() {
    }

    public TailattentionmJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tailattentionm tailattentionm) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tailattentionm);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTailattentionm(tailattentionm.getServicefk()) != null) {
                throw new PreexistingEntityException("Tailattentionm " + tailattentionm + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tailattentionm tailattentionm) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = tailattentionm.getServicefk();
            if (findTailattentionm(id) == null) {
                throw new NonexistentEntityException("The tailattentionm with id " + id + " no longer exists.");
            }
            tailattentionm = em.merge(tailattentionm);
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
            Tailattentionm tailattentionm;
            try {
                tailattentionm = em.getReference(Tailattentionm.class, id);
                tailattentionm.getServicefk();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tailattentionm with id " + id + " no longer exists.", enfe);
            }
            em.remove(tailattentionm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tailattentionm> findTailattentionmEntities() {
        return findTailattentionmEntities(true, -1, -1);
    }

    public List<Tailattentionm> findTailattentionmEntities(int maxResults, int firstResult) {
        return findTailattentionmEntities(false, maxResults, firstResult);
    }

    private List<Tailattentionm> findTailattentionmEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tailattentionm.class));
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

    public Tailattentionm findTailattentionm(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tailattentionm.class, id);
        } finally {
            em.close();
        }
    }

    public int getTailattentionmCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tailattentionm> rt = cq.from(Tailattentionm.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
