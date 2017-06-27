/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumproductdivision;

import java.util.Scanner;

/**
 *
 * @author chizz
 */
public class SumProductDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double x,y;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the first number ");
        x = scan.nextDouble();
        
        System.out.println("Enter the second number ");
        y = scan.nextDouble();
        
        System.out.println("");
        System.out.println("The sum of the numbers is " + (x+y));
        System.out.println("The product of the numbers is " + (x*y));
        System.out.println("The result of dividing the number by the second is " + (x/y));
        
    }
    
}
