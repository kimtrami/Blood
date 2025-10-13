package com.example.blood.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemAddBloodSugarBinding;
import com.example.blood.model.Sugar;

import java.util.ArrayList;
import java.util.List;

public class EditBloodSugarAdapter extends RecyclerView.Adapter<EditBloodSugarAdapter.ViewHolder> {

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
        ItemAddBloodSugarBinding binding = ItemAddBloodSugarBinding.inflate(inflater, parent, false);
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

        private ItemAddBloodSugarBinding binding;

        public ViewHolder(ItemAddBloodSugarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Sugar sugar) {
            binding.txtStateBloodSugar.setText(sugar.getState());
            binding.txtStateBloodSugar.setTextColor(Color.parseColor(sugar.getStateColor()));
            binding.imgState.setBackgroundColor(Color.parseColor(sugar.getImgState()));
            binding.txtGlucoseLevel.setText(sugar.getGlucoseLevel());
        }
    }
}
