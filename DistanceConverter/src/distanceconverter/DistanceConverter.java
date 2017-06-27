/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distanceconverter;

import java.util.Scanner;

/**
 *
 * @author chizz
 */
public class DistanceConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double distance;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the distance in miles");
        distance = scan.nextDouble();
        System.out.println(distance +" Miles is equivalent to around " + (distance * 1.60934) + "KM");
    }
    
}
