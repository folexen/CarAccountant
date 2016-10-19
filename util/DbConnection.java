package com.caracount.util;


import com.caracount.model.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_LOCAL_URL = "jdbc:mysql://localhost/car_accountant";

    public static Connection createConnectionToLocalDb() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_LOCAL_URL, "root", "");
            Class.forName(JDBC_DRIVER);
        } catch (SQLException | ClassNotFoundException e) {
            Helper.showErrorMessage(e.getMessage());
        }
        return connection;
    }
}
