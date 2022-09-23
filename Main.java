package com.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome To ATM App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Press 1 To Opening A new Account");
            System.out.println("Press 2 To Withdraw Money");
            System.out.println("Press 3 To Add Money In Your Account");
            System.out.println("Press 4 To Check Account Info");
            System.out.println("Press 5 To Close Your Account");
            System.out.println("Press 6 To Exit");

            int input = Integer.parseInt(br.readLine());

            if (input == 1){
                System.out.println("Enter Your Name: ");
                String name = br.readLine();

                System.out.println("Enter Your Phone Number: ");
                String phone = br.readLine();

                System.out.println("Enter Your Address:");
                String address = br.readLine();

                System.out.println("Enter Your Age: ");
                int age = Integer.parseInt(br.readLine());

                System.out.println("Enter Your Account Number Of 10 Digits: ");
                String accountnum = br.readLine();

                System.out.println("Enter Password Of Max 10 Digits: ");
                String password = br.readLine();

                System.out.println("Enter Amount You Want To Add: ");
                int amount = Integer.parseInt(br.readLine());

                Users us = new Users(accountnum, password, name, phone, address,
                        age, amount);
                boolean ans = Operations.open_account(us);
                if (ans){
                    System.out.println("Congratulations Your Account Has Been Open Successfully");
                }
                else{
                    System.out.println("Something Went Wrong Try Again Later");
                }
            }

            else if (input == 2){
                System.out.println("Enter Your Account Number: ");
                String accountnum = br.readLine();

                System.out.println("Enter Password: ");
                String password = br.readLine();

                System.out.println("How Much Amount You Want To Withdraw? ");
                int amount = Integer.parseInt(br.readLine());
                Operations.withDraw(accountnum, password, amount);
            }

            else if (input == 3){
                System.out.println("Enter Your Account Number: ");
                String accountnum = br.readLine();

                System.out.println("Enter Password: ");
                String password = br.readLine();

                System.out.println("How Much Amount You Want To Add? ");
                int amount = Integer.parseInt(br.readLine());
                Operations.addMoney(accountnum, password, amount);
            }

            else if (input == 4){
                System.out.println("Enter Your Account Number: ");
                String accountnum = br.readLine();

                System.out.println("Enter Password: ");
                String password = br.readLine();
                Operations.showInfo(accountnum, password);
            }

            else if (input == 5){
                System.out.println("Enter Your Account Number: ");
                String accountnum = br.readLine();

                System.out.println("Enter Your Password");
                String password = br.readLine();

                Operations.delete_account(accountnum, password);
            }

            else if (input == 6){
                System.out.println("Thank You For Using Our Service");
                break;
            }

            else{
                System.out.println("Sorry But You Have Given A Wrong Input, Try Again");
            }
        }
    }
}