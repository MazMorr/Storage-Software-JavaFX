
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;
    
/**
 *
 * @author MazMorr
 */
@Entity
@Table(name="Producto")
public class Producto implements Serializable{
    
    //Atributes
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_product;
    
    @Column(nullable=false, length = 20)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "categoria", nullable=false)
    private Categoria categoria;

    @Version
    private int version;

    //Constructors, Getters and Setters
    public Producto() {
    }

    public Producto(String nombre, Categoria categoria) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return id_product;
    }

    public void setIdProducto(int id_product) {
        this.id_product = id_product;
    }

    public String getNameProduct() {
        return nombre;
    }

    public void setNameProduct(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
