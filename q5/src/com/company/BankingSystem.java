package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void register(User user){users.add(user);}

    public void login(String id, String password){
        Iterator<User> it = users.iterator();
        boolean isId = false;

        while (it.hasNext()){
           User user = it.next();

           if(user.getId().equals(id)){
               isId = true;

               if(user.getPassword().equals(password))
                   System.out.println("logged in.");
               else
                   System.out.println("wrong password.");
           }
        }
        if(!isId)
            System.out.println("there is no user with that id: " + id);
    }

    public void addUser(User user){users.add(user);}

    public void removeUser(User user){users.remove(user);}

    public void displayUsers(){
        Iterator<User> it = users.iterator();

        while (it.hasNext()){
           User user = it.next();

           user.printUserData();
        }
    }

    public void addAccount(Account account){

    }
/*

    removeAccount(Account account)

    displayAccounts()
    findAccount(String serial)
 */
}

