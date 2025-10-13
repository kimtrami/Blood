package com.example.blood.databloodsugar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BloodSugarDao {
    @Query("SELECT * FROM BloodSugarEntity ORDER BY id DESC")
    List<BloodSugarEntity> getAllData();

    @Insert
    long insertAll(BloodSugarEntity bloodSugarEntity);

    @Update
    void update(BloodSugarEntity bloodSugarEntity);


}
