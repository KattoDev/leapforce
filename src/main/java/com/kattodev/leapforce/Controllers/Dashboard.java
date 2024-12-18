package com.kattodev.leapforce.Controllers;

import com.kattodev.leapforce.Controllers.Components.SideBar;
import com.kattodev.leapforce.Controllers.Modules.UserProfile;
import com.kattodev.leapforce.Utils.ModuleLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Dashboard {

    @FXML
    private Pane container_sidebar;

    @FXML
    private Pane container_dashboardModule;

    public void initialize() throws IOException {
        String sidebarComponentResource = "/com/kattodev/leapforce/Views/Components/SideBar.fxml";
        String dashboardMainModule = "/com/kattodev/leapforce/Views/Modules/UserProfile.fxml";

        ModuleLoader.LoadModule(container_sidebar, sidebarComponentResource);
        ModuleLoader.LoadModule(container_dashboardModule, dashboardMainModule);
    }
}
