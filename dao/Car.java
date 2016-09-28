package com.caracount.dao;

/**
 * Created by Flex on 08.09.2016.
 */
public class Car {
    private String VIN;
    private String make;
    private String model;
    private int year;
    private double engineVolume;
    private String fuel;
    private int mileage;

    public Car(String VIN, String make, String model, int year, double engineVolume, String fuel, int mileage) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineVolume = engineVolume;
        this.fuel = fuel;
        this.mileage = mileage;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engineVolume=" + engineVolume +
                ", fuel='" + fuel + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
