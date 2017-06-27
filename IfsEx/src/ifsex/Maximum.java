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
public class Maximum {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n1;
        int n2;
        
        System.out.println("Enter the first number");
        n1 = input.nextInt();
    
        System.out.println("Enter the second number");
        n2 = input.nextInt();
        
        if (n1 >n2){
            System.out.println("The first number is greater");
        }else if (n1<n2){
            System.out.println("The second number is greater");
        }else{
            System.out.println("The numbers are equal");
        }
    }
}
