package com.caracount.view;

import com.caracount.Controller;
import com.caracount.dao.Car;
import com.caracount.dao.CarJdbc;
import com.caracount.dao.LoginDaoJdbc;
import com.caracount.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 25.08.2016.
 */
//This class contains basic information on car stored, such as make, model, model year, engine volume. etc
class CarInfoPanel extends AbstractEntryPanel {
    private JComboBox carVin1;

    public String getVIN() {
        return Model.getSelectedVin();
    }

    private void setVIN() {
        if (carVin1 != null) {
            Model.setSelectedVin((String)carVin1.getSelectedItem());
        }
    }

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

        JLabel carMake = new JLabel("Make:");
        carMake.setFont(FontInitializer.setJlabelFont());
        JLabel carModel = new JLabel("Model:");
        carModel.setFont(FontInitializer.setJlabelFont());
        JLabel carVin = new JLabel("VIN:");
        carVin.setFont(FontInitializer.setJlabelFont());
        JLabel carModelYear = new JLabel("Model Year:");
        carModelYear.setFont(FontInitializer.setJlabelFont());
        JLabel carCurrentMileage = new JLabel("Mileage:");
        carCurrentMileage.setFont(FontInitializer.setJlabelFont());

        JLabel carMake1 = new JLabel(this.getCarFromList(getVIN()).getMake());
        carMake1.setFont(FontInitializer.setJlabelFont());
        JLabel carModel1 = new JLabel(this.getCarFromList(getVIN()).getModel());
        carModel1.setFont(FontInitializer.setJlabelFont());
        carVin1 = new JComboBox(Model.getAllVins());
        carVin1.setSelectedItem(getVIN());
        carVin1.setFont(FontInitializer.setJlabelFont());
        carVin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVIN();
                Controller.tabSwitch(FramesNames.MainFrame);
            }
        });
        JLabel carModelYear1 = new JLabel(String.valueOf(this.getCarFromList(getVIN()).getYear()));
        carModelYear1.setFont(FontInitializer.setJlabelFont());
        JLabel carCurrentMileage1 = new JLabel(String.valueOf(this.getCarFromList(getVIN()).getMileage()));
        carCurrentMileage1.setFont(FontInitializer.setJlabelFont());



        //Adding Swing components to content pane
        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridheight = 7;
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

        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridheight = 1;
        this.add(carMake1, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        this.add(carModel1, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        this.add(carVin1, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        this.add(carModelYear1, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        this.add(carCurrentMileage1, gc);
    }

    private Car getCarFromList(String VIN) {
        Car result = null;
        for (Car car: CarJdbc.getCars(LoginDaoJdbc.getID())) {
            if (car.getVIN().equals(VIN)) {
                result = car;
                break;
            }
        }
        return result;
    }
}
