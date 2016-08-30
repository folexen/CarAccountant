package com.caracount.view;

import com.caracount.dao.ServiceDao;
import com.caracount.listeners.AddServiceDataButtonListener;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Flex on 26.08.2016.
 */
public class ServiceEntryPanel extends AbstractEntryPanel{
    private static JTextField jTextFieldMileage;
    private static JTextField jTextTotalCost;
    private static JTextField jTextCurrentDate;
    private static JTextField jTextServiceOrPartName;

    private static JLabel carMileage;
    private static JLabel totalCost;
    private static JLabel currentDate;
    private static JLabel serviceType;
    private static JComboBox serviceTypeSelection;
    private static JLabel serviceOrPartName;

    public ServiceEntryPanel() {
        super("SERVICE EXPENSES ENTRY SECTION");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components
        carMileage = new JLabel("Enter current mileage:");
        totalCost = new JLabel("Enter total cost of service:");
        currentDate = new JLabel("Current date:");
        serviceType = new JLabel("Select service type (work or spare part):");
        serviceTypeSelection = new JComboBox(new String[]{"Work", "Spare Part"});
        serviceOrPartName = new JLabel("Service or part Name");

        jTextFieldMileage = new JTextField("", 50);
        jTextTotalCost = new JTextField("", 50);
        jTextCurrentDate = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 50);
        jTextServiceOrPartName = new JTextField("", 50);

        JButton addButton = new JButton("Add data");
        addButton.addActionListener(new AddServiceDataButtonListener());


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
        this.add(serviceType, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(serviceTypeSelection, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(serviceOrPartName, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(totalCost, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        this.add(currentDate, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        this.add(jTextFieldMileage, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(jTextServiceOrPartName, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(jTextTotalCost, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        this.add(jTextCurrentDate, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 5;
        gc.ipady = 30;
        add(addButton, gc);
    }

    public static ServiceDao processDataToServiceDao() {
        int mileage = 0;
        boolean isServiceWork = false;
        String workOrPartName = null;
        double serviceOrWorkCost = 0.0;
        Date date = null;
        try {
            mileage = Integer.parseInt(jTextFieldMileage.getText());
            isServiceWork = serviceTypeSelection.getSelectedItem().toString().equalsIgnoreCase("work");
            workOrPartName = jTextServiceOrPartName.getText();
            serviceOrWorkCost = Double.parseDouble(jTextTotalCost.getText());
            date = new SimpleDateFormat("dd/MM/yyyy").parse(jTextCurrentDate.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Wrong date format. Reenter data please.");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Something wrong with input data!");
        }
        return new ServiceDao(mileage, isServiceWork, workOrPartName, serviceOrWorkCost, date, null);
        /*if (mileage != 0 && !isServiceWork  && workOrPartName != null && serviceOrWorkCost != 0.0 && date != null) {
            return new ServiceDao(mileage, isServiceWork, workOrPartName, serviceOrWorkCost, date, null);
        }
        else return null;*/
    }
}
