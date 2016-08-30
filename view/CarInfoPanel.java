package com.caracount.view;

import com.caracount.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 25.08.2016.
 */
//This class contains basic information on car stored, such as make, model, model year, engine volume. etc
class CarInfoPanel extends AbstractEntryPanel {

    public CarInfoPanel() {
        super("CAR INFO");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components
        ImageIcon icon = LayoutInitializer.createImageIcon("resources/CarIcon.jpg", "Temporary Description");
        JLabel carIconLabel = new JLabel(icon, JLabel.CENTER);

        JLabel carMake = new JLabel("Car Make: Temporary not available.");
        JLabel carModel = new JLabel("Car Model: Temporary not available.");
        JLabel carVin = new JLabel("VIN: Temporary not available.");
        JLabel carModelYear = new JLabel("Car Model Year: Temporary not available.");
        JLabel carCurrentMileage = new JLabel("Car Current Mileage: Temporary not available.");

        //Adding Swing components to content pane
        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 0;
        gc.gridheight = 5;
        this.add(carIconLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 1;
        this.add(carMake, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(carModel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(carVin, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(carModelYear, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        this.add(carCurrentMileage, gc);
    }
}
