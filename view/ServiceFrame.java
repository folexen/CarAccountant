package com.caracount.view;

import com.caracount.listeners.ExitButtonListener;
import com.caracount.listeners.FuelButtonListener;
import com.caracount.listeners.MainButtonListener;
import com.caracount.model.Model;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by Flex on 25.08.2016.
 */
public class ServiceFrame extends MainFrame {

    public ServiceFrame(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void initGui() {
        //Setting layout
        setLayout(new GridBagLayout ());

        JPanel serviceEntryPanel = new ServiceEntryPanel();
        //Temporary table data
        JTable serviceTable = new JTable(Model.getServiceDataForTable(), Model.getServiceFieldsName().toArray());
        JScrollPane serivceTableScrollPane = new JScrollPane(serviceTable);

        //Button creation
        //Creating button which gives us ability to go to main window
        JButton mainButton = JButtonInitializer.initAndCreateMainFrameButton();
        //Creating button which gives us ability to go to fuel tab
        JButton fuelButton = JButtonInitializer.initAndCreateFuelButton();
        //Creating button which gives us ability to go to exit application
        JButton exitButton = JButtonInitializer.initAndCreateExitButton();

        //Adding Swing components using GridBagConstraints. Use of static initializer provides
        // identic view for all frames.
        LayoutInitializer.initializeStandardLayout(this, serviceEntryPanel, mainButton,
                fuelButton, exitButton, serivceTableScrollPane);
    }

}

