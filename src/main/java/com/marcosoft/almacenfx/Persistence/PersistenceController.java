package com.marcosoft.almacenfx.Persistence;

import com.marcosoft.almacenfx.Logic.*;
import jakarta.persistence.*;

public class PersistenceController {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersistenceController() {
        try {
            // 1. Crear el EntityManagerFactory usando el nombre de la unidad de persistencia
            emf = Persistence.createEntityManagerFactory("AlmacenPU");

            // 2. Crear el EntityManager
            em = emf.createEntityManager();

            // 3. Verificar que la conexión es válida
            if (!em.isOpen()) {
                throw new PersistenceException("No se pudo abrir el EntityManager");
            }
        } catch (PersistenceException e) {
            // Manejo de errores
            System.err.println("Error al inicializar JPA: " + e.getMessage());
            throw e;
        }
    }

    // Método para obtener el EntityManager actual
    private EntityManager getEntityManager() {
        return em;
    }

    // Métodos para Billetera
    public void addWallet(Billetera wallet) {
        executeInTransaction(() -> em.persist(wallet));
    }

    public Billetera findWallet(int id) {
        return em.find(Billetera.class, id);
    }

    public void updateWallet(Billetera wallet) {
        executeInTransaction(() -> em.merge(wallet));
    }

    public void deleteWallet(int id) {
        executeInTransaction(() -> {
            Billetera wallet = em.find(Billetera.class, id);
            if (wallet != null) {
                em.remove(wallet);
            }
        });
    }

    // Métodos para Categoria
    public void addCategory(Categoria category) {
        executeInTransaction(() -> em.persist(category));
    }

    public Categoria findCategory(int id) {
        return em.find(Categoria.class, id);
    }

    public Categoria findCategoryByName(String categoryName) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Categoria c WHERE c.nombreCategoria = :name", Categoria.class)
                     .setParameter("name", categoryName)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void updateCategory(Categoria category) {
        executeInTransaction(() -> em.merge(category));
    }

    public void deleteCategory(int id) {
        executeInTransaction(() -> {
            Categoria category = em.find(Categoria.class, id);
            if (category != null) {
                em.remove(category);
            }
        });
    }

    // Métodos para Cuenta
    public void addAccount(Cuenta account) {
        executeInTransaction(() -> em.persist(account));
    }

    public Cuenta findAccount(int id) {
        return em.find(Cuenta.class, id);
    }

    public void updateAccount(Cuenta account) {
        executeInTransaction(() -> em.merge(account));
    }

    public void deleteAccount(int id) {
        executeInTransaction(() -> {
            Cuenta account = em.find(Cuenta.class, id);
            if (account != null) {
                em.remove(account);
            }
        });
    }

    public boolean isAccountValid(String nombre, String contrasena) {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(c) FROM Cuenta c WHERE c.nombre = :nombre AND c.contrasena = :contrasena", Long.class)
                .setParameter("nombre", nombre)
                .setParameter("contrasena", contrasena)
                .getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

    // Métodos para Moneda
    public void addCoin(Moneda coin) {
        executeInTransaction(() -> em.persist(coin));
    }

    public Moneda findCoin(int id) {
        return em.find(Moneda.class, id);
    }

    public void updateCoin(Moneda coin) {
        executeInTransaction(() -> em.merge(coin));
    }

    public void deleteCoin(int id) {
        executeInTransaction(() -> {
            Moneda coin = em.find(Moneda.class, id);
            if (coin != null) {
                em.remove(coin);
            }
        });
    }

    // Métodos para Producto
    public void addProduct(Producto product) {
        executeInTransaction(() -> em.persist(product));
    }

    public Producto findProduct(int id) {
        return em.find(Producto.class, id);
    }

    public void updateProduct(Producto product) {
        executeInTransaction(() -> em.merge(product));
    }

    public void deleteProduct(int id) {
        executeInTransaction(() -> {
            Producto product = em.find(Producto.class, id);
            if (product != null) {
                em.remove(product);
            }
        });
    }

    // Métodos para TipoTransaccion
    public void addTransactionType(TipoTransaccion transactionType) {
        executeInTransaction(() -> em.persist(transactionType));
    }

    public TipoTransaccion findTransactionType(int id) {
        return em.find(TipoTransaccion.class, id);
    }

    public void updateTransactionType(TipoTransaccion transactionType) {
        executeInTransaction(() -> em.merge(transactionType));
    }

    public void deleteTransactionType(int id) {
        executeInTransaction(() -> {
            TipoTransaccion transactionType = em.find(TipoTransaccion.class, id);
            if (transactionType != null) {
                em.remove(transactionType);
            }
        });
    }

    // Métodos para Transaccion
    public void addTransaction(Transaccion transaction) {
        executeInTransaction(() -> em.persist(transaction));
    }

    public Transaccion findTransaction(int id) {
        return em.find(Transaccion.class, id);
    }

    public void updateTransaction(Transaccion transaction) {
        executeInTransaction(() -> em.merge(transaction));
    }

    public void deleteTransaction(int id) {
        executeInTransaction(() -> {
            Transaccion transaction = em.find(Transaccion.class, id);
            if (transaction != null) {
                em.remove(transaction);
            }
        });
    }

    // Método genérico para ejecutar operaciones en transacción
    private void executeInTransaction(Runnable operation) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            operation.run();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error en la transacción", e);
        }
    }

    private void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}