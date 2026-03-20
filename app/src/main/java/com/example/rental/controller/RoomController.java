package com.example.rental.controller;

import com.example.rental.model.entity.Room;
import com.example.rental.model.repository.RoomRepository;
import java.util.List;

public class RoomController {
    private RoomRepository repository;

    public RoomController() {
        repository = new RoomRepository();
    }

    public List<Room> getAllRooms() {
        return repository.getAllRooms();
    }

    /**
     * Ràng buộc dữ liệu (Validation)
     */
    public String validateInput(String name, String address, String priceStr) {
        if (name == null || name.trim().isEmpty()) {
            return "Tên phòng không được để trống";
        }
        if (address == null || address.trim().isEmpty()) {
            return "Địa chỉ không được để trống";
        }
        try {
            double price = Double.parseDouble(priceStr);
            if (price <= 0) {
                return "Giá thuê phải lớn hơn 0";
            }
        } catch (NumberFormatException e) {
            return "Giá thuê phải là số hợp lệ";
        }
        return null;
    }

    public void addRoom(String name, String address, double price, String description, boolean isAvailable) {
        // ID sẽ được Repository tự động gán
        Room room = new Room(0, name, address, price, description, isAvailable);
        repository.insert(room);
    }

    public void updateRoom(Room room) {
        repository.update(room);
    }

    public void deleteRoom(Room room) {
        repository.delete(room);
    }
}
