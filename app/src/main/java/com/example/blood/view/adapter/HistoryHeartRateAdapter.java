package com.example.blood.view.adapter;


import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.dataHeartRate.HeartRateEntity;
import com.example.blood.databinding.ItemHistoryBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryHeartRateAdapter extends RecyclerView.Adapter<HistoryHeartRateAdapter.ViewHolder> {

    private List<HeartRateEntity> data = new ArrayList<>();

    public void setData(List<HeartRateEntity> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHistoryBinding binding = ItemHistoryBinding.inflate(inflater, parent, false);
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

        private ItemHistoryBinding binding;

        public ViewHolder(ItemHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(HeartRateEntity entity) {


            long timestamp = entity.getTime();

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String time = timeFormat.format(new Date(timestamp));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String date = dateFormat.format(new Date(timestamp));

            binding.txtDate.setText(entity.getDate());
            binding.txtTime.setText(time);
            binding.txtTitle.setText("Heart Rate");
        }
    }


}
