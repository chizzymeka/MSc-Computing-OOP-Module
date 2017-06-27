/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salestax;

//Import statments
import java.util.Scanner;
import java.text.*;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class SalesTax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //identifier declarations
        double vatRate = 0.2;
        double price;
        double tax; //Changed type to double to avoid lossy conversions
        double total;
        String item;

        //create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in); //Missing semi-colon added

        //display prompts and get input
        System.out.print("Item description:  "); //Switched 'char' to "string"
        item = keyboard.nextLine();
        System.out.print("Item price:  ");
        price = keyboard.nextDouble();
        System.out.println("--------------------");

        //calculations
        tax = (vatRate * price); // Amended from tax = price + vatRate;
        total = price + tax; // Amended from total = price * tax;
        
        //Decimal formatting to better represent the output monetary values
        DecimalFormat decFor = new DecimalFormat("0.00");
        
        //display results
        System.out.print(item + "        £");
        System.out.println(decFor.format(price));
        System.out.print("VAT          £");
        System.out.println(decFor.format(tax));
        System.out.print("Total        £");
        System.out.println(decFor.format(total));
    }    
}
