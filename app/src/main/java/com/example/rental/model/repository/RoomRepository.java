package com.example.rental.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.rental.model.dao.RoomDao;
import com.example.rental.model.database.AppDatabase;
import com.example.rental.model.entity.Room;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomRepository {
    private RoomDao roomDao;
    private LiveData<List<Room>> allRooms;
    private static final int NUMBER_OF_THREADS = 4;
    private static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public RoomRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        roomDao = db.roomDao();
        allRooms = roomDao.getAllRooms();
    }

    public LiveData<List<Room>> getAllRooms() {
        return allRooms;
    }

    public void insert(Room room) {
        databaseWriteExecutor.execute(() -> {
            roomDao.insertRoom(room);
        });
    }

    public void delete(Room room) {
        databaseWriteExecutor.execute(() -> {
            roomDao.deleteRoom(room);
        });
    }
}
