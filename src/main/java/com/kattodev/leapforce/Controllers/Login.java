package com.kattodev.leapforce.Controllers;

import DebugHandler.Debug;
import com.kattodev.leapforce.APIClient.DatabaseConnection;
import com.kattodev.leapforce.Apps.Dashboard;
import com.kattodev.leapforce.Models.User;
import com.kattodev.leapforce.Utils.Alerts;
import com.kattodev.leapforce.Utils.SystemMessages;
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
            // dispose the current Stage
            Stage currentStage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
            currentStage.close();

            // Launch the dashboard
            try {
                Dashboard dashboardScene = new Dashboard();
                Stage dashboardStage = new Stage();
                dashboardScene.start(dashboardStage);

            } catch (NullPointerException nullPointerException) {
                Alerts.showAlert(
                        Alert.AlertType.ERROR,
                        SystemMessages.InternErrorTitle,
                        "Se ha producido un error con la aplicación\n" +
                        "Código de error:\n\n" + nullPointerException.getCause());
                new Debug(nullPointerException.getMessage());
            }
        }
    }
}
