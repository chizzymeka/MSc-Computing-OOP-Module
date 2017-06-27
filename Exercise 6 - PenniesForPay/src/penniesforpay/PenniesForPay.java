/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penniesforpay;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class PenniesForPay {
    
    //Code for negative value
    
    public static void main(String[] args) {
        int days;
        double totalPay = 0;
        int i;
        
        //user input mechanism
        Scanner scan = new Scanner(System.in);
        System.out.println("How many days pay do you want to calculate?");
        days = scan.nextInt();

        //check to ensure the days is equal to or more than 1
        if(days <= 0){
            System.out.println("Number of days cannot be negative or zero!");
            
        //main program logic
        }else if(1 == days){
            System.out.println("The total pay will be 1 Penny");
        }else{
            for(i=1; i<=days; i++){
                totalPay = Math.pow(2,(days-1));
            }
        
        //Maximum range limiter
        if(days > 30){
            System.out.println("OUT OF RANGE! - The value is too big "
                + "to show, key in fewer days.");
            
        //Conversion of pennies to pounds if pennies amount to 100 or above
        }else if(totalPay>100){
            System.out.println("£ " + (totalPay/100));
        }else{      
                System.out.println("The total pay will be " + 
                   Math.round(totalPay)+ " pennies");
            }
        }
    }
}