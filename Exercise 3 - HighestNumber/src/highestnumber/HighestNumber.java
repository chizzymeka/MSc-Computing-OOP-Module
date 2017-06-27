/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highestnumber;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class HighestNumber {
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int highest;
        int number;
        
        //user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scan.nextInt();
        highest = number;
        
        //main program logic
        while(number !=0){
            if (number > highest){
                highest = number;
            }
            System.out.println("");
            System.out.println("Enter another number");
            number = scan.nextInt();
        }
        //show highest number entered
        System.out.println("");
        System.out.println("The highest number you entered is " + highest);
    }
    
}
