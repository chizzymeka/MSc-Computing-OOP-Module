/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial2;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Factorial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //user input
        Scanner scan = new Scanner(System.in);
        int val;
        
        //loop mechanism
        do {
            System.out.println("Enter a number (-1 to quit)");
            val = scan.nextInt();

            if (val >= 0) {
                //method call
                factorial(val);
            }
        // quit mechanism
        } while (val != -1);
    }

    public static void factorial(int n) {
        int i;
        int fact = 1;

        //main program logic
        for (i = n; i > 0; i--) {
            fact = fact * i;
        }
        System.out.println("The factorial of " + n
                + " is " + fact);
    }
}
/*Exercise 4
 Pre Conditions: (val >= 0), while(val != -1)
 Post Conditions: factorial of n is returned
 */
