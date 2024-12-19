package com.kattodev.leapforce.APIClient;

/**
 * Class to simplify the configuration with the database
 */
public class DatabaseConfig {
    // Database Host
    private final String databaseHost = "localhost";
    // Database Host port
    private final String databasePort = "3306";

    // Database Auth credentials
    private final String databaseUser = "API";
    private final String databasePassword = "localstaticvoid__3306";

    // Database name
    private final String databaseName = "leapforce_app";


    public DatabaseConfig() {
    }


    public String getDatabaseHost() {
        return databaseHost;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDatabaseName() {
        return databaseName;
    }
}
