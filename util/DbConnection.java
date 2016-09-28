package com.caracount.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Flex on 06.09.2016.
 */
public class DbConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_LOCAL_URL = "jdbc:mysql://localhost/car_accountant";

   public static Connection createConnectionToLocalDb() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_LOCAL_URL, "root", "");
            Class.forName(JDBC_DRIVER);
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
