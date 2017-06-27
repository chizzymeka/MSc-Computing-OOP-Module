/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irrationalnumber;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class IrrationalNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        double factorial = 1;
        double e = 1;
        
        
        //user input mechanism
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        num = scan.nextInt();
        
        int i;
        
        
        //ensure input is between '1' and '20'
        if(num<0 || num>20){
            System.out.println("Please ensure you the number is between"
                    + " '1' and '20'");
        
        //Print the mathematical constant for '0'
        }else if(num == 0){
            System.out.println("The mathematical constant (e) of '0' is 1");
        
        //main program logic
        }else{
            for(i=1; i<=num; i++){
                factorial = factorial*i;
                e = e + 1/factorial;
            }
            System.out.println("");
            System.out.println("The mathematical constant (e) "
                    + "of " + num + " is " + e);
        }
    }
}
