/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perimetercalculator;

//Import statement to make the scanner class available for use in our program
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class PerimeterCalculator {

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
        System.out.println("Input the length of the rectangle to the "
                + "approximate whole number: ");
        //Variable initialization
        length = scan.nextDouble();

        //User prompt
        System.out.println("Input the width of the rectangle to the "
                + "approximate whole number: ");
        //Variable initialization
        width = scan.nextDouble();
        
        //Decimal place formatter
        DecimalFormat decFor = new DecimalFormat("0.00");
        
        //Output and main program logic
        System.out.println("The perimeter of your rectangle is: "
                + (2 * (length + width)) + " and the length of "
                + "the diagonal is "
                + decFor.format(Math.sqrt((length * length) + 
                        (width * width))));

    }

}
