package com.example.blood.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blood.databinding.ItemPopupSelectionBloodSugarBinding;
import com.example.blood.model.FunctionPopupBloodSugar;

import java.util.ArrayList;
import java.util.List;

public class PopupBloodSugarAdapter extends RecyclerView.Adapter<PopupBloodSugarAdapter.ViewHolder> {

    private List<String> data = new ArrayList<>();
    private OnItemFunctionPopup listener;

    public void setData(List<String> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setItemFunctionPopup(OnItemFunctionPopup listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPopupSelectionBloodSugarBinding binding = ItemPopupSelectionBloodSugarBinding.inflate(inflater, parent, false);
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

        private ItemPopupSelectionBloodSugarBinding binding;

        public ViewHolder(ItemPopupSelectionBloodSugarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.txtTitleMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.position(data.get(getAdapterPosition()));
                }
            });
        }

        public void bindView(String title) {
            binding.txtTitleMenu.setText(title);
        }
    }
}
