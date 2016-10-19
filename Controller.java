package com.caracount;

import com.caracount.view.FramesNames;
import com.caracount.view.MainFrame;
import com.caracount.view.RegisterFrame;

import javax.swing.*;

public class Controller {
    private static MainFrame mainFrame;
    private static RegisterFrame registerFrame;

    private static void initGui() {
        setSystemLookAndFeel();
        mainFrame = new MainFrame("CAR ACCOUNTANT");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void initRegisterFrame() {
        SwingUtilities.invokeLater(() -> {
            setSystemLookAndFeel();
            registerFrame = new RegisterFrame("Register new Car Accountant account.");
            registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            registerFrame.setVisible(true);
        });
    }

    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void cancelRegistration() {
        registerFrame.dispose();
    }

    public static void tabSwitch(FramesNames framesNames) {
        mainFrame.disposeGUI();
        mainFrame.initGui(framesNames);
    }

    private static void selectLoginWindow() {
        initGui();
        mainFrame.initGui(FramesNames.LoginFrame);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Controller::selectLoginWindow);
    }
}
