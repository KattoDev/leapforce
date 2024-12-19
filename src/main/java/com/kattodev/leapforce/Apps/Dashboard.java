package com.kattodev.leapforce.Apps;

import DebugHandler.Debug;
import com.kattodev.leapforce.Utils.ActualUser;
import com.kattodev.leapforce.Utils.WindowSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Login.class.getResource("/com/kattodev/leapforce/Views/Dashboard.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load(),
                WindowSize.getDashboard()[0],
                WindowSize.getDashboard()[1]);

        stage.setTitle("LEAPFORCE - DASHBOARD");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        new Debug(ActualUser.getInstance().getUser().toString());
    }
}
