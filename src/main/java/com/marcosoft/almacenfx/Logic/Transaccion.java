package com.marcosoft.almacenfx.Logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;

/**
 *
 * @author MazMorr
 */
@Entity
@Table(name= "Transaccion")
public class Transaccion {
    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;
    
    @ManyToOne
    @JoinColumn(name="id_cuenta", nullable= false)
    private Cuenta cuenta;
    
    @Column(nullable=false)
    private BigDecimal precio;
    
    @Column(nullable= false)
    private int cantidad;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable= false)
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name= "tipo_transaccion", nullable= false)
    private TipoTransaccion tipoTransaccion;
    
    @ManyToOne
    @JoinColumn(name= "moneda", nullable=false)
    private Moneda moneda;

    //Constructors, Getters and Setters
    public Transaccion() {
    }

    public Transaccion(int idTransaccion, Cuenta cuenta, BigDecimal precio, int cantidad, LocalDate fecha, TipoTransaccion tipoTransaccion, Moneda moneda) {
        this.idTransaccion = idTransaccion;
        this.cuenta = cuenta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
        this.moneda = moneda;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
    
    
    
}
