/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threebythree;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing (2016/2017)
 */
public class ThreeByThree {

    /**
     * @param args the command line arguments
     */
    static char[][] threeMatrix = new char[3][3];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            //character user input
            System.out.println("Character?");
            char c = scan.nextLine().charAt(0);

            //row user input
            System.out.println("Please choose a number between 1 and 3 for the row?");
            int row = scan.nextInt();
            scan.nextLine();

            //column user input
            System.out.println("Please choose a number between 1 and 3 for the column?");
            int column = scan.nextInt();
            scan.nextLine();

            //reduce the row user input by one to ensure it matches correct array index
            int ro;
            ro = row - 1;

            //reduce the column user input by one to ensure it matches correct array index
            int co;
            co = column - 1;

            //method calls
            setArray(c, ro, co);
            printArray();
        }
    }

    public static void setArray(char ch, int r, int c) {
        //iterate through rows
        for (int row = 0; row < threeMatrix.length; row++) {
            //iterate through columns
            for (int column = 0; column < threeMatrix[row].length; column++) {
                //fill in the arrays with character '.'
                threeMatrix[column][row] = '.';
                // add the user's specified charcater at the specified coordinate
                threeMatrix[c][r] = ch;
            }
        }
    }

    public static void printArray() {
        System.out.println();
        for (int row = 0; row < threeMatrix.length; row++) {
            for (int column = 0; column < threeMatrix[row].length; column++) {
                System.out.print(threeMatrix[column][row]);
            }
            System.out.println();
        }
    }
}
