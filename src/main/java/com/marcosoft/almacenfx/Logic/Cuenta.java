package com.marcosoft.almacenfx.Logic;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Cuenta")
public class Cuenta implements Serializable{
    //Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_cuenta;
    
    @Column(nullable = false, length = 20)
    private String nombre;
    
    @Column(nullable=false, length=225)
    private String contrasena;

    public Cuenta() {
    }

    public Cuenta( String nombre, String password) {
        this.nombre = nombre;
        this.contrasena = password;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
