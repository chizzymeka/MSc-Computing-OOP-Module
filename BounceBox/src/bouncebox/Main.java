/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncebox;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author p0073862
 */
public class Main {

    static int a, b, c, d, e, f, g, h, i, j;

    static int z;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //setUpDemo1();
        //For exercise 2, comment out the line above, and uncomment the one
        //below
        //simpleDemo();
        addShapes();
    }

    public static void setUpDemo1() {
        BounceBox box = new BounceBox(700, 500);

        Circle c1 = new Circle(20, 50, 20);
        c1.setColor(Color.BLUE);
        c1.setVelocity(100, 0);

        Circle c2 = new Circle(300, 50, 20);
        c2.setColor(Color.CYAN);
        Circle c3 = new Circle(360, 50, 20);
        c3.setColor(Color.MAGENTA);
        Circle c4 = new Circle(420, 50, 20);
        c4.setColor(Color.ORANGE);
        Circle c5 = new Circle(480, 50, 20);
        c5.setColor(Color.PINK);
        Circle c6 = new Circle(540, 50, 20);
        c6.setColor(Color.RED);
        Circle c7 = new Circle(400, 440, 40);
        c7.setColor(Color.CYAN);
        c7.setVelocity(30, 30);

        Circle c8 = new Circle(300, 440, 40);
        c8.setColor(Color.BLUE);
        c8.setVelocity(30, 20);

        Circle c9 = new Circle(500, 440, 40);
        c9.setColor(Color.GREEN);
        c9.setVelocity(-20, 30);

        Circle c10 = new Circle(120, 50, 20);
        c10.setColor(Color.CYAN);
        Circle c11 = new Circle(180, 50, 20);
        c11.setColor(Color.ORANGE);
        Circle c12 = new Circle(240, 50, 20);
        c12.setColor(Color.PINK);

        Square s1 = new Square(120, 120, 40);
        s1.setColor(Color.BLUE);
        s1.setVelocity(30, 20);

        Square s2 = new Square(240, 120, 40);
        s2.setColor(Color.GREEN);
        s2.setVelocity(-20, 30);

        //c2.setVelocity(-100,0);
        box.addCircle(c1);
        box.addCircle(c2);
        box.addCircle(c3);
        box.addCircle(c4);
        box.addCircle(c5);
        box.addCircle(c6);
        box.addCircle(c7);
        box.addCircle(c8);
        box.addCircle(c9);
        box.addCircle(c10);
        box.addCircle(c11);
        box.addCircle(c12);

        box.addSquare(s1);
        box.addSquare(s2);

        box.start();
    }

    public static void simpleDemo() {
        //Implement this as exercise 2
        BounceBox box = new BounceBox(700, 500);

        Circle c13 = new Circle(40, 50, 40);
        c13.setColor(Color.BLUE);
        c13.setVelocity(100, 0);

        Square s3 = new Square(560, 50, 45);
        s3.setColor(Color.RED);
        s3.setVelocity(-100, 0);

        box.addCircle(c13);
        box.addSquare(s3);

        box.start();
    }

    public static void addShapes() throws FileNotFoundException {
        BounceBox box = new BounceBox(700, 500);

        FileInputStream fileIn = new FileInputStream("ex4.txt");
        Scanner scan = new Scanner(fileIn);

        /*while(scan.hasNext()){
         if (scan.next().equalsIgnoreCase("Circle")) {
         //Obtian values for the first circle
         if (scan.hasNextInt()) {
         a = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         b = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         c = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         d = scan.nextInt();
         }//else if (!scan.hasNextInt()){
         // Circle c15 = new Circle(a, b, c);
         //box.addCircle(c15);
         //}
         if (scan.hasNextInt()) {
         e = scan.nextInt();
         }
         } else {
         System.err.println("Circle cannot be drawn as the required values cannot be found in the file");
         }

         if (scan.next().equalsIgnoreCase("Square")) {
         //Obtian values for the Square
         if (scan.hasNextInt()) {
         f = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         g = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         h = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         i = scan.nextInt();
         }
         if (scan.hasNextInt()) {
         j = scan.nextInt();
         }
         } else {
         System.err.println("Square cannot be drawn as the required values cannot be found in the file");
         }

         Circle c14 = new Circle(a, b, c);
         c14.setVelocity(d, e);

         Square s4 = new Square(f, g, h);
         s4.setVelocity(i, j);

         box.addCircle(c14);
         box.addSquare(s4);
         box.start();
         }
         }*/
        while (scan.hasNext()) {
            String shape = scan.next();
            
            if (shape.equalsIgnoreCase("Circle")) {
                circleHandler(scan, box);
            }
            
            if (shape.equalsIgnoreCase("Square")) {
                squareHandler(scan, box);
            }
            box.start();
        }
    }

    public static void circleHandler(Scanner scan, BounceBox box) {

        //if (scan.next().equalsIgnoreCase("Circle")) {
            //while (z < scan.nextInt()) {
                //z++;

                //if (z == 5) {
                    int xCoordinate = scan.nextInt();
                    int yCoordinate = scan.nextInt();
                    int radius = scan.nextInt();
                    int xVelocity = scan.nextInt();
                    int yVelocity = scan.nextInt();
                    Circle c14 = new Circle(xCoordinate, yCoordinate, radius);
                    c14.setVelocity(xVelocity, yVelocity);
                    box.addCircle(c14);
                //} else if (z == 3) {
                    //int xCoordinate = scan.nextInt();
                    //int yCoordinate = scan.nextInt();
                    //int radius = scan.nextInt();
                    //Circle c14 = new Circle(xCoordinate, yCoordinate, radius);
                    //box.addCircle(c14);
                //}
            //}
        //}
    }

    public static void squareHandler(Scanner scan, BounceBox box) {

        //if (scan.next().equalsIgnoreCase("Square")) {
            //while (z < scan.nextInt()) {
                //z++;

                //if (z == 5) {
                    int xCoordinate = scan.nextInt();
                    int yCoordinate = scan.nextInt();
                    int radius = scan.nextInt();
                    int xVelocity = scan.nextInt();
                    int yVelocity = scan.nextInt();
                    Square s4 = new Square(xCoordinate, yCoordinate, radius);
                    s4.setVelocity(xVelocity, yVelocity);
                    box.addSquare(s4);
                //} else if (z == 3) {
                    //int xCoordinate = scan.nextInt();
                    //int yCoordinate = scan.nextInt();
                    //int radius = scan.nextInt();
                    //Square s4 = new Square(xCoordinate, yCoordinate, radius);
                    //box.addSquare(s4);
                //}
            //}
        //}
    }
}
