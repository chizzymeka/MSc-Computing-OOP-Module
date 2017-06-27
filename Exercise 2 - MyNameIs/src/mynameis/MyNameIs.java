/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynameis;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing
 */
public class MyNameIs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str;
        String mn = "My name is";

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String in the form of (My name is + name)");
        str = scan.nextLine();
        StringBuilder strb = new StringBuilder(str);

        if ((strb.substring(0, 10)).equals(mn)) {
            System.out.println("Hello " + strb.substring(10));
        } else {
            System.out.println("I did not understand your input, please try again");
        }
    }

}
