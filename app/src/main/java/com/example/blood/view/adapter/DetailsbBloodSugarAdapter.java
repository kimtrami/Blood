package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemBloodSugarDetailsBinding;
import com.example.blood.model.ResultSugar;

import java.util.ArrayList;
import java.util.List;

public class DetailsbBloodSugarAdapter extends RecyclerView.Adapter<DetailsbBloodSugarAdapter.ViewHolder> {

    private List<ResultSugar> data = new ArrayList();

    public void setData(List<ResultSugar> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBloodSugarDetailsBinding binding = ItemBloodSugarDetailsBinding.inflate(inflater, parent, false);
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

        private ItemBloodSugarDetailsBinding binding;

        public ViewHolder(ItemBloodSugarDetailsBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bindView(ResultSugar sugar) {
            binding.txtTitle.setText(sugar.getTitle());
            binding.txtContent.setText(sugar.getContent());
        }
    }
}
