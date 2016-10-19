package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.DaoFactory;
import com.caracount.dao.ServiceExpenses;
import com.caracount.model.Model;
import com.caracount.view.FramesNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *  Class provides data addition, validity check, user informing.
 *
 */
public class AddServiceBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ServiceExpenses serviceExpenses = Model.processDataToServiceDao(); //Processing data from JTextFields to ServiceExpenses entry

        if (serviceExpenses != null) {
            if (Model.checkServiceEntryValidity(serviceExpenses)) { //Checking entry validity
                DaoFactory.getInstance().getServiceExpensesDao().addServiceExpenses(serviceExpenses);
                Controller.tabSwitch(FramesNames.ServiceFrame); //Refreshing view. Looking for another possibility to refresh table.
            } else {
                JOptionPane.showMessageDialog(null, "Please check data. \nEntered mileage isn't possible on entered date",
                        "Incorrect data", JOptionPane.ERROR_MESSAGE); //Informing user about incorrect data
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data input isn't complete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
