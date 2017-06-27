/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.exercise;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class BankAccountExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the first account with an initial balance of £0
        BankAccount myAccount = new BankAccount(12345,0);
        // show the balance of the first account
        System.out.println("The balance of account " + myAccount.getAccountNumber() + " is now " + myAccount.getBalance(12345));
        
        // create the second account with an initial balance of £1000
        BankAccount myOtherAccount = new BankAccount(54321,1000);
        // show the balance of the second account
        System.out.println("The balance of account " + myOtherAccount.getAccountNumber() + " is now " + myOtherAccount.getBalance(12345));
        
        // deposit £50 into the first account
        myAccount.deposit(12345, 50);
        // show the balance of the first account
        System.out.println("The balance of account " + myAccount.getAccountNumber() + " is now " + myAccount.getBalance(12345));
        
        // withdraw £25 form the first account
        myAccount.withdraw(12345, 25);
        // show the balance of the first account
        System.out.println("The balance of account " + myAccount.getAccountNumber() + " is now " + myAccount.getBalance(12345));
        
        // calculate the interest of the second account
        System.out.println("The interest of account " + myOtherAccount.getAccountNumber() + " is " + myOtherAccount.calculateInterest(54321));
        
        // deposit the interest of my second account into the first account
        myAccount.deposit(12345, myOtherAccount.calculateInterest(12345));
        
        // show the balance of the first account
        System.out.println("The balance of account " + myAccount.getAccountNumber() + " is now " + myAccount.getBalance(12345));
        
        // Withdrawal possiblity from first account
        System.out.println(myAccount.canWithdraw(500));
        
        // Withdrawal possiblity from first account
        System.out.println(myOtherAccount.canWithdraw(500));
    }
}
