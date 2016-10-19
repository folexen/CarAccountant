package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.DaoFactory;
import com.caracount.dao.ServiceExpenses;
import com.caracount.localData.ServiceData;
import com.caracount.view.FramesNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class DelServiceBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected data(row)?");

        if (reply == JOptionPane.YES_OPTION) {
            JTable processedTable = Controller.getMainFrame().getServiceTable();
            int row = processedTable.getSelectedRow();

            Integer idToDelete = Integer.parseInt((String) processedTable.getModel().getValueAt(row, 0));

            Iterator<ServiceExpenses> iterator = ServiceData.getServicesList().iterator();
            while (iterator.hasNext()) {
                ServiceExpenses current = iterator.next();
                System.out.println(current.getId().equals(idToDelete));
                if (current.getId().equals(idToDelete)) {
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
