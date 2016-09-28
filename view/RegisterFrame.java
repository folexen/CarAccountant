package com.caracount.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Flex on 06.09.2016.
 */
public class RegisterFrame extends JFrame {

    private JLabel createLogin;
    private JLabel createPassword;
    private JLabel confirmPassword;

    private static JTextField enterLogin;
    private static JPasswordField enterPassword;
    private static JPasswordField enterConfirmPassword;

    public RegisterFrame(String s) throws HeadlessException {
        super(s);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)(screenSize.getWidth()/3), (int) (screenSize.getHeight()/3));
        setContentPane(new JLabel(LayoutInitializer.createScaledImageIcon("resources/Background.jpg", "Background")));
        this.getRootPane().setBorder(BorderFactory.createEtchedBorder(20, Color.DARK_GRAY, Color.LIGHT_GRAY));
        initGui();
    }

    private void initGui() {
        setLayout(new GridBagLayout());

        createLogin = new JLabel("Enter your login here: ");
        createLogin.setFont(FontInitializer.setJlabelFont());
        createPassword = new JLabel("Enter your password here: ");
        createPassword.setFont(FontInitializer.setJlabelFont());
        confirmPassword = new JLabel("Confirm your password:");
        confirmPassword.setFont(FontInitializer.setJlabelFont());

        enterLogin = new JTextField("", 20);
        enterPassword = new JPasswordField("", 20);
        enterConfirmPassword = new JPasswordField("", 20);

        JButton confirmBtn = JButtonInitializer.initAndCreateConfirmButton();
        JButton cancelBtn = JButtonInitializer.initAndCreateCancelButton();

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.5;
        gc.weighty = 0;
        gc.insets = new Insets(10, 10, 10, 10);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(createLogin, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        this.add(createPassword, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(confirmPassword, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(enterLogin, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(enterPassword, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(enterConfirmPassword, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.ipady = 8;
        gc.ipadx = 20;
        this.add(confirmBtn, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 3;
        gc.ipady = 8;
        gc.ipadx = 12;
        this.add(cancelBtn, gc);
    }

    public static boolean checkPasswordIdentity() {
        return Arrays.equals(enterPassword.getPassword(), enterConfirmPassword.getPassword());
    }

    public static String getLogin() {
        return enterLogin.getText();
    }

    public static String getPassword() {
        return new String(enterPassword.getPassword());
    }
}
