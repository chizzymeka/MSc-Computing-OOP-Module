/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.exercise;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BankAccount ac = new BankAccount(34567);

        for (int i = 0; 1 < 20; i++) {
            System.out.println("Please press '1', to make a deposit, '2' to make a withdrawal and '3' to view your balance");

            switch (scan.nextInt()) {
                case 1:
                    double depositAmount;
                    System.out.println("Please enter the amount you wish to deposit");
                    depositAmount = scan.nextDouble();
                    ac.deposit(34567, depositAmount);
                    System.out.println("The balance of account " + ac.getAccountNumber() + " is " + ac.getBalance(34567));
                    break;
                case 2:
                    double withdrawAmount;
                    System.out.println("Please enter the amount you wish to withdraw");
                    withdrawAmount = scan.nextDouble();
                    ac.withdraw(34567, withdrawAmount);
                    System.out.println("The balance of account " + ac.getAccountNumber() + " is " + ac.getBalance(34567));
                    break;
                case 3:
                    System.out.println("The balance of account " + ac.getAccountNumber() + " is " + ac.getBalance(34567));
                    break;
                default:
                    System.out.println("Please ensure you choose the right option: '1', '2' or '3'");
            }
        }
    }
}
