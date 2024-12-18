package com.kattodev.leapforce.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ModuleLoader {

    /**
     * static method for load a module inside a panel via FXML resource
     * @param container the target container
     * @param resource the FXML view resource
     * @return the controller of the module
     * @throws IOException
     */
    public static <Module> Module LoadModule(Pane container, String resource) throws IOException {

        // clear the container
        container.getChildren().clear();

        // get the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(ModuleLoader.class.getResource(resource));

        // load the module
        Pane module = fxmlLoader.load();

        // container config
        container.setOpacity(1);

        // add the module to container
        container.getChildren().add(module);

        return fxmlLoader.getController();
    }
}
