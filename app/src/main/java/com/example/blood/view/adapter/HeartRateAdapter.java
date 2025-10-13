package com.example.blood.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemStatusAddHeartRateBinding;
import com.example.blood.model.HeartRate;

import java.util.ArrayList;
import java.util.List;

public class HeartRateAdapter extends RecyclerView.Adapter<HeartRateAdapter.ViewHolder> {

    private List<HeartRate> data = new ArrayList<>();

    public void setData(List<HeartRate> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemStatusAddHeartRateBinding binding = ItemStatusAddHeartRateBinding.inflate(inflater, parent, false);
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

        private ItemStatusAddHeartRateBinding binding;

        public ViewHolder(ItemStatusAddHeartRateBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(HeartRate heartRate) {
            binding.txtHeartRateStatus.setText(heartRate.getHeartRateStatus());
            binding.txtHeartRateBars.setBackgroundColor(Color.parseColor(heartRate.getHeartRateBars()));
            binding.txtHeartRateStatus.setTextColor(Color.parseColor(heartRate.getHeartRateStatusColor()));
            binding.txtHeartRateValue.setText(heartRate.getHeartRateValue());
        }
    }
}
