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
public class BankAccount {

    private int accountNumber;
    private double balance;
    private double interestRate; // interest Rate for the account

    // constructors
    public BankAccount() {
        balance = 0;
        interestRate = 0.06; // all the accounts have an 6% interest Rate
    }

    public BankAccount(int number) {
        this.accountNumber = number;
        interestRate = 0.06; // all the accounts have an 6% interest Rate
    }
    
    public BankAccount(int number, double initialBalance) {
        this.accountNumber = number;
        balance = balance + initialBalance;
        interestRate = 0.06; // all the accounts have an 6% interest Rate
    }

    // methods
    // return the number of the account
    public int getAccountNumber() {
        return accountNumber;
    }

    // return the balance of the account
    public double getBalance(int number) {
        return balance;
    }

    // add the amount to the balance
    public void deposit(int number, double amount) {
        balance = balance + amount;
    }

    // substract amount from the balance
    public void withdraw(int number, double amount) {
        if ((balance + 0.10) >= amount){
            balance = ((balance - amount) - 0.10);
            System.out.println("Withdrawal processed!, your balance is now " + balance);
        }else{
            System.out.println("Sorry, you do not have enough balance to make a withdraw");
        }
    }

    public boolean canWithdraw(double amount) {
        boolean withdrawal = false;

        if (balance > (amount + 0.10)) {
            withdrawal = true;
        }
        return withdrawal;
    }

    public double calculateInterest(int number) {
        return balance * interestRate;
    }
}
