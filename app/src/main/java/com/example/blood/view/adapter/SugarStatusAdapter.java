package com.example.blood.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemInfoStateBloodSugarBinding;
import com.example.blood.model.Sugar;

import java.util.ArrayList;
import java.util.List;

public class SugarStatusAdapter extends RecyclerView.Adapter<SugarStatusAdapter.ViewHolder> {

    private int state = 0;
    private List<Sugar> data = new ArrayList<>();

    public void setData(List<Sugar> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemInfoStateBloodSugarBinding binding = ItemInfoStateBloodSugarBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemInfoStateBloodSugarBinding binding;

        public ViewHolder(ItemInfoStateBloodSugarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Sugar sugar) {
            binding.bgStatus.setBackgroundColor(Color.parseColor(sugar.getStateColor()));
        }
    }
}
