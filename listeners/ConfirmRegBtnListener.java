package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.LoginDaoJdbc;
import com.caracount.view.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 07.09.2016.
 */
public class ConfirmRegBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (RegisterFrame.getLogin().length() ==  0) {
            JOptionPane.showMessageDialog(null, "Write your login, please.", "Login field is empty!", JOptionPane.ERROR_MESSAGE);
        }
        else if (RegisterFrame.getPassword().length() < 3) {
            JOptionPane.showMessageDialog(null, "Reenter your password", "Password too short", JOptionPane.ERROR_MESSAGE);
        }
        else if (RegisterFrame.checkPasswordIdentity()) {
            LoginDaoJdbc.addNewUserToDb(RegisterFrame.getLogin(), RegisterFrame.getPassword());
            Controller.cancelRegistration();
        }
    }
}
