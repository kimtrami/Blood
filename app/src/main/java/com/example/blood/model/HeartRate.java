package com.example.blood.model;

public class HeartRate {

    private String heartRateStatus;
    private String heartRateStatusColor;
    private String heartRateBars;
    private String heartRateValue;

    public HeartRate(String heartRateStatus, String heartRateStatusColor, String heartRateBars, String heartRateValue) {
        this.heartRateStatus = heartRateStatus;
        this.heartRateStatusColor = heartRateStatusColor;
        this.heartRateBars = heartRateBars;
        this.heartRateValue = heartRateValue;
    }

    public String getHeartRateStatus() {
        return heartRateStatus;
    }

    public void setHeartRateStatus(String heartRateStatus) {
        this.heartRateStatus = heartRateStatus;
    }

    public String getHeartRateStatusColor() {
        return heartRateStatusColor;
    }

    public void setHeartRateStatusColor(String heartRateStatusColor) {
        this.heartRateStatusColor = heartRateStatusColor;
    }

    public String getHeartRateBars() {
        return heartRateBars;
    }

    public void setHeartRateBars(String heartRateBars) {
        this.heartRateBars = heartRateBars;
    }

    public String getHeartRateValue() {
        return heartRateValue;
    }

    public void setHeartRateValue(String heartRateValue) {
        this.heartRateValue = heartRateValue;
    }
}
