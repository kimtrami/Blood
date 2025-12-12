package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemTrackerBinding;
import com.example.blood.model.Tracker;

import java.util.ArrayList;
import java.util.List;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.ViewHolder> {

    private List<Tracker> data = new ArrayList<>();
    private onClickItemInfo onClickItemInfo;

    private int maxPressure;
    private int minPressure;

    private float maxSugar;
    private float minSugar;

    private int maxHeart;
    private int minHeart;

    public void setOnClickItemInfo(onClickItemInfo onClickItemInfo) {
        this.onClickItemInfo = onClickItemInfo;
    }

    public void setData(List<Tracker> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setMaxPressure(int value) { this.maxPressure = value; notifyDataSetChanged(); }
    public void setMinPressure(int value) { this.minPressure = value; notifyDataSetChanged(); }

    public void setMaxSugar(float value) { this.maxSugar = value; notifyDataSetChanged(); }
    public void setMinSugar(float value) { this.minSugar = value; notifyDataSetChanged(); }

    public void setMaxHeart(int value) { this.maxHeart = value; notifyDataSetChanged(); }
    public void setMinHeart(int value) { this.minHeart = value; notifyDataSetChanged(); }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTrackerBinding binding = ItemTrackerBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
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

        private ItemTrackerBinding binding;

        public ViewHolder(ItemTrackerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.btnAddRecordBlood.setOnClickListener(
                    view -> onClickItemInfo.onClickItem(getAdapterPosition())
            );
        }

        public void bindView(Tracker tracker) {

            binding.imgBloodSugare.setImageResource(tracker.getSrc());
            binding.txtBlood.setText(tracker.getTitle());

            binding.Max.setVisibility(View.VISIBLE);
            binding.Min.setVisibility(View.VISIBLE);

            switch (tracker.getTitle()) {

                case "Huyết áp":
                    binding.Max.setText(String.valueOf(maxPressure));
                    binding.Min.setText(String.valueOf(minPressure));
                    break;

                case "Đường huyết":
                    binding.Max.setText(String.format("%.1f", maxSugar));
                    binding.Min.setText(String.format("%.1f", minSugar));
                    break;

                case "Nhịp tim":
                    binding.Max.setText(String.valueOf(maxHeart));
                    binding.Min.setText(String.valueOf(minHeart));
                    break;
            }
        }
    }
}
