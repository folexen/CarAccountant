package com.caracount.dao;

import com.caracount.localData.FuelData;
import com.caracount.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class FuelExpensesDaoImpl implements FuelExpensesDao {

    @Override
    public Collection getFuelExpenses(String VIN) {
        List<FuelExpenses> fuel = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from FuelExpenses where vinId = :vin_id ").setString("vin_id", VIN);
            fuel = (List<FuelExpenses>)query.list();//Checkout uncheked cast warning!!!
            session.getTransaction().commit();        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error in process of getting all fuel data",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally {
            sessionClose(session);
        }
        return fuel;
    }

    @Override
    public void addFuelExpenses(FuelExpenses fuelExpenses) {
        FuelData.addFuelDatatoFuelStorage(fuelExpenses);
        FuelData.writeFuelDatatoDisk();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(fuelExpenses);
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Insert Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally {
            sessionClose(session);
        }
    }

    @Override
    public void updateFuelExpenses(Integer id, FuelExpenses fuelExpenses) {

    }

    @Override
    public void deleteFuelExpenses(FuelExpenses fuelExpenses) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(fuelExpenses);
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Deletion Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            sessionClose(session);
        }
    }

    private static void sessionClose(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
