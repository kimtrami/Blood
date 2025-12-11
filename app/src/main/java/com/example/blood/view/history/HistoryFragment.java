package com.example.blood.view.history;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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


    @Override
    protected FragmentHistoryBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHistoryBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeEvent() {
        super.initializeEvent();


        binding.btnHistoryPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ActivityHistoryPressure.class);
                startActivity(intent);
            }
        });

        binding.btnHistoryBloodSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ActivityHistoryBloodSugar.class);
                startActivity(intent);
            }
        });

        binding.btnHistoryHeatRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ActivityHistoryHearRate.class);
                startActivity(intent);
            }
        });

    }


}
