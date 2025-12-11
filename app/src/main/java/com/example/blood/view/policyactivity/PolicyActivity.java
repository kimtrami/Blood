package com.example.blood.view.policyactivity;

import android.view.LayoutInflater;
import android.view.View;

import com.example.blood.databinding.ActivityPolycyBinding;
import com.example.blood.view.base.BaseActivity;

public class PolicyActivity extends BaseActivity<ActivityPolycyBinding> {

    @Override
    protected ActivityPolycyBinding inflateBinding(LayoutInflater inflater) {
        return ActivityPolycyBinding.inflate(inflater);
    }


    @Override
    public void initializeEvent() {
        binding.btnGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
