package com.example.blood.view.infofragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.FragmentInfoBinding;
import com.example.blood.model.Infomation;
import com.example.blood.view.adapter.InfoAdapter;
import com.example.blood.view.adapter.InfoDetailPressureAdapter;
import com.example.blood.view.adapter.onClickItemInfo;
import com.example.blood.view.base.BaseFragment;
import com.example.blood.view.infodetailbloodsugar.InfoDetailBloodSugarActivity;
import com.example.blood.view.infodetailheartrate.InfoDetailHeartRateActivity;
import com.example.blood.view.infodetailpressure.InfoDetailPressureActivity;
import com.example.blood.view.infodetailweightbmi.InfoDetailWeightBmiActivity;
import com.example.blood.view.language.LanguageActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends BaseFragment<FragmentInfoBinding> implements onClickItemInfo {

    private InfoAdapter adapter;
    private InfoViewModel infoViewModel;
    private ArrayList<Infomation> infomationArrayList = new ArrayList<>();
    private String title = "pressure";
    private Intent intent;

    @Override
    protected FragmentInfoBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentInfoBinding.inflate(inflater, container, false);
    }

    @Override
    public void initializeComponent() {
        adapter = new InfoAdapter();
        binding.lstMenuItem.setAdapter(adapter);
        adapter.setOnClickItemInfo(this);

        infoViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
    }

    @Override
    public void initializeData() {
        List<Infomation> infomations = infoViewModel.initData();
        adapter.setData(infomations);
    }

    @Override
    public void bindView() {
        infoViewModel.initData();
    }

    @Override
    public void onClickItem(int position) {
        switch (position) {
            case 0:
                title = "Pressure";
                intent = new Intent(getActivity(), InfoDetailPressureActivity.class);
                startActivity(intent);
                break;
            case 1:
                title = "Sugar";
                intent = new Intent(getActivity(), InfoDetailBloodSugarActivity.class);
                startActivity(intent);
                break;
            case 2:
                title = "Heart";
                intent = new Intent(getActivity(), InfoDetailHeartRateActivity.class);
                startActivity(intent);
                break;
            case 3:
                title = "BMI";
                intent = new Intent(getActivity(), InfoDetailWeightBmiActivity.class);
                startActivity(intent);
                break;
        }

    }
}
