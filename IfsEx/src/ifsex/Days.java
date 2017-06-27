/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsex;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */

public class Days {
   public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);     
 	int number; // To hold keyboard input
     
        // Ask the user to enter a number.
        System.out.print("Enter a number between 1 and 5 ");
        number = keyboard.nextInt();

	// Determine which number the user entered.
        switch (number)
        {
        case 1:
            System.out.println("Monday");
            break;
        case 2:
            System.out.println("Tuesday");
            break;
        case 3:
            System.out.println("Wednesday");
            break;
	case 4:
            System.out.println("Thursday");
            break;
	case 5:
            System.out.println("Friday");
            break;
        default:
            System.out.println("Incorrect answer");
        }
    }
}