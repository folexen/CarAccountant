package com.caracount.dao;

import java.util.Date;

/**
 * Created by Flex on 29.08.2016.
 */
public class FuelDao {
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
}
