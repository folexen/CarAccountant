package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.*;
import com.caracount.model.Model;
import com.caracount.view.FramesNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 31.08.2016.
 */
/*
 * Class provides data addition, validity check, user informing.
 */
public class AddFuelBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Processing data from JTextField to FuelExpenses entity.
        FuelExpenses fuelExpenses = Model.processDataToFuelExpenses();
        //Checking wether data imported to entity or not
        if (fuelExpenses != null) {
            //Checking validity of Fuel data entry
            if (Model.checkFuelEntryValidity(fuelExpenses)) {
                //pushing data to DB (Dao method also pushes data to local storage)
                DaoFactory.getInstance().getFuelExpensesDao().addFuelExpenses(fuelExpenses);
                //Refreshing view.
                Controller.tabSwitch(FramesNames.FuelFrame);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please check data. \nEntered mileage isn't possible on entered date",
                    "Incorrect data", JOptionPane.ERROR_MESSAGE); //Informing user about incorrect data
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You entered no data or data enter incomplete.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
