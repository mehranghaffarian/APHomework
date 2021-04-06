package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    /**
     * @param user is added to the bank system if there is no problem
     * */
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

    /**
     * @param id is checked with the ids from the bank list
     * @param password is checked with the user which has the given id
     * @return user with the given id and password, if not found returns null
     * */
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

    /**
     * @param user is added to the bank list
     * */
    public void addUser(User user){users.add(user);}

    /**
     * @param user and its accounts are removed from the bank system
     * */
    public void removeUser(User user) {
        accounts.removeIf(account -> user.getAccountList().contains(account));
        users.remove(user);
        System.out.println("User removed.");
    }
    /**
     *all the users in the bank system are listed
     * */
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

    /**
     * @param account is removed from both bank system and the user who owns it
     * */
    public void removeAccount(Account account){
        accounts.remove(account);

        Iterator<User> usersIt = users.iterator();

        while (usersIt.hasNext()){
            User user = usersIt.next();

            user.removeAccount(account.getSerial());
        }
    }

    /**
     * exhibits the all accounts
     * */
    public void displayAccounts(){
        Iterator<Account> it = accounts.iterator();

        while (it.hasNext()){
            Account account = it.next();

            account.printAccountData();
        }
    }

    /**
     * @param serial is searched among the users serials
     * @return an account with the given serial or returns null
     * */
    public Account findAccount(String serial){
        Iterator<Account> it = accounts.iterator();

        while (it.hasNext()){
            Account account = it.next();

            if(account.checkSerial(serial))
                return account;
        }
        return null;
    }

    /**
     * @param ID is searched among the users ids
     * @return an user with the given ID or returns null
     * */
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