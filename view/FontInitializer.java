package com.caracount.view;

import java.awt.*;

/**
 * Created by Flex on 06.09.2016.
 */
public class FontInitializer {

    //Method setting fonts for components.
    public static Font setMainButtonFont() {
        return new Font("Courier", Font.BOLD, 14);
    }

    public static Font setSecondaryButtonFont() {
        return new Font("Courier", Font.BOLD, 12);
    }

    public static Font setJlabelFont() {
        return new Font("Courier", Font.TRUETYPE_FONT, 14);
    }

    public static Font setPanelFont() {
        return new Font("Courier", Font.CENTER_BASELINE, 16);
    }
}
