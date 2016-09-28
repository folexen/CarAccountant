package com.caracount.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Flex on 26.08.2016.
 */
public class ServiceEntryPanel extends AbstractEntryPanel{
    private static JTextField mileage;
    private static JTextField totalCost;
    private static JTextField date;
    private static JTextField serviceName;
    private static JTextField comment;


    private static JLabel carMileage;
    private static JLabel totalCostLabel;
    private static JLabel currentDate;
    private static JLabel serviceType;
    private static JComboBox serviceTypeSelection;
    private static JLabel serviceOrPartName;
    private static JLabel serviceComment;

    public ServiceEntryPanel() {
        super("SERVICE EXPENSES ENTRY SECTION");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components
        carMileage = new JLabel("Enter current mileage:");
        carMileage.setFont(FontInitializer.setJlabelFont());
        totalCostLabel = new JLabel("Enter total cost of service:");
        totalCostLabel.setFont(FontInitializer.setJlabelFont());
        currentDate = new JLabel("Current date:");
        currentDate.setFont(FontInitializer.setJlabelFont());
        serviceType = new JLabel("Select service type (work or spare part):");
        serviceType.setFont(FontInitializer.setJlabelFont());
        serviceTypeSelection = new JComboBox(new String[]{"Work", "Spare Part"});
        serviceOrPartName = new JLabel("ServiceExpenses or part Name");
        serviceOrPartName.setFont(FontInitializer.setJlabelFont());
        serviceComment = new JLabel("Enter your comment here: ");
        serviceComment.setFont(FontInitializer.setJlabelFont());

        mileage = new JTextField("", 50);
        totalCost = new JTextField("", 50);
        date = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 50);
        serviceName = new JTextField("", 50);
        comment = new JTextField("", 50);

        JButton addButton = JButtonInitializer.initAndCreateAddServiceDataButton();
        JButton deleteButton = JButtonInitializer.initAndCreateDeleteSrvcButton();

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
        this.add(serviceType, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(serviceOrPartName, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(totalCostLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        this.add(currentDate, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        this.add(serviceComment, gc);


        gc.anchor = GridBagConstraints.LINE_START;
        gc.ipady = 10;
        gc.gridx = 1;
        gc.gridy = 1;
        this.add(serviceTypeSelection, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(mileage, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(serviceName, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(totalCost, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        this.add(date, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        this.add(comment, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 6;
        gc.ipady = 15;
        gc.ipadx = 30;
        add(addButton, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.gridy = 6;
        gc.ipady = 15;
        gc.ipadx = 30;
        add(deleteButton, gc);
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

    public static JTextField getServiceName() {
        return serviceName;
    }

    public static JTextField getComment() {
        return comment;
    }

    public static JComboBox getServiceTypeSelection() {
        return serviceTypeSelection;
    }
}
