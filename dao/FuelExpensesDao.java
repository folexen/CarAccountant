package com.caracount.dao;

import java.util.Collection;

interface FuelExpensesDao {

    Collection getFuelExpenses(String VIN);
    void addFuelExpenses(FuelExpenses fuelExpenses);
    void updateFuelExpenses(Integer id, FuelExpenses fuelExpenses);
    void deleteFuelExpenses(FuelExpenses fuelExpenses);
}
