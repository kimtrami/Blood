package com.example.blood.view.history;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityHistoryPressureBinding;
import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.DataManager;
import com.example.blood.view.adapter.HistoryAdapter;
import com.example.blood.view.base.BaseActivity;

public class ActivityHistoryPressure extends BaseActivity<ActivityHistoryPressureBinding> {


    private HistoryViewModel historyViewModel;
    private HistoryAdapter adapter;

    @Override
    protected ActivityHistoryPressureBinding inflateBinding(LayoutInflater inflater) {
        return ActivityHistoryPressureBinding.inflate(inflater);
    }


    @Override
    public void initializeComponent() {
        super.initializeComponent();

        adapter = new HistoryAdapter();
        binding.lstHistory.setAdapter(adapter);


        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        AppDatabase appDatabase = DataManager.getInstance().createDataBase(this);
        historyViewModel.setAppDatabase(appDatabase);
        historyViewModel.getDataHistoryPressure();
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
        historyViewModel.getPressureListLiveData().observe(this, list -> {
            adapter.setData(list);
        });
    }

}
