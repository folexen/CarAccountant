package com.caracount;

import java.io.File;

/**
 * Created by Flex on 02.08.2016.
 */
public class Controller {
    private View view;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
    }

    public void exit() {
        System.exit(1);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
