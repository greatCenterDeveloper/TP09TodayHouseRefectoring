package com.swj.tp09todayhouserefectoring;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.swj.tp09todayhouserefectoring.databinding.RecyclerviewItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    Context context;
    ArrayList<Item> itemArrayList;

    public MyAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RecyclerviewItemBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item = itemArrayList.get(position);
        holder.binding.ivRoomImage.setImageResource(item.roomImageId);
        holder.binding.tvRoomTitle.setText(item.roomTitle);
        holder.binding.tvRoomSeller.setText(item.roomSeller);

        if(position < 3)
            holder.binding.cardviewNew.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        RecyclerviewItemBinding binding;
        public VH(@NonNull RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    } // VH class
} // MyAdapter class
