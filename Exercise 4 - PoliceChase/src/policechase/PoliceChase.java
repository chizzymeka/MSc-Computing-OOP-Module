/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policechase;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class PoliceChase {

    /**
     * @param args the command line arguments
     */
    double x;
    double y;
    double d;
    double t;

    Scanner scan = new Scanner(System.in);

    public void Input() {
        System.out.println("");
        System.out.println("What is the speed of the "
                + "runner in km/hr? ");
        x = scan.nextDouble();

        System.out.println("");
        System.out.println("What is the speed of the police unit"
                + " in pursuit in km/hr? ");
        y = scan.nextDouble();

        Test();
    }

    public void Test() {
        if (y > x) {
            Evaluate();
        } else {
            System.out.println("The police unit must be "
                    + "travelling faster than the runner, "
                    + "for it to be abe to catch up!");
            System.out.println("");
            System.out.println("Having said that, let's "
                    + "start again!");
            System.out.println("");
            Input();
        }
    }

    public void Evaluate() {
        System.out.println("");
        System.out.println("What is the distance between the "
                + "police and the speeder in km? ");
        d = scan.nextDouble();

        t = (d / (y - x));

        DecimalFormat decFor = new DecimalFormat("0.00");
        
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println("It will take the police about " +
                decFor.format(t * 60) + " "
                + "minutes to catch up with the perpetrator!");
    }

    public static void main(String[] args) {
        PoliceChase pc = new PoliceChase();
        pc.Input();
    }
}
