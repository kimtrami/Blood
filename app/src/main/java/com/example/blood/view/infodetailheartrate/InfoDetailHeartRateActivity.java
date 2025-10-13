package com.example.blood.view.infodetailheartrate;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityInfoDetailHeartRateBinding;
import com.example.blood.model.InfoDetail;
import com.example.blood.view.adapter.InfoDetailHeartRateAdapter;
import com.example.blood.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailHeartRateActivity extends BaseActivity<ActivityInfoDetailHeartRateBinding> {

    private InfoDetailHeartRateViewModel viewModel;
    private InfoDetailHeartRateAdapter adapter;
    private List<InfoDetail> data ;

    @Override
    protected ActivityInfoDetailHeartRateBinding inflateBinding(LayoutInflater inflater) {
        return ActivityInfoDetailHeartRateBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoDetailHeartRateAdapter();
        binding.lstInfoDetailHeartRate.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(InfoDetailHeartRateViewModel.class);
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
