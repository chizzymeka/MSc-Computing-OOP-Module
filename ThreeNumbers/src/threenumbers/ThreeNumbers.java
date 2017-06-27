/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threenumbers;

import java.util.Scanner;

/**
 *
 * @author chizz
 */
public class ThreeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x,y,z,sum;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the first number ");
        x = scan.nextInt();
        
        System.out.println("Enter the second number ");
        y = scan.nextInt();
        
        System.out.println("Enter the third number ");
        z = scan.nextInt();
        
        sum = x + y + z;
        
        if(sum >= 50){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
    
}
