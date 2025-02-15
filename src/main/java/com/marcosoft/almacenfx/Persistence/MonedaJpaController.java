/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Persistence;

import com.marcosoft.almacenfx.Persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import com.marcosoft.almacenfx.Logic.Moneda;

/**
 *
 * @author MazMorr
 */
public class MonedaJpaController implements Serializable {

    public MonedaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public MonedaJpaController(){
        emf = Persistence.createEntityManagerFactory("AlmacenSoftwarePU");
    }

    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moneda moneda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moneda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moneda moneda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moneda = em.merge(moneda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moneda.getIdMoneda();
                if (findMoneda(id) == null) {
                    throw new NonexistentEntityException("The billetera with id " + id + " no longer exists.");
                }
            }
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
            Moneda moneda;
            try {
                moneda = em.getReference(Moneda.class, id);
                moneda.getIdMoneda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billetera with id " + id + " no longer exists.", enfe);
            }
            em.remove(moneda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moneda> findMonedaEntities() {
        return findMonedaEntities(true, -1, -1);
    }

    public List<Moneda> findMonedaEntities(int maxResults, int firstResult) {
        return findMonedaEntities(false, maxResults, firstResult);
    }

    private List<Moneda> findMonedaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moneda.class));
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

    public Moneda findMoneda(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moneda.class, id);
        } finally {
            em.close();
        }
    }

    public int getMonedaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moneda> rt = cq.from(Moneda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
