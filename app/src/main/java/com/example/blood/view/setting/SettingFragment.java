package com.example.blood.view.setting;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blood.databinding.ActivityPolycyBinding;
import com.example.blood.databinding.FragmentSettingBinding;
import com.example.blood.view.base.BaseFragment;
import com.example.blood.view.dialog.ShareDialog;
import com.example.blood.view.policyactivity.PolicyActivity;

public class SettingFragment extends BaseFragment<FragmentSettingBinding> {
    @Override
    protected FragmentSettingBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentSettingBinding.inflate(inflater, container, false);
    }


    @Override
    public void initializeComponent() {
        super.initializeComponent();
    }

    @Override
    public void initializeEvent() {
        binding.txtShare.setOnClickListener(v -> shareApp());
        binding.txtPrivacyPolicy.setOnClickListener(v -> policyApp());
    }


    @Override
    public void initializeData() {
        super.initializeData();
    }

    @Override
    public void bindView() {
        super.bindView();
    }

    private void shareApp() {

        ShareDialog shareDialog = new ShareDialog();
        shareDialog.show(requireActivity().getSupportFragmentManager(), "share");
    }

    private void policyApp(){
        Intent intent = new Intent(requireContext(), PolicyActivity.class );
        startActivity(intent);
    }

}