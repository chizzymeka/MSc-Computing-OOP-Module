/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    
      
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Ener your name> ");
        String name = scan.nextLine();
        System.out.println("Enter a number> ");
        int firstNum = scan.nextInt();
        System.out.println("Enter another number> ");
        int secondNum = scan.nextInt();
        int sum = firstNum + secondNum;
        System.out.println("Dear " + ", name + "
                + "the sum of your numbers is " + sum);
    }
}
