package com.example.blood.view.history;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityHistoryBloodSugarBinding;
import com.example.blood.databloodsugar.AppDatabaseSugar;
import com.example.blood.databloodsugar.DataManager;
import com.example.blood.view.adapter.HistoryBloodPressureAdapter;
import com.example.blood.view.base.BaseActivity;

public class ActivityHistoryBloodSugar extends BaseActivity<ActivityHistoryBloodSugarBinding> {

    private HistoryViewModel historyViewModel;
    private HistoryBloodPressureAdapter adapter;


    @Override
    protected ActivityHistoryBloodSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityHistoryBloodSugarBinding.inflate(inflater);
    }

    @Override
    public void initializeComponent() {
        super.initializeComponent();

        adapter = new HistoryBloodPressureAdapter();
        binding.lstHistory.setAdapter(adapter);


        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        AppDatabaseSugar appDatabase = DataManager.getInstance().createDataBase(this);
        historyViewModel.setAppDatabaseSugar(appDatabase);
        historyViewModel.getDataHistoryBloodSugar();
    }


    @Override
    public void initializeEvent() {
        super.initializeEvent();
    }


    @Override
    public void initializeData() {
        super.initializeData();
    }

    @Override
    public void bindView() {
        historyViewModel.getBloodSugarListLiveData().observe(this, list -> {
            adapter.setData(list);
        });
    }



}
