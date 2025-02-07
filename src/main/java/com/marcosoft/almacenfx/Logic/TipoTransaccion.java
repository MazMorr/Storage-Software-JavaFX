/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
/**
 *
 * @author Usuario
 */
@Entity
@Table(name= "tipo_transaccion")
class TipoTransaccion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idTipoTransaccion;
    
    @Column(nullable=false, length=15)
    private String nombreTransaccion;

    public TipoTransaccion() {
    }

    public TipoTransaccion(int idTipoTransaccion, String nombreTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
        this.nombreTransaccion = nombreTransaccion;
    }

    public int getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getNombreTransaccion() {
        return nombreTransaccion;
    }

    public void setNombreTransaccion(String nombreTransaccion) {
        this.nombreTransaccion = nombreTransaccion;
    }
    
    
}
