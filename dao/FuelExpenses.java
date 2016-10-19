package com.caracount.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fuel_expenses")
public class FuelExpenses implements Serializable, Comparable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "vin_id")
    private String vinId;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "date")
    private Date date;

    @Column(name = "cost_per_liter")
    private Float costPerLiter;

    @Column(name = "total_cost")
    private Float totalCost;

    @Column(name = "refuel_total")
    private Boolean isRefuelTotal;

    @Transient
    private static final long serialVersionUID = 1212454536;

    public FuelExpenses() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getVinId() {
        return vinId;
    }

    public void setVinId(String vinId) {
        this.vinId = vinId;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getCostPerLiter() {
        return costPerLiter;
    }

    public void setCostPerLiter(Float costPerLiter) {
        this.costPerLiter = costPerLiter;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public Boolean getRefuelTotal() {
        return isRefuelTotal;
    }

    public void setRefuelTotal(Boolean refuelTotal) {
        isRefuelTotal = refuelTotal;
    }

    @Override
    public int compareTo(Object o) {
        FuelExpenses entry = (FuelExpenses) o;
        return getMileage() - entry.getMileage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FuelExpenses)) return false;

        FuelExpenses that = (FuelExpenses) o;

        if (getID() != null ? !getID().equals(that.getID()) : that.getID() != null) return false;
        if (getVinId() != null ? !getVinId().equals(that.getVinId()) : that.getVinId() != null) return false;
        if (getMileage() != null ? !getMileage().equals(that.getMileage()) : that.getMileage() != null) return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        if (getCostPerLiter() != null ? !getCostPerLiter().equals(that.getCostPerLiter()) : that.getCostPerLiter() != null)
            return false;
        if (getTotalCost() != null ? !getTotalCost().equals(that.getTotalCost()) : that.getTotalCost() != null)
            return false;
        return isRefuelTotal != null ? isRefuelTotal.equals(that.isRefuelTotal) : that.isRefuelTotal == null;

    }

    @Override
    public int hashCode() {
        int result = getID().hashCode();
        result = 31 * result + getVinId().hashCode();
        result = 31 * result + getMileage().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getCostPerLiter().hashCode();
        result = 31 * result + getTotalCost().hashCode();
        result = 31 * result + isRefuelTotal.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FuelExpenses{" +
                "ID=" + ID +
                ", vinId='" + vinId + '\'' +
                ", mileage=" + mileage +
                ", date=" + date +
                ", costPerLiter=" + costPerLiter +
                ", totalCost=" + totalCost +
                ", isRefuelTotal=" + isRefuelTotal +
                '}';
    }
}
