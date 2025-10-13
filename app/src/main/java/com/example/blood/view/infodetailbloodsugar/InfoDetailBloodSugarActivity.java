package com.example.blood.view.infodetailbloodsugar;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityInfoDetailSugarBinding;
import com.example.blood.model.InfoDetail;
import com.example.blood.view.adapter.InfoDetailBloodSugarAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailBloodSugarActivity extends BaseActivity<ActivityInfoDetailSugarBinding> {

    private InfoDetailBloodSugarAdapter adapter;
    private InfoDetailBloodSugarViewModel viewModel;
    private List<InfoDetail> data = new ArrayList<>();

    @Override
    protected ActivityInfoDetailSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityInfoDetailSugarBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoDetailBloodSugarAdapter();
        binding.lstInfoDetailBloodSugar.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(InfoDetailBloodSugarViewModel.class);
    }

    @Override
    public void initializeEvent() {
       binding.btnBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initializeData() {
        data = viewModel.initData();
        adapter.setData(data);
    }
}
