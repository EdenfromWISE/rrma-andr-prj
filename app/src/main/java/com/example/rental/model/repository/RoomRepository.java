package com.example.rental.model.repository;

import com.example.rental.model.entity.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> roomList;
    private int nextId = 1;

    public RoomRepository() {
        roomList = new ArrayList<>();
        // Khởi tạo một số dữ liệu mẫu phong phú hơn
        roomList.add(new Room(nextId++, "Phòng VIP 01", "123 Cách Mạng Tháng 8, Quận 3", 5000000, "Phòng đầy đủ tiện nghi, view đẹp, ban công rộng.", true));
        roomList.add(new Room(nextId++, "Phòng Studio", "45 Nguyễn Đình Chiểu, Quận 1", 7500000, "Phòng thiết kế hiện đại, phù hợp cho người đi làm.", false));
        roomList.add(new Room(nextId++, "Phòng Giá Rẻ", "789 Kha Vạn Cân, Thủ Đức", 1800000, "Phòng nhỏ gọn, an ninh tốt, gần trường đại học.", true));
        roomList.add(new Room(nextId++, "Căn hộ 202", "12 Lê Lợi, Quận Gò Vấp", 4200000, "Phòng có máy lạnh, máy giặt riêng, lối đi riêng.", true));
        roomList.add(new Room(nextId++, "Phòng Trọ A1", "56 Bùi Viện, Quận 1", 3500000, "Phòng ngay trung tâm, phù hợp khách du lịch thuê ngắn hạn.", true));
    }

    public List<Room> getAllRooms() {
        return roomList;
    }

    public void insert(Room room) {
        room.setId(nextId++);
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
