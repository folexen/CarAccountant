package com.caracount.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Flex on 25.08.2016.
 */
/* FuelEntryPanel contains gives user ability to enter data
 * such as mileage (should be Integer value ex. 85170 without
 * adding km. or miles), cost per liter (should be Float value
 * without naming currency ex. 23.21), total cost(requirements are
 * the same as for previous entry), date in format Day(two digits)/
 * Month(two digits)/Year (four digits), and select complete or
 * partial refueling.
 */

public class FuelEntryPanel extends AbstractEntryPanel {

    private static JTextField mileage;
    private static JTextField totalCost;
    private static JTextField date;
    private static JTextField costPerLiter;
    private static JRadioButton isRefuelComlete;

    public FuelEntryPanel() {
        super("FUEL EXPENSES ENTRY SECTION");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components
        JLabel carMileage = new JLabel("Enter current mileage:");
        carMileage.setFont(FontInitializer.setJlabelFont());
        JLabel totalCost = new JLabel("Enter total cost of refuel:");
        totalCost.setFont(FontInitializer.setJlabelFont());
        JLabel currentDate = new JLabel("Current date:");
        currentDate.setFont(FontInitializer.setJlabelFont());
        JLabel costPerLiter = new JLabel("Cost per liter");
        costPerLiter.setFont(FontInitializer.setJlabelFont());
        JLabel refuelType = new JLabel("Refuel type:");
        refuelType.setFont(FontInitializer.setJlabelFont());

        mileage = new JTextField("", 50);
        FuelEntryPanel.totalCost = new JTextField("", 50);
        date = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 50);
        FuelEntryPanel.costPerLiter = new JTextField("", 50);

        JButton addButton = JButtonInitializer.initAndCreateAddFuelDataButton();
        JButton delButton = JButtonInitializer.initAndCreateDeleteFuelButton();
        isRefuelComlete = new JRadioButton("Select if refuel was complete");
        isRefuelComlete.setFont(FontInitializer.setJlabelFont());
        isRefuelComlete.setOpaque(false);


        //Adding Swing components to content pane
        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.insets = new Insets(3, 3, 3, 3);

        gc.anchor = GridBagConstraints.LINE_END;
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

        gc.gridx = 0;
        gc.gridy = 4;
        this.add(refuelType, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.ipady = 10;
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(mileage, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(FuelEntryPanel.totalCost, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(date, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(FuelEntryPanel.costPerLiter, gc);

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 5;
        gc.ipady = 15;
        gc.ipadx = 30;
        add(addButton, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 4;
        gc.ipady = 30;
        add(isRefuelComlete, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.ipady = 15;
        gc.ipadx = 30;
        add(delButton, gc);
    }

    public static JTextField getMileage() {
        return mileage;
    }

    public static JTextField getTotalCost() {
        return totalCost;
    }

    public static JTextField getDate() {
        return date;
    }

    public static JTextField getCostPerLiter() {
        return costPerLiter;
    }

    public static JRadioButton getIsRefuelComlete() {
        return isRefuelComlete;
    }
}
