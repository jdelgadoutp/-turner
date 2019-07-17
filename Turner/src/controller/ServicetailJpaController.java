/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.Servicetail;
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
public class ServicetailJpaController implements Serializable {

    public ServicetailJpaController() {
    }

    public ServicetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicetail servicetail) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(servicetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findServicetail(servicetail.getService()) != null) {
                throw new PreexistingEntityException("Servicetail " + servicetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicetail servicetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = servicetail.getService();
            if (findServicetail(id) == null) {
                throw new NonexistentEntityException("The servicetail with id " + id + " no longer exists.");
            }
            servicetail = em.merge(servicetail);
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
            Servicetail servicetail;
            try {
                servicetail = em.getReference(Servicetail.class, id);
                servicetail.getService();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(servicetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicetail> findServicetailEntities() {
        return findServicetailEntities(true, -1, -1);
    }

    public List<Servicetail> findServicetailEntities(int maxResults, int firstResult) {
        return findServicetailEntities(false, maxResults, firstResult);
    }

    private List<Servicetail> findServicetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicetail.class));
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

    public Servicetail findServicetail(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicetail> rt = cq.from(Servicetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
