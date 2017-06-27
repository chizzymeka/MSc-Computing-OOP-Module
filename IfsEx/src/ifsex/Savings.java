/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsex;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Savings {
    public static void main(String [] args){
        int year = 0;
        double balance = 10000;
        double invest;
        invest = balance;
        
        while(invest < 2*balance){
            year++;
            invest = invest + (0.05*invest);
        }
        
        System.out.println("you will double your investment in " +year+ " "
                + "years to double your investment");
    }
}
