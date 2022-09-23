package com.atm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import static com.atm.ConnectionProvider.createConnection;

public class Operations {
    public static boolean open_account(Users us){
        boolean f = false;
        try{
            Connection con = createConnection();
            String q = "insert into users (uaccountnum, upassword, uname," +
                    " uphone, uaddress, " +
                    "uage, uamount) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, us.getUserAccountNumber());
            pstmt.setString(2, us.getUserPassword());
            pstmt.setString(3, us.getUserName());
            pstmt.setString(4, us.getUserPhone());
            pstmt.setString(5, us.getUserAddress());
            pstmt.setInt(6, us.getUserAge());
            pstmt.setInt(7, us.getUserAmount());

            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showInfo(String accountnum, String password){
        try{
            Connection con = createConnection();
            String q = "select * from users where uaccountnum = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, accountnum);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                String password_check = set.getString(2);
                if (Objects.equals(password_check, password)) {
                    String name = set.getString(3);
                    String phone = set.getString(4);
                    String address = set.getString(5);
                    int age = set.getInt(6);
                    int amount = set.getInt(7);
                    System.out.println("Account No --> " + accountnum);
                    System.out.println("Name --> " + name);
                    System.out.println("Phone Number --> "+ phone);
                    System.out.println("Address --> " + address);
                    System.out.println("Age --> " + age);
                    System.out.println("Amount In Account -- > " + amount);
                } else {
                    System.out.println("Invalid Password");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void withDraw(String accountnum, String password, int amount){
        try{
            Connection con = createConnection();
            String query1 = "select * from users where uaccountnum = ?";
            PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, accountnum);
            ResultSet set = pstmt.executeQuery();
            while (set.next()){
                String password_check = set.getString(2);
                if (Objects.equals(password_check, password)) {
                    int amount_check = set.getInt(7);
                    if (amount_check < amount) {
                        System.out.println("Sorry You Don't Have Sufficient Balance " +
                                "In Your Account ");
                    }
                    else {
                        int new_balance = amount_check - amount;
                        String query2 = "Update Users set uamount = ? Where uaccountnum = ?";
                        PreparedStatement pstmt2 = con.prepareStatement(query2);
                        pstmt2.setInt(1, new_balance);
                        pstmt2.setString(2, accountnum);
                        pstmt2.executeUpdate();
                        System.out.println("Your New Balance Is --> " + new_balance);
                    }
                }
                else{
                    System.out.println("Invalid Password");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addMoney(String accountnum, String password, int amount){
        try{
            Connection con = createConnection();
            String query1 = "select * from users where uaccountnum = ?";
            PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, accountnum);
            ResultSet set = pstmt.executeQuery();
            while (set.next()){
                String password_check = set.getString(2);
                if (Objects.equals(password_check, password)) {
                    int amount_check = set.getInt(7);
                    int new_balance = amount_check + amount;
                    String query2 = "Update Users set uamount = ? Where uaccountnum = ?";
                    PreparedStatement pstmt2 = con.prepareStatement(query2);
                    pstmt2.setInt(1, new_balance);
                    pstmt2.setString(2, accountnum);
                    pstmt2.executeUpdate();
                    System.out.println("Your New Balance Is --> " + new_balance);
                }
                else{
                    System.out.println("Invalid Password");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete_account(String accountnum, String password){
        try {
            Connection con = createConnection();
            String query = "select * from users where uaccountnum =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, accountnum);
            ResultSet set = pstmt.executeQuery();
            while (set.next()){
                String password_check = set.getString(2);
                if (Objects.equals(password_check, password)){
                    String query2 = "Delete from users where uaccountnum = ?";
                    PreparedStatement pstmt2 = con.prepareStatement(query2);
                    pstmt2.setString(1, accountnum);
                    pstmt2.executeUpdate();
                    System.out.println("Your Account Has Been Deleted Successfully");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
