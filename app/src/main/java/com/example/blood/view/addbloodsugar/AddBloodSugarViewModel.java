package com.example.blood.view.addbloodsugar;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.databloodsugar.AppDatabaseSugar;
import com.example.blood.databloodsugar.BloodSugarEntity;
import com.example.blood.databloodsugar.DataManager;
import com.example.blood.model.Sugar;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddBloodSugarViewModel extends ViewModel {

    private AppDatabaseSugar appDatabase;
    private BloodSugarEntity bloodSugarEntity = new BloodSugarEntity();
    private final MutableLiveData<Long> preMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Long> getPreMutableLiveData() {
        return preMutableLiveData;
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

    public long insertDataBloodSugar(Context context) {
        appDatabase = DataManager.getInstance().createDataBase(context);
        long id = appDatabase.bloodSugarDao().insertAll(bloodSugarEntity);
        preMutableLiveData.postValue(id);
        return id;
    }

    public List<Sugar> initData() {
        List<Sugar> data = new ArrayList<>();

        data.add(new Sugar("Thấp", "#41ACE9", "#41ACE9", "< 4.0"));
        data.add(new Sugar("Bình Thường", "#00C57E", "#00C57E", "4.0 - 5.5"));
        data.add(new Sugar("Tiền tiểu đường", "#E9D841", "#E9D841", "5.5 - 7.0"));
        data.add(new Sugar("Tiểu đường", "#FB5555", "#FB5555", "5.5 - 7.0"));

        return data;
    }
}
