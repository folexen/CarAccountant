package com.caracount.listeners;

import com.caracount.Controller;
import com.caracount.view.FramesNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 25.08.2016.
 */
public class FuelBtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Controller.tabSwitch(FramesNames.FuelFrame);
    }
}
