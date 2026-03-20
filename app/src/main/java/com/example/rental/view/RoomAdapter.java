package com.example.rental.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rental.R;
import com.example.rental.model.entity.Room;
import java.io.File;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private List<Room> roomList;
    private Context context;

    public RoomAdapter(Context context, List<Room> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.tvName.setText(room.getName());
        holder.tvAddress.setText(room.getAddress());
        holder.tvPrice.setText(String.format("%,.0f VND", room.getPrice()));

        // Display Image
        if (room.getImagePath() != null && !room.getImagePath().isEmpty()) {
            File imgFile = new File(room.getImagePath());
            if (imgFile.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                holder.ivImage.setImageBitmap(myBitmap);
            } else {
                holder.ivImage.setImageResource(android.R.drawable.ic_menu_gallery);
            }
        } else {
            holder.ivImage.setImageResource(android.R.drawable.ic_menu_gallery);
        }
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvAddress, tvPrice;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivRoomImage);
            tvName = itemView.findViewById(R.id.tvRoomName);
            tvAddress = itemView.findViewById(R.id.tvRoomAddress);
            tvPrice = itemView.findViewById(R.id.tvRoomPrice);
        }
    }
}
