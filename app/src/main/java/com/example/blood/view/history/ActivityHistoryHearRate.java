package com.example.blood.view.history;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.dataHeartRate.AppDataBaseHeartRate;
import com.example.blood.dataHeartRate.DataManager;
import com.example.blood.databinding.ActivityHistoryHeartRateBinding;
import com.example.blood.view.adapter.HistoryHeartRateAdapter;
import com.example.blood.view.base.BaseActivity;

public class ActivityHistoryHearRate extends BaseActivity<ActivityHistoryHeartRateBinding> {

    private HistoryViewModel historyViewModel;
    private HistoryHeartRateAdapter adapter;


    @Override
    protected ActivityHistoryHeartRateBinding inflateBinding(LayoutInflater inflater) {
        return ActivityHistoryHeartRateBinding.inflate(inflater);
    }

    @Override
    public void initializeComponent() {
        super.initializeComponent();

        adapter = new HistoryHeartRateAdapter();
        binding.lstHistory.setAdapter(adapter);


        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        AppDataBaseHeartRate appDatabase = DataManager.getInstance().createDataBase(this);
        historyViewModel.setAppDataBaseHeartRate(appDatabase);
        historyViewModel.getDataHistoryHeartRate();
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
        historyViewModel.getHeartRateListLiveData().observe(this, list -> {
            adapter.setData(list);
        });
    }


}
