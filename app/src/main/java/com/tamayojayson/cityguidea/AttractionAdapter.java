package com.tamayojayson.cityguidea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.ViewHolder>{
    public interface OnItemClick {void onClick(int position);}
    private final String[] items;
    private final OnItemClick listener;

    public AttractionAdapter(String[] items, OnItemClick listener){
        this.items = items;
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtAttraction;
        ViewHolder(View row){
            super(row);
            txtAttraction = row.findViewById(R.id.txtAttraction);
        }
    }

    @NonNull
    @Override
    public AttractionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attraction, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionAdapter.ViewHolder holder, int position) {
        holder.txtAttraction.setText(items[position]);
        holder.itemView.setOnClickListener(v -> listener.onClick(holder.getBindingAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
