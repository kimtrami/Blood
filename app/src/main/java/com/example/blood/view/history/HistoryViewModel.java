package com.example.blood.view.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.databloodpressure.AppDatabase;
import com.example.blood.databloodpressure.PressureEntity;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    private com.example.blood.databloodpressure.AppDatabase appDatabase;
    private MutableLiveData<List<PressureEntity>> pressureListLiveData = new MutableLiveData<>();

    public MutableLiveData<List<PressureEntity>> getPressureListLiveData() {
        return pressureListLiveData;
    }

    public void setAppDatabase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public void getDataHistory(){
        new Thread(() -> {
            List<PressureEntity> list = appDatabase.pressureDao().getAll();
            pressureListLiveData.postValue(list);
        }).start();
    }

}
