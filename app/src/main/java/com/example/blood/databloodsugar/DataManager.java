package com.example.blood.databloodsugar;

import android.content.Context;

import androidx.room.Room;

public class DataManager {

    private static DataManager dataManager;


    public DataManager() {

    }


    public static DataManager getInstance() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public AppDatabaseSugar createDataBase(Context context) {
        return Room.databaseBuilder(context, AppDatabaseSugar.class, "db_blood_sugar")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

}
