package com.caracount.view;

import com.caracount.listeners.ExitButtonListener;
import com.caracount.listeners.FuelButtonListener;
import com.caracount.listeners.MainButtonListener;
import com.caracount.listeners.ServiceButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 29.08.2016.
 */
public class JButtonInitializer {

    static JButton initAndCreateExitButton() {
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        exitButton.setToolTipText("Press this button to exit application.");
        exitButton.addActionListener(new ExitButtonListener());
        return exitButton;
    }

    static JButton initAndCreateFuelButton() {
        JButton fuelButton = new JButton("FUEL EXPENSES TAB");
        fuelButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        fuelButton.setToolTipText("Press this button to go to fuel expenses tab.");
        fuelButton.addActionListener(new FuelButtonListener());
        return fuelButton;
    }

    static JButton initAndCreateServiceButton() {
        JButton serviceButton = new JButton("SERVICE EXPENSES TAB");
        serviceButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        serviceButton.setToolTipText("Press this button to go to service expenses tab.");
        serviceButton.addActionListener(new ServiceButtonListener());
        return serviceButton;
    }

    static JButton initAndCreateMainFrameButton() {
        JButton mainFrameButton = new JButton("GOTO MAIN TAB");
        mainFrameButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        mainFrameButton.setToolTipText("Press this button to return to main tab.");
        mainFrameButton.addActionListener(new MainButtonListener());
        return mainFrameButton;
    }
}
