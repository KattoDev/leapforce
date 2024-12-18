package com.kattodev.leapforce.Controllers.Components;

import DebugHandler.Debug;
import com.kattodev.leapforce.Utils.DayTime;
import com.kattodev.leapforce.Utils.ActualUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class SideBar {
    @FXML
    private Label lbl_greeting;

    @FXML
    private Label lbl_username;

    @FXML
    private ImageView btn_settings;

    @FXML
    private ImageView ico_user;

    /**
     * Initialize the labels
     */
    public void initialize(){
        lbl_greeting.setText(new DayTime().getDayGreeting());
        lbl_username.setText(ActualUser.getInstance().getUser().getName());
        setIco_user("user");
    }

    public void btn_settings_clicked(MouseEvent mouseEvent) {
        new Debug("Settings button clicked");
    }

    public void btn_user_clicked(MouseEvent mouseEvent) {
    }

    public void btn_user_hover(MouseEvent mouseEvent) {
        setIco_user("settings");
    }

    public void btn_user_notHover(MouseEvent mouseEvent) {
        setIco_user("user");
    }


    private void setIco_user(String icon){
        String iconRoute;
        if (icon.equals("settings")) {
            iconRoute = "/com/kattodev/leapforce/icons/cog.png";
        } else {
            iconRoute = "/com/kattodev/leapforce/icons/account.png";
        }
        ico_user.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconRoute))));
    }
}
