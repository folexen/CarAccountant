package com.caracount.model;

import com.caracount.dao.FuelDao;
import com.caracount.dao.ServiceDao;
import com.caracount.localData.FuelDataStorage;
import com.caracount.localData.ServiceDataStorage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Flex on 25.08.2016.
 */
public class Model {

    public static void getAverageDataForMainView() {

    }

    public static List<String> getServiceFieldsName() {
        List<String> result = new ArrayList<>();
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\com\\caracount\\properties\\service_fields_names_EN.properties")) {
            properties.load(fis);
            result.add(properties.getProperty("zeroColumn"));
            result.add(properties.getProperty("firstColumn"));
            result.add(properties.getProperty("secondColumn"));
            result.add(properties.getProperty("thirdColumn"));
            result.add(properties.getProperty("fourthColumn"));
            result.add(properties.getProperty("fifthColumn"));
            result.add(properties.getProperty("sixthColumn"));
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Properties file not found!");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Something wrong!");
        }
        return result;
    }

    public static List<String> getFuelFieldsName() {
        List<String> result = new ArrayList<>();
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\com\\caracount\\properties\\fuel_fields_names_EN.properties")) {
            properties.load(fis);
            result.add(properties.getProperty("zeroColumn"));
            result.add(properties.getProperty("firstColumn"));
            result.add(properties.getProperty("secondColumn"));
            result.add(properties.getProperty("thirdColumn"));
            result.add(properties.getProperty("fourthColumn"));
            result.add(properties.getProperty("fifthColumn"));
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Properties file not found!");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Something wrong!");
        }
        return result;
    }

    public static String[][] getServiceDataForTable() {
        ArrayList<ServiceDao> serviceDaoHashSet = ServiceDataStorage.getServiceDataSet();
        Collections.sort(serviceDaoHashSet, new Comparator<ServiceDao>() {
            @Override
            public int compare(ServiceDao serviceDao, ServiceDao t1) {
                return serviceDao.getServiceMileage() > t1.getServiceMileage() ? 1 : 0;
            }
        });
        int i = 0;
        int size = serviceDaoHashSet.size();
        String[][] data = new String[size][7];
        for (ServiceDao sd: serviceDaoHashSet) {
            int k = i + 1;
            data[i][0] = String.valueOf(k);
            data[i][1] = String.valueOf(sd.getServiceMileage());
            data[i][2] = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(sd.getDate()));
            data[i][3] = String.valueOf(sd.isServiceTypeWork()? "Work" : "Spare part");
            data[i][4] = String.valueOf(sd.getWorkOrPartName());
            data[i][5] = String.valueOf(sd.getServiceOrWorkCost());
            data[i][6] = String.valueOf(sd.getComment());
            i++;
        }
        return data;
    }

    public static String[][] getFuelDataForTable() {
        ArrayList<FuelDao> fuelDaoList = FuelDataStorage.getFuelDataSet();
        Collections.sort(fuelDaoList, new Comparator<FuelDao>() {
            @Override
            public int compare(FuelDao fuelDao, FuelDao t1) {
                return fuelDao.getCarCurrentMileage() > t1.getCarCurrentMileage() ? 1 : 0;
            }
        });
        int i = 0;
        int size = fuelDaoList.size();
        String[][] data = new String[size][6];
        for (FuelDao sd: fuelDaoList) {
            int k = i + 1;
            data[i][0] = String.valueOf(k);
            data[i][1] = String.valueOf(sd.getCarCurrentMileage());
            data[i][2] = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(sd.getDate()));
            data[i][5] = String.valueOf(sd.isRefillPartial() ? "Partial" : "Total");
            data[i][3] = String.valueOf(sd.getFuelCost());
            data[i][4] = String.valueOf(sd.getTotalFuelCost());
            i++;
        }
        return data;
    }
}
