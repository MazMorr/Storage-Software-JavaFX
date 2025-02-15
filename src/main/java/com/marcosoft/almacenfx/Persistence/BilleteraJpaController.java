
package com.marcosoft.almacenfx.Persistence;

import com.marcosoft.almacenfx.Logic.Billetera;
import com.marcosoft.almacenfx.Persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author MazMorr
 */
public class BilleteraJpaController implements Serializable {

    public BilleteraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public BilleteraJpaController(){
        emf = Persistence.createEntityManagerFactory("AlmacenSoftwarePU");
    }
    
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Billetera billetera) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(billetera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Billetera billetera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            billetera = em.merge(billetera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = billetera.getIdBilletera();
                if (findBilletera(id) == null) {
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
            Billetera billetera;
            try {
                billetera = em.getReference(Billetera.class, id);
                billetera.getIdBilletera();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billetera with id " + id + " no longer exists.", enfe);
            }
            em.remove(billetera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Billetera> findBilleteraEntities() {
        return findBilleteraEntities(true, -1, -1);
    }

    public List<Billetera> findBilleteraEntities(int maxResults, int firstResult) {
        return findBilleteraEntities(false, maxResults, firstResult);
    }

    private List<Billetera> findBilleteraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Billetera.class));
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

    public Billetera findBilletera(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Billetera.class, id);
        } finally {
            em.close();
        }
    }

    public int getBilleteraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Billetera> rt = cq.from(Billetera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
