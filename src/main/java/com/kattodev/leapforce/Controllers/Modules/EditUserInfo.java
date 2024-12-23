package com.kattodev.leapforce.Controllers.Modules;

import com.gluonhq.charm.glisten.control.TextField;
import com.kattodev.leapforce.APIClient.DatabaseConnection;
import com.kattodev.leapforce.Models.User;
import com.kattodev.leapforce.Utils.ActualUser;
import com.kattodev.leapforce.Utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.sql.Date;
import java.time.LocalDate;

public class EditUserInfo {

    private final User user = ActualUser.getInstance().getUser();
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_address;
    @FXML
    private DatePicker txt_birthday;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_password;
    @FXML
    private Pane btn_save;

    public void initialize() {
        txt_name.setText(user.getName());
        txt_address.setText(user.getAddress());
        txt_birthday.setValue(LocalDate.parse(user.getBirthDay().toString()));
        txt_phone.setText(String.valueOf(user.getPhone()));
        txt_email.setText(user.getEmail());
        txt_password.setText(user.getPassword());
    }

    public void btn_save_click(MouseEvent mouseEvent) {
        User userToUpdate = new User(
                user.getUID(),
                txt_name.getText(),
                txt_address.getText(),
                Date.valueOf(txt_birthday.getValue()),
                Long.parseLong(txt_phone.getText()),
                txt_email.getText(),
                user.getDepartment(),
                user.getPosition(),
                user.getSalary(),
                txt_password.getText(),
                user.getIsAdmin()
        );
        userToUpdate.UpdateUser(DatabaseConnection.getInstance().connection);
        Alerts.showAlert(
                Alert.AlertType.INFORMATION,
                "Aviso",
                "Los cambios surgiran efectos la siguiente ves que inicie sesión");
    }
}
