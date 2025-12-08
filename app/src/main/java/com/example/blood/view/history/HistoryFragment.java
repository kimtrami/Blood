package com.example.blood.view.history;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.FragmentHistoryBinding;
import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.DataManager;
import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.view.adapter.HistoryAdapter;
import com.example.blood.view.adapter.PressureAdapter;
import com.example.blood.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {

    private HistoryViewModel historyViewModel;
    private HistoryAdapter adapter;

    @Override
    protected FragmentHistoryBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHistoryBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeComponent() {
        super.initializeComponent();

        adapter = new HistoryAdapter();
        binding.lstHistory.setAdapter(adapter);


        historyViewModel = new ViewModelProvider(requireActivity()).get(HistoryViewModel.class);
        AppDatabase appDatabase = DataManager.getInstance().createDataBase(requireContext());
        historyViewModel.setAppDatabase(appDatabase);
        historyViewModel.getDataHistory();
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
        historyViewModel.getPressureListLiveData().observe(getViewLifecycleOwner(), list -> {
            adapter.setData(list);
        });
    }
}
