package com.company;

import java.util.Scanner;

/**
 * @mehran
 * */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BankingSystem bank = new BankingSystem();
        User mehran = new User("9931042", "mehran", "ghaffarian", "123");

        Account account1 = new Account("Mehran", "Ghaffarian", "sepordeh", 125, "123");
        Account account2 = new Account("Mehran", "Ghaffarian", "sepordeh", 205, "124");

        bank.addUser(mehran);
        bank.addAccount(account1);
        bank.addAccount(account2);

        mehran.addAccount(account1);
        mehran.addAccount(account2);

        int choice = 1;

        while (choice != 4) {
            System.out.println("to return to the main menu enter -1 anytime\n");
            System.out.println("1.sign up\n2.log in\n3.System Admin\n4.Exit");
            choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("please enter the id, first name, last name and password respectively");
                scan.nextLine();

                User userToAdd = new User(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());

                bank.register(userToAdd);
            }
            else if (choice == 2) {
                System.out.println("please enter the id and password respectively.");
                scan.nextLine();
                String id = scan.next();
                String password = scan.next();

                if (!id.equals("-1") && !password.equals("-1")) {
                    User user = bank.login(id, password);

                    if (user.notBack()) {
                        Boolean Back = false;

                        while (!Back) {
                            System.out.println("1.Existing accounts\n2.Add new account\n3.Log out");
                            choice = scan.nextInt();

                            if (choice == 1) {
                                user.printAllAvailableAccount();
                                System.out.println("Choose from above.");
                                int index = scan.nextInt();

                                if (index > 0 && index <= user.getAccountList().size()) {
                                    System.out.println("1.Withdrawal\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Back\n6.print transactions");
                                    choice = scan.nextInt();

                                    Account account = user.getAccountList().get(index - 1);

                                    if (choice == 1) {
                                        System.out.println("please enter the amount of money to withdrawal.");
                                        int amount = scan.nextInt();

                                        user.withdrawal(account, amount);
                                    } else if (choice == 2) {
                                        System.out.println("please enter the amount of money to deposit.");
                                        int amount = scan.nextInt();

                                        user.deposit(account, amount);

                                        System.out.println("Completed.");
                                    } else if (choice == 3) {
                                        System.out.println("Enter the destination serial and the amount of the money respectively.");
                                        scan.nextLine();
                                        String serial = scan.nextLine();
                                        int amount = scan.nextInt();

                                        Account destAccount = bank.findAccount(serial);

                                        if (destAccount == null)
                                            System.out.println("Destination account doesn’t exist or there is not enough money in your account.");
                                        else
                                            user.transfer(account, destAccount, amount);
                                    } else if (choice == 4)
                                        user.checkBalance(account);
                                    else if (choice == 5) {
                                        System.out.println("Logged out of account.");
                                        Back = false;
                                    } else if (choice == 6)
                                        account.printTransactions();
                                }
                            }
                            else if (choice == 2) {
                                System.out.println("Enter User ID, Account type and Money respectively.");
                                scan.nextLine();
                                id = scan.nextLine();
                                String type = scan.nextLine();
                                int money = scan.nextInt();

                                if (user.checkId(id)) {
                                    bank.addAccount(new Account(user.getFirstName(), user.getlastName(), type, money, id));
                                    user.addAccount((new Account(user.getFirstName(), user.getlastName(), type, money, id)));

                                    System.out.println("New account opened.");
                                } else
                                    System.out.println("Wrong ID.");
                            }
                            else if (choice == 3) {
                                Back = true;
                                System.out.println("Logged out.");
                            }
                        }
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("please enter the username and password respectively.");
                scan.nextLine();
                String username = scan.nextLine();
                String password = scan.nextLine();

                if ((!username.equals("sysadmin") || !password.equals("1234")) && !username.equals("-1") && !password.equals("-1"))
                    System.out.println("username or password is incorrect.");

                else if (!username.equals("-1") && !password.equals("-1")) {
                    System.out.println("Logged in as sysadmin.");

                    System.out.println("1.display users\n2.display accounts\n3.remove user\n4.remove account");
                    choice = scan.nextInt();

                    if (choice == 1)
                        bank.displayUsers();

                    else if (choice == 2)
                        bank.displayAccounts();

                    else if (choice == 3) {
                        System.out.println("please enter the ID.");
                        scan.nextLine();
                        String id = scan.nextLine();

                        User userCheck = bank.findUser(id);

                        if (userCheck == null)
                            System.out.println("User does not exist.");

                        else
                            bank.removeUser(userCheck);
                    }
                    else if (choice == 4) {
                        System.out.println("please enter the serial.");
                        scan.nextLine();
                        String serial = scan.nextLine();

                        Account accountRemove = bank.findAccount(serial);

                        if (accountRemove == null)
                            System.out.println("Account does not exist.");

                        else {
                            bank.removeAccount(accountRemove);

                            System.out.println("Account removed.");
                        }
                    }
                }
            }
        }
    }
}