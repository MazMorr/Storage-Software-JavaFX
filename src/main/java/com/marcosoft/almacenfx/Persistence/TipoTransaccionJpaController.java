/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Persistence;

import com.marcosoft.almacenfx.Logic.TipoTransaccion;
import com.marcosoft.almacenfx.Persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

/**
 *
 * @author MazMorr
 */
public class TipoTransaccionJpaController {
    public TipoTransaccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public TipoTransaccionJpaController(){
        emf = Persistence.createEntityManagerFactory("AlmacenSoftwarePU");
    }

    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoTransaccion tipoTransaccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoTransaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoTransaccion tipoTransaccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoTransaccion = em.merge(tipoTransaccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoTransaccion.getIdTipoTransaccion();
                if (findTipoTransaccion(id) == null) {
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

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoTransaccion tipoTransaccion;
            try {
                tipoTransaccion = em.getReference(TipoTransaccion.class, id);
                tipoTransaccion.getIdTipoTransaccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billetera with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoTransaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoTransaccion> findTipoTransaccionEntities() {
        return findTipoTransaccionEntities(true, -1, -1);
    }

    public List<TipoTransaccion> findTipoTransaccionEntities(int maxResults, int firstResult) {
        return findTipoTransaccionEntities(false, maxResults, firstResult);
    }

    private List<TipoTransaccion> findTipoTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoTransaccion.class));
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

    public TipoTransaccion findTipoTransaccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoTransaccion.class, id);
        } finally {
            em.close();
        }
    }


    public int getTipoTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoTransaccion> rt = cq.from(TipoTransaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
