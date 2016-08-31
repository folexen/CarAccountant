package com.caracount.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Flex on 29.08.2016.
 */
public class FuelDao implements Serializable, Comparable {

    private static final long serialVersionUID = 1212454536;
    private int carCurrentMileage;
    private Date date;
    private double fuelCost;
    private double totalFuelCost;
    private boolean isRefillPartial;

    public FuelDao(int carCurrentMileage, Date date, double fuelCost, double totalFuelCost, boolean isRefillPartial) {
        this.carCurrentMileage = carCurrentMileage;
        this.date = date;
        this.fuelCost = fuelCost;
        this.totalFuelCost = totalFuelCost;
        this.isRefillPartial = isRefillPartial;
    }

    public int getCarCurrentMileage() {
        return carCurrentMileage;
    }

    public Date getDate() {
        return date;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getTotalFuelCost() {
        return totalFuelCost;
    }

    public boolean isRefillPartial() {
        return isRefillPartial;
    }

    @Override
    public String toString() {
        return "FuelDao{" +
                "carCurrentMileage=" + carCurrentMileage +
                ", date=" + date +
                ", fuelCost=" + fuelCost +
                ", totalFuelCost=" + totalFuelCost +
                ", isRefillPartial=" + isRefillPartial +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        FuelDao entry = (FuelDao) o;
        return entry.carCurrentMileage > carCurrentMileage ? 1 : 0;
    }
}
