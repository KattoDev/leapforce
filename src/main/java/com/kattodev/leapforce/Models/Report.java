package com.kattodev.leapforce.Models;

import java.sql.Blob;
import java.util.Date;

public class Report {
    private long RID;
    private Date date;
    private Blob content; // TODO FIX THIS TO STORE A .PDF


    public Report() {
    }

    public Report(long RID, Date date, Blob content) {
        this.RID = RID;
        this.date = date;
        this.content = content;
    }


    public long getRID() {
        return RID;
    }

    public void setRID(long RID) {
        this.RID = RID;
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
