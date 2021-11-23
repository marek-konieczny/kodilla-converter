package com.example.kodillaconverter.domain;

public class Car {

    private String model;
    private int year;
    private int power;

    public Car(String model, int year, int power) {
        this.model = model;
        this.year = year;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", power=" + power +
                '}';
    }
}
