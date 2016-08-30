package com.caracount.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 23.08.2016.
 */
/* The MainFrame class provides the basic view of the application*/

public class MainFrame extends JFrame {

    public MainFrame(String title) throws HeadlessException {
        super(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initGui();
        setFont(new Font("Tahoma", Font.BOLD, 20));
    }
    public void initGui() {
        //Setting layout
        setLayout(new GridBagLayout());

        //Creating Swing components
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

        //Button creation
        //Creating button which gives us ability to go to fuel tab
        JButton fuelButton = JButtonInitializer.initAndCreateFuelButton();
        //Creating button which gives us ability to go to service tab
        JButton serviceButton = JButtonInitializer.initAndCreateServiceButton();
        //Creating button which gives us ability to go to exit application
        JButton exitButton = JButtonInitializer.initAndCreateExitButton();

        //Adding Swing components using GridBagConstraints. Use of static initializer provides
        // identic view for all frames.
        LayoutInitializer.initializeStandardLayout(this, carInfoPanel, fuelButton,
                 serviceButton, exitButton, averageDataScrollPane);
     }
}

