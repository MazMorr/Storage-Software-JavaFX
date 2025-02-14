package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Cuenta")
public class Cuenta implements Serializable{
    //Attributes
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

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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
