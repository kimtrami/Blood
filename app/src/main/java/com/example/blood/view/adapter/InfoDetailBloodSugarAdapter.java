package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemInfoStateBloodSugarBinding;
import com.example.blood.databinding.ItemInfoSugarDetailBinding;
import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailBloodSugarAdapter extends RecyclerView.Adapter<InfoDetailBloodSugarAdapter.ViewHolder> {

    private List<InfoDetail> data = new ArrayList<>();

    public void setData(List<InfoDetail> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemInfoSugarDetailBinding binding = ItemInfoSugarDetailBinding.inflate(inflater);
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

        private ItemInfoSugarDetailBinding binding;

        public ViewHolder(ItemInfoSugarDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(InfoDetail infoDetail){
            binding.txtTitle.setText(infoDetail.getTitle());
            binding.txtContent.setText(infoDetail.getContent());
        }
    }

}
