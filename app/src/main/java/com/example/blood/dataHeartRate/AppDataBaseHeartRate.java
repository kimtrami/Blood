package com.example.blood.dataHeartRate;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HeartRateEntity.class}, version = 1)
public abstract class AppDataBaseHeartRate extends RoomDatabase {

    public abstract HeartRateDao heartRateDao();
}
