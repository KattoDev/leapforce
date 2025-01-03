package com.kattodev.leapforce.Controllers.Modules;

import DebugHandler.Debug;
import com.kattodev.leapforce.APIClient.DatabaseConnection;
import com.kattodev.leapforce.Apps.EditUserInfo;
import com.kattodev.leapforce.Models.Department;
import com.kattodev.leapforce.Models.User;
import com.kattodev.leapforce.Utils.ActualUser;
import com.kattodev.leapforce.Utils.Alerts;
import com.kattodev.leapforce.Utils.SystemMessages;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserProfile {

    @FXML
    private Label lbl_user_name;

    @FXML
    private Label lbl_user_address;

    @FXML
    private Label lbl_user_birthday;

    @FXML
    private Label lbl_user_phone;

    @FXML
    private Label lbl_user_email;

    @FXML
    private Label lbl_user_position;

    @FXML
    private Label lbl_user_department;

    @FXML
    private Label lbl_user_salary;


    public void initialize() {
        User user = ActualUser.getInstance().getUser();

        lbl_user_name.setText(user.getName());
        lbl_user_address.setText(user.getAddress());
        lbl_user_birthday.setText(user.getBirthDay().toString());
        lbl_user_phone.setText(String.valueOf(user.getPhone()));
        lbl_user_email.setText(user.getEmail());
        lbl_user_position.setText(user.getPosition());
        lbl_user_department.setText(
                new Department().getDepartmentName(
                        user.getDepartment(), DatabaseConnection.getInstance().connection));
        lbl_user_salary.setText(String.valueOf(user.getSalary()));
    }

    public void btn_login_click(MouseEvent mouseEvent) {
        new Debug("Clicked");

        try {
            EditUserInfo scene = new EditUserInfo();
            Stage stage = new Stage();
            scene.start(stage);
        } catch (Exception exception) {
            Alerts.showAlert(
                    Alert.AlertType.ERROR,
                    SystemMessages.InternErrorTitle,
                    "Se ha producido un error con la aplicación\n" +
                            SystemMessages.ErrorCode + exception.getCause());
            new Debug(exception.getMessage());
        }
    }
}
