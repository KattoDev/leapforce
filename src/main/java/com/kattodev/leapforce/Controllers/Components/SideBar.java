package com.kattodev.leapforce.Controllers.Components;

import DebugHandler.Debug;
import com.kattodev.leapforce.Controllers.Dashboard;
import com.kattodev.leapforce.Utils.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SideBar {
    private final IconSetter iconSetter = new IconSetter();

    @FXML
    private Label lbl_greeting;

    @FXML
    private Label lbl_username;

    @FXML
    private ImageView ico_user;

    @FXML
    private Pane btn_employees;

    @FXML
    private Pane btn_departments;

    @FXML
    private Pane btn_reports;

    @FXML
    private Pane btn_tasks_and_projects;

    private Pane container = PersistentDashboard.getInstance().getDashboard().container_dashboardModule;

    public void initialize() {
        lbl_greeting.setText(new DayTime().getDayGreeting());
        lbl_username.setText(ActualUser.getInstance().getUser().getName());
        iconSetter.set_SideBar_Ico_user("user", ico_user);
    }


    // ----------------------------------------------------------------------------------------------------------------
    // click events
    // ----------------------------------------------------------------------------------------------------------------
    public void btn_user_clicked(MouseEvent mouseEvent) throws IOException {
        new Debug("Settings button clicked");
        ModuleLoader.LoadModule(container, ModuleLoader.dashboardMainModule);
    }

    public void btn_logout_clicked(MouseEvent mouseEvent) {
        // TODO clear the actual session and exit app
        new Debug("logout button clicked");
    }

    public void btn_employees_clicked(MouseEvent mouseEvent) {
        new Debug("employees button clicked");
    }

    public void btn_departments_clicked(MouseEvent mouseEvent) {
        new Debug("departments button clicked");
    }

    public void btn_reports_clicked(MouseEvent mouseEvent) {
        new Debug("reports button clicked");
    }

    public void btn_tasks_and_projects_clicked(MouseEvent mouseEvent) {
        new Debug("task & projects button clicked");
    }


    // ----------------------------------------------------------------------------------------------------------------
    // misc events
    // ----------------------------------------------------------------------------------------------------------------
    public void btn_user_hover(MouseEvent mouseEvent) {
        iconSetter.set_SideBar_Ico_user("settings", ico_user);
    }

    public void btn_user_notHover(MouseEvent mouseEvent) {
        iconSetter.set_SideBar_Ico_user("user", ico_user);
    }


}
