module com.kattodev.leapforce {
    requires javafx.fxml;

    requires com.google.gson;

    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires mysql.connector.j;
    requires com.gluonhq.charm.glisten;

    opens com.kattodev.leapforce.Apps to javafx.fxml;
    exports com.kattodev.leapforce.Apps;
    opens com.kattodev.leapforce.Controllers to javafx.fxml;
    exports com.kattodev.leapforce.Controllers;
    exports com.kattodev.leapforce.APIClient;
    opens com.kattodev.leapforce.APIClient to javafx.fxml;
}