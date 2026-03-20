package com.example.rental.controller;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.rental.model.entity.Room;
import com.example.rental.model.repository.RoomRepository;
import java.util.List;

public class RoomController {
    private RoomRepository repository;
    private LiveData<List<Room>> allRooms;

    public RoomController(Application application) {
        repository = new RoomRepository(application);
        allRooms = repository.getAllRooms();
    }

    public LiveData<List<Room>> getAllRooms() {
        return allRooms;
    }

    public void addRoom(String name, String address, double price, String description) {
        Room room = new Room(name, address, price, description);
        repository.insert(room);
    }

    public void deleteRoom(Room room) {
        repository.delete(room);
    }
}
