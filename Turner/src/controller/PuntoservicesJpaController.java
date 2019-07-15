/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.Puntoservices;
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
public class PuntoservicesJpaController implements Serializable {

    public PuntoservicesJpaController() {
    }

    public PuntoservicesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puntoservices puntoservices) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puntoservices);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puntoservices puntoservices) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Integer id = puntoservices.getId();
            if (findPuntoservices(id) == null) {
                throw new NonexistentEntityException("The puntoservices with id " + id + " no longer exists.");
            }
            puntoservices = em.merge(puntoservices);
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
            Puntoservices puntoservices;
            try {
                puntoservices = em.getReference(Puntoservices.class, id);
                puntoservices.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puntoservices with id " + id + " no longer exists.", enfe);
            }
            em.remove(puntoservices);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puntoservices> findPuntoservicesEntities() {
        return findPuntoservicesEntities(true, -1, -1);
    }

    public List<Puntoservices> findPuntoservicesEntities(int maxResults, int firstResult) {
        return findPuntoservicesEntities(false, maxResults, firstResult);
    }

    private List<Puntoservices> findPuntoservicesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puntoservices.class));
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

    public Puntoservices findPuntoservices(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puntoservices.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuntoservicesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puntoservices> rt = cq.from(Puntoservices.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
