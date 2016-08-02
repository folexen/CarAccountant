package com.caracount;

import com.caracount.listeners.FrameListener;
import com.caracount.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Flex on 02.08.2016.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane jTabbedPane = new JTabbedPane();
    private JTable jTableRepairments;


    //Temporary data for Jtable
    String[] jTablePetroliumColumnNames = {"Date", "Mileage", "Petrolium Total Cost", "Petrolium cost per liter"};
    String[][] jTabelPetroliumData = {{"15.01.2016", "80157", "902.75", "17.50"}, {"17.01.2016", "81096", "750.62", "17.50"}};
    //Petrolium Table
    JTable jTablePetrolium = new JTable(jTabelPetroliumData, jTablePetroliumColumnNames);

    //Temporary Service Data
    String[] jTableServiceColumnNames = {"Date", "Mileage", "Service Name", "Service Cost"};
    String[][] jTableServiceData = {{"15.01.2016", "80157", "Brake Pads Change", "457.50"}, {"17.01.2016", "81096", "Cabin Filter Change", "312.50"}};
    //Service Table
    private JTable jTableService = new JTable(jTableServiceData, jTableServiceColumnNames);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
           ExceptionHandler.log(e)
           ;
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }

    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
    }

    public void initPanels() {
        jTabbedPane.addTab("Petrolium", new JScrollPane(jTablePetrolium));
        jTabbedPane.addTab("Service", new JScrollPane(jTableService));
        jTabbedPane.setPreferredSize(new Dimension(1024, 768));
        jTabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        Container container = getContentPane();
        container.add(jTabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initPanels();
        pack();
    }

    public void selectedTabChanged() {
    }
}
