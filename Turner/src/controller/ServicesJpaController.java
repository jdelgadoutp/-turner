/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.Services;
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
public class ServicesJpaController implements Serializable {

    public ServicesJpaController() {
    }
    
    public ServicesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");
    
    public void create(Services services) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(services);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findServices(services.getId()) != null) {
                throw new PreexistingEntityException("Services " + services + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Services services) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = services.getId();
                if (findServices(id) == null) {
                    throw new NonexistentEntityException("The services with id " + id + " no longer exists.");
                }
            services = em.merge(services);
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
            Services services;
            try {
                services = em.getReference(Services.class, id);
                services.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The services with id " + id + " no longer exists.", enfe);
            }
            em.remove(services);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Services> findServicesEntities() {
        return findServicesEntities(true, -1, -1);
    }

    public List<Services> findServicesEntities(int maxResults, int firstResult) {
        return findServicesEntities(false, maxResults, firstResult);
    }

    private List<Services> findServicesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Services.class));
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

    public Services findServices(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Services.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Services> rt = cq.from(Services.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
