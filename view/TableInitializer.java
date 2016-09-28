package com.caracount.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 06.09.2016.
 */
public class TableInitializer {

    public static JTable getInstantedTable(String[][] data, Object[] columns) {
        JTable resultTable = new JTable(data, columns);
        resultTable.setFont(FontInitializer.setJlabelFont());
        resultTable.getTableHeader().setFont(FontInitializer.setJlabelFont());
        resultTable.getTableHeader().setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY));
        resultTable.setGridColor(Color.GRAY);
        resultTable.setEnabled(true);
        resultTable.setOpaque(false);
        resultTable.setFillsViewportHeight(true);
        return resultTable;
    }
}
