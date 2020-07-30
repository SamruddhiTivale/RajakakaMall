package com.example.rajakakamall.models;

public class Product {
    private int id;
    private String title;
    private double price;


    private double mrp;
    private int image;

    public Product(int id, String title,double price,double mrp,int image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.mrp=mrp;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public double getMrp() {
        return mrp;
    }


    public int getImage() {
        return image;
    }
}