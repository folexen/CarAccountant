package com.caracount;

import com.caracount.view.FuelFrame;
import com.caracount.view.LoginPanel;
import com.caracount.view.MainFrame;
import com.caracount.view.ServiceFrame;

import javax.swing.*;

/**
 * Created by Flex on 23.08.2016.
 */
public class Controller {
    private static MainFrame mainFrame;
    private static FuelFrame fuelFrame;
    private static ServiceFrame serviceFrame;
    private static LoginPanel loginPanel;

    public static void initGui() {
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

        mainFrame = new MainFrame("Car Accountant");
        fuelFrame = new FuelFrame("Fuel consumption and expnces control");
        serviceFrame = new ServiceFrame("Service expences control window");

        serviceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fuelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        serviceFrame.setVisible(false);
        fuelFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    public static void changeWindowToFuelFrame() {
        serviceFrame.setVisible(false);
        fuelFrame.setVisible(true);
        mainFrame.setVisible(false);
    }
    public static void changeWindowToServiceFrame() {
        serviceFrame.setVisible(true);
        fuelFrame.setVisible(false);
        mainFrame.setVisible(false);
    }
    public static void changeWindowToMainFrame() {
        serviceFrame.setVisible(false);
        fuelFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    public static void initAppAfterSecuritySection() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initGui();
                loginPanel.dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginPanel = new LoginPanel();
                loginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginPanel.setVisible(true);
            }
        });

    }
}
