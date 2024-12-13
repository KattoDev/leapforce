package com.kattodev.leapforce.Controllers;

import DebugHandler.Debug;

import com.kattodev.leapforce.APIClient.DatabaseConnection;

import com.kattodev.leapforce.Apps.SideBar;
import com.kattodev.leapforce.Utils.ActualUser;
import com.kattodev.leapforce.Utils.SystemMessages;
import com.kattodev.leapforce.Models.User;

import com.kattodev.leapforce.Utils.Alerts;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_email;

    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_password;

    public void btn_login_click(MouseEvent mouseEvent) throws IOException {
        new Debug("Login button Click");

        String email = txt_email.getText();
        String password = txt_password.getText();

        User tempUser = new User(email, password);
        if (!(tempUser.Auth(DatabaseConnection.getInstance().connection))) {
            Alerts.showAlert(Alert.AlertType.WARNING, SystemMessages.LoginErrorTitle, SystemMessages.LoginErrorBody);
        } else {

            Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

            // Lanzar el Dashboard
            try {
                SideBar sideBar = new SideBar();
                Stage sideBarStage = new Stage();
                sideBar.start(sideBarStage);
            } catch (NullPointerException nullPointerException) {
                nullPointerException.getCause();
            }

            new Debug(ActualUser.getInstance().getUser().toString());
        }
    }
}
