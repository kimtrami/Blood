package com.example.blood.view.resultsugar;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityResultBloodSugarBinding;
import com.example.blood.databloodsugar.BloodSugarEntity;
import com.example.blood.model.ResultSugar;
import com.example.blood.model.Sugar;
import com.example.blood.view.Utils;
import com.example.blood.view.adapter.DetailsbBloodSugarAdapter;
import com.example.blood.view.adapter.SugarStatusAdapter;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.editbloodsugar.EditBloodSugarActivity;
import com.google.gson.Gson;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResultSugarActivity extends BaseActivity<ActivityResultBloodSugarBinding> {

    private BloodSugarEntity entity;
    private ResultSugarViewModel viewModel;
    private DetailsbBloodSugarAdapter adapter;
    private SugarStatusAdapter adapterStatus;

    @Override
    protected ActivityResultBloodSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityResultBloodSugarBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initializeComponent() {

        adapter = new DetailsbBloodSugarAdapter();
        binding.lstBloodSugarDetails.setAdapter(adapter);

        adapterStatus = new SugarStatusAdapter();
        binding.lstStatus.setAdapter(adapterStatus);

        viewModel = new ViewModelProvider(this).get(ResultSugarViewModel.class);

        Intent intent = getIntent();
        String key = intent.getStringExtra(Utils.KEY_SAVE_SUGAR);

        Gson gson = new Gson();
        entity = gson.fromJson(key, BloodSugarEntity.class);
    }

    @Override
    public void initializeEvent() {

        binding.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditBloodSugarActivity.class);
            Gson gson = new Gson();
            String key = gson.toJson(entity);
            intent.putExtra("key1", key);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void initializeData() {
        List<ResultSugar> dataResultSugar = viewModel.initDataResult();
        List<Sugar> dataSugarStatus = viewModel.initDataSugarStatus();
        adapter.setData(dataResultSugar);
        adapterStatus.setData(dataSugarStatus);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void bindView() {

        float concentration = entity.getSugarConcenttration();
        ResultSugar result = viewModel.checkConcentration(concentration);

        binding.txtStateBloodSugar.setText(result.getState());
        binding.txtStateBloodSugar.setTextColor(ContextCompat.getColor(this, result.getColorState()));

        binding.txtNote.setText("Note: " + entity.getNote());


        binding.txtMgDL.setText(entity.getSugarConcenttration() + " ");

        long time = entity.getTime();
        LocalTime localTime = LocalTime.ofSecondOfDay(time / 1000);
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        binding.txtContentMeasured.setText(String.format("Measured: " + "%s - %s", entity.getDate(), formattedTime));

    }

}
