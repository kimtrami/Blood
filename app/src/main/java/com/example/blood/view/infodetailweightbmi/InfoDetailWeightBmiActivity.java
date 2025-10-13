package com.example.blood.view.infodetailweightbmi;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityInfoDetailBmiBinding;
import com.example.blood.model.InfoDetail;
import com.example.blood.view.adapter.InfoDetailWeightBmiAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailWeightBmiActivity extends BaseActivity<ActivityInfoDetailBmiBinding> {

    private InfoDetailWeightBmiAdapter adapter;
    private InfoDetailWeightBmiViewModel viewModel;
    private List<InfoDetail> data;

    @Override
    protected ActivityInfoDetailBmiBinding inflateBinding(LayoutInflater inflater) {
        return ActivityInfoDetailBmiBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoDetailWeightBmiAdapter();
        binding.lstInfoDetailWeightBmi.setAdapter(adapter);

        data = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(InfoDetailWeightBmiViewModel.class);
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
