package com.caracount.dao;

import com.caracount.util.DbConnection;
import com.caracount.view.LoginPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Created by Flex on 06.09.2016.
 */
public class LoginDaoJdbc {

    private static int ID;

    //Method providing ID and password check from car database.
    public static boolean checkLoginPassword() {
        Connection connection = DbConnection.createConnectionToLocalDb();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT ID, login, password FROM accounts " +
                    "WHERE login = '%s'", LoginPanel.getLogin()));
            while (resultSet.next()) {
                if (Arrays.equals (resultSet.getString("password").toCharArray(), LoginPanel.getPassword())) {
                    ID = resultSet.getInt("ID");
                    connection.close();
                    statement.close();
                    return true;
                }
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addNewUserToDb(String login, String password) {
        Connection connection = DbConnection.createConnectionToLocalDb();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(
                    "INSERT INTO `car_accountant`.`accounts` (`login`, `password`) VALUES ('%s', '%s')", login, password));
            JOptionPane.showMessageDialog(null, "Your login and password has been added successfully.");
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "User login already exists, please select another one.");
        }
    }

    public static int getID() {
        return ID;
    }
}
