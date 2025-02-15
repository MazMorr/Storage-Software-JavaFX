
package com.marcosoft.almacenfx.Logic;

import java.math.BigDecimal;
import com.marcosoft.almacenfx.Persistence.PersistenceController;

/**
 *
 * @author MazMorr
 */
public class LogicPersistenceController {
    
    PersistenceController controlPersis= new PersistenceController();
    
    public void addWallet(Cuenta account, BigDecimal balance) {
        Billetera wallet = new Billetera();

        wallet.setCuenta(account);
        wallet.setSaldo(balance);
       
        controlPersis.addWallet(wallet);
    }
    public void addCategory(String nombreCategoria){
         Categoria category = new Categoria();

         category.setNombreCategoria(nombreCategoria);

         controlPersis.addCategory(category);
    }
    public void addAccount(String name, String password){
        Cuenta account = new Cuenta();

        account.setName(name);
        account.setPassword(password);

        controlPersis.addAccount(account);
    }
    public void addCoin(String idCoin, String coinName){
        Moneda coin = new Moneda();

        coin.setIdMoneda(idCoin);
        coin.setNombreMoneda(coinName);

        controlPersis.addCoin(coin);
    }
    public void addProduct(String name, Categoria category){
        Producto product= new Producto();

        product.setNameProduct(name);
        product.setCategoria(category);

        controlPersis.addProduct(product);
    }
    public void addTransactionType(int idTransaction, String name){
        TipoTransaccion transactionType = new TipoTransaccion();

        transactionType.setNombreTransaccion(name);
        transactionType.setIdTipoTransaccion(idTransaction);

        controlPersis.addTransactionType(transactionType);
    }
    public void addTransaction(){
        Transaccion transaction = new Transaccion();

        transaction.setFecha();
        transaction.setCantidad();

        controlPersis.addTransaction(transaction);
    }
}
