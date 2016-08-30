package com.caracount.localData;

import com.caracount.dao.ServiceDao;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;


/**
 * Created by Flex on 30.08.2016.
 */
public class ServiceDataStorage implements Serializable{

    private static final long serialVersionUID =  991275049;
    private static HashSet<ServiceDao> serviceDataSet = readServiceDatafromDisk();

    public static HashSet<ServiceDao> getServiceDataSet() {
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
            JOptionPane.showMessageDialog(null, "Done");
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Unable to store data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashSet<ServiceDao> readServiceDatafromDisk() {
        HashSet<ServiceDao> result = new HashSet<>();
        try (FileInputStream fis = new FileInputStream("src\\com\\caracount\\serializedData\\SerializedServiceData.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (HashSet) ois.readObject();
            JOptionPane.showMessageDialog(null, "Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
