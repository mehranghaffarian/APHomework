package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void register(User user) {
        Iterator<User> it = users.iterator();
        Boolean isSame = false;

        if (user.notBack()) {
            while (it.hasNext()) {
                User userCheck = it.next();

                if (userCheck.isSame(user))
                    isSame = true;
            }

            if (isSame)
                System.out.println("user already exists.");

            else {
                users.add(user);

                System.out.println("user created.");
            }
        }
    }

    public User login(String id, String password){
        Iterator<User> it = users.iterator();
        boolean isId = false;

        while (it.hasNext()){
            User user = it.next();

            if(user.checkId(id)){
                isId = true;

                if(user.checkPassword(password)) {
                    System.out.println("logged in.");
                    return user;
                }
                else
                    System.out.println("wrong password.");
            }
        }
        if(!isId)
            System.out.println("there is no user with that id: " + id);

        return new User("-1", "0", "0", "0");
    }

    public void addUser(User user){users.add(user);}

    public void removeUser(User user) {
        Iterator<Account> accountsIt = accounts.iterator();

        while (accountsIt.hasNext()) {
            Account account = accountsIt.next();

            if (user.getAccountList().contains(account))
                accountsIt.remove();
        }
        users.remove(user);
        System.out.println("User removed.");
    }

    public void displayUsers() {
        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            User user = it.next();

            user.printUserData();
        }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account){
        accounts.remove(account);

        Iterator<User> usersIt = users.iterator();

        while (usersIt.hasNext()){
            User user = usersIt.next();

            user.removeAccount(account.getSerial());
        }
    }

    public void displayAccounts(){
        Iterator<Account> it = accounts.iterator();

        while (it.hasNext()){
            Account account = it.next();

            account.printAccountData();
        }
    }

    public Account findAccount(String serial){
        Iterator<Account> it = accounts.iterator();

        while (it.hasNext()){
            Account account = it.next();

            if(account.checkSerial(serial))
                return account;
        }
        return null;
    }

    public User findUser(String ID){
        Iterator<User> it = users.iterator();

        while (it.hasNext()){
            User user = it.next();

            if(user.checkId(ID))
                return user;
        }

        return null;
    }
}