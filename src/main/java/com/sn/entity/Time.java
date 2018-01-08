package com.sn.entity;

import java.util.Date;

public class Time {
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    private String dateString;

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Integer getIselect() {
        return iselect;
    }

    public void setIselect(Integer iselect) {
        this.iselect = iselect;
    }

    private Date date;
    private String week;

    private Integer iselect;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    private Integer value;
}
