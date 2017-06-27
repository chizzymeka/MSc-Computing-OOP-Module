package courseworkone;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing (2016/2017)
 */
public class Game {

    static char[][] tenByTen = new char[10][10];
    static int moveCounter;
    static int doughnutCounter;

    public static void main(String[] args) {
        System.out.println("Press 'U' to move up, 'D' to move down, 'L' to move left and 'R' to move right");

        // provide the coordinates for the initialisation of the player and home positions
        boardManager(0, 9, 9, 0);
    }//end of main method

    public static void boardManager(int cP, int rP, int cH, int rH) {

        //iterate through rows
        for (int row = 0; row < tenByTen.length; row++) {

            //iterate through columns
            for (int column = 0; column < tenByTen[row].length; column++) {

                //fill both arrays with the character '.'
                tenByTen[column][row] = '.';

                //set initial player position
                tenByTen[cP][rP] = 'P';

                // set home position
                tenByTen[cH][rH] = 'H';
            }
        }
        elementManager(cP, rP, cH, rH);

        // display the new state of the boardManager
        displayManager();

        // pass the values for the position of 'P' and 'H' to the userInputManager method
        userInputManager(cP, rP, cH, rH);
    }

    public static void elementManager(int cP, int rP, int cH, int rH) {
        //if the player reaches home, terminate program
        if (tenByTen[cP][rP] == tenByTen[cH][rH]) {
            for (int row = 0; row < tenByTen.length; row++) {
                for (int column = 0; column < tenByTen[row].length; column++) {
                    if (tenByTen[column][row] == 'P') {
                        tenByTen[column][row] = '.';
                    }
                }
            }
        }

    }
    //end of boardManager method

    public static void displayManager() {
        System.out.println();
        for (int row = 0; row < tenByTen.length; row++) {
            for (int column = 0; column < tenByTen[row].length; column++) {
                System.out.print(tenByTen[column][row] + " ");
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("Number of moves made so far: " + moveCounter);
        System.out.println("Number of doughnuts eaten so far: " + doughnutCounter);
    }//end of displayManager method

    public static void userInputManager(int cP, int rP, int cH, int rH) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            char inputCharacter = scan.nextLine().charAt(0);
            switch (inputCharacter) {
                case 'u':
                    if (rP == 0) {
                        System.out.println("Sorry, that move takes you off the board");
                    } else {
                        moveCounter++;
                        tenByTen[cP][rP - 1] = 'P';
                        tenByTen[cP][rP] = '.';
                        boardManager(cP, rP - 1, cH, rH);
                    }
                    break;
                case 'd':
                    if (rP == 9) {
                        System.out.println("Sorry, that move takes you off the board");
                    } else {
                        moveCounter++;
                        tenByTen[cP][rP + 1] = 'P';
                        tenByTen[cP][rP] = '.';
                        boardManager(cP, rP + 1, cH, rH);
                    }
                    break;
                case 'l':
                    if (cP == 0) {
                        System.out.println("Sorry, that move takes you off the board");
                    } else {
                        moveCounter++;
                        tenByTen[cP - 1][rP] = 'P';
                        tenByTen[cP][rP] = '.';
                        boardManager(cP - 1, rP, cH, rH);
                    }
                    break;
                case 'r':
                    if (cP == 9) {
                        System.out.println("Sorry, that move takes you off the board");
                    } else {
                        moveCounter++;
                        tenByTen[cP + 1][rP] = 'P';
                        boardManager(cP + 1, rP, cH, rH);
                        tenByTen[cP][rP] = '.';
                    }
                    break;
                default:
                    System.out.println("Please ensure you enter the correct character: 'U', 'D', 'L', or 'R'");
            }
        }
    }//end of userInputManager method

    public static void quit() {
        System.out.println("Welcome home and...Good Bye!");
        System.exit(0);
    }//end of quit method
}//end of class Game
