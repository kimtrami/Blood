package com.example.blood.databloodsugar;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BloodSugarEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private float sugarConcenttration;
    private String measured;
    private long time;
    private String date;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSugarConcenttration() {
        return sugarConcenttration;
    }

    public void setSugarConcenttration(float sugarConcenttration) {
        this.sugarConcenttration = sugarConcenttration;
    }

    public String getMeasured() {
        return measured;
    }

    public void setMeasured(String measured) {
        this.measured = measured;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
