package com.climat.demo.Models;

public class ParamsModel {

    private int userId = 1;
    private String airMax;

    private String airMin;

    private String tempMax;

    private String tempMin;

    private String wetMax;

    private String wetMin;

    public int getUserId() {
        return userId;
    }

    public String getAirMax() {
        return airMax;
    }

    public void setAirMax(String airMax) {
        this.airMax = airMax;
    }

    public String getAirMin() {
        return airMin;
    }

    public void setAirMin(String airMin) {
        this.airMin = airMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String temp_max) {
        this.tempMax = temp_max;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getWetMax() {
        return wetMax;
    }

    public void setWetMax(String wetMax) {
        this.wetMax = wetMax;
    }

    public String getWetMin() {
        return wetMin;
    }

    public void setWetMin(String wetMin) {
        this.wetMin = wetMin;
    }
}
