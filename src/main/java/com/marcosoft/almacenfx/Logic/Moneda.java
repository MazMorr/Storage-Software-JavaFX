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
    private String idMoneda;//cambiado a String para ajustarse al esquema de la BD
    
    @Column(nullable= false, length= 25)
    private String nombreMoneda;

    public Moneda() {
    }

    public Moneda(String idMoneda, String nombreMoneda) {
        this.idMoneda = idMoneda;
        this.nombreMoneda = nombreMoneda;
    }

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }
    
    
    
}
