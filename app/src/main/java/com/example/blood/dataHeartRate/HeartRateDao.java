package com.example.blood.dataHeartRate;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HeartRateDao {
    @Query("SELECT * FROM HeartRateEntity ORDER BY id DESC")
    List<HeartRateEntity> getAll();

    @Insert
    long insertAllHeartRateEntity(HeartRateEntity heartRateEntity);

    @Update
    void updateHeartEntity(HeartRateEntity heartRateEntity);
}
