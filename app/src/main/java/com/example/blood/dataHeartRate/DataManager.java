package com.example.blood.dataHeartRate;

import android.content.Context;

import androidx.room.Room;

public class DataManager {

    private static DataManager dataManager;

    public DataManager(){}

    public static DataManager getInstance(){
        if (dataManager == null){
            dataManager = new DataManager();
        }
        return  dataManager;
    }

    public com.example.blood.dataHeartRate.AppDataBase createDataBase(Context context){
        return Room.databaseBuilder(context, com.example.blood.dataHeartRate.AppDataBase.class, "db_heart_rate")
                .fallbackToDestructiveMigrationOnDowngrade()
                .allowMainThreadQueries()
                .build();
    }

}
