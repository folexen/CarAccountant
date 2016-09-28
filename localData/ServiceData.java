package com.caracount.localData;

import com.caracount.dao.ServiceExpenses;
import com.caracount.view.LoginPanel;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by Flex on 30.08.2016.
 */
public class ServiceData implements Serializable{

    private static final long serialVersionUID =  991275049;

    public static void setServicesList(ArrayList<ServiceExpenses> servicesList) {
        ServiceData.servicesList = servicesList;
    }

    private static ArrayList<ServiceExpenses> servicesList = readServiceDatafromDisk();

    public static ArrayList<ServiceExpenses> getServicesList() {
        return servicesList;
    }

    public static void addServiceDataToServiceStorage(ServiceExpenses serviceExpenses) {
        servicesList.add(serviceExpenses);
    }

    public static void writeServiceDatatoDisk() {
        try {
            if (!Files.exists(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedServiceData.ser", LoginPanel.getLogin())))) {
                Files.createFile(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedServiceData.ser", LoginPanel.getLogin())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedServiceData.ser", LoginPanel.getLogin()));
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(servicesList);
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Application was unable to store data.", "File not found!", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ServiceExpenses> readServiceDatafromDisk() {
        ArrayList<ServiceExpenses> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedServiceData.ser", "folexen@gmail.com"));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (ArrayList<ServiceExpenses>) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No data available localy.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        for (ServiceExpenses serviceExpenses: readServiceDatafromDisk()) {
            System.out.println(serviceExpenses.toString());
        }
    }
}
