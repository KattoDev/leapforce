package com.kattodev.leapforce.APIClient;

import DebugHandler.Debug;

import com.kattodev.leapforce.Utils.Alerts;
import com.kattodev.leapforce.Utils.SystemMessages;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Class to handle the {@link DatabaseConnection} within the app.
 * Uses MySQL to connect to database.
 * The config file is {@link DatabaseConfig}.
 *
 * @author Katto
 * @version 2.0.0
 */
public class DatabaseConnection {
    private final DatabaseConfig databaseConfig = new DatabaseConfig();

    private static DatabaseConnection instance;
    public Connection connection = null;
    public ResultSet resultSet;
    public Statement statement;


    /**
     * Gets the instance of the {@link DatabaseConnection} and connecting itself to MySQL database
     *
     * @return the {@link DatabaseConnection} instance
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            instance.connectDatabase();
        }
        return instance;
    }

    /**
     * Destroy the {@link DatabaseConnection} instance, safely closing the connection.
     */
    public void destroyInstance() {
        instance.CloseConnection();
        instance = null;
    }

    /**
     * Connects with the MySQL database Registering the database using JDBC Driver
     */
    private void connectDatabase() {
        // Register the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            Alerts.showAlert(
                    Alert.AlertType.ERROR,
                    SystemMessages.InternErrorTitle,
                    "ERROR no se puede registrar el driver\n" +
                            "Código de error: " + classNotFoundException.getMessage());
            new Debug(classNotFoundException.getMessage());
        }

        // Set the connection
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" +
                            databaseConfig.getDatabaseHost() +
                            ":" + databaseConfig.getDatabasePort() + "/" +
                            databaseConfig.getDatabaseName(),
                    databaseConfig.getDatabaseUser(),
                    databaseConfig.getDatabasePassword());
            new Debug(
                    connection.isValid(50000) ?
                            "Conexion con la base de datos establecida" :
                            "No se pudo establecer conexion con la base de datos");

            // set up the statement with the connection
            statement = connection.createStatement();

        } catch (SQLException sqlException) {
            Alerts.showAlert(Alert.AlertType.ERROR,
                    SystemMessages.InternErrorTitle,
                    "Error no se puede conectar a la base de datos\n" +
                            "Código de error: " + sqlException.getMessage());
            new Debug("ERROR: no se puede conectar a la DB \n" + sqlException.getMessage());
        }
    }

    /**
     * Closes the connection with the MySQL database, safely cleaning the statement, resultSet and connection.
     */
    private void CloseConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            new Debug("Se ha cerrado la conexión con la base de datos");
        } catch (SQLException sqlException) {
            Alerts.showAlert(
                    Alert.AlertType.ERROR,
                    SystemMessages.InternErrorTitle,
                    "No se pudo cerrar la conexion con la base de datos.\n" +
                            "Código de error: " + sqlException.getMessage());
            new Debug("ERROR: No se pudo cerrar la conexion con DB " + sqlException.getMessage());
        }
    }
}