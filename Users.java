package com.atm;

public class Users {
    private String userAccountNumber;
    private String userPassword;
    private String userName;
    private String userPhone;
    private int userAge;
    private String userAddress;
    private int userAmount;

    public Users (String userAccountNumber, String userPassword, String userName,
                  String userPhone, String userAddress, int userAge, int userAmount){
        this.userAccountNumber = userAccountNumber;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userAge = userAge;
        this.userAmount = userAmount;
    }

    public String getUserAccountNumber(){
        return userAccountNumber;
    }

    public void setUserAccountNumber(String userAccountNumber){
        this.userAccountNumber = userAccountNumber;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserPassword(int userAccountNumber){
        this.userPassword = userPassword;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserPhone(){
        return userPhone;
    }

    public void setUserPhone(String userPhone){
        this.userPhone = userPhone;
    }
    public String getUserAddress(){
        return userAddress;
    }

    public void setUserAddress(String userAddress){
        this.userAddress = userAddress;
    }

    public int getUserAge(){
        return userAge;
    }

    public void setUserAge(int userAge){
        this.userAge = userAge;
    }

    public int getUserAmount(){
        return userAmount;
    }

    public void setUserAmount(int userAmount){
        this.userAmount = userAmount;
    }

    @Override
    public String toString(){
        return "User[User Account_Number = " + userAccountNumber + ", UserName = " + userName + ", UserPhone = "
                + userPhone +  ", UserAddress = " + userAddress + ", UserAge = " + userAge + ", UserAmount = "
                + userAmount + "]";
    }
}
