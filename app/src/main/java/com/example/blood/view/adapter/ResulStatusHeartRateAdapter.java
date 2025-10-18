package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemHeartRateStatusDetailBinding;
import com.example.blood.model.HeartRateStatus;

import java.util.List;

public class ResulStatusHeartRateAdapter extends RecyclerView.Adapter<ResulStatusHeartRateAdapter.ViewHolder> {

    private List<HeartRateStatus> data;
    private int position = 0;

    public void setData(List<HeartRateStatus> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHeartRateStatusDetailBinding binding = ItemHeartRateStatusDetailBinding.inflate(inflater, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ItemHeartRateStatusDetailBinding binding;

        public ViewHolder(ItemHeartRateStatusDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(HeartRateStatus heartRateStatus){
            binding.bgStatus.setTextColor(heartRateStatus.getBgState());
            if(position == getAdapterPosition()){
                binding.imgHeart.setVisibility(View.VISIBLE);
            } else {
                binding.imgHeart.setVisibility(View.GONE);
            }
        }
    }
}
