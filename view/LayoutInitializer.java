package com.caracount.view;

import com.caracount.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 26.08.2016.
 */
public class LayoutInitializer {

    public static void initConstrainGrid(GridBagConstraints gc, int x, int y) {
        gc.gridx = x;
        gc.gridy = y;
    }


    public static void initializeStandardLayout(JFrame jFrame, JPanel jPanel,
                                                JButton jButton1, JButton jButton2,
                                                JButton jButton3, JScrollPane jScrollPane) {
        jPanel.setOpaque(false);
        jScrollPane.setOpaque(false);

        GridBagConstraints gcMain = new GridBagConstraints();

        gcMain.weightx = 0.5;
        gcMain.weighty = 0;

        gcMain.fill = GridBagConstraints.BOTH;
        initConstrainGrid(gcMain, 0, 0);
        gcMain.gridwidth = 3;
        jFrame.add(jPanel, gcMain);

        initConstrainGrid(gcMain, 0, 1);
        gcMain.ipady = 20;
        gcMain.gridwidth = 1;
        jFrame.add(jButton1, gcMain);

        initConstrainGrid(gcMain, 1, 1);
        gcMain.gridwidth = 1;
        jFrame.add(jButton2, gcMain);

        initConstrainGrid(gcMain, 2, 1);
        gcMain.gridwidth = 1;
        jFrame.add(jButton3, gcMain);

        gcMain.weighty = 2;
        gcMain.ipady = 0;
        initConstrainGrid(gcMain, 0,2);
        gcMain.gridwidth = 3;
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

    static ImageIcon createScaledImageIcon(String path, String description) {
        Image image = createImageIcon(path, description).getImage();
        return new ImageIcon(image.getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH), description);
    }
}
