package com.example.blood.databloodsugar;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BloodSugarEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BloodSugarDao bloodSugarDao();
}
