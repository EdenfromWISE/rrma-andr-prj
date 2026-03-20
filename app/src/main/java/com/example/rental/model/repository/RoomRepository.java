package com.example.rental.model.repository;

import android.content.Context;
import com.example.rental.model.entity.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> roomList;
    private int nextId = 1;

    public RoomRepository(Context context) {
        roomList = new ArrayList<>();
        // Seed data with placeholder image paths
        roomList.add(new Room(nextId++, "P101", "Phòng VIP 01", "123 Cách Mạng Tháng 8, Quận 3", 5000000, "Phòng đầy đủ tiện nghi", true, "Nguyễn Văn A", "0901234567", ""));
        roomList.add(new Room(nextId++, "P102", "Phòng Studio", "45 Nguyễn Đình Chiểu, Quận 1", 7500000, "Phòng thiết kế hiện đại", false, "Trần Thị B", "0907654321", ""));
        roomList.add(new Room(nextId++, "P103", "Phòng Giá Rẻ", "789 Kha Vạn Cân, Thủ Đức", 1800000, "Gần trường đại học", true, "", "", ""));
    }

    public List<Room> getAllRooms() {
        return roomList;
    }

    public void insert(Room room) {
        if (room.getId() == 0) {
            room.setId(nextId++);
        }
        roomList.add(room);
    }

    public void update(Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == updatedRoom.getId()) {
                roomList.set(i, updatedRoom);
                return;
            }
        }
    }

    public void delete(Room room) {
        roomList.removeIf(r -> r.getId() == room.getId());
    }
}
