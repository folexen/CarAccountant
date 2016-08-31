package com.caracount.view;

import com.caracount.dao.FuelDao;
import com.caracount.dao.ServiceDao;
import com.caracount.listeners.AddFuelDataButtonListener;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.DoubleToIntFunction;

/**
 * Created by Flex on 25.08.2016.
 */
//FuelEntryPanel contains basic information on car stored, such as make, model, model year, engine volume. etc
public class FuelEntryPanel extends AbstractEntryPanel {
    private static JTextField jTextFieldMileage;
    private static JTextField jTextTotalCost;
    private static JTextField jTextCurrentDate;
    private static JTextField jTextCostPerLiter;
    private static JRadioButton completeRefueling;

    public FuelEntryPanel() {
        super("FUEL EXPENSES ENTRY SECTION");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components

        JLabel carMileage = new JLabel("Enter current mileage:");
        JLabel totalCost = new JLabel("Enter total cost of refuel:");
        JLabel currentDate = new JLabel("Current date:");
        JLabel costPerLiter = new JLabel("Cost per liter");

        jTextFieldMileage = new JTextField("", 50);
        jTextTotalCost = new JTextField("", 50);
        jTextCurrentDate = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 50);
        jTextCostPerLiter = new JTextField("", 50);

        JButton addButton = JButtonInitializer.initAndCreateAddFuelDataButton();
        completeRefueling = new JRadioButton("Select if refuel was complete");


        //Adding Swing components to content pane
        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(carMileage, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        this.add(totalCost, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(currentDate, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(costPerLiter, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        this.add(jTextFieldMileage, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(jTextTotalCost, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(jTextCurrentDate, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(jTextCostPerLiter, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.ipady = 30;
        add(addButton, gc);


        gc.gridx = 1;
        gc.gridy = 4;
        gc.ipady = 30;
        add(completeRefueling, gc);
    }

    public static FuelDao processDataToFuelDao() {
        int mileage = 0;
        boolean isRefuelPartial = false;
        double costPerLiter = 0.0;
        double totalCost = 0.0;
        Date date = null;
        try {
            mileage = Integer.parseInt(jTextFieldMileage.getText());
            isRefuelPartial = !completeRefueling.isSelected();
            costPerLiter = Double.parseDouble(jTextCostPerLiter.getText());
            totalCost = Double.parseDouble(jTextTotalCost.getText());
            date = new SimpleDateFormat("dd/MM/yyyy").parse(jTextCurrentDate.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Wrong date format. Reenter data please.");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Something wrong with input data!");
        }
        return new FuelDao(mileage, date, costPerLiter, totalCost, isRefuelPartial);
    }
}
