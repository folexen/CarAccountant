package com.caracount;

import com.caracount.view.FontInitializer;
import com.caracount.view.FramesNames;
import com.caracount.view.MainFrame;
import com.caracount.view.RegisterFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 23.08.2016.
 */
public class Controller {
    private static MainFrame mainFrame;
    private static RegisterFrame registerFrame;

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
        mainFrame = new MainFrame("CAR ACCOUNTANT");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void initRegisterFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
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
                registerFrame = new RegisterFrame("Register new Car Accountant account.");
                registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registerFrame.setVisible(true);
            }
        });
    }

    public static void cancelRegistration() {
        registerFrame.dispose();
    }

    public static void tabSwitch(FramesNames framesNames) {
        mainFrame.disposeGUI();
        mainFrame.initGui(framesNames);
    }

    public static void selectLoginWindow() {
        initGui();
        mainFrame.initGui(FramesNames.LoginFrame);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                selectLoginWindow();
            }
        });
    }
}
