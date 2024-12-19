package com.kattodev.leapforce.Controllers;

import com.kattodev.leapforce.Utils.ModuleLoader;
import com.kattodev.leapforce.Utils.PersistentDashboard;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Dashboard {

    @FXML
    public Pane container_sidebar;

    @FXML
    public Pane container_dashboardModule;

    public void initialize() throws IOException {
        PersistentDashboard.getInstance().setDashboard(this);
        ModuleLoader.LoadModule(container_sidebar, ModuleLoader.sidebarComponentResource);
    }
}
