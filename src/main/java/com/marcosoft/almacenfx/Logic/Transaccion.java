package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Transaccion")
public class Transaccion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_transaccion;

    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal precio;

    @Column(nullable=false)
    private int cantidad;

    @Column(nullable=false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name="id_moneda", nullable=false)
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name="id_cuenta", nullable=false)
    private Cuenta id_cuenta;

    @ManyToOne
    @JoinColumn(name="id_product", nullable=false)
    private Producto id_product;

    @ManyToOne
    @JoinColumn(name="tipo_transaccion", nullable=false)
    private TipoTransaccion tipo_transaccion;

    public Transaccion() {
    }

    public Transaccion(BigDecimal precio, Producto product, TipoTransaccion transactionType, Cuenta account, Moneda coin, int cantidad, LocalDate fecha) {
        this.precio = precio;
        this.id_product = product;
        this.tipo_transaccion = transactionType;
        this.id_cuenta = account;
        this.moneda = coin;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdTransaccion() {
        return id_transaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.id_transaccion = idTransaccion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cuenta getAccount() {
        return id_cuenta;
    }

    public void setAccount(Cuenta account) {
        this.id_cuenta = account;
    }

    public Producto getProduct() {
        return id_product;
    }

    public void setProduct(Producto product) {
        this.id_product = product;
    }

    public TipoTransaccion getTransactionType() {
        return tipo_transaccion;
    }

    public void setTransactionType(TipoTransaccion transactionType) {
        this.tipo_transaccion = transactionType;
    }

    public Moneda getCoin() {
        return moneda;
    }

    public void setCoin(Moneda coin) {
        this.moneda = coin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
