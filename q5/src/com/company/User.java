package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private final String id;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Account>  accountList = new ArrayList<>();

    public User(String id, String fName, String lName, String password){
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.password = password;
    }

    /**
     * @param account is added to the user accounts
     * */
    public void addAccount(Account account){accountList.add(account);}

    /**
     * @param serial clarifies the account to remove
     * */
    public void removeAccount(String serial){
        Iterator<Account> accounts = accountList.iterator();

        while (accounts.hasNext()){
            Account account = accounts.next();

            if(account.checkSerial(serial))
                accountList.remove(account);
        }
    }

    /**
     * @param account to be charged
     * @param amount to send to the account
     * */
    public void deposit(Account account, int amount){
        account.updateBalance(amount);
        account.addTransaction(new Transaction(amount));

        System.out.println("Completed.");
    }

    /**
     * checks the conditions
     * @param account to get money from
     * @param amount money to get from
     * */
    public  void withdrawal(Account account , int amount){
        if (!accountList.contains(account))
            System.out.println("The account does not belong to you.");

        else if(account.getBalance() - amount < 0)
            System.out.println("There is not enough money to withdrawal.");

        else {
            account.addTransaction(new Transaction(-amount));
            account.updateBalance(-amount);

            System.out.println("Completed.");
        }
    }

    /**
     * checks the conditions
     * @param srcAccount sends money
     * @param destAccount receives money
     * @param amount mooney to send from srcAccount to the destAccount
     * */
    public void transfer(Account srcAccount, Account destAccount, int amount){
        if(!accountList.contains(srcAccount))
            System.out.println("the account does not belong to you.");

        else if(srcAccount.getBalance() - amount < 0)
            System.out.println("There is not enough money to transfer.");

        else{
            srcAccount.addTransaction(new Transaction(-amount));
            srcAccount.updateBalance(-amount);

            destAccount.updateBalance(amount);
            destAccount.addTransaction(new Transaction(amount));

            System.out.println("Completed.");
        }
    }

    /**
     * @param account to print the remaining money
     * */
    public void checkBalance(Account account) {System.out.println("balance: " + account.getBalance());}

    /**
     * demonstrates the User Accounts Data
     * */
    public void printAllAvailableAccount(){
        for (int i = 0;i < accountList.size();i++){
            System.out.printf("Account %d: ", 1 + i);
            accountList.get(i).printAccountData();
        }
    }

    /**
     * demonstrates the User Data
     * */
    public void printUserData(){System.out.println("id: " + id + ", Name: " + firstName + " " + lastName + ", password: " + password + ", Number of accounts: " + accountList.size());}

    /**
     * @return true if the given user is equal to the main user
     * */
    public Boolean isSame(User user){
        if(user.checkId(id))
            return true;

        return false;
    }

    /**
     * @return true if the user wants to get back to the main menu by entering -1 otherwise returns false
     * */
    public Boolean notBack(){
        if(firstName.equals("-1") || lastName.equals("-1") || id.equals("-1") || password.equals("-1"))
            return false;

        return true;
    }

    /**
     * @param id is checked with the user id
     * */
    public Boolean checkId(String id){
        if(this.id.equals(id))
            return true;

        return false;
    }

    /**
     * @param pass is compared with the user password
     * */
    public Boolean checkPassword(String pass){
        if(pass.equals(password))
            return true;

        return false;
    }

    public ArrayList<Account> getAccountList(){return accountList;}

    public String getFirstName(){return firstName;}

    public String getlastName(){return lastName;}
}