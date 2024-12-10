package com.kattodev.leapforce.Models;

import java.util.ArrayList;

public class Department {
    private long DID;
    private String name;
    private ArrayList<Integer> projects;


    public Department() {
    }

    public Department(long DID, String name, ArrayList<Integer> projects) {
        this.DID = DID;
        this.name = name;
        this.projects = projects;
    }


    public long getDID() {
        return DID;
    }

    public void setDID(long DID) {
        this.DID = DID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Integer> projects) {
        this.projects = projects;
    }
}
