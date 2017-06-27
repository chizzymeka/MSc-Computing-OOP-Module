/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watertemperature;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class WaterTemperature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int temp;

        //user input mechanism
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type the temperature in celsius");
        temp = scan.nextInt();

        //Checking when water will freeze
        if (temp<=0) {
            System.out.println("");
            System.out.println("Water will solidify at this temprature");
        //Checking when water will liquefy
        }else if(temp>0 & temp<100){
            System.out.println("");
            System.out.println("Water will liquify at this temprature");
        }
        //Checking when water will evaporate
        else if (temp>=100) {
            System.out.println("");
            System.out.println("Water will turn to gas at this temprature");
        }
    }

}
