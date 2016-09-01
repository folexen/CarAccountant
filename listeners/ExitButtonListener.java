package com.caracount.listeners;

import com.caracount.localData.FuelDataStorage;
import com.caracount.localData.ServiceDataStorage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 25.08.2016.
 */
public class ExitButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(1);
    }
}
