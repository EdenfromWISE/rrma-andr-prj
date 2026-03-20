package com.example.rental;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rental.controller.RoomController;
import com.example.rental.view.RoomAdapter;

public class MainActivity extends AppCompatActivity {
    private RoomController roomController;
    private RecyclerView rvRooms;
    private RoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomController = new RoomController(this);
        rvRooms = findViewById(R.id.rvRooms);
        
        // Setup RecyclerView
        adapter = new RoomAdapter(this, roomController.getAllRooms());
        rvRooms.setLayoutManager(new LinearLayoutManager(this));
        rvRooms.setAdapter(adapter);
    }
}
