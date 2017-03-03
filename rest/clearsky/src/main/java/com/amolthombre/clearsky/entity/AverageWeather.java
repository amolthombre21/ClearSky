package com.amolthombre.clearsky.entity;

import java.sql.Timestamp;

public class AverageWeather {
    double humidityAvg;
    double pressureAvg;
    double tempeartureAvg;
    double degreeAvg;
    double speedAvg;
    Timestamp timestamp;

    public AverageWeather() {

    }

    public AverageWeather(double humidityAvg, double pressureAvg,
            double tempeartureAvg, double degreeAvg, double speedAvg,
            Timestamp timestamp) {
        this.humidityAvg = humidityAvg;
        this.pressureAvg = pressureAvg;
        this.tempeartureAvg = tempeartureAvg;
        this.degreeAvg = degreeAvg;
        this.speedAvg = speedAvg;
        this.timestamp = timestamp;
    }

    public double getHumidityAvg() {
        return humidityAvg;
    }

    public void setHumidityAvg(double humidityAvg) {
        this.humidityAvg = humidityAvg;
    }

    public double getPressureAvg() {
        return pressureAvg;
    }

    public void setPressureAvg(double pressureAvg) {
        this.pressureAvg = pressureAvg;
    }

    public double getTempeartureAvg() {
        return tempeartureAvg;
    }

    public void setTempeartureAvg(double tempeartureAvg) {
        this.tempeartureAvg = tempeartureAvg;
    }

    public double getDegreeAvg() {
        return degreeAvg;
    }

    public void setDegreeAvg(double degreeAvg) {
        this.degreeAvg = degreeAvg;
    }

    public double getSpeedAvg() {
        return speedAvg;
    }

    public void setSpeedAvg(double speedAvg) {
        this.speedAvg = speedAvg;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AverageWeather [humidityAvg=" + humidityAvg + ", pressureAvg="
                + pressureAvg + ", tempeartureAvg=" + tempeartureAvg
                + ", degreeAvg=" + degreeAvg + ", speedAvg=" + speedAvg
                + ", timestamp=" + timestamp + "]";
    }
}