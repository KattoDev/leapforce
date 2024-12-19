package com.kattodev.leapforce.Utils;

import com.kattodev.leapforce.Controllers.Dashboard;

/// Singleton class to get the Actual User within the app
public class PersistentDashboard {
    private static PersistentDashboard instance;
    private Dashboard dashboard;


    /**
     * Static method to get the actual instance of {@link PersistentDashboard}. <br>
     * If the instance is null, this method creates a new instance with a empty {@link Dashboard}
     *
     * @return the instance of the {@link PersistentDashboard}
     */
    public static PersistentDashboard getInstance() {
        if (instance == null) {
            instance = new PersistentDashboard();
        }
        return instance;
    }

    /// Destroys the {@link PersistentDashboard} instance
    public void destroyInstance() {
        instance = null;
    }

    /**
     * Gets the dashboard within the global instance
     *
     * @return a global instance of {@link PersistentDashboard} {@link Dashboard}
     */
    public Dashboard getDashboard() {
        return dashboard;
    }

    /**
     * Sets a <b>dashboard</b> to be globally used with the app
     *
     * @param dashboard an instance of {@link Dashboard}
     */
    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}

