package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;

@Entity
@Table(name = "Cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCuenta;
    
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable=false, length=225)
    private String password;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String name, String password) {
        this.idCuenta = idCuenta;
        this.name = name;
        this.password = password;
    }

    public int getIdProduct() {
        return idCuenta;
    }

    public void setIdProduct(int idProduct) {
        this.idCuenta = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
