package com.caracount.view;

import com.caracount.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 29.08.2016.
 */
public class JButtonInitializer {

    private static Font fontMain = FontInitializer.setMainButtonFont();
    private static Font fontHelp = FontInitializer.setSecondaryButtonFont();

    static JButton initAndCreateButton(String name, Font font, String toolTipText, ActionListener actionListener) {
        JButton resultButton = new JButton(name);
        resultButton.setFont(font);
        resultButton.setToolTipText(toolTipText);
        resultButton.addActionListener(actionListener);
        return resultButton;
    }
    static JButton initAndCreateExitButton() {
        return initAndCreateButton("EXIT", fontMain,
                "Press this button to exit application.", new ExitBtnListener());
    }

    static JButton initAndCreateOKButton() {
        return initAndCreateButton("OK", fontMain,
                "Press this button to confirm login and password entry.", new OkBtnListener());
    }

    static JButton initAndCreateFuelButton() {
        return initAndCreateButton("FUEL EXPENSES TAB", fontMain,
                "Press this button to go to fuel expenses tab.", new FuelBtnListener());
    }

    static JButton initAndCreateServiceButton() {
        return initAndCreateButton("SERVICE EXPENSES TAB", fontMain,
                "Press this button to go to service expenses tab.", new ServiceBtnListener());
    }

    static JButton initAndCreateMainFrameButton() {
        return initAndCreateButton("GOTO MAIN TAB", fontMain,
                "Press this button to return to main tab.", new MainBtnListener());
    }

    static JButton initAndCreateAddFuelDataButton() {
        return initAndCreateButton("ADD FUEL DATA", fontHelp,
                "Press this button to process this data to local storage.", new AddFuelBtnListener());
    }

    static JButton initAndCreateAddServiceDataButton() {
        return initAndCreateButton("ADD SERVICE DATA", fontHelp,
                "Press this button to process this data to local storage.", new AddServiceBtnListener());
    }

    static JButton initAndCreateRegisterButton() {
        return initAndCreateButton("Register", fontHelp,
                "Press this button to create new account.", new RegisterBtnListener());
    }

    static JButton initAndCreateDeleteSrvcButton() {
        return initAndCreateButton("Delete", fontHelp,
                "Press this button to delete selected row.", new DelServiceBtnListener());
    }

    static JButton initAndCreateDeleteFuelButton() {
        return initAndCreateButton("Delete", fontHelp,
                "Press this button to delete selected row.", new DelFuelBtnListener());
    }

    static JButton initAndCreateConfirmButton() {
        return initAndCreateButton("Confirm", fontHelp,
                "Press this button to confirm your new login and password.", new ConfirmRegBtnListener());
    }

    static JButton initAndCreateCancelButton() {
        return initAndCreateButton("Cancel", fontHelp,
                "Press this button cancel changes " + "\n" +
                        "and return back to login screen.", new CancelRegBtnListener());
    }
}
