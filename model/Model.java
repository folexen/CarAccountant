package com.caracount.model;

import com.caracount.dao.ServiceDao;
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

    public static String[][] getServiceDataForTable() {
        HashSet<ServiceDao> serviceDaoHashSet = ServiceDataStorage.getServiceDataSet();
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
}
