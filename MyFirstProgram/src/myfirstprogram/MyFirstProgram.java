/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprogram;

import java.util.Scanner;

/**
 *
 * @author chizz
 */
public class MyFirstProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int z, y, sum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number > ");
        z = scan.nextInt();
        System.out.println("Enter another number > ");
        y = scan.nextInt();
        sum = z+y;
        System.out.println(sum);
    }
    
}
