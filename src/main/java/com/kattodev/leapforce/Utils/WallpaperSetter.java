package com.kattodev.leapforce.Utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;
import java.util.Random;

public class WallpaperSetter {

    private static final String[] wallpapers = {
            "/com/kattodev/leapforce/images/background/7a1de529a2187bb742303ea925188714.jpg",
            "/com/kattodev/leapforce/images/background/29fca04ea8553daab3869d40bfac7701.jpg",
            "/com/kattodev/leapforce/images/background/af9b731bcd238263cd38379821da0384.jpg",
            "/com/kattodev/leapforce/images/background/c0acf79822c641c498a342eb3e473a96.jpg",
    };

    /**
     * Sets a wallpaper in the login
     *
     * @param img_background the login image container
     */
    public static void setWallpaper(ImageView img_background) {

        String image = WallpaperRandomizer(wallpapers.length);

        img_background.setImage(new Image(Objects.requireNonNull(WallpaperSetter.class.getResourceAsStream(image))));
    }

    /**
     * Method for make random the wallpaper
     *
     * @param wallpapersLenght the lenght of the wallpapers array
     * @return a string with the wallpaper resource
     */
    private static String WallpaperRandomizer(int wallpapersLenght) {
        int selected = new Random().nextInt(wallpapersLenght);

        return wallpapers[selected];
    }
}
