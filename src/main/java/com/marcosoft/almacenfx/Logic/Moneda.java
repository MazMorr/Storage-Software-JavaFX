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
@Table(name="moneda")
public class Moneda implements Serializable{
    @Id
    private String id_moneda;
    
    @Column(nullable= false, length= 25)
    private String nombre_moneda;

    public Moneda() {
    }

    public Moneda(String id_moneda, String nombre_moneda) {
        this.id_moneda = id_moneda;
        this.nombre_moneda = nombre_moneda;
    }

    public String getIdMoneda() {
        return id_moneda;
    }

    public void setIdMoneda(String id_moneda) {
        this.id_moneda = id_moneda;
    }

    public String getNombreMoneda() {
        return nombre_moneda;
    }

    public void setNombreMoneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }
    
    
    
}
