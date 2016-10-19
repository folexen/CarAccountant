package com.caracount.model;

import com.caracount.dao.*;
import com.caracount.localData.FuelData;
import com.caracount.localData.ServiceData;
import com.caracount.view.FuelEntryPanel;
import com.caracount.view.ServiceEntryPanel;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Model {

    /*VIN code is initialized with default value (first car in the list got from DB)
     * further manipulations is handled by setSelectedVin() method
     */

    private static String selectedVin = CarJdbc.getCars(LoginDaoJdbc.getID()).get(0).getVIN();

    public static String getSelectedVin() {
        return selectedVin;
    }

    public static void setSelectedVin(String selectedVin) {
        Model.selectedVin = selectedVin;
    }

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
        } catch (FileNotFoundException ex) {
            Helper.showErrorMessage("Properties file not found!");
        } catch (IOException e) {
            Helper.showErrorMessage("Something wrong!");
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
        } catch (FileNotFoundException ex) {
            Helper.showErrorMessage("Properties file not found!");
        } catch (IOException e) {
            Helper.showErrorMessage("Something wrong!");
        }
        return result;
    }

    public static String[][] getServiceDataForTable(String selectedVin) {
        ArrayList<ServiceExpenses> serviceExpensesList = ServiceData.getServicesList();
        Collections.sort(serviceExpensesList);
        int i = 0;
        int size = serviceExpensesList.size();
        String[][] data = new String[size][7];
        for (ServiceExpenses sd : serviceExpensesList) {
            if (sd.getVIN().equals(selectedVin)) {
                data[i][0] = String.valueOf(sd.getId());
                data[i][1] = String.valueOf(sd.getMileage());
                data[i][2] = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(sd.getDate()));
                data[i][3] = String.valueOf(sd.getServiceTypeWork() ? "Work" : "Spare part");
                data[i][4] = String.valueOf(sd.getServiceName().getServiceName());
                data[i][5] = String.valueOf(sd.getServiceCost());
                data[i][6] = String.valueOf(sd.getComment());
                i++;
            }
        }
        return data;
    }

    public static String[][] getFuelDataForTable(String selectedVin) {
        ArrayList<FuelExpenses> fuelList = FuelData.getFuelList();
        Collections.sort(fuelList);
        int i = 0;
        int size = fuelList.size();
        String[][] data = new String[size][6];
        for (FuelExpenses sd : fuelList) {
            if (sd.getVinId().equals(selectedVin)) {
                data[i][0] = String.valueOf(sd.getID());
                data[i][1] = String.valueOf(sd.getMileage());
                data[i][2] = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(sd.getDate()));
                data[i][5] = String.valueOf(sd.getRefuelTotal() ? "Total" : "Partial");
                data[i][3] = String.valueOf(sd.getCostPerLiter());
                data[i][4] = String.valueOf(sd.getTotalCost());
                i++;
            }
        }
        return data;
    }

    /*
     * Method provides validity check for ServiceExpenses class data entry using
     * following criteria:
     * 1. Mileage and data values are the smallest (user entered the
     * earliest data).
     * 2. Mileage and data are located between existing entries. So mileage value should
     * be equal or more then previous entry's mileage value and less or equal then following
     * entry mileage. The same requirements are for date.
     * 3. Mileage and data are the newest so their values more or equal to the last entry
     * values.
     */
    public static boolean checkServiceEntryValidity(ServiceExpenses serviceExpense) {
        ArrayList<ServiceExpenses> serviceExpenses = new ArrayList<>();
        for (ServiceExpenses serviceExpenses1 : ServiceData.getServicesList()) {
            if (serviceExpenses1.getVIN().equals(Model.getSelectedVin())) {
                serviceExpenses.add(serviceExpenses1);
            }
        }
        Collections.sort(serviceExpenses);

        if (serviceExpenses.size() == 0) {
            return true;
        }
        for (int i = 0; i < serviceExpenses.size(); i++) {
            if (serviceExpenses.get(i).getMileage() >= serviceExpense.getMileage() &&
                    serviceExpenses.get(i).getDate().getTime() >= serviceExpense.getDate().getTime() &&
                    i == 0) {
                return true;
            } else if (i != serviceExpenses.size() - 1) {
                if (serviceExpenses.get(i).getMileage() <= serviceExpense.getMileage() &&
                        serviceExpenses.get(i).getDate().getTime() <= serviceExpense.getDate().getTime() &&
                        serviceExpenses.get(i + 1).getMileage() >= serviceExpense.getMileage() &&
                        serviceExpenses.get(i + 1).getDate().getTime() >= serviceExpense.getDate().getTime()) {
                    return true;
                }
            } else if (serviceExpenses.get(i).getMileage() <= serviceExpense.getMileage() &&
                    serviceExpenses.get(i).getDate().getTime() <= serviceExpense.getDate().getTime() &&
                    i == serviceExpenses.size() - 1) {
                return true;
            }
        }
        return false;
    }

    /*
    * Method provides validity check for Fuel class data entry using
    * following criteria:
    * 1. Mileage and data values are the smallest (user entered the data
    * about most recent refuel).
    * 2. Mileage and data are located between existing entries. So mileage value should
    * more then previous entry's mileage value and less then following entry mileage.
    * The same requirements are for date but date entry may be equal (refuel can be made
    * at the same date later).
    * 3. Mileage and data are the newest so their values more or equal(considering date
     * only) to the last entry values.
    */
    public static boolean checkFuelEntryValidity(FuelExpenses fuel) {
        ArrayList<FuelExpenses> fuels = new ArrayList<>();
        for (FuelExpenses fuelExpenses : FuelData.getFuelList()) {
            if (fuelExpenses.getVinId().equals(Model.getSelectedVin())) {
                fuels.add(fuelExpenses);
            }
        }
        Collections.sort(fuels);
        if (fuels.size() == 0) {
            return true;
        }
        for (int i = 0; i < fuels.size(); i++) {
            if (fuels.get(i).getMileage() > fuel.getMileage() &&
                    fuels.get(i).getDate().getTime() > fuel.getDate().getTime() &&
                    i == 0) {
                return true;
            } else if (i != fuels.size() - 1) {
                if (fuels.get(i).getMileage() < fuel.getMileage() &&
                        fuels.get(i).getDate().getTime() <= fuel.getDate().getTime() &&
                        fuels.get(i + 1).getMileage() > fuel.getMileage() &&
                        fuels.get(i + 1).getDate().getTime() >= fuel.getDate().getTime()) {
                    return true;
                }
            } else if (fuels.get(i).getMileage() < fuel.getMileage() &&
                    fuels.get(i).getDate().getTime() <= fuel.getDate().getTime() &&
                    i == fuels.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public static FuelExpenses processDataToFuelExpenses() {
        int mileage = 0;
        Boolean isRefuelTotal = false;
        Float costPerLiter = 0.0f;
        Float totalCost = 0.0f;
        Date date = null;
        try {
            mileage = Integer.parseInt(FuelEntryPanel.getMileage().getText());
            isRefuelTotal = FuelEntryPanel.getIsRefuelComlete().isSelected();
            costPerLiter = Float.parseFloat(FuelEntryPanel.getCostPerLiter().getText());
            totalCost = Float.parseFloat(FuelEntryPanel.getTotalCost().getText());
            date = new SimpleDateFormat("dd/MM/yyyy").parse(FuelEntryPanel.getDate().getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Wrong date format. Reenter data please.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Something wrong with input data!");
        }
        if (mileage != 0 && costPerLiter != 0.0 && totalCost != 0.0 & date != null) {
            FuelExpenses fuelExpenses = new FuelExpenses();
            fuelExpenses.setCostPerLiter(costPerLiter);
            fuelExpenses.setDate(date);
            fuelExpenses.setMileage(mileage);
            fuelExpenses.setTotalCost(totalCost);
            fuelExpenses.setVinId(Model.getSelectedVin());
            fuelExpenses.setRefuelTotal(isRefuelTotal);
            return fuelExpenses;
        } else return null;
    }

    public static ServiceExpenses processDataToServiceDao() {
        Integer mileage = 0;
        Boolean isServiceWork = false;
        String workOrPartName = null;
        Float serviceOrWorkCost = 0.0f;
        String comment = null;
        Date date = null;
        ServiceExpenses serviceExpenses = new ServiceExpenses();
        try {
            mileage = Integer.parseInt(ServiceEntryPanel.getMileage().getText());
            isServiceWork = ServiceEntryPanel.getServiceTypeSelection().
                    getSelectedItem().toString().equalsIgnoreCase("work");
            workOrPartName = ServiceEntryPanel.getServiceName().getText();
            serviceOrWorkCost = Float.parseFloat(ServiceEntryPanel.getTotalCost().getText());
            date = new SimpleDateFormat("dd/MM/yyyy").parse(ServiceEntryPanel.getDate().getText());
            comment = ServiceEntryPanel.getComment().getText();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Wrong date format. Reenter data please.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Something wrong with input data!");
        }
        ServiceName serviceName = new ServiceName();
        if (mileage != 0 && workOrPartName != null && serviceOrWorkCost != .0f && date != null) {
            serviceExpenses.setMileage(mileage);
            serviceExpenses.setDate(date);
            serviceExpenses.setComment(comment);
            serviceExpenses.setServiceCost(serviceOrWorkCost);
            serviceExpenses.setVIN(Model.getSelectedVin());
            serviceExpenses.setServiceTypeWork(isServiceWork);
            serviceName.setServiceName(workOrPartName);
            serviceExpenses.setServiceName(serviceName);
            return serviceExpenses;
        } else return null;
    }

    public static void synchronizeServiceList() {
        ArrayList<FuelExpenses> list = new ArrayList<>();
        for (String vin : getAllVins()) {
            list.addAll(DaoFactory.getInstance().getFuelExpensesDao().getFuelExpenses(vin));
        }
        FuelData.setFuelList(list);
        FuelData.writeFuelDatatoDisk();
    }

    public static void synchronizeFuelList() {
        ArrayList<ServiceExpenses> list = new ArrayList<>();
        for (String vin : getAllVins()) {
            list.addAll(DaoFactory.getInstance().getServiceExpensesDao().getServiceExpenses(vin));
        }
        ServiceData.setServicesList(list);
        ServiceData.writeServiceDatatoDisk();
    }

    public static String[] getAllVins() {
        String[] result = new String[CarJdbc.getCars(LoginDaoJdbc.getID()).size()];
        int i = 0;
        for (Car car : CarJdbc.getCars(LoginDaoJdbc.getID())) {
            result[i] = car.getVIN();
            i++;
        }
        return result;
    }

    public static Map<String, Float> getFuelCostsAndData(String VIN) {
        Map<String, Float> result = new HashMap<>();
        result.put("LAST", 0.0f);
        result.put("OVERALL", 0.0f);
        result.put("COST MONTH", 0.0f);
        result.put("COST OVERALL", 0.0f);
        ArrayList<FuelExpenses> allData = (ArrayList<FuelExpenses>) DaoFactory.getInstance().getFuelExpensesDao().getFuelExpenses(VIN);
        System.out.println(allData.size() + " " + VIN);
        int listSize = allData.size();
        if (allData.size() < 2) {//Solve problem with single entry!!!!!!!
            return result;
        } else {
            //Claculating overall average consumption
            Integer lastTotalRefueIndex = 0;
            Integer preLastTotalRefuel = 0;
            Integer firstTotalRefuelIndex = 0;
            Float overAllLiters = 0.0f;
            Float lastLiters = 0.0f;
            Float overAllAverage = 0.0f;
            Float lastAverage = 0.0f;
            Float fuelCostMonth = 0.0f;
            Float fuelCost = 0.0f;
            int currentMonth = new Date().getMonth();
            for (int i = listSize - 1; i >= 0; i--) {
                fuelCost += allData.get(i).getTotalCost();
                if (allData.get(i).getDate().getMonth() == currentMonth) {
                    fuelCostMonth += allData.get(i).getTotalCost();
                }
                if (allData.get(i).getRefuelTotal() && lastTotalRefueIndex == 0) {
                    lastTotalRefueIndex = i;
                    for (int j = i - 1; i >= 0; j--) {
                        if (allData.get(j).getRefuelTotal() && preLastTotalRefuel == 0) {
                            preLastTotalRefuel = j;
                            break;
                        }
                    }
                }
                if (allData.get(i).getRefuelTotal()) {
                    firstTotalRefuelIndex = i;
                }
            }
            for (int i = firstTotalRefuelIndex + 1; i <= lastTotalRefueIndex; i++) {
                overAllLiters += allData.get(i).getTotalCost() / allData.get(i).getCostPerLiter();
            }
            for (int i = preLastTotalRefuel + 1; i <= lastTotalRefueIndex; i++) {
                lastLiters += allData.get(i).getTotalCost() / allData.get(i).getCostPerLiter();
            }
            if (lastTotalRefueIndex != 0 && overAllLiters != 0) {
                overAllAverage = overAllLiters * 100 / (allData.get(lastTotalRefueIndex).getMileage()
                        - allData.get(firstTotalRefuelIndex).getMileage());
                result.put("OVERALL", (Math.round(overAllAverage * 100)) / 100.0f);

            }
            if (lastTotalRefueIndex != 0) {
                lastAverage = lastLiters * 100 / (allData.get(lastTotalRefueIndex).getMileage()
                        - allData.get(preLastTotalRefuel).getMileage());
                result.put("LAST", (Math.round(lastAverage * 100)) / 100.0f);
            }
            result.put("COST MONTH", fuelCostMonth);
            result.put("COST OVERALL", fuelCost);
        }
        return result;
    }

    public static Map<String, Float> getServiceExpenses(String VIN) {
        Map<String, Float> result = new HashMap<>();
        result.put("MONTH ALL", 0.0f);
        result.put("MONTH WORK", 0.0f);
        result.put("MONTH SERVICE", 0.0f);
        result.put("ALL", 0.0f);
        result.put("ALL WORK", 0.0f);
        result.put("ALL SERVICE", 0.0f);

        ArrayList<ServiceExpenses> allServiceData =
                (ArrayList<ServiceExpenses>) DaoFactory.getInstance().getServiceExpensesDao().getServiceExpenses(VIN);
        int currentMonth = new Date().getMonth();
        Float allMonth = 0.0f;
        Float workMonth = 0.0f;
        Float serviceMonth = 0.0f;
        Float all = 0.0f;
        Float allWork = 0.0f;
        Float allService = 0.0f;

        for (ServiceExpenses se : allServiceData) {
            all += se.getServiceCost();
            if (se.getServiceTypeWork()) {
                allWork += se.getServiceCost();
            } else {
                allService += se.getServiceCost();
            }
            if (se.getDate().getMonth() == currentMonth) {
                allMonth += se.getServiceCost();
                if (se.getServiceTypeWork()) {
                    workMonth += se.getServiceCost();
                } else {
                    serviceMonth += se.getServiceCost();
                }
            }
            result.put("MONTH ALL", allMonth);
            result.put("MONTH WORK", workMonth);
            result.put("MONTH SERVICE", serviceMonth);
            result.put("ALL", all);
            result.put("ALL WORK", allWork);
            result.put("ALL SERVICE", allService);
        }
        return result;
    }
}
