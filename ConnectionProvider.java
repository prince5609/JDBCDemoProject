package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;

    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  // Driver class name
            String url = "jdbc:mysql://localhost:3306/bank_info";
            String user = "root";
            String password = "admin";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
