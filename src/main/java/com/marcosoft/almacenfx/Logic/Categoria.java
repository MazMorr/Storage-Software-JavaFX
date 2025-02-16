
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author MazMorr
 */
@Entity
@Table(name= "categoria")
public class Categoria implements Serializable{
    //Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column(nullable=false, length= 20)
    private String nombreCategoria;

    
    //Constructors, Getters and Setters
    public Categoria() {
    }

    public Categoria(String nombreCategoria) {
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
