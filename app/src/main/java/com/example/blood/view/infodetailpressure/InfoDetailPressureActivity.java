package com.example.blood.view.infodetailpressure;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityInfoDetailPressureBinding;
import com.example.blood.model.InfoDetail;
import com.example.blood.view.adapter.InfoDetailPressureAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailPressureActivity extends BaseActivity<ActivityInfoDetailPressureBinding> {
    private InfoDetailPressureAdapter adapter;
    private InfoDetailPressureViewModel viewModel;
    private List<InfoDetail> data;

    @Override
    protected ActivityInfoDetailPressureBinding inflateBinding(LayoutInflater inflater) {
        return ActivityInfoDetailPressureBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoDetailPressureAdapter();
        binding.lstInfoDetailPressure.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(InfoDetailPressureViewModel.class);
        data = new ArrayList<>();
    }

    @Override
    public void initializeEvent() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initializeData() {
        data = viewModel.initData();
        adapter.setData(data);
    }
}
