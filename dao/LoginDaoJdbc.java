package com.caracount.dao;

import com.caracount.model.Helper;
import com.caracount.util.DbConnection;
import com.caracount.view.LoginPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class LoginDaoJdbc {

    private static int ID;
    private static String login;

    static String getLogin() {
        return login;
    }

    private static void setLogin(String login) {
        LoginDaoJdbc.login = login;
    }

    //Method providing ID and password check from car database.
    public static boolean checkLoginPassword() {
        Connection connection = DbConnection.createConnectionToLocalDb();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT ID, login, password FROM accounts " +
                    "WHERE login = '%s'", LoginPanel.getLogin()));
            while (resultSet.next()) {
                if (Arrays.equals(resultSet.getString("password").toCharArray(), LoginPanel.getPassword())) {
                    setLogin(LoginPanel.getLogin());
                    ID = resultSet.getInt("ID");
                    connection.close();
                    statement.close();
                    return true;
                }
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            Helper.showErrorMessage("User login already exists, please select another one.");
        }
    }

    public static int getID() {
        return ID;
    }
}
