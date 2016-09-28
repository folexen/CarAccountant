package com.caracount.listeners;

import com.caracount.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 07.09.2016.
 */
public class CancelRegBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Controller.cancelRegistration();
    }
}
