package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.view.FramesNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Controller.tabSwitch(FramesNames.MainFrame);
    }
}
