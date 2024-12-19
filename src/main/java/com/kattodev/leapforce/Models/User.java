package com.kattodev.leapforce.Models;

import DebugHandler.Debug;
import com.kattodev.leapforce.Utils.ActualUser;
import com.kattodev.leapforce.Utils.Alerts;
import com.kattodev.leapforce.Utils.SystemMessages;
import javafx.scene.control.Alert;

import java.sql.*;


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


    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthDay=" + birthDay +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    /**
     * Auths a user with email and password.
     *
     * @param databaseConnection the {@link com.kattodev.leapforce.APIClient.DatabaseConnection} connection
     * @return true if the {@link User} is authorized to log in.
     */
    public boolean Auth(Connection databaseConnection) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement pstmt = databaseConnection.prepareStatement(query)) {
            pstmt.setString(1, this.email);
            pstmt.setString(2, this.password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return false;
                }

                ActualUser.getInstance().setUser(
                        new User(
                                rs.getLong("UID"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getDate("birthDay"),
                                rs.getLong("phone"),
                                this.email,
                                rs.getLong("department"),
                                rs.getString("position"),
                                rs.getLong("salary"),
                                this.password,
                                rs.getBoolean("isAdmin")
                        )
                );
                return true;
            }

        } catch (SQLException sqlException) {
            new Debug("No se pudo hacer el proceso de AUTH");
            return false;
        }
    }

    /**
     * Inserts a {@link User} into the database.
     *
     * @param databaseConnection the {@link com.kattodev.leapforce.APIClient.DatabaseConnection} connection
     */
    public void AddUser(Connection databaseConnection) {
        String query = "INSERT INTO users " +
                "(name, address, birthDay, phone, email, department, position," +
                "salary, password, isAdmin) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = databaseConnection.prepareStatement(query)) {

            pstmt.setString(1, getName());
            pstmt.setString(2, getAddress());
            pstmt.setDate(3, getBirthDay());
            pstmt.setLong(4, getPhone());
            pstmt.setString(5, getEmail());
            pstmt.setLong(6, getDepartment());
            pstmt.setString(7, getPosition());
            pstmt.setLong(8, getSalary());
            pstmt.setString(9, String.valueOf(getPhone()));
            pstmt.setBoolean(10, getIsAdmin());

            pstmt.executeUpdate();
            Alerts.showAlert(
                    Alert.AlertType.INFORMATION,
                    null,
                    "Se ha registrado el nuevo empleado");
        } catch (SQLException sqlException) {
            Alerts.showAlert(Alert.AlertType.ERROR,
                    SystemMessages.GenericError,
                    "No se pudo registrar el empleado\n" +
                            SystemMessages.ErrorCode + sqlException.getMessage());
            new Debug(sqlException.getMessage());
        }
    }

    /**
     * Updates the {@link User} information like name, email, phone, address, birthDay, position, salary and password
     * based on the {@link User}'s UID
     *
     * @param databaseConnection the {@link com.kattodev.leapforce.APIClient.DatabaseConnection} connection
     */
    public void UpdateUser(Connection databaseConnection) {
        String query = "UPDATE users " +
                "SET name = ?, email = ?, phone = ?, address = ?, birthDay = ?," +
                "position = ?, salary = ?, password = ? WHERE UID = ?";

        try (PreparedStatement pstmt = databaseConnection.prepareStatement(query)) {

            pstmt.setString(1, getName());
            pstmt.setString(2, getEmail());
            pstmt.setLong(3, getPhone());
            pstmt.setString(4, getAddress());
            pstmt.setDate(5, getBirthDay());
            pstmt.setString(6, getPosition());
            pstmt.setLong(7, getSalary());
            pstmt.setString(8, getPassword());
            pstmt.setLong(9, getUID());

            new Debug(pstmt.toString());
            pstmt.executeUpdate();
            Alerts.showAlert(
                    Alert.AlertType.INFORMATION,
                    null,
                    "se ha actualizado la información del usuario");
        } catch (SQLException sqlException) {
            Alerts.showAlert(
                    Alert.AlertType.ERROR,
                    SystemMessages.GenericError,
                    "No se pudo actualizar la información del usuario\n" +
                            SystemMessages.ErrorCode + sqlException.getMessage());
            new Debug(sqlException.getMessage());
        }
    }
}
