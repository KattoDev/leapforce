package com.kattodev.leapforce.Utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class IconSetter {

    /**
     * Sets a icon into ico_user within {@link com.kattodev.leapforce.Controllers.Components.SideBar}
     *
     * @param icon the icon to set<br>
     *             can be <b>"settings"</b> or <b>"user"</b>
     * @param ico_user the ImageView icon user
     */
    public void set_SideBar_Ico_user(String icon, ImageView ico_user) {
        String iconRoute;
        if (icon.equals("settings")) {
            iconRoute = "/com/kattodev/leapforce/icons/cog.png";
        } else {
            iconRoute = "/com/kattodev/leapforce/icons/account.png";
        }
        ico_user.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconRoute))));
    }
}
