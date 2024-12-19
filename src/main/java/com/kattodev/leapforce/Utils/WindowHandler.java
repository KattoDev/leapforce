package com.kattodev.leapforce.Utils;

import DebugHandler.Debug;
import com.kattodev.leapforce.Apps.Dashboard;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WindowHandler {
    public static void LoadDashboardWindow(MouseEvent mouseEvent) {

        disposeStage(mouseEvent);

        try {
            Dashboard scene = new Dashboard();
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

    /**
     * Disposes the current stage
     *
     * @param mouseEvent the mouse event triggered
     */
    private static void disposeStage(MouseEvent mouseEvent) {
        Stage currentStage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
