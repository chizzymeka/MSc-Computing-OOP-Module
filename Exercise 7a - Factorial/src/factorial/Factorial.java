/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Factorial {
    int number;
    int factorial = 1;
    
    public void calculate(){
        //user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        number = scan.nextInt();
        
        int i;
        
        //Restrict input to positive numbers
        if(number<0){
            System.out.println("Please ensure you enter a positive number");
        //Print the factorial of '0'
        }else if(number == 0){
            System.out.println("The factorial of '0' is 1");
        //main program logic
        }else{
            for(i=1; i<=number; i++){
                factorial = factorial*i;
            }
            System.out.println("");
            System.out.println("The factorial of " + number 
                    + " is " +factorial);
        }
    }
    
               
    public static void main(String[] args) {
        Factorial f = new Factorial();
        f.calculate();
    }
}