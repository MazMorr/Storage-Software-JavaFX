
package com.marcosoft.almacenfx.Logic;

import java.math.BigDecimal;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author MazMorr
 */
@Entity
@Table(name= "billetera")
public class Billetera implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idBilletera;
    
    @ManyToOne
    @JoinColumn(name="id_cuenta", nullable=false)
    private Cuenta cuenta;
    
    @Column(nullable=false,precision=10, scale=2)
    private BigDecimal saldo;

    //Constructors, Getters and Setters
    public Billetera() {
    }

    public Billetera(int idBilletera, Cuenta cuenta, BigDecimal saldo) {
        this.idBilletera = idBilletera;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public int getIdBilletera() {
        return idBilletera;
    }

    public void setIdBilletera(int idBilletera) {
        this.idBilletera = idBilletera;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
}
