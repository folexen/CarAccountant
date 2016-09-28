package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.*;
import com.caracount.localData.FuelData;
import com.caracount.model.Model;
import com.caracount.view.FramesNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Flex on 08.09.2016.
 */
/* DB Deletion should implemented

 */
public class DelFuelBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected data(row)?");

        List<FuelExpenses> fuelExpenses = FuelData.getFuelList();

        if (reply == JOptionPane.YES_OPTION) {
            JTable processedTable = Controller.getMainFrame().getFuelTable();
            int row = processedTable.getSelectedRow();
            Iterator<FuelExpenses> iterator = fuelExpenses.iterator();
            while (iterator.hasNext()) {
                FuelExpenses current = iterator.next();
                if (current.getID() == Integer.parseInt((String) processedTable.getModel().getValueAt(row, 0))) {
                    iterator.remove();
                    DaoFactory.getInstance().getFuelExpensesDao().deleteFuelExpenses(current);
                    break;
                }
            }
            FuelData.writeFuelDatatoDisk();
            Controller.tabSwitch(FramesNames.FuelFrame);

        }
    }
}
