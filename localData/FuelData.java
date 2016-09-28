package com.caracount.localData;

import com.caracount.dao.FuelExpenses;
import com.caracount.view.LoginPanel;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Flex on 30.08.2016.
 */
public class FuelData implements Serializable{

    private final static long serialVersionUID = 1214567980;

    public static void setFuelList(ArrayList<FuelExpenses> fuelList) {
        FuelData.fuelList = fuelList;
    }

    private static ArrayList<FuelExpenses> fuelList = readFuelDatafromDisk();

    public static ArrayList<FuelExpenses> getFuelList() {
        return fuelList;
    }

    public static void addFuelDatatoFuelStorage(FuelExpenses fuel) {
        fuelList.add(fuel);
    }

    public static void writeFuelDatatoDisk() {
        try {
            if (!Files.exists(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedFuelData.ser", LoginPanel.getLogin())))) {
                Files.createFile(Paths.get(String.format("src\\com\\caracount\\serializedData\\%s\\SerializedFuelData.ser", LoginPanel.getLogin())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(
                String.format("src\\com\\caracount\\serializedData\\%s\\SerializedFuelData.ser", LoginPanel.getLogin()));
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(fuelList);
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data backup error. Possible data loss.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method returnes list with fuel expenses data stored localy.
    public static ArrayList<FuelExpenses> readFuelDatafromDisk() {
        ArrayList<FuelExpenses> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(
                String.format("src\\com\\caracount\\serializedData\\%s\\SerializedFuelData.ser", LoginPanel.getLogin()));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (ArrayList<FuelExpenses>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No data available localy.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
