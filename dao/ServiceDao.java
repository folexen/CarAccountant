package com.caracount.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Flex on 26.08.2016.
 */
public class ServiceDao implements Serializable, Comparable {

    private final static long serialVersionUID = 1234567980;
    private int serviceMileage;
    private boolean isServiceTypeWork;
    private String workOrPartName;
    private String comment;
    private double serviceOrWorkCost;
    private Date date;

    public ServiceDao(int serviceMileage, boolean isServiceTypeWork, String workOrPartName, double serviceOrWorkCost, Date date, String comment) {
        this.serviceMileage = serviceMileage;
        this.isServiceTypeWork = isServiceTypeWork;
        this.workOrPartName = workOrPartName;
        this.serviceOrWorkCost = serviceOrWorkCost;
        this.date = date;
        this.comment = comment;

    }

    public int getServiceMileage() {
        return serviceMileage;
    }

    public boolean isServiceTypeWork() {
        return isServiceTypeWork;
    }

    public String getWorkOrPartName() {
        return workOrPartName;
    }

    public String getComment() {
        return comment;
    }

    public double getServiceOrWorkCost() {
        return serviceOrWorkCost;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        String isServiceTypeWorkString;
        if (isServiceTypeWork)  isServiceTypeWorkString = "Work";
        else isServiceTypeWorkString = "Spare Part";
        return "ServiceDao{" +
                "serviceMileage=" + serviceMileage +
                ", isServiceTypeWork=" + isServiceTypeWorkString +
                ", workOrPartName='" + workOrPartName + '\'' +
                ", serviceOrWorkCost=" + serviceOrWorkCost +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ServiceDao entry = (ServiceDao) o;

        return this.getServiceMileage() < entry.getServiceMileage() ? 1 : 0;
    }
}
