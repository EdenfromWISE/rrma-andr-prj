package com.example.rental.controller;

import android.content.Context;
import android.net.Uri;
import com.example.rental.model.entity.Room;
import com.example.rental.model.repository.RoomRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class RoomController {
    private RoomRepository repository;

    public RoomController(Context context) {
        repository = new RoomRepository(context);
    }

    public List<Room> getAllRooms() {
        return repository.getAllRooms();
    }

    public String saveImageToInternalStorage(Context context, Uri uri) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            String fileName = "room_" + System.currentTimeMillis() + ".jpg";
            File file = new File(context.getFilesDir(), fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addRoom(String roomCode, String name, String address, double price, String description, 
                        boolean isAvailable, String tenantName, String phoneNumber, String imagePath) {
        Room room = new Room(0, roomCode, name, address, price, description, isAvailable, tenantName, phoneNumber, imagePath);
        repository.insert(room);
    }

    public void updateRoom(Room room) {
        repository.update(room);
    }

    public void deleteRoom(Room room) {
        repository.delete(room);
    }
}
