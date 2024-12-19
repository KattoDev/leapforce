package com.kattodev.leapforce.Controllers;

import DebugHandler.Debug;
import com.kattodev.leapforce.APIClient.DatabaseConnection;
import com.kattodev.leapforce.Models.User;
import com.kattodev.leapforce.Utils.Alerts;
import com.kattodev.leapforce.Utils.SystemMessages;
import com.kattodev.leapforce.Utils.WallpaperSetter;
import com.kattodev.leapforce.Utils.WindowHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Login {
    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_email;

    @FXML
    private com.gluonhq.charm.glisten.control.TextField txt_password;

    @FXML
    private ImageView img_background;


    public void initialize() {
        WallpaperSetter.setWallpaper(img_background);
    }


    // ----------------------------------------------------------------------------------------------------------------
    // click events
    // ----------------------------------------------------------------------------------------------------------------
    public void btn_login_click(MouseEvent mouseEvent) throws IOException {
        new Debug("Login button Click");

        String email = txt_email.getText();
        String password = txt_password.getText();

        User tempUser = new User(email, password);

        boolean isAuth = tempUser.Auth(DatabaseConnection.getInstance().connection);

        if (!isAuth) {
            Alerts.showAlert(
                    Alert.AlertType.WARNING,
                    SystemMessages.LoginErrorTitle,
                    SystemMessages.LoginErrorBody);
        } else {
            WindowHandler.LoadDashboardWindow(mouseEvent);
        }
    }
}
