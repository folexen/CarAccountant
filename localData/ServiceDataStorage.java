package com.caracount.localData;

import com.caracount.dao.ServiceDao;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by Flex on 30.08.2016.
 */
public class ServiceDataStorage implements Serializable{

    private static final long serialVersionUID =  991275049;
    private static ArrayList<ServiceDao> serviceDataSet = readServiceDatafromDisk();

    public static ArrayList<ServiceDao> getServiceDataSet() {
        return serviceDataSet;
    }

    public static void addServiceDataToServiceStorage(ServiceDao serviceDao) {
        serviceDataSet.add(serviceDao);
    }

    public static void writeServiceDatatoDisk() {
        try {
            if (!Files.exists(Paths.get("src\\com\\caracount\\serializedData\\SerializedServiceData.ser"))) {
                Files.createFile(Paths.get("src\\com\\caracount\\serializedData\\SerializedServiceData.ser"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream("src\\com\\caracount\\serializedData\\SerializedServiceData.ser");
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(serviceDataSet);
            JOptionPane.showMessageDialog(null, "Data backup to disk succesfull!");
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data backup corrupted. Possible data loss.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ServiceDao> readServiceDatafromDisk() {
        ArrayList<ServiceDao> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src\\com\\caracount\\serializedData\\SerializedServiceData.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (ArrayList<ServiceDao>) ois.readObject();
            JOptionPane.showMessageDialog(null, "Data load succesfull");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No data available.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
