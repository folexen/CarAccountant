package com.caracount.listeners;

import com.caracount.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterBtnListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Controller.initRegisterFrame();
    }
}
