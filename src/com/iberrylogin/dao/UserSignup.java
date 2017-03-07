package com.iberrylogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class UserSignup {
    public static boolean newuser(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/?";
        String dbName = "demotest";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";
        
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url , user, password);
            pst = conn.prepareStatement("INSERT INTO useridschema.userlogin(iduserlogin,password) VALUES('"+name+"','"+pass+"')");
            System.out.println("Query"+"INSERT INTO useridschema.userlogin(iduserlogin,password) VALUES('"+name+"','"+pass+"')");
            status=(pst.executeUpdate()==1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}