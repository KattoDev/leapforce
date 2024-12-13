package com.kattodev.leapforce.Utils;

import com.kattodev.leapforce.Models.User;

/**
 * Singleton class to get the Actual User within the app
 */
public class ActualUser {
    private static ActualUser instance;
    private User user;


    /**
     * Static method to get the actual instance of {@link ActualUser}.
     * If the instance is null, this method creates a new instance with a empty {@link User}
     * @return the instance of the {@link ActualUser}
     */
    public static ActualUser getInstance() {
        if (instance == null) {
            instance = new ActualUser();
        }
        return instance;
    }

    /**
     * Destroys the {@link ActualUser} instance
     */
    public void destroyInstance() {
        instance = null;
    }

    /**
     * Sets a user to be globally used with the app
     * @param user an instance of {@link User}
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the user within the global instance
     * @return a global instance of {@link ActualUser} {@link User}
     */
    public User getUser() {
        return user;
    }
}
