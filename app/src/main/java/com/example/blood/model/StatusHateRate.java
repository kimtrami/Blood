package com.example.blood.model;

public class StatusHateRate {

    private int images;
    private String stauts;
    private String titleState;
    private int textColor;

    public StatusHateRate(int images,String titleState, String stauts, int textColor) {
        this.images = images;
        this.titleState = titleState;
        this.stauts = stauts;
        this.textColor = textColor;
    }

    public int getImages() {
        return images;
    }

    public String getTitleState() {
        return titleState;
    }

    public String getStauts() {
        return stauts;
    }


    public int getTextColor() {
        return textColor;
    }

}
