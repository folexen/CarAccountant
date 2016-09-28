package com.caracount.dao;

import com.caracount.localData.ServiceData;
import com.caracount.model.Helper;
import com.caracount.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Flex on 20.09.2016.
 */
public class ServiceExpensesDaoImpl implements ServiceExpensesDao{

    private static void sessionClose(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    @Override
    public Collection getServiceExpenses(String VIN) {
        List service = new ArrayList<ServiceExpenses>();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ServiceExpenses where VIN = :vin_id ").setString("vin_id", VIN);
            service = (List<ServiceExpenses>)query.list();
            session.getTransaction().commit();        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error in process of getting all service data",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally {
            sessionClose(session);
        }
        return service;
    }

    @Override
    public void addServiceExpenses(ServiceExpenses serviceExpenses) {
        ServiceData.addServiceDataToServiceStorage(serviceExpenses); //Adding data to list
        ServiceData.writeServiceDatatoDisk(); //Writing data to local storage
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(serviceExpenses);
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            Helper.showErrorMessage("Insert Error!");
            ex.printStackTrace();
        }
        finally {
            sessionClose(session);
        }

    }

    @Override
    public void deleteServiceExpenses(ServiceExpenses serviceExpenses) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(serviceExpenses);
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            Helper.showErrorMessage("Deletion Error!");
            ex.printStackTrace();
        }
        finally {
            sessionClose(session);
        }

    }

    @Override
    public void updateServiceExpenses(Integer id, ServiceExpenses serviceExpenses) {

    }
}
