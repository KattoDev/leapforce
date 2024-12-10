package com.kattodev.leapforce.Models;

import java.util.Date;

public class Project {
    private long PID;
    private String name;
    private String description;
    private Date endDate;
    private int department;
    private boolean finished;


    public Project() {
    }

    public Project(long PID, String name, String description, Date endDate, int department, boolean finished) {
        this.PID = PID;
        this.name = name;
        this.description = description;
        this.endDate = endDate;
        this.department = department;
        this.finished = finished;
    }


    public long getPID() {
        return PID;
    }

    public void setPID(long PID) {
        this.PID = PID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
