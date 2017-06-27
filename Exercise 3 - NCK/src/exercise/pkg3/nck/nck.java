/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.pkg3.nck;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class nck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int totalSetNbr;
        int nbrOfChoices;
        int binomialCoefficient;
        int n;
        int k;

        // user input mechanism
        Scanner scan = new Scanner(System.in);
        System.out.println("How many things does the set contain(n)?");

        totalSetNbr = scan.nextInt();

        //Restrict input to positive numbers
        if (totalSetNbr <= 0) {
            System.out.println("Please ensure you enter a positive number");

            // else continue operation
        } else {
            n = factorial(totalSetNbr);

            System.out.println("How many things are you choosing(k)?");
            nbrOfChoices = scan.nextInt();

            //check that 'n' is greater than 'k'
            if (totalSetNbr < nbrOfChoices) {
                System.out.println("'k' cannot be greater than 'n'");
            } else {

                // method call
                k = factorial(nbrOfChoices);

                //main program logic
                binomialCoefficient = (n / (k * (totalSetNbr - nbrOfChoices)));

                // output statement
                System.out.println("Disregarding order, there are " + binomialCoefficient + " way(s) to choose " + nbrOfChoices + " thing(s) from " + totalSetNbr + " things");
            }
        }
    }

    //calculate the factorials of the passed in values
    public static int factorial(int z) {
        int i;
        int factorial = 1;

        // factorial calculation
        for (i = 1; i <= z; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
/*Exercise 4
 Pre Conditions: (totalSetNbr <= 0), (totalSetNbr < nbrOfChoices), (i<=z)
 Post Conditions: factorials of n and k are returned, 'binomialCoefficient' is evaluated
 */
