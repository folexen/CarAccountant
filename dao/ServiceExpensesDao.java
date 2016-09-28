package com.caracount.dao;

import java.util.Collection;

/**
 * Created by Flex on 20.09.2016.
 */
public interface ServiceExpensesDao {

    Collection getServiceExpenses(String VIN);
    void addServiceExpenses(ServiceExpenses serviceExpenses);
    void deleteServiceExpenses(ServiceExpenses serviceExpenses);
    void updateServiceExpenses(Integer id, ServiceExpenses serviceExpenses);
}
