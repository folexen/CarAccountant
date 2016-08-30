package com.caracount.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Flex on 30.08.2016.
 */
public abstract class AbstractEntryPanel extends JPanel {

    public AbstractEntryPanel(String panelTitle) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension panelSize = getPreferredSize();
        panelSize.height = size.height/3 - 20;
        panelSize.width = size.width/2 - 20;
        setPreferredSize(panelSize);
        setBorder(BorderFactory.createTitledBorder(panelTitle));
    }


}
