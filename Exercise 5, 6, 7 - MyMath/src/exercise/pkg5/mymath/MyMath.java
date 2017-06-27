/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.pkg5.mymath;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class MyMath {

    static int number;

//Exercise 6
    public static void main(String[] args) {
        int firstNbr;
        int secondNbr;
        int thirdNbr;
        int sum;
        int product;
        char pressedKey;
        int max;

        do {
            //options user input mechanism
            Scanner keyboard = new Scanner(System.in);
            System.out.println("");
            System.out.println("Press 'a' for addition, 'm' for multiplication or 'q' to quit");
            pressedKey = keyboard.next(".").charAt(0);

            //addition section
            if (pressedKey == 'a') {
                System.out.println("");
                System.out.println("Input the three numbers you want to add");
                System.out.println("Enter the first number: ");
                firstNbr = keyboard.nextInt();

                System.out.println("Enter the Second number: ");
                secondNbr = keyboard.nextInt();

                System.out.println("Enter the Third number: ");
                thirdNbr = keyboard.nextInt();

                sum = addIntegers(firstNbr, secondNbr, thirdNbr);
                System.out.println("The sum of the numbers is " + sum);

                max = maxNumber(firstNbr, secondNbr, thirdNbr);
                System.out.println("");
                System.out.println("...and highest number you entered is " + max);

                //multiplication section
            } else if (pressedKey == 'm') {
                System.out.println("");
                System.out.println("Input the three numbers you want to multiply");
                System.out.println("Enter the first number: ");
                firstNbr = keyboard.nextInt();

                System.out.println("Enter the Second number: ");
                secondNbr = keyboard.nextInt();

                System.out.println("Enter the Third number: ");
                thirdNbr = keyboard.nextInt();

                product = multiplyIntegers(firstNbr, secondNbr, thirdNbr);
                System.out.println("The product of the numbers is " + product);

                max = maxNumber(firstNbr, secondNbr, thirdNbr);
                System.out.println("");
                System.out.println("...and highest number you entered is " + max);
            }
            //program end mechanism
        } while (pressedKey != 'q');
    }

    //Exercise 7
    public static int maxNumber(int e, int f, int g) {
        if ((e >= f) && (e >= g)) {
            number = e;
        } else if ((f >= e) && (f >= g)) {
            number = f;
        } else if ((g >= e) && (g >= f)) {
            number = g;
        }
        return number;
    }

    //Exercise 5
    public static int addIntegers(int e, int f, int g) {
        int h = e + f + g;

        return h;
    }

    public static int multiplyIntegers(int p, int q, int r) {
        int s = p * q * r;

        return s;
    }
}
