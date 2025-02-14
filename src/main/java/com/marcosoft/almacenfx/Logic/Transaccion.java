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
    private int idTransaccion;

    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal precio;

    @Column(nullable=false)
    private int cantidad;

    @Column(nullable=false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name="id_moneda", nullable=false)
    private Moneda coin;

    @ManyToOne
    @JoinColumn(name="id_cuenta", nullable=false)
    private Cuenta account;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto product;

    @ManyToOne
    @JoinColumn(name="tipo_transaccion", nullable=false)
    private TipoTransaccion transactionType;

    public Transaccion() {
    }

    public Transaccion(BigDecimal precio, Producto product, TipoTransaccion transactionType, Cuenta account, Moneda coin, int cantidad, LocalDate fecha) {
        this.precio = precio;
        this.product = product;
        this.transactionType = transactionType;
        this.account = account;
        this.coin = coin;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
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
        return account;
    }

    public void setAccount(Cuenta account) {
        this.account = account;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public TipoTransaccion getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TipoTransaccion transactionType) {
        this.transactionType = transactionType;
    }

    public Moneda getCoin() {
        return coin;
    }

    public void setCoin(Moneda coin) {
        this.coin = coin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
