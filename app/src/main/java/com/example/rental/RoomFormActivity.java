package com.example.rental;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rental.controller.RoomController;
import com.example.rental.model.entity.Room;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

public class RoomFormActivity extends AppCompatActivity {
    public static final String EXTRA_ROOM = "com.example.rental.EXTRA_ROOM";

    private TextInputEditText etRoomCode, etRoomName, etRoomAddress, etRoomPrice, etRoomDescription, etTenantName, etPhoneNumber;
    private SwitchMaterial swIsAvailable;
    private Button btnSave;
    private RoomController roomController;
    private Room existingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        roomController = new RoomController();

        etRoomCode = findViewById(R.id.etRoomCode);
        etRoomName = findViewById(R.id.etRoomName);
        etRoomAddress = findViewById(R.id.etRoomAddress);
        etRoomPrice = findViewById(R.id.etRoomPrice);
        etRoomDescription = findViewById(R.id.etRoomDescription);
        etTenantName = findViewById(R.id.etTenantName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        swIsAvailable = findViewById(R.id.swIsAvailable);
        btnSave = findViewById(R.id.btnSave);

        if (getIntent().hasExtra(EXTRA_ROOM)) {
            setTitle(R.string.title_edit_room);
            existingRoom = (Room) getIntent().getSerializableExtra(EXTRA_ROOM);
            if (existingRoom != null) {
                etRoomCode.setText(existingRoom.getRoomCode());
                etRoomName.setText(existingRoom.getName());
                etRoomAddress.setText(existingRoom.getAddress());
                etRoomPrice.setText(String.valueOf(existingRoom.getPrice()));
                etRoomDescription.setText(existingRoom.getDescription());
                etTenantName.setText(existingRoom.getTenantName());
                etPhoneNumber.setText(existingRoom.getPhoneNumber());
                swIsAvailable.setChecked(existingRoom.isAvailable());
            }
        } else {
            setTitle(R.string.title_add_room);
        }

        btnSave.setOnClickListener(v -> saveRoom());
    }

    private void saveRoom() {
        String code = etRoomCode.getText().toString().trim();
        String name = etRoomName.getText().toString().trim();
        String address = etRoomAddress.getText().toString().trim();
        String priceStr = etRoomPrice.getText().toString().trim();
        String description = etRoomDescription.getText().toString().trim();
        String tenantName = etTenantName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        boolean isAvailable = swIsAvailable.isChecked();

        String validationError = roomController.validateInput(name, address, priceStr);
        if (validationError != null) {
            Toast.makeText(this, validationError, Toast.LENGTH_SHORT).show();
            return;
        }

        double price = Double.parseDouble(priceStr);

        if (existingRoom == null) {
            roomController.addRoom(code, name, address, price, description, isAvailable, tenantName, phoneNumber);
            Toast.makeText(this, "Room added", Toast.LENGTH_SHORT).show();
        } else {
            existingRoom.setRoomCode(code);
            existingRoom.setName(name);
            existingRoom.setAddress(address);
            existingRoom.setPrice(price);
            existingRoom.setDescription(description);
            existingRoom.setAvailable(isAvailable);
            existingRoom.setTenantName(tenantName);
            existingRoom.setPhoneNumber(phoneNumber);
            roomController.updateRoom(existingRoom);
            Toast.makeText(this, "Room updated", Toast.LENGTH_SHORT).show();
        }
        setResult(RESULT_OK);
        finish();
    }
}
