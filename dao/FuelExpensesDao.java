package com.caracount.dao;

import java.util.Collection;

/**
 * Created by Flex on 15.09.2016.
 */
public interface FuelExpensesDao {

    Collection getFuelExpenses(String VIN);
    void addFuelExpenses(FuelExpenses fuelExpenses);
    void updateFuelExpenses(Integer id, FuelExpenses fuelExpenses);
    void deleteFuelExpenses(FuelExpenses fuelExpenses);
}
