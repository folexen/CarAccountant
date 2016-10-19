package com.caracount.listeners;

import com.caracount.model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
        if (reply == JOptionPane.YES_OPTION) {
            //TEMP SYNCH SECTION FOR FUTHER REFACTORING
                Model.synchronizeFuelList();
                Model.synchronizeServiceList();
            //TEMP SYNCH SECTION FOR FUTHER REFACTORING
            System.exit(1);
        }
    }
}
