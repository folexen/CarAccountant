package com.caracount.model;

import javax.swing.*;

public class Helper {

    public static void showErrorMessage(String errorText) {
        JOptionPane.showMessageDialog(null, "Error", errorText, JOptionPane.ERROR_MESSAGE);
    }
}
