package com.kattodev.leapforce.Models;

import java.util.Date;

public class Task {
    private long PID;
    private String name;
    private String description;
    private Date endDate;
    private long user;
    private long project;
    private boolean finished;


    public Task() {
    }

    public Task(long PID, String name, String description, Date endDate, long user, long project, boolean finished) {
        this.PID = PID;
        this.name = name;
        this.description = description;
        this.endDate = endDate;
        this.user = user;
        this.project = project;
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

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getProject() {
        return project;
    }

    public void setProject(long project) {
        this.project = project;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
