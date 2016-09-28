package com.caracount.model;

import javax.swing.*;

/**
 * Created by Flex on 20.09.2016.
 */
public class Helper {

    public static void showErrorMessage(String errorText) {
        JOptionPane.showMessageDialog(null, "Error", errorText, JOptionPane.ERROR_MESSAGE);
    }
}
