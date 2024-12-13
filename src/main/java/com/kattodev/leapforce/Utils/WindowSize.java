package com.kattodev.leapforce.Models;

public class WindowSize {
    private static final int[] login = {600, 400};
    private static final int[] dashboard = {1280, 720};

    private static final int[] componentSideBar = {260, 720};

    private static final int[] moduleUserProfile = {1020, 720};


    public static int[] getLogin() {
        return login;
    }

    public static int[] getDashboard() {
        return dashboard;
    }


    public static int[] getComponentSideBar() {
        return componentSideBar;
    }


    public static int[] getModuleUserProfile() {
        return moduleUserProfile;
    }
}
