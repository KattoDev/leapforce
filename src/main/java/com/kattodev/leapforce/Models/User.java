package com.kattodev.leapforce.Models;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.Date;


public class User {
    private long UID;
    private String name;
    private String address;
    private Date birthDay;
    private long phone;
    private String email;
    private long department;
    private String position;
    private long salary;
    private String password;
    private boolean isAdmin;


    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(long UID, String name, String address, Date birthDay, long phone, String email, long department, String position, long salary, String password, boolean isAdmin) {
        this.UID = UID;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public JsonArray getAsJSONArray() {
        String jsonString = "[{" +
                "\"name\": \"" + getName() + "\"," +
                "\"address\": \"" + getAddress() + "\"," +
                "\"birthday\": \"" + getBirthDay() + "\"," +
                "\"phoneNumber\": \"" + getPhone() + "\"," +
                "\"email\": \"" + getEmail() + "\"," +
                "\"position\": \"" + getPosition() + "\"," +
                "\"salary\": " + getSalary() + "," +
                "\"password\": \"" + getPassword() + "\"," +
                "\"department\": \"" + getDepartment() + "\"," +
                "\"isAdmin\": " + getIsAdmin() +
                "}]";

        return JsonParser.parseString(jsonString).getAsJsonArray();
    }
}
