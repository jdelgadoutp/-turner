/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.Servicetailm;
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
public class ServicetailmJpaController implements Serializable {

    public ServicetailmJpaController() {
    }

    public ServicetailmJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicetailm servicetailm) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(servicetailm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicetailm servicetailm) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Integer id = servicetailm.getTurn();
            if (findServicetailm(id) == null) {
                throw new NonexistentEntityException("The servicetailm with id " + id + " no longer exists.");
            }
            servicetailm = em.merge(servicetailm);
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

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicetailm servicetailm;
            try {
                servicetailm = em.getReference(Servicetailm.class, id);
                servicetailm.getTurn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicetailm with id " + id + " no longer exists.", enfe);
            }
            em.remove(servicetailm);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicetailm> findServicetailmEntities() {
        return findServicetailmEntities(true, -1, -1);
    }

    public List<Servicetailm> findServicetailmEntities(int maxResults, int firstResult) {
        return findServicetailmEntities(false, maxResults, firstResult);
    }

    private List<Servicetailm> findServicetailmEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicetailm.class));
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

    public Servicetailm findServicetailm(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicetailm.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicetailmCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicetailm> rt = cq.from(Servicetailm.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
