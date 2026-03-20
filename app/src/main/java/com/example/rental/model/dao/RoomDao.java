package com.example.rental.model.dao;

import androidx.room.*;
import com.example.rental.model.entity.Room;
import java.util.List;
import androidx.lifecycle.LiveData;

@Dao
public interface RoomDao {
    @Query("SELECT * FROM rooms")
    LiveData<List<Room>> getAllRooms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRoom(Room room);

    @Update
    void updateRoom(Room room);

    @Delete
    void deleteRoom(Room room);

    @Query("SELECT * FROM rooms WHERE id = :id")
    Room getRoomById(int id);
}
