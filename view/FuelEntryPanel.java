package com.caracount.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Flex on 25.08.2016.
 */
//FuelEntryPanel contains basic information on car stored, such as make, model, model year, engine volume. etc
class FuelEntryPanel extends AbstractEntryPanel {

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

        JTextField jTextFieldMileage = new JTextField("", 50);
        JTextField jTextTotalCost = new JTextField("", 50);
        JTextField jTextCurrentDate = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 50);
        JTextField jTextCostPerLiter = new JTextField("", 50);

        JButton addButton = new JButton("Add data");
        JRadioButton completeRefueling = new JRadioButton("Complete refueling.");

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
}
