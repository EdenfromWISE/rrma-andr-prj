package com.example.rental;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.example.rental.controller.RoomController;
import com.example.rental.model.entity.Room;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RoomController roomController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomController = new RoomController(getApplication());

        Button btnAdd = findViewById(R.id.btnAddRoom);
        
        btnAdd.setOnClickListener(v -> {
            roomController.addRoom("Phòng 101", "123 ABC", 2000, "Phòng đẹp");
        });

        // Observer Model via Controller
        roomController.getAllRooms().observe(this, new Observer<List<Room>>() {
            @Override
            public void onChanged(List<Room> rooms) {
                // Update UI
            }
        });
    }
}
