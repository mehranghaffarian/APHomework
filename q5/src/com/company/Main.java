package com.company;

import java.util.Iterator;
import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BankingSystem bank = new BankingSystem();

        bank.addAccount(new Account("Mehran", "Ghaffarian", "sepordeh", 125, "123"));
        bank.addUser(new User("9931042", "mehran", "ghaffarian", "12345678"));

        int choice = 1;

        while(choice != 4){
            System.out.println("-1.return to the Menu\n1.sign up\n2.log in\n3.System Admin\n4.Exit");
            choice = scan.nextInt();

            if(choice == 1){
                    System.out.println("please enter the first name, last name, id and password respectively");

                    String fName = scan.next();
                    String lName = scan.next();
                    String id = scan.next();
                    String password = scan.next();

                    Iterator<User> it = bank.getUsers().iterator();
                    Boolean isSame = false;

                    if (fName.equals("-1") || lName.equals("-1") || id.equals("-1") || password.equals("-1"))
                        break;

                    while (it.hasNext()){
                        User user = it.next();

                        if(user.getId().equals(id))
                            isSame = true;
                    }

                    if(!isSame)
                        System.out.println("user already exists.");

                    else{
                        bank.getUsers().add(new User(fName, lName, id, password));

                        System.out.println("user created.");
                    }
            }
            else if (choice == 2){
                System.out.println("please enter the id and password respectively.");

                String id = scan.next();
                String password = scan.next();

                Iterator<User> it = bank.getUsers().iterator();
                Boolean isIn = false;

                while (it.hasNext()){
                    User user = it.next();

                    if(user.getId().equals(id))
                        if(user.getPassword().equals(password)) {
                            isIn = true;
                            break;
                        }
                }
                if(!isIn) {
                    System.out.println("user doesn't exists or password is incorrect");
                    break;
                }
                System.out.println("logged in.");

                System.out.println("1.Existing accounts\n2.Add new account\n3.Log out");
                choice = scan.nextInt();

                if(choice == 1){

                }
                else if(choice == 2){

                }
                else{

                }
                // Choose from list of accounts
                // 1.WithDrawal
                // 2.Deposit
                // 3.Transfer
                // 4.Check balance
                // 5.Back
                // Enter info
            }
            else if(choice == 3){

            }
        }
    }
}