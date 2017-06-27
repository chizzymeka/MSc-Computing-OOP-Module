/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder strdrv;
        String tostrb;
        String str;
        String tostrbrv;

        // create scanner object
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String");

        // initialise string variable with user input
        str = scan.nextLine();

        //pass the input into a string builder object
        StringBuilder strb = new StringBuilder(str);

        // convert the string builder object to a string object for equality check purposes and change it to lower case, clear white spaces and non word characters at the same time
        tostrb = (((strb.toString()).toLowerCase()).replace(" ", "")).replaceAll("[\\W]", "");

        // reverse same string builder object
        strdrv = strb.reverse();

        // convert the string builder object to a string object, again for equality check purposes and change it to lower case, clear white spaces and non word characters at the same time
        tostrbrv = (((strdrv.toString()).toLowerCase()).replace(" ", "")).replaceAll("[\\W]", "");
        System.out.println(tostrbrv);

        // equality check
        if (tostrb.equals(tostrbrv)) {
            System.out.println("This string is a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}