package com.caracount.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 05.09.2016.
 */
public class LoginPanel extends AbstractEntryPanel{
    private JLabel jLogin;
    private JLabel jPassword;

    private static JTextField jTextLogin;
    private static JPasswordField jPasswordField;

    private JButton registerButton;
    private JButton okButton;
    private JButton exitButton;
    public LoginPanel(String panelTitle) {
        super(panelTitle);
        initGui();
    }

    private void initGui() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //instantiating fields;
        jLogin = new JLabel("Enter your login: ");
        jLogin.setFont(FontInitializer.setJlabelFont());
        jPassword = new JLabel("Enter your password: ");
        jPassword.setFont(FontInitializer.setJlabelFont());

        jTextLogin = new JTextField("", 50);
        jPasswordField = new JPasswordField("", 50);

        registerButton  = JButtonInitializer.initAndCreateRegisterButton();
        okButton = JButtonInitializer.initAndCreateOKButton();
        exitButton = JButtonInitializer.initAndCreateExitButton();


        gc.weightx = 0.5;
        gc.weighty = 0;
        gc.insets = new Insets(10, 10, 10, 10);
        gc.ipady = 20;
        gc.ipadx = 30;

        gc.anchor = GridBagConstraints.LINE_END;
        LayoutInitializer.initConstrainGrid(gc, 0, 0);
        this.add(jLogin, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 1);
        this.add(jPassword, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        LayoutInitializer.initConstrainGrid(gc, 1, 1);
        this.add(jPasswordField, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 0);
        this.add(jTextLogin, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 2);
        gc.ipady = 9;
        gc.ipadx = 9;
        this.add(exitButton, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        LayoutInitializer.initConstrainGrid(gc, 0, 2);
        gc.ipady = 8;
        gc.ipadx = 20;
        this.add(okButton, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 3);
        gc.ipady = 8;
        gc.ipadx = 2;
        this.add(registerButton, gc);
    }

    public static String getLogin() {
        return jTextLogin.getText();
    }

    public static char[] getPassword() {
        return jPasswordField.getPassword();
    }
}
