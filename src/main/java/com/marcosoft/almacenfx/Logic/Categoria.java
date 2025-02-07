/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
/**
 *
 * @author MazMorr
 */
@Entity
@Table(name= "categoria")
class Categoria {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column(nullable=false, length= 20)
    private String nombreCategoria;

    
    //Constructors, Getters and Setters
    public Categoria() {
    }

    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
        
}
