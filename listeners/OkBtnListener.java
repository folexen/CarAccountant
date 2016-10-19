package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.dao.LoginDaoJdbc;
import com.caracount.model.Helper;
import com.caracount.view.FramesNames;
import com.caracount.view.LoginPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OkBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!Files.exists(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s", LoginPanel.getLogin())))) {
            try {
                Files.createDirectories(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s", LoginPanel.getLogin())));
            } catch (IOException e) {
                Helper.showErrorMessage("Something wrong while creating directories for syncronization.");
            }
        }
        if (LoginDaoJdbc.checkLoginPassword()) {
            Controller.tabSwitch(FramesNames.MainFrame);
        } else {
            Helper.showErrorMessage("Login/Password incorrect, or you are not registered.");
        }


    }
}
