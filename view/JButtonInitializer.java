package com.caracount.view;

import com.caracount.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 29.08.2016.
 */
public class JButtonInitializer {

    private static Font fontMain = new Font("Courier", Font.BOLD, 10);
    private static Font fontHelp = new Font("Courier", Font.BOLD, 9);

    static JButton initAndCreateButton(String name, Font font, String toolTipText, ActionListener actionListener) {
        JButton resultButton = new JButton(name);
        resultButton.setFont(font);
        resultButton.setToolTipText(toolTipText);
        resultButton.addActionListener(actionListener);
        return resultButton;
    }
    static JButton initAndCreateExitButton() {
        return initAndCreateButton("EXIT", fontMain,
                "Press this button to exit application.", new ExitButtonListener());
    }

    static JButton initAndCreateFuelButton() {
        return initAndCreateButton("FUEL EXPENSES TAB", fontMain,
                "Press this button to go to fuel expenses tab.", new FuelButtonListener());
    }

    static JButton initAndCreateServiceButton() {
        return initAndCreateButton("SERVICE EXPENSES TAB", fontMain,
                "Press this button to go to service expenses tab.", new ServiceButtonListener());
    }

    static JButton initAndCreateMainFrameButton() {
        return initAndCreateButton("GOTO MAIN TAB", fontMain,
                "Press this button to return to main tab.", new MainButtonListener());
    }

    static JButton initAndCreateAddFuelDataButton() {
        return initAndCreateButton("ADD FUEL DATA", fontHelp,
                "Press this button to process this data to local storage.", new AddFuelDataButtonListener());
    }

    static JButton initAndCreateAddServiceDataButton() {
        return initAndCreateButton("ADD SERVICE DATA", fontHelp,
                "Press this button to process this data to local storage.", new AddServiceDataButtonListener());
    }
}
