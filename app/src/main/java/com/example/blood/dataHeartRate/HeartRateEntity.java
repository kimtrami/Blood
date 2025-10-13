package com.example.blood.dataHeartRate;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HeartRateEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int bpm;
    private long time;
    private String date;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
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
