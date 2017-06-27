/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.pkg2.power;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Power {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int base;
        int exponent;
        double value;
        
        //loop mechanism
        do {
            //user input mechanism
            System.out.println("Enter two numbers, if the second number is negative, we quit: ");
            base = scan.nextInt();
            exponent = scan.nextInt();

            // second input positive number restriction
            if (exponent >= 0) {
                
                // method call
                value = power(base, exponent);
                
                // output statement
                System.out.println("");
                System.out.println("The value of " + base + " raised to the power " + exponent + " is " + value);
            }
        //quit mechanism
        } while (exponent >= 0);
    }

    public static double power(int x, int y) {
        //calculate base to the power of exponent
        double p = pow(x, y);
        return p;
    }
}
/*Exercise 4
 Pre Conditions: (exponent >= 0)
 Post Conditions: 'value' is returned
 */
