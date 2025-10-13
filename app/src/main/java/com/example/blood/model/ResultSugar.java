package com.example.blood.model;

public class ResultSugar {

    private String title;
    private String content;
    private String state;
    private int  colorState;

    public ResultSugar(String state, int bloodSugarLevel) {
        this.state = state;
        this.colorState = bloodSugarLevel;
    }

    public ResultSugar(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getColorState() {
        return colorState;
    }

    public void setColorState(int colorState) {
        this.colorState = colorState;
    }
}
