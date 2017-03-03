package com.amolthombre.clearsky.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {
    @Id
    private String id;
    private double speed;
    private int degree;

    public Wind() {
        this.id = UUID.randomUUID().toString();
    }

    public Wind(double speed, int degree) {
        this.id = UUID.randomUUID().toString();
        this.speed = speed;
        this.degree = degree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}