package com.caracount.view;

import com.caracount.model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 03.10.2016.
 */
public class CarStatisticPanel extends AbstractEntryPanel {

    public CarStatisticPanel() {
        super("CAR STATISITIC");
        initGui();
    }

    private void initGui() {
        //Setting layout manager
        setLayout(new GridBagLayout());

        //Creating Swing components
        JLabel averageFuelConsumptionLast = LayoutInitializer.getjLabel("Average fuel consumption on last refuel:");
        JLabel averageFuelConsumptionTotal = LayoutInitializer.getjLabel("Average total fuel consuption:");
        JLabel fuelMonthExpenses = LayoutInitializer.getjLabel("Money spent to refuel this month:");
        JLabel fuelOverallExpenses = LayoutInitializer.getjLabel("Money spent totally to refuel:");
        JLabel serviceOverallExpenses = LayoutInitializer.getjLabel("Money spent totally on service:");
        JLabel serviceMonthExpenses = LayoutInitializer.getjLabel("Money spent on service this month:");
        JLabel workExpensesAll = LayoutInitializer.getjLabel("Money spent totally on work:");
        JLabel workExpensesMonth = LayoutInitializer.getjLabel("Money spent on work this month:");
        JLabel sparePartsExpenseOverall = LayoutInitializer.getjLabel("Money spent totally on spare parts:");
        JLabel sparePartsExpensesMonth = LayoutInitializer.getjLabel("Money spent on spare parts this month:");

        JLabel averageFuelConsumptionLastValue = LayoutInitializer.getjLabel(String.valueOf(Model.getFuelCostsAndData(Model.getSelectedVin()).get("LAST")));
        JLabel averageFuelConsumptionTotalValue = LayoutInitializer.getjLabel(String.valueOf(Model.getFuelCostsAndData(Model.getSelectedVin()).get("OVERALL")));
        JLabel fuelMonthExpensesValue = LayoutInitializer.getjLabel(String.valueOf(Model.getFuelCostsAndData(Model.getSelectedVin()).get("COST MONTH")));
        JLabel fuelOverallExpensesValue = LayoutInitializer.getjLabel(String.valueOf(Model.getFuelCostsAndData(Model.getSelectedVin()).get("COST OVERALL")));
        JLabel serviceOverallExpensesValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("ALL")));
        JLabel serviceMonthExpensesValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("MONTH ALL")));
        JLabel workExpensesAllValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("ALL WORK")));
        JLabel workExpensesMonthValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("MONTH WORK")));
        JLabel sparePartsExpenseOverallValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("ALL SERVICE")));
        JLabel sparePartsExpensesMonthValue = LayoutInitializer.getjLabel(String.valueOf(Model.getServiceExpenses(Model.getSelectedVin()).get("MONTH SERVICE")));

        //Adding Swing components to content pane
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 0.0;
        gc.weighty = 0.1;

        gc.anchor = GridBagConstraints.LINE_END;
        LayoutInitializer.initConstrainGrid(gc, 0, 0);
        this.add(averageFuelConsumptionLast, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 1);
        this.add(averageFuelConsumptionTotal, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 2);
        this.add(fuelMonthExpenses, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 3);
        this.add(fuelOverallExpenses, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 4);
        this.add(serviceMonthExpenses, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 5);
        this.add(serviceOverallExpenses, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 6);
        this.add(workExpensesMonth, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 7);
        this.add(workExpensesAll, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 8);
        this.add(sparePartsExpensesMonth, gc);

        LayoutInitializer.initConstrainGrid(gc, 0, 9);
        this.add(sparePartsExpenseOverall, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        LayoutInitializer.initConstrainGrid(gc, 1, 0);
        this.add(averageFuelConsumptionLastValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 1);
        this.add(averageFuelConsumptionTotalValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 2);
        this.add(fuelMonthExpensesValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 3);
        this.add(fuelOverallExpensesValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 4);
        this.add(serviceMonthExpensesValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 5);
        this.add(serviceOverallExpensesValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 6);
        this.add(workExpensesMonthValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 7);
        this.add(workExpensesAllValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 8);
        this.add(sparePartsExpensesMonthValue, gc);

        LayoutInitializer.initConstrainGrid(gc, 1, 9);
        this.add(sparePartsExpenseOverallValue, gc);
    }
}
