package com.caracount.view;

import com.caracount.model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 23.08.2016.
 */
/* The MainFrame class provides the basic view of the application*/

public class MainFrame extends JFrame {


    private JPanel loginPanel;
    private JPanel carInfoPanel;
    private JPanel serviceEntryPanel;
    private JPanel fuelEntryPanel;

    private JButton mainButton;
    private JButton fuelButton;
    private JButton serviceButton;
    private JButton exitButton;

    private JTable serviceTable;
    private JTable fuelTable;


    private JScrollPane fuelScrollPane;
    private JScrollPane serivceScrollPane;
    private CarStatisticPanel carStatisticPanel;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getPreferredSize();
        frameSize.height = screenSize.height - 20;
        frameSize.width = screenSize.width - 10;
        setPreferredSize(frameSize);
        setContentPane(new JLabel(LayoutInitializer.createScaledImageIcon("resources/Background.jpg", "Background")));
        this.getRootPane().setBorder(BorderFactory.createEtchedBorder(20, Color.DARK_GRAY, Color.LIGHT_GRAY));
    }

    public void initGui(FramesNames framesNames) {
        //Setting layout
        setLayout(new GridBagLayout());

        //Button creation
        //Creating button which gives us ability to go to main window
        mainButton = JButtonInitializer.initAndCreateMainFrameButton();
        //Creating button which gives us ability to go to fuel tab
        fuelButton = JButtonInitializer.initAndCreateFuelButton();
        //Creating button which gives us ability to go to service tab
        serviceButton = JButtonInitializer.initAndCreateServiceButton();
        //Creating button which gives us ability to go to exit application
        exitButton = JButtonInitializer.initAndCreateExitButton();

        //Adding Swing components using GridBagConstraints. Use of static initializer provides
        // identic view for all frames.
        if (framesNames.equals(FramesNames.MainFrame)) {
            //initializing components needed for Main Frame
            carInfoPanel = new CarInfoPanel();
            carStatisticPanel = new CarStatisticPanel();
            //creating standart layout.
            LayoutInitializer.initializeStandardLayout(this, carInfoPanel, fuelButton,
                    serviceButton, exitButton, carStatisticPanel);
        }
        else if (framesNames.equals(FramesNames.FuelFrame)) {
            //initializing components needed for Fuel Frame.
            fuelEntryPanel = new FuelEntryPanel();
            fuelTable = TableInitializer.getInstantedTable(Model.getFuelDataForTable(Model.getSelectedVin()),
                    Model.getFuelFieldsName().toArray());

            fuelScrollPane = new JScrollPane(fuelTable);
            //creating standart layout.
            LayoutInitializer.initializeStandardLayout(this, fuelEntryPanel, mainButton, serviceButton,
                    exitButton, fuelScrollPane);
        }

        else if (framesNames.equals(FramesNames.ServiceFrame)) {
            //initializing components needed for ServiceExpenses Frame.
            serviceEntryPanel = new ServiceEntryPanel();
            serviceTable = TableInitializer.getInstantedTable(Model.getServiceDataForTable(Model.getSelectedVin()),
                    Model.getServiceFieldsName().toArray());
            serviceTable.setFillsViewportHeight(true);
            serivceScrollPane = new JScrollPane(serviceTable);
            //creating statndart layout.
            LayoutInitializer.initializeStandardLayout(this, serviceEntryPanel, mainButton,
                   fuelButton, exitButton, serivceScrollPane);
        }

        else if (framesNames.equals(FramesNames.LoginFrame)) {
            //initializing components needed for ServiceExpenses Frame.
            loginPanel = new LoginPanel("LOGIN ENTRY TAB");
            loginPanel.setOpaque(false);
            GridBagConstraints gc = new GridBagConstraints();

            gc.fill = GridBagConstraints.BOTH;
            gc.weightx = 0.5;
            gc.weighty = 0;
            gc.gridx = 0;
            gc.gridy = 0;
            gc.gridwidth = 3;

            this.add(loginPanel, gc);
        }
        this.pack();
     }

    public JTable getServiceTable() {
        return serviceTable;
    }

    public JTable getFuelTable() {
        return fuelTable;
    }

    public void disposeGUI() {
        if (loginPanel != null) this.remove(loginPanel);
        if (carInfoPanel != null) this.remove(carInfoPanel);
        if (serviceEntryPanel != null) this.remove(serviceEntryPanel);
        if (fuelEntryPanel != null) this.remove(fuelEntryPanel);

        if (mainButton != null) this.remove(mainButton);
        if (fuelButton != null) this.remove(fuelButton);
        if (serviceButton != null) this.remove(serviceButton);
        if (exitButton != null) this.remove(exitButton);

        if (carStatisticPanel != null) this.remove(carStatisticPanel);
        if (serviceTable != null) this.remove(serviceTable);
        if (fuelTable != null) this.remove(fuelTable);

        if (fuelScrollPane != null) this.remove(fuelScrollPane);
        if (serivceScrollPane != null) this.remove(serivceScrollPane);
    }
}

