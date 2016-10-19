package com.caracount.view;

import com.caracount.Controller;
import com.caracount.dao.Car;
import com.caracount.dao.CarJdbc;
import com.caracount.dao.LoginDaoJdbc;
import com.caracount.model.Model;

import javax.swing.*;
import java.awt.*;

//This class contains basic information on car stored, such as make, model, model year, engine volume. etc
class CarInfoPanel extends AbstractEntryPanel {
    private JComboBox carVin;

    public String getVIN() {
        return Model.getSelectedVin();
    }

    private void setVIN() {
        if (carVin != null) {
            Model.setSelectedVin((String) carVin.getSelectedItem());
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

        JLabel carMake = LayoutInitializer.getjLabel("Make:");
        JLabel carModel = LayoutInitializer.getjLabel("Model:");
        JLabel vinLabel = LayoutInitializer.getjLabel("VIN:");
        JLabel carModelYear = LayoutInitializer.getjLabel("Model Year:");
        JLabel carCurrentMileage = LayoutInitializer.getjLabel("Mileage:");

        JLabel carMake1 = LayoutInitializer.getjLabel(this.getCarFromList(getVIN()).getMake());
        JLabel carModel1 = LayoutInitializer.getjLabel(this.getCarFromList(getVIN()).getModel());
        carVin = new JComboBox(Model.getAllVins());
        carVin.setSelectedItem(getVIN());
        carVin.setFont(FontInitializer.setJlabelFont());
        carVin.addActionListener(actionEvent -> {
            setVIN();
            Controller.tabSwitch(FramesNames.MainFrame);
        });
        JLabel carModelYear1 = LayoutInitializer.getjLabel(String.valueOf(this.getCarFromList(getVIN()).getYear()));
        JLabel carCurrentMileage1 = LayoutInitializer.getjLabel(String.valueOf(this.getCarFromList(getVIN()).getMileage()));



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
        this.add(vinLabel, gc);

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
        this.add(carVin, gc);

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
