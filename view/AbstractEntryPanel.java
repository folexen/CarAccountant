package com.caracount.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Flex on 30.08.2016.
 */
public abstract class AbstractEntryPanel extends JPanel {

    public AbstractEntryPanel(String panelTitle) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension panelSize = getPreferredSize();
        panelSize.height = (int)(size.height*0.4);
        panelSize.width = size.width;
        setPreferredSize(panelSize);
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        TitledBorder border = BorderFactory.createTitledBorder(etchedBorder, panelTitle);
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitleFont(FontInitializer.setPanelFont());
        border.setTitleColor(Color.DARK_GRAY);
        setBorder(border);
    }
}
