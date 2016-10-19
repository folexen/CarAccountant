package com.caracount.dao;

public class DaoFactory {
    private static DaoFactory instance = null;
    private FuelExpensesDaoImpl fuelExpensesDao = null;
    private ServiceExpensesDaoImpl serviceExpensesDao = null;

    public static synchronized DaoFactory getInstance(){
        if (instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    public FuelExpensesDaoImpl getFuelExpensesDao() {
        if (fuelExpensesDao == null) {
            fuelExpensesDao = new FuelExpensesDaoImpl();
        }
        return fuelExpensesDao;
    }

    public ServiceExpensesDaoImpl getServiceExpensesDao() {
        if (serviceExpensesDao == null) {
           serviceExpensesDao = new ServiceExpensesDaoImpl();
        }
        return serviceExpensesDao;
    }
}
