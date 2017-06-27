/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcoursework;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    //initial player and home positions
    static int playerColumn = 0;
    static int playerRow = 9;
    static int homeColumn = 9;
    static int homeRow = 0;

    //Variable Declaration for Player and Home
    static char player = 'P';
    static char home = 'H';

    //Doughnut Coordinates
    //Doughnut 1
    static int d1C = 5;
    static int d1R = 6;
    //Doughnut 2
    static int d2C = 7;
    static int d2R = 1;
    //Doughnut 3
    static int d3C = 1;
    static int d3R = 4;
    //Doughnut 4
    static int d4C = 2;
    static int d4R = 8;
    //Doughnut 5
    static int d5C = 4;
    static int d5R = 5;

    //Variable Declaration for Doughnuts
    static char d1 = '@';
    static char d2 = '@';
    static char d3 = '@';
    static char d4 = '@';
    static char d5 = '@';

    //Board Dimension Variables
    static final int column = 10;
    static final int row = 10;

    //Board Setup
    static char[][] tenByTen = new char[column][row];

    //Counters
    static int moveCounter;
    static int doughnutCounter;

    public static void main(String[] args) {
        initiateBoard();
        do {
            inputManager();
            updateBoard();
            boardManager();
        } while (tenByTen[playerColumn][playerRow] != tenByTen[homeColumn][homeRow]);
        System.out.println("Welcome home and...good bye!");
    }

    public static void initiateBoard() {
        for (int r = 0; r < tenByTen.length; r++) {
            //iterate through c
            for (int c = 0; c < tenByTen[r].length; c++) {

                //Insert the Grid
                tenByTen[c][r] = '.';

                //First Vertical Wall
                tenByTen[3][2] = 'X';
                tenByTen[3][3] = 'X';
                tenByTen[3][4] = 'X';
                tenByTen[3][5] = 'X';
                tenByTen[3][6] = 'X';

                //Second Vertical Wall
                tenByTen[7][2] = 'X';
                tenByTen[7][3] = 'X';
                tenByTen[7][4] = 'X';
                tenByTen[7][5] = 'X';
                tenByTen[7][6] = 'X';

                //Horizontal Wall
                tenByTen[2][7] = 'X';
                tenByTen[3][7] = 'X';
                tenByTen[4][7] = 'X';
                tenByTen[5][7] = 'X';
                tenByTen[6][7] = 'X';

                //position doughnuts as per coordinates defined at class level
                tenByTen[d1C][d1R] = d1;
                tenByTen[d2C][d2R] = d2;
                tenByTen[d3C][d3R] = d3;
                tenByTen[d4C][d4R] = d4;
                tenByTen[d5C][d5R] = d5;

                //position the player and home accordingly
                tenByTen[playerColumn][playerRow] = player;
                tenByTen[homeColumn][homeRow] = home;
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static void inputManager() {
        //User Prompt
        System.out.println("Press 'U' to move up, 'D' to move down, 'L' to move left and 'R' to move right");

        Scanner scan = new Scanner(System.in);
        char inputCharacter = scan.nextLine().charAt(0);

        switch (inputCharacter) {
            case 'u':
                if (playerRow == 0) {
                    System.out.println("Sorry, that move takes you off the board");
                } else {
                    moveCounter++;
                    playerRow = --playerRow;
                }
                break;
            case 'd':
                if (playerRow == 9) {
                    System.out.println("Sorry, that move takes you off the board");
                } else {
                    moveCounter++;
                    playerRow = ++playerRow;
                }
                break;
            case 'l':
                if (playerColumn == 0) {
                    System.out.println("Sorry, that move takes you off the board");
                } else {
                    moveCounter++;
                    playerColumn = --playerColumn;
                }
                break;
            case 'r':
                if (playerColumn == 9) {
                    System.out.println("Sorry, that move takes you off the board");
                } else {
                    moveCounter++;
                    playerColumn = ++playerColumn;
                }
                break;
            default:
                System.out.println("Please ensure you enter the correct character: 'U', 'D', 'L', or 'R'");
        }
    }

    public static void updateBoard() {
        if (tenByTen[playerColumn][playerRow - 1] == 'X') {
            System.out.println("You cannot go through the wall");
        }

        if (tenByTen[playerColumn][playerRow + 1] == 'X') {
            System.out.println("You cannot go through the wall");
        }

        if (tenByTen[playerColumn - 1][playerRow] == 'X') {
            System.out.println("You cannot go through the wall");
        }

        if (tenByTen[playerColumn + 1][playerRow] == 'X') {
            System.out.println("You cannot go through the wall");
        }
    }

    public static void boardManager() {
        //iterate through r
        for (int r = 0; r < tenByTen.length; r++) {
            //iterate through c
            for (int c = 0; c < tenByTen[r].length; c++) {

                System.out.print(tenByTen[c][r] + " ");
            }
            System.out.println();
        }
        System.out.println("");

        //Move Counter
        System.out.println(moveCounter);
        System.out.println(doughnutCounter);
    }
}
