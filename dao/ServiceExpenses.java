package com.caracount.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "service_expenses")
public class ServiceExpenses implements Serializable, Comparable {

    @Transient
    private final static long serialVersionUID = 1234567980;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "vin_id")
    private String VIN;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "type")
    private Boolean isServiceTypeWork;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    private ServiceName serviceName;

    @Column(name = "cost")
    private Float serviceCost;

    @Column(name = "date")
    private Date date;

    @Column(name = "comment")
    private String comment;


    public ServiceExpenses() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Boolean getServiceTypeWork() {
        return isServiceTypeWork;
    }

    public void setServiceTypeWork(Boolean serviceTypeWork) {
        isServiceTypeWork = serviceTypeWork;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }

    public Float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        String isServiceTypeWorkString;
        if (isServiceTypeWork) isServiceTypeWorkString = "Work";
        else isServiceTypeWorkString = "Spare Part";
        return "Following entry:" + "\n" +
                "Mileage: " + mileage + "\n" +
                "Entry type: " + isServiceTypeWorkString + "\n" +
                "Name: " + serviceName + "\n" +
                "Cost: " + serviceCost + "\n" +
                "ServiceExpenses date: " + date + "\n" +
                "ServiceExpenses comment: " + comment;
    }

    @Override
    public int compareTo(Object o) {
        ServiceExpenses entry = (ServiceExpenses) o;
        if (Objects.equals(getMileage(), entry.getMileage())) {
            return (int) (getDate().getTime() - entry.getDate().getTime());
        }
        return this.getMileage() - entry.getMileage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceExpenses)) return false;

        ServiceExpenses that = (ServiceExpenses) o;

        if (!getVIN().equals(that.getVIN())) return false;
        if (!getMileage().equals(that.getMileage())) return false;
        if (!isServiceTypeWork.equals(that.isServiceTypeWork)) return false;
        if (!getServiceName().equals(that.getServiceName())) return false;
        if (!getServiceCost().equals(that.getServiceCost())) return false;
        if (!getDate().equals(that.getDate())) return false;
        return getComment().equals(that.getComment());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getVIN().hashCode();
        result = 31 * result + getMileage().hashCode();
        result = 31 * result + isServiceTypeWork.hashCode();
        result = 31 * result + getServiceName().hashCode();
        result = 31 * result + getServiceCost().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getComment().hashCode();
        return result;
    }
}
