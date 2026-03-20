package com.example.rental.model.entity;

import java.io.Serializable;

public class Room implements Serializable {
    private int id;
    private String roomCode;
    private String name;
    private String address;
    private double price;
    private String description;
    private boolean isAvailable;
    private String tenantName;
    private String phoneNumber;

    public Room(int id, String roomCode, String name, String address, double price, String description, boolean isAvailable, String tenantName, String phoneNumber) {
        this.id = id;
        this.roomCode = roomCode;
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRoomCode() { return roomCode; }
    public void setRoomCode(String roomCode) { this.roomCode = roomCode; }
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
    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
