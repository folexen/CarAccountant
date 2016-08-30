package com.caracount.view;

import com.caracount.listeners.ExitButtonListener;
import com.caracount.listeners.MainButtonListener;
import com.caracount.listeners.ServiceButtonListener;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by Flex on 25.08.2016.
 */
public class FuelFrame extends MainFrame {

    public FuelFrame(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void initGui() {
        //Setting layout
        setLayout(new GridBagLayout ());
        //Creating Swing components
        final JPanel carInfoPanel = new CarInfoPanel();
        final JPanel fuelEntryPanel = new FuelEntryPanel();

        //temporary fill of averageData table
        String[] columns = {"#", "Mileage", "Totally Spent", "Cost per liter", "Refill partial of full"};
        String[][] data = {{"1", "50150", "718", "1.3", "Yes"},
                {"2", "50970", "718", "1.3", "Yes"},
                {"3", "51610", "698", "1.3", "Yes"},
                {"4", "52150", "548", "1.3", "Yes"},
                {"5", "52990", "718", "1.3", "Yes"},
                {"6", "53650", "898", "1.3", "Yes"}};

        JTable averageData = new JTable(data, columns);
        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                column = averageData.getColumnModel().getColumn(i);
                column.setPreferredWidth(5);
                column.setResizable(false);
            }
            else if (i == 1) {
                column = averageData.getColumnModel().getColumn(i);
                column.setPreferredWidth(300);
                column.setResizable(true);
            }
            else if (i == 2) {
                column = averageData.getColumnModel().getColumn(i);
                column.setPreferredWidth(5);
                column.setResizable(true);
            }
            else if (i == 3) {
                column = averageData.getColumnModel().getColumn(i);
                column.setPreferredWidth(5);
                column.setResizable(true);
            }
        }
        averageData.setEnabled(false);

        JScrollPane consumptionTableScrollPane = new JScrollPane(averageData);

        //Button creation
        //Creating button which gives us ability to go to main window
        JButton mainFrameButton = JButtonInitializer.initAndCreateMainFrameButton();
        //Creating button which gives us ability to go to service tab
        JButton serviceButton = JButtonInitializer.initAndCreateServiceButton();
        //Creating button which gives us ability to go to exit application
        JButton exitButton = JButtonInitializer.initAndCreateExitButton();

        //Adding Swing components using GridBagConstraints. Use of static initializer provides
        // identic view for all frames.
        LayoutInitializer.initializeStandardLayout(this, fuelEntryPanel, mainFrameButton, serviceButton,
                exitButton, consumptionTableScrollPane);
    }
}
