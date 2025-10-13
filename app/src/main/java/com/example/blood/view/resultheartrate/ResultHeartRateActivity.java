package com.example.blood.view.resultheartrate;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.R;
import com.example.blood.dataHeartRate.HeartRateEntity;
import com.example.blood.databinding.ActivityResultHeartRateBinding;
import com.example.blood.model.InfoDetail;
import com.example.blood.view.Utils;
import com.example.blood.view.adapter.HeartRateDetailAdapter;
import com.example.blood.view.adapter.ResulStatusHeartRateAdapter;
import com.example.blood.view.base.BaseActivity;
import com.google.gson.Gson;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ResultHeartRateActivity extends BaseActivity<ActivityResultHeartRateBinding> {

    private HeartRateDetailAdapter adapterDetail;
    private ResulStatusHeartRateAdapter resulStatusHeartRateAdapter;
    private ResultHeartRateViewModel viewModel;
    private List<InfoDetail> data;
    private HeartRateEntity entity;

    @Override
    protected ActivityResultHeartRateBinding inflateBinding(LayoutInflater inflater) {
        return ActivityResultHeartRateBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {
        adapterDetail = new HeartRateDetailAdapter();
        binding.lstHeartRateDetails.setAdapter(adapterDetail);

        data = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(ResultHeartRateViewModel.class);

        Intent intent = getIntent();
        String json = intent.getStringExtra(Utils.KEY_SAVE_HEART_RATE);

        Gson gson = new Gson();
        entity = gson.fromJson(json, HeartRateEntity.class);

    }

    @Override
    public void initializeEvent() {
        super.initializeEvent();
        binding.btnGoHome.setOnClickListener(v -> finish());
    }

    @Override
    public void initializeData() {
        data = viewModel.initDataDetail();
        adapterDetail.setData(data);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void bindView() {
        binding.txtNote.setText("Note: " + entity.getNote());

        long time = entity.getTime();
        LocalTime localTime = LocalTime.ofSecondOfDay(time / 1000);
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        binding.txtContentMeasured.setText(formattedTime + " - " + entity.getDate());
        binding.txtBpm.setText(entity.getBpm() + " PBM");
    }
}
