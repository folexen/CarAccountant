package com.caracount.listeners;

import com.caracount.dao.ServiceDao;
import com.caracount.localData.ServiceDataStorage;
import com.caracount.view.ServiceEntryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 25.08.2016.
 */
public class AddServiceDataButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ServiceDao serviceDao = ServiceEntryPanel.processDataToServiceDao();
        ServiceDataStorage.addServiceDataToServiceStorage(serviceDao);
        JOptionPane.showMessageDialog(null, serviceDao.toString() +"\n" + "data added.");
    }
}
