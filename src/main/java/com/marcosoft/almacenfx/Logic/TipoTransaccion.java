/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author MazMorr
 */
@Entity
@Table(name= "tipo_transaccion")
public class TipoTransaccion implements Serializable{
    @Id
    private int id_tipo_transaccion;
    
    @Column(nullable=false, length=15)
    private String nombre_transaccion;

    public TipoTransaccion() {
    }

    public TipoTransaccion(int id_tipo_transaccion, String nombre_transaccion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
        this.nombre_transaccion = nombre_transaccion;
    }

    public int getIdTipoTransaccion() {
        return id_tipo_transaccion;
    }

    public void setIdTipoTransaccion(int id_tipo_transaccion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
    }

    public String getNombreTransaccion() {
        return nombre_transaccion;
    }

    public void setNombreTransaccion(String nombre_transaccion) {
        this.nombre_transaccion = nombre_transaccion;
    }
    
    
}
