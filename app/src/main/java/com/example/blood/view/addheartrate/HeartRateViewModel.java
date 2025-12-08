package com.example.blood.view.addheartrate;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.dataHeartRate.AppDataBase;
import com.example.blood.dataHeartRate.DataManager;
import com.example.blood.dataHeartRate.HeartRateEntity;
import com.example.blood.model.HeartRate;
import com.example.blood.model.StatusHateRate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HeartRateViewModel extends ViewModel {

    private List<HeartRate> data;
    private AppDataBase db;
    private final MutableLiveData<Long> preMutableLiveData = new MutableLiveData<>();
    private HeartRateEntity heartRateEntity = new HeartRateEntity();


    public void updateBpm(int bpm) {
        heartRateEntity.setBpm(bpm);
    }

    public MutableLiveData<Long> getPreMutableLiveData() {
        return preMutableLiveData;
    }

    public HeartRateEntity getHeartRateEntity() {
        return heartRateEntity;
    }

    public void updateID(long id){
        heartRateEntity.setId((int) id);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(time, formatter);
        long timestamp = localTime.toSecondOfDay() * 1000L;
        heartRateEntity.setTime(timestamp);
    }

    public void updateDate(String date) {
        heartRateEntity.setDate(date);
    }

    public void updateNote(String note) {
        heartRateEntity.setNote(note);
    }


    public long update(Context context) {
        db = DataManager.getInstance().createDataBase(context);
        long id = db.heartRateDao().insertAllHeartRateEntity(heartRateEntity);
        preMutableLiveData.postValue(id);
        return id;
    }

    public StatusHateRate checkHeartRate(int bpm) {
        int img;
        String titleState;
        String status;
        int textColor;

        if (bpm <= 60) {
            img = R.drawable.low_heart_rate;
            titleState = "Nhịp tim thấp";
            status = "Nhịp tim lúc nghỉ ≤ 60 BPM";
            textColor = Color.parseColor("#41ACE9");
        } else if (bpm <= 100) {
            img = R.drawable.heart_normal;
            titleState = "Nhịp tim bình thường";
            status = "Nhịp tim lúc nghỉ 60–100 BPM";
            textColor = Color.parseColor("#00C57E");
        } else {
            img = R.drawable.diabetes_heart_rate;
            titleState = "Nhịp tim cao";
            status = "Nhịp tim lúc nghỉ ≥ 100 BPM";
            textColor = Color.parseColor("#FB5555");
        }

        return new StatusHateRate(img, titleState, status, textColor);
    }

    public List<HeartRate> intiData() {
        data = new ArrayList<>();

        data.add(new HeartRate("Thấp", "#41ACE9", "#41ACE9", "≤ 60"));
        data.add(new HeartRate("Bình Thường", "#00C57E", "#00C57E", "60 - 100"));
        data.add(new HeartRate("Cao", "#FB5555", "#FB5555", "≥ 100"));
        return data;
    }
}
