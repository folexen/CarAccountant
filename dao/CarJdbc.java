package com.caracount.dao;

import com.caracount.model.Helper;
import com.caracount.util.DbConnection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarJdbc {

    public static List<Car> getCars(int ID) {
        List<Car> resultList = new ArrayList<>();

        Connection connection = DbConnection.createConnectionToLocalDb();
        try {
            PreparedStatement statement = connection.prepareStatement(String.format("select vin_code, year, engine,\n" +
                    "type, make, model, max(mileage) as mileage from \n" +
                    "(select car_info.vin_code, car_info.year, car_info.engine,\n" +
                    "fuel_type.type, car_makes.make, car_models.model, fuel_expenses.mileage from car_info\n" +
                    "left join car_makes on car_makes.ID=car_info.make\n" +
                    "left join car_models on car_models.ID=car_info.model\n" +
                    "left join fuel_type on car_info.fuel=fuel_type.ID\n" +
                    "left join fuel_expenses on car_info.vin_code = fuel_expenses.vin_id \n" +
                    "where vin_code IN (select vin_code from account_info where account_id=1)) as s\n" +
                    "group by vin_code", ID));

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultList.add(new Car(resultSet.getString("vin_code"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getDouble("engine"),
                        resultSet.getString("type"),
                        resultSet.getInt("mileage")));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

   public static void addCarToDb(Car car) {
       Connection connection = DbConnection.createConnectionToLocalDb();
       try {
           Statement statement= connection.createStatement();
           statement.executeUpdate(String.format("insert into car_info (vin_code, make, model, year, engine, fuel)\n" +
                   "\tvalues ('%s', (select  ID from car_makes where make = '%s'), \n" +
                   "    (select ID from car_models where model = '%s'), '%d',  %f, \n" +
                   "    (select ID from fuel_type where type = '%s'));\n" +
                   "\tinsert into account_info (account_id, vin_code, account_active, start_date)\n" +
                   "\tvalues((select ID from accounts where login='%s'), \n" +
                   "    (select vin_code from car_info where vin_code='%s'), %d, '%s');",
                   car.getVIN(), car.getMake(), car.getModel(), car.getYear(), car.getEngineVolume(), car.getFuel(),
                   LoginDaoJdbc.getLogin(), car.getVIN(), 1, new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
           statement.close();
           connection.close();
       } catch (SQLException e) {
           Helper.showErrorMessage("Error encounterd while inserting information.");
       }
   }
}
