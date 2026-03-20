package com.example.rental.model.entity;

import java.io.Serializable;

public class Room implements Serializable {
    private int id;
    private String name;
    private String address;
    private double price;
    private String description;
    private boolean isAvailable;

    public Room(int id, String name, String address, double price, String description, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
