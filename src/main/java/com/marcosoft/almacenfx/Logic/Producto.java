
package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
    
/**
 *
 * @author MazMorr
 */
@Entity
@Table(name="Producto")
public class Producto {
    
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
    
    public Producto(int idProducto, String nameProduct, Categoria categoria) {
        this.idProducto = idProducto;
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
