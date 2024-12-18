package com.kattodev.leapforce.Models;

import DebugHandler.Debug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public String getDepartmentName(long DID, Connection databaseConnection) {
        String query = "SELECT name FROM departments WHERE DID = ?";
        String error = "ERROR EN LA BUSQUEDA DEL DEPARTAMENTO";

        try (PreparedStatement pstmt = databaseConnection.prepareStatement(query)) {
            pstmt.setLong(1, DID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return error;
                }

                return rs.getString("name");
            }
        } catch (SQLException sqlException) {
            new Debug(error + "\n" + sqlException.getMessage());
            return error;
        }
    }

    public String getDepartmentDID(String departmentName, Connection databaseConnection) {
        String query = "SELECT DID FROM departments WHERE name = ?";
        String error = "ERROR EN LA BUSQUEDA DEL DEPARTAMENTO";

        try (PreparedStatement pstmt = databaseConnection.prepareStatement(query)) {
            pstmt.setString(1, departmentName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return error;
                }

                return rs.getString("DID");
            }
        } catch (SQLException sqlException) {
            new Debug(error + "\n" + sqlException.getMessage());
            return error;
        }
    }
}
