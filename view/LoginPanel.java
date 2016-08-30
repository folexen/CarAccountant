package com.caracount.view;

import com.caracount.Controller;
import com.caracount.dao.ServiceDao;
import com.caracount.localData.ServiceDataStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.RunnableFuture;

/**
 * Created by Flex on 29.08.2016.
 */
public class LoginPanel extends MainFrame{
    private final char[] cpw = {'1','2','3'};
    private char[] pwd;

    public LoginPanel() throws HeadlessException {
        super("SECURITY SECTION");
        initGui();
    }

    @Override
    public void initGui() {
        setLayout(new GridBagLayout());

       JPasswordField jPasswordField = new JPasswordField(null, 20);
        JLabel jLabel = new JLabel("Enter Password");
        JButton okButton = new JButton("Ok");
        okButton.setActionCommand("Confrim");
        jPasswordField.setActionCommand("Confirm");
       okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Arrays.equals(cpw, jPasswordField.getPassword())) {
                    Controller.initAppAfterSecuritySection(); //temporary deleted
                }
                else {
                    JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD");
                }
            }
        });

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0;
        gc.weightx = 0;

        gc.gridx = 0;
        gc.gridy = 0;
        add(jLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(jPasswordField, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        add(okButton, gc);
    }
}
