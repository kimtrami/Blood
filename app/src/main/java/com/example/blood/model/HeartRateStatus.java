package com.example.blood.model;

public class HeartRateStatus {

    private String titleState;
    private int titleStateColor;
    private int bgState;
    private int imgState;

    public HeartRateStatus(String titleState, int titleStateColor, int imgState) {
        this.titleState = titleState;
        this.titleStateColor = titleStateColor;
        this.imgState = imgState;
    }

    public String getTitleState() {
        return titleState;
    }

    public void setTitleState(String titleState) {
        this.titleState = titleState;
    }

    public int getTitleStateColor() {
        return titleStateColor;
    }

    public void setTitleStateColor(int titleStateColor) {
        this.titleStateColor = titleStateColor;
    }

    public int getBgState() {
        return bgState;
    }

    public void setBgState(int bgState) {
        this.bgState = bgState;
    }

    public int getImgState() {
        return imgState;
    }

    public void setImgState(int imgState) {
        this.imgState = imgState;
    }
}
