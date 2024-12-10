package com.kattodev.leapforce.Models;

import java.sql.Blob;
import java.util.Date;

public class Report {
    private long IID;
    private Date date;
    private Blob content; // TODO FIX THIS TO STORE A .PDF


    public Report() {
    }

    public Report(long IID, Date date, Blob content) {
        this.IID = IID;
        this.date = date;
        this.content = content;
    }


    public long getIID() {
        return IID;
    }

    public void setIID(long IID) {
        this.IID = IID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }
}
