package com.kattodev.leapforce.Apps;

import com.kattodev.leapforce.Utils.WindowSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SideBar extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Login.class.getResource("/com/kattodev/leapforce/Views/Components/SideBar.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load(),
                WindowSize.getComponentSideBar()[0],
                WindowSize.getComponentSideBar()[1]);

        stage.setTitle("LEAPFORCE - SIDEBAR TEST");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
