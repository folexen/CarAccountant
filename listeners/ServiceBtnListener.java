package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.view.FramesNames;
import com.caracount.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 25.08.2016.
 */
public class ServiceBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Controller.tabSwitch(FramesNames.ServiceFrame);
    }
}