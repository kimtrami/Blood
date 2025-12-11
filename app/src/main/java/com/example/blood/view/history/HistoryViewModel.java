package com.example.blood.view.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.dataHeartRate.AppDataBaseHeartRate;
import com.example.blood.dataHeartRate.HeartRateEntity;
import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.PressureEntity;
import com.example.blood.databloodsugar.AppDatabaseSugar;
import com.example.blood.databloodsugar.BloodSugarEntity;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    private com.example.blood.databloodpressure.AppDatabase appDatabase;
    private AppDatabaseSugar appDatabaseSugar;
    private AppDataBaseHeartRate appDataBaseHeartRate;


    private MutableLiveData<List<PressureEntity>> pressureListLiveData = new MutableLiveData<>();
    private MutableLiveData<List<BloodSugarEntity>> BloodSugarListLiveData = new MutableLiveData<>();
    private MutableLiveData<List<HeartRateEntity>> HeartRateListLiveData = new MutableLiveData<>();


    public MutableLiveData<List<BloodSugarEntity>> getBloodSugarListLiveData() {
        return BloodSugarListLiveData;
    }

    public MutableLiveData<List<PressureEntity>> getPressureListLiveData() {
        return pressureListLiveData;
    }

    public MutableLiveData<List<HeartRateEntity>> getHeartRateListLiveData() {
        return HeartRateListLiveData;
    }

    public AppDataBaseHeartRate getAppDataBaseHeartRate() {
        return appDataBaseHeartRate;
    }

    public void setAppDatabase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public void setAppDatabaseSugar(AppDatabaseSugar appDatabase) {
        this.appDatabaseSugar = appDatabase;
    }

    public void setAppDataBaseHeartRate(AppDataBaseHeartRate appDataBaseHeartRate) {
        this.appDataBaseHeartRate = appDataBaseHeartRate;
    }

    public void getDataHistoryPressure() {
        new Thread(() -> {
            List<PressureEntity> list = appDatabase.pressureDao().getAll();
            list.forEach(pressureEntity -> {
            });
            pressureListLiveData.postValue(list);
        }).start();
    }


    public void getDataHistoryBloodSugar() {
        new Thread(() -> {
            List<BloodSugarEntity> list = appDatabaseSugar.bloodSugarDao().getAllData();
            list.forEach(pressureEntity -> {
            });
            BloodSugarListLiveData.postValue(list);
        }).start();
    }


    public void getDataHistoryHeartRate() {
        new Thread(() -> {
            List<HeartRateEntity> list = appDataBaseHeartRate.heartRateDao().getAll();
            list.forEach(pressureEntity -> {
            });
            HeartRateListLiveData.postValue(list);
        }).start();
    }

}
