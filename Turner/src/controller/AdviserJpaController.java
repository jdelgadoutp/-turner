/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.Adviser;
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
public class AdviserJpaController implements Serializable {

    public AdviserJpaController() {
    }

    public AdviserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TurnerJpaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Adviser adviser) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(adviser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdviser(adviser.getId()) != null) {
                throw new PreexistingEntityException("Adviser " + adviser + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Adviser adviser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            String id = adviser.getId();
            if (findAdviser(id) == null) {
                throw new NonexistentEntityException("The adviser with id " + id + " no longer exists.");
            }
            adviser = em.merge(adviser);
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
            Adviser adviser;
            try {
                adviser = em.getReference(Adviser.class, id);
                adviser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The adviser with id " + id + " no longer exists.", enfe);
            }
            em.remove(adviser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Adviser> findAdviserEntities() {
        return findAdviserEntities(true, -1, -1);
    }

    public List<Adviser> findAdviserEntities(int maxResults, int firstResult) {
        return findAdviserEntities(false, maxResults, firstResult);
    }

    private List<Adviser> findAdviserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Adviser.class));
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

    public Adviser findAdviser(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Adviser.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdviserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Adviser> rt = cq.from(Adviser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
