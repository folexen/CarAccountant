package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.DaoFactory;
import com.caracount.dao.ServiceExpenses;
import com.caracount.dao.ServiceName;
import com.caracount.localData.ServiceData;
import com.caracount.model.Model;
import com.caracount.view.FramesNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Flex on 06.09.2016.
 */
public class DelServiceBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected data(row)?");

        if (reply == JOptionPane.YES_OPTION) {
            JTable processedTable = Controller.getMainFrame().getServiceTable();
            int row = processedTable.getSelectedRow();
            Date date = null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse((String)processedTable.getModel().getValueAt(row, 2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ServiceName serviceName = new ServiceName();
            serviceName.setServiceName((String)processedTable.getModel().getValueAt(row, 4));

            ServiceExpenses daoToDelete = new ServiceExpenses();
                daoToDelete.setVIN(Model.getSelectedVin());
                daoToDelete.setMileage(Integer.parseInt((String) processedTable.getModel().getValueAt(row, 1)));
                daoToDelete.setServiceTypeWork(processedTable.getModel().getValueAt(row, 3).equals("Work"));
                daoToDelete.setServiceName(serviceName);
                daoToDelete.setServiceCost(Float.parseFloat((String) (processedTable.getModel().getValueAt(row, 5))));
                daoToDelete.setDate(date);
                daoToDelete.setComment((String)processedTable.getModel().getValueAt(row, 6));

            Iterator<ServiceExpenses> iterator = ServiceData.getServicesList().iterator();
            while (iterator.hasNext()) {
                ServiceExpenses current = iterator.next();
                if (current.equals(daoToDelete)) {
                    iterator.remove();
                    DaoFactory.getInstance().getServiceExpensesDao().deleteServiceExpenses(current);
                    break;
                }
            }
            ServiceData.writeServiceDatatoDisk();
            Controller.tabSwitch(FramesNames.ServiceFrame);
        }
    }
}
