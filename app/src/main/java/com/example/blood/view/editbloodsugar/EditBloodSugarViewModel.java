package com.example.blood.view.editbloodsugar;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.databloodsugar.AppDatabase;
import com.example.blood.databloodsugar.BloodSugarEntity;
import com.example.blood.databloodsugar.DataManager;
import com.example.blood.model.Sugar;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EditBloodSugarViewModel extends ViewModel {

    private AppDatabase appDatabase;
    private BloodSugarEntity bloodSugarEntity = new BloodSugarEntity();

    public void setBloodSugarEntity(BloodSugarEntity bloodSugarEntity) {
        this.bloodSugarEntity = bloodSugarEntity;
    }

    public void insertSugarConcenttration(float sugarConcenttration) {
        bloodSugarEntity.setSugarConcenttration(sugarConcenttration);
    }

    public void insertMeasured(String measured) {
        bloodSugarEntity.setMeasured(measured);
    }

    public void insertNote(String note) {
        bloodSugarEntity.setNote(note);
    }

    public BloodSugarEntity getBloodSugarEntity() {
        return bloodSugarEntity;
    }

    public void insertId(long id) {
        bloodSugarEntity.setId((int) id);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(time, formatter);
        long timestamp = localTime.toSecondOfDay() * 1000L;
        bloodSugarEntity.setTime(timestamp);
    }

    public void insertDate(String date) {
        bloodSugarEntity.setDate(date);
    }

    public void updateDataBloodSugar(Context context) {
        appDatabase = DataManager.getInstance().createDataBase(context);
        appDatabase.bloodSugarDao().update(bloodSugarEntity);
    }

    public List<Sugar> initData() {
        List<Sugar> data = new ArrayList<>();

        data.add(new Sugar("Low", "#41ACE9", "#41ACE9", "< 4.0"));
        data.add(new Sugar("Normal", "#00C57E", "#00C57E", "4.0 - 5.5"));
        data.add(new Sugar("Pre-diabetes", "#E9D841", "#E9D841", "5.5 - 7.0"));
        data.add(new Sugar("Diabetes", "#FB5555", "#FB5555", "5.5 - 7.0"));

        return data;
    }

}
