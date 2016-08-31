package com.caracount;

import com.caracount.view.FramesNames;
import com.caracount.view.MainFrame;
import javax.swing.*;

/**
 * Created by Flex on 23.08.2016.
 */
public class Controller {
    private static MainFrame mainFrame;

    public static void initGui(FramesNames framesNames) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        String frameName = "";
        if (framesNames.equals(FramesNames.MainFrame)) frameName = "CAR ACCOUNTANT MAIN WINDOW";
        if (framesNames.equals(FramesNames.FuelFrame)) frameName = "CAR ACCOUNTANT FUEL TAB";
        if (framesNames.equals(FramesNames.ServiceFrame)) frameName = "CAR ACCOUNTANT SERVICE";

        mainFrame = new MainFrame(frameName, framesNames);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void selectFuelWindow() {
        mainFrame.dispose();
        initGui(FramesNames.FuelFrame);
    }
    public static void selectServiceWindow() {
        mainFrame.dispose();
        initGui(FramesNames.ServiceFrame);
    }
    public static void selectMainWindow() {
        if (mainFrame != null) mainFrame.dispose();
        initGui(FramesNames.MainFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                selectMainWindow();
            }
        });
    }
}
