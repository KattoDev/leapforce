package com.kattodev.leapforce.Controllers;

import DebugHandler.Debug;

import com.kattodev.leapforce.APIClient.DatabaseConfig;
import com.kattodev.leapforce.APIClient.DatabaseConnection;

import com.kattodev.leapforce.Models.ActualUser;
import com.kattodev.leapforce.Models.SystemMessages;
import com.kattodev.leapforce.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class Login {
    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_email;

    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_password;

    public void btn_login_click(MouseEvent mouseEvent) {
        new Debug("Click");

        String email = txt_email.getText();
        String password = txt_password.getText();

        User tempUser = new User(email, password);
        if (!(tempUser.Auth(DatabaseConnection.getInstance().connection))) {
            Alerts.showAlert(Alert.AlertType.WARNING, SystemMessages.LoginErrorTitle, SystemMessages.LoginErrorBody);
        }

        new Debug(ActualUser.getInstance().getUser().toString());

    }
}
