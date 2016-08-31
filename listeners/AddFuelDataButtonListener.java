package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.FuelDao;
import com.caracount.localData.FuelDataStorage;
import com.caracount.view.FuelEntryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 31.08.2016.
 */
public class AddFuelDataButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FuelDao fuelDao = FuelEntryPanel.processDataToFuelDao();
        FuelDataStorage.addFuelDatatoFuelStorage(fuelDao);
        JOptionPane.showMessageDialog(null, fuelDao.toString() +"\n" + "data added.");
        Controller.selectFuelWindow();
    }
}
