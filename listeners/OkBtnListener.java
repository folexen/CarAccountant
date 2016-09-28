package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.CarJdbc;
import com.caracount.dao.LoginDaoJdbc;
import com.caracount.view.FramesNames;
import com.caracount.view.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Flex on 05.09.2016.
 */
public class OkBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!Files.exists(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s", LoginPanel.getLogin())))) {
            try {
                Files.createDirectories(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s", LoginPanel.getLogin())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (LoginDaoJdbc.checkLoginPassword() == true) {
            Controller.tabSwitch(FramesNames.MainFrame);
        }
        else {
            JOptionPane.showMessageDialog(null, "Login/Password incorrect, or you are not registered.");
        }



    }
}
