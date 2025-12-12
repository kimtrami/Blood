package com.example.blood.view.trackerfragmet;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.dataHeartRate.AppDataBaseHeartRate;
import com.example.blood.databinding.FragmentTrackerBinding;
import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.DataManager;
import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.databloodsugar.AppDatabaseSugar;
import com.example.blood.model.Tracker;
import com.example.blood.view.adapter.TrackerAdapter;
import com.example.blood.view.adapter.onClickItemInfo;
import com.example.blood.view.addbloodsugar.AddBloodSugarActivity;
import com.example.blood.view.addheartrate.AddHeartRateActivity;
import com.example.blood.view.addpressure.AddBloodPressureActivity;
import com.example.blood.view.base.BaseFragment;

import java.util.List;

public class TrackerFragment extends BaseFragment<FragmentTrackerBinding> implements onClickItemInfo {

    private TrackerAdapter adapter;
    private TrackerViewModel viewModel;


    @Override
    protected FragmentTrackerBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentTrackerBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeComponent() {
        adapter = new TrackerAdapter();
        adapter.setOnClickItemInfo(this);
        binding.lstmenuTracker.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(TrackerViewModel.class);
        AppDatabase appDatabase = DataManager.getInstance().createDataBase(requireContext());
        AppDatabaseSugar appDatabaseSugar = com.example.blood.databloodsugar.DataManager.getInstance().createDataBase(requireContext());
        AppDataBaseHeartRate appDataBaseHeartRate = com.example.blood.dataHeartRate.DataManager.getInstance().createDataBase(requireContext());

        viewModel.setAppDataBaseHeartRate(appDataBaseHeartRate);
        viewModel.setAppDatabase(appDatabase);
        viewModel.setAppDatabaseSugar(appDatabaseSugar);

        viewModel.getDataHistoryPressure();
        viewModel.getDataHistoryBloodSugar();
        viewModel.getDataHistoryHeartRate();
    }


    @Override
    public void initializeData() {
        List<Tracker> trackers = viewModel.initData();
        adapter.setData(trackers);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getDataHistoryPressure();
        viewModel.getDataHistoryBloodSugar();
        viewModel.getDataHistoryHeartRate();
    }

    @Override
    public void bindView() {

        viewModel.initData();


        viewModel.getPressureListLiveData().observe(getViewLifecycleOwner(), list -> {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i).getDia();

                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }


            adapter.setMaxPressure(max);
            adapter.setMinPressure(min);
        });

        viewModel.getBloodSugarListLiveData().observe(getViewLifecycleOwner(), list -> {
            float max = Float.MIN_VALUE;
            float min = Float.MAX_VALUE;

            for (int i = 0; i < list.size(); i++) {
                float value = list.get(i).getSugarConcenttration();

                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }
            adapter.setMaxSugar(max);
            adapter.setMinSugar(min);
        });

        viewModel.getHeartRateListLiveData().observe(getViewLifecycleOwner(), list -> {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i).getBpm();

                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }
            adapter.setMaxHeart(max);
            adapter.setMinHeart(min);
        });

    }

    @Override
    public void onClickItem(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(getActivity(), AddBloodPressureActivity.class);
                intent.putExtra("Pressure", "Thêm huyết áp");
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity(), AddBloodSugarActivity.class);
                intent.putExtra("Sugar", "Thêm đường huyết");
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity(), AddHeartRateActivity.class);
                intent.putExtra("heartRate", "Thêm nhịp tim");
                startActivity(intent);
                break;
        }
    }


}
