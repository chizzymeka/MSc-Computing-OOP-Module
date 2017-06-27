/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areacalculator;

//Import statement to make the scanner class available for use in our program
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class AreaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable delcarations
        double length;
        double width;

        //User input mechanism
        Scanner scan = new Scanner(System.in);

        //User prompt
        System.out.println("Input the length of the rectangle: ");
        //Variable initialization through user input
        length = scan.nextDouble();

        //User prompt
        System.out.println("Input the width of the rectangle: ");
        //Variable initialization through user input
        width = scan.nextDouble();

        //Output and main program logic
        System.out.println("The area of rectangle is: " + (length * width));
    }

}
