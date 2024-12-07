package com.marcosoft.almacenfx.Logic;

import java.time.LocalDate;
import java.util.Date;

public class Product {
    
    private int id;
    private String name;
    private String product;
    private int amount;
    private LocalDate date;
    private double prize;
    private String coin;
    private String entrance;
    
    public Product(int id, String name, String product, int amount, LocalDate date, double prize, String coin, String entrance){
        this.id=id;
        this.name=name;
        this.product=product;
        this.amount=amount;
        this.date= date;
        this.prize=prize;
        this.coin=coin;
        this.entrance=entrance;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getProduct(){
        return product;
    }
    
    public void setProduct(String product){
        this.product=product;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public void setAmount(int amount){
        this.amount=amount;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public void setDate(LocalDate date){
        this.date=date;
    }
    
    public double getPrize(){
        return prize;
    }
    
    public void setPrize(double prize){
        this.prize=prize;
    }
    
    public String getNombre(){
        return name;
    }
    
    public void setNombre(String nombre){
        this.name=nombre;
    }
    
    public String getCoin(){
        return coin;
    }
    
    public void setCoin(String coin){
        this.coin=coin;
    }
    
    public String getEntrance(){
        return entrance;
    }
    
    public void setEntrance(String entrance){
        this.entrance=entrance;
    }
}
