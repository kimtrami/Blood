package com.example.blood.view.infodetailpressure;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailPressureViewModel extends ViewModel {

    private List<InfoDetail> data;

    public List<InfoDetail> initData(){
        data = new ArrayList<>();
        data.add(new InfoDetail("Introduction", "Blood pressure disorders often have no visible my symptims, which can be dangerous because high or low blood pressure can lead to life - threatening conditions like heart attack to stroke." +
                " However, you can prevents or treat them early through monitoring your blood pressure levels. Early diagnosis and healthy lifestyle changes can help you maintain good blood pressure and prevent health problems."));

        data.add(new InfoDetail("About Blood Pressure", "Blood pressure refers to the force that blood exerts against the walls of your arteries it is pumped out from the heart." +
                " Checking your heart is working and is an essential part of a general health assessment. Proper medication management and blood pressure monitoring are critical for people with high blood pressure."));

        data.add(new InfoDetail("How is high Blood Pressure Diagnosed","The only way to know if you have high blood pressure is to get regular checks from a healthcare provider." +
                " If your blood pressure is normal, your providers should check it at every annual checkup. If your readings are high, your provider may ask you to monitor your blood pressure at home several times a day or once a week."));

        return data;
    }

}
