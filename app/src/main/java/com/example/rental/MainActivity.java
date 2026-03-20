package com.example.rental;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rental.controller.RoomController;
import com.example.rental.model.entity.Room;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RoomController roomController;
    private RoomAdapter adapter;
    private static final int REQUEST_CODE_FORM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomController = new RoomController();

        RecyclerView recyclerView = findViewById(R.id.rvRooms);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RoomAdapter();
        recyclerView.setAdapter(adapter);

        updateRoomList();

        FloatingActionButton fabAdd = findViewById(R.id.fabAddRoom);
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RoomFormActivity.class);
            startActivityForResult(intent, REQUEST_CODE_FORM);
        });

        // Update - Click to edit
        adapter.setOnItemClickListener(room -> {
            Intent intent = new Intent(MainActivity.this, RoomFormActivity.class);
            intent.putExtra(RoomFormActivity.EXTRA_ROOM, room);
            startActivityForResult(intent, REQUEST_CODE_FORM);
        });

        // Delete - Long click to delete
        adapter.setOnItemLongClickListener(room -> {
            showDeleteConfirmation(room);
        });
    }

    private void showDeleteConfirmation(Room room) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.delete_confirm_title)
                .setMessage(R.string.delete_confirm_msg)
                .setPositiveButton(R.string.yes, (dialog, which) -> {
                    roomController.deleteRoom(room);
                    updateRoomList();
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }

    private void updateRoomList() {
        List<Room> rooms = roomController.getAllRooms();
        adapter.setRooms(rooms);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FORM && resultCode == RESULT_OK) {
            updateRoomList();
        }
    }
}
