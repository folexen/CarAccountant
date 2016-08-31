package com.caracount.view;

import com.caracount.localData.FuelDataStorage;
import com.caracount.model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 23.08.2016.
 */
/* The MainFrame class provides the basic view of the application*/

public class MainFrame extends JFrame {

    public MainFrame(String title, FramesNames frameType) throws HeadlessException {
        super(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initGui(frameType);
        setFont(new Font("Tahoma", Font.BOLD, 20));
    }

    public void initGui(FramesNames framesNames) {
        //Setting layout
        setLayout(new GridBagLayout());

        //Button creation
        //Creating button which gives us ability to go to main window
        JButton mainButton = JButtonInitializer.initAndCreateMainFrameButton();
        //Creating button which gives us ability to go to fuel tab
        JButton fuelButton = JButtonInitializer.initAndCreateFuelButton();
        //Creating button which gives us ability to go to service tab
        JButton serviceButton = JButtonInitializer.initAndCreateServiceButton();
        //Creating button which gives us ability to go to exit application
        JButton exitButton = JButtonInitializer.initAndCreateExitButton();

        //Adding Swing components using GridBagConstraints. Use of static initializer provides
        // identic view for all frames.
        if (framesNames.equals(FramesNames.MainFrame)) {
            //initializing components needed for Main Frame
            final JPanel carInfoPanel = new CarInfoPanel();

            //temporary fill of averageData table
            String[] columns = {"#", "Info type", "Value", "Unit"};
            String[][] data = {{"1", "Average consumption (month)", "6.78", "l/100km"},
                    {"2", "Average consumption (year) ", "5.43", "l/100km"},
                    {"3", "Average consumption (overall)", "5.29", "l/100km"},
                    {"4", "Service costs (month)", "1052", "grn"}};

            final JTable averageData = new JTable(data, columns);
            averageData.setEnabled(false);
            averageData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            JScrollPane averageDataScrollPane = new JScrollPane(averageData);
            //creating standart layout.
            LayoutInitializer.initializeStandardLayout(this, carInfoPanel, fuelButton,
                    serviceButton, exitButton, averageDataScrollPane);
        }
        else if (framesNames.equals(FramesNames.FuelFrame)) {
            //initializing components needed for Fuel Frame.
            final JPanel fuelEntryPanel = new FuelEntryPanel();

            JTable fuelDataTable = new JTable(Model.getFuelDataForTable(), Model.getFuelFieldsName().toArray());
            fuelDataTable.setEnabled(false);
            JScrollPane consumptionTableScrollPane = new JScrollPane(fuelDataTable);
            //creating standart layout.
            LayoutInitializer.initializeStandardLayout(this, fuelEntryPanel, mainButton, serviceButton,
                    exitButton, consumptionTableScrollPane);
        }

        else if (framesNames.equals(FramesNames.ServiceFrame)) {
            //initializing components needed for Service Frame.
            JPanel serviceEntryPanel = new ServiceEntryPanel();
            JTable serviceTable = new JTable(Model.getServiceDataForTable(), Model.getServiceFieldsName().toArray());
            JScrollPane serivceTableScrollPane = new JScrollPane(serviceTable);
            //creating statndart layout.
            LayoutInitializer.initializeStandardLayout(this, serviceEntryPanel, mainButton,
                    fuelButton, exitButton, serivceTableScrollPane);
        }
     }
}

