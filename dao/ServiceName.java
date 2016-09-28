package com.caracount.dao;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Flex on 22.09.2016.
 */
@Entity
@Table(name = "service_name")
public class ServiceName implements Serializable{

    @Transient
    private final static long serialVersionUID = 1299657812;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "name")
    private String serviceName;

    public ServiceName() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceName)) return false;

        ServiceName that = (ServiceName) o;
        return getServiceName().equals(that.getServiceName());

    }

    @Override
    public int hashCode() {
        int result = getID().hashCode();
        result = 31 * result + getServiceName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ServiceName{" +
                "ID=" + ID +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
