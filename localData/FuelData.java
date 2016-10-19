package com.caracount.localData;

import com.caracount.dao.FuelExpenses;
import com.caracount.model.Helper;
import com.caracount.view.LoginPanel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuelData implements Serializable {

    private final static long serialVersionUID = 1214567980;
    private static ArrayList<FuelExpenses> fuelList = readFuelDatafromDisk();

    public static ArrayList<FuelExpenses> getFuelList() {
        return fuelList;
    }

    public static void setFuelList(ArrayList<FuelExpenses> fuelList) {
        FuelData.fuelList = fuelList;
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
        } catch (FileNotFoundException ex) {
            Helper.showErrorMessage("Data backup error. Possible data loss.");
        } catch (IOException e) {
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
        } catch (FileNotFoundException e) {
            Helper.showErrorMessage("No data available localy.");
        } catch (IOException | ClassNotFoundException e) {
            Helper.showErrorMessage(e.getMessage());
        }
        return result;
    }
}
