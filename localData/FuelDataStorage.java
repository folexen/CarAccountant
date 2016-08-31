package com.caracount.localData;

import com.caracount.dao.FuelDao;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by Flex on 30.08.2016.
 */
public class FuelDataStorage implements Serializable{
    private final static long serialVersionUID = 1214567980;
    private static ArrayList<FuelDao> fuelDataSet = readFuelDatafromDisk();

    public static ArrayList<FuelDao> getFuelDataSet() {
        return fuelDataSet;
    }

    public static void addFuelDatatoFuelStorage(FuelDao fuelDao) {
        fuelDataSet.add(fuelDao);
    }

    public static void writeFuelDatatoDisk() {
        try {
            if (!Files.exists(Paths.get("src\\com\\caracount\\serializedData\\SerializedFuelData.ser"))) {
                Files.createFile(Paths.get("src\\com\\caracount\\serializedData\\SerializedFuelData.ser"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream("src\\com\\caracount\\serializedData\\SerializedFuelData.ser");
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(fuelDataSet);
            JOptionPane.showMessageDialog(null, "Data backup to disk succesfull!");
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data backup corrupted. Possible data loss.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FuelDao> readFuelDatafromDisk() {
        ArrayList<FuelDao> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src\\com\\caracount\\serializedData\\SerializedFuelData.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (ArrayList<FuelDao>) ois.readObject();
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
