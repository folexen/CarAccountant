package com.caracount.dao;

import java.util.Collection;

interface ServiceExpensesDao {

    Collection getServiceExpenses(String VIN);
    void addServiceExpenses(ServiceExpenses serviceExpenses);
    void deleteServiceExpenses(ServiceExpenses serviceExpenses);
    void updateServiceExpenses(Integer id, ServiceExpenses serviceExpenses);
}
