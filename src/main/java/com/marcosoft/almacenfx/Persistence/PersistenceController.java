
package com.marcosoft.almacenfx.Persistence;

import com.marcosoft.almacenfx.Logic.*;

/**
 *
 * @author MazMorr
 */
public class PersistenceController {
    BilleteraJpaController walletJpa = new BilleteraJpaController();
    CategoriaJpaController categoryJpa = new CategoriaJpaController();
    CuentaJpaController accountJpa = new CuentaJpaController();
    MonedaJpaController coinJpa = new MonedaJpaController();
    ProductoJpaController productJpa= new ProductoJpaController();
    TipoTransaccionJpaController transactionTypeJpa = new TipoTransaccionJpaController();
    TransaccionJpaController transactionJpa = new TransaccionJpaController();

    public void addWallet(Billetera wallet) {
        walletJpa.create(wallet);
    }
    public void addCategory(Categoria category) {
        categoryJpa.create(category);
    }
    public void addAccount (Cuenta account){
        accountJpa.create(account);
    }
    public void addCoin (Moneda coin){
        coinJpa.create(coin);
    }
    public void addProduct (Producto product){
        productJpa.create(product);
    }
    public void addTransactionType(TipoTransaccion transactionType){
        transactionTypeJpa.create(transactionType);
    }
    public void addTransaction(Transaccion transaction){
        transactionJpa.create(transaction);
    }
}
