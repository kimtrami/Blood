package com.example.blood.model;

public class SugarStatus {
    private int state;
    private int colorState;

    public SugarStatus(int state, int colorState) {
        this.state = state;
        this.colorState = colorState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getColorState() {
        return colorState;
    }

    public void setColorState(int colorState) {
        this.colorState = colorState;
    }
}
