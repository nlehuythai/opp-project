package model;

import java.io.Serializable;

public class Shoe implements Serializable {
    private String id;
    private String name;
    private String type;
    private String brand;
    private int size;
    private double price;

    public Shoe(String id, String name, String type, String brand, int size, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
