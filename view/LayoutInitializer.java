package com.caracount.view;

import com.caracount.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 26.08.2016.
 */
public class LayoutInitializer {
    public static void initializeStandardLayout(JFrame jFrame, JPanel jPanel,
                                                JButton jButton1, JButton jButton2,
                                                JButton jButton3, JScrollPane jScrollPane) {
        GridBagConstraints gcMain = new GridBagConstraints();

        gcMain.weightx = 0.5;
        gcMain.weighty = 0;

        gcMain.anchor = GridBagConstraints.FIRST_LINE_START;
        gcMain.gridx = 0;
        gcMain.gridy = 0;
        gcMain.gridwidth = 6;
        jFrame.add(jPanel, gcMain);

        gcMain.fill = GridBagConstraints.HORIZONTAL;
        gcMain.gridx = 0;
        gcMain.gridy = 1;
        gcMain.ipady = 20;
        gcMain.gridwidth = 1;
        jFrame.add(jButton1, gcMain);

        gcMain.fill = GridBagConstraints.HORIZONTAL;
        gcMain.gridx = 1;
        gcMain.gridwidth = 1;
        jFrame.add(jButton2, gcMain);

        gcMain.fill = GridBagConstraints.HORIZONTAL;
        gcMain.gridx = 2;
        gcMain.gridwidth = 1;
        jFrame.add(jButton3, gcMain);

        gcMain.weighty = 2;
        gcMain.fill = GridBagConstraints.HORIZONTAL;
        gcMain.ipady = 0;
        gcMain.gridx = 0;
        gcMain.gridy = 2;
        gcMain.gridwidth = 6;
        jFrame.add(jScrollPane, gcMain);
    }

    static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = Controller.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
