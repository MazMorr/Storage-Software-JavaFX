
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
    private int idProducto;
    
    @Column(nullable=false, length = 20)
    private String nameProduct;
    
    @ManyToOne
    @JoinColumn(name = "categoria", nullable=false)
    private Categoria categoria;

    
    //Constructors, Getters and Setters
    public Producto() {
    }

    public Producto(String nameProduct, Categoria categoria) {
        if (nameProduct == null || nameProduct.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
        this.nameProduct = nameProduct;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
