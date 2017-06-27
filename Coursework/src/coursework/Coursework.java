package coursework;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class Coursework {

    //initial player and home positions
    static int playerColumn = 0;
    static int playerRow = 9;
    static int homeColumn = 9;
    static int homeRow = 0;

    //counters
    static int moveCounter;
    static int doughnutCounter;

    //Variable Declaration for Board Elements
    static char grid = '.';
    static char wall = 'X';
    static char player = 'P';
    static char home = 'H';

    //board Dimension Variables
    static final int c = 10;
    static final int r = 10;

    // Board Setup
    static char[][] tenByTen = new char[c][r];

    public static void main(String[] args) {
        board(playerColumn, playerRow, homeColumn, homeRow);
        while (true) {
            input();
            board(playerColumn, playerRow, homeColumn, homeRow);
        }
    }

    public static void input() {
        Scanner scan = new Scanner(System.in);
        char inputCharacter = scan.nextLine().charAt(0);

        switch (inputCharacter) {
            case 'u':
                if (playerRow == 0) {
                    System.out.println("Sorry, that move takes you off the board");
                } else if (tenByTen[playerColumn][playerRow - 1] == 'X') {
                    System.out.println("You cannot go through the wall");
                } else if (tenByTen[playerColumn][playerRow - 1] == tenByTen[8][2]) {
                    tenByTen[8][2] = '.';
                } else {
                    moveCounter++;
                    board(playerColumn, --playerRow, homeColumn, homeRow);
                }
                break;
            case 'd':
                if (playerRow == 9) {
                    System.out.println("Sorry, that move takes you off the board");
                } else if (tenByTen[playerColumn][playerRow + 1] == 'X') {
                    System.out.println("You cannot go through the wall");
                } else {
                    moveCounter++;
                    board(playerColumn, ++playerRow, homeColumn, homeRow);
                }
                break;
            case 'l':
                if (playerColumn == 0) {
                    System.out.println("Sorry, that move takes you off the board");
                } else if (tenByTen[playerColumn - 1][playerRow] == 'X') {
                    System.out.println("You cannot go through the wall");
                } else {
                    moveCounter++;
                    board(--playerColumn, playerRow, homeColumn, homeRow);
                }
                break;
            case 'r':
                if (playerColumn == 9) {
                    System.out.println("Sorry, that move takes you off the board");
                } else if (tenByTen[playerColumn + 1][playerRow] == 'X') {
                    System.out.println("You cannot go through the wall");
                } else {
                    moveCounter++;
                    board(++playerColumn, playerRow, homeColumn, homeRow);
                }
                break;
            default:
                System.out.println("Please ensure you enter the correct character: 'U', 'D', 'L', or 'R'");
        }
    }

    public static void board(int playerColumn, int playerRow, int homeColumn, int homeRow) {
        //User Prompt
        System.out.println("Press 'U' to move up, 'D' to move down, 'L' to move left and 'R' to move right");
        //Counters
        System.out.println("Number of moves made so far: " + moveCounter);
        System.out.println("Number of doughnuts eaten so far: " + doughnutCounter);

        //iterate through r
        for (int row = 0; row < tenByTen.length; row++) {
            //iterate through c
            for (int column = 0; column < tenByTen[row].length; column++) {
                //fill the arrays
                tenByTen[column][row] = grid;
                tenByTen[playerColumn][playerRow] = player;
                tenByTen[homeColumn][homeRow] = home;

                tenByTen[3][2] = 'X';
                tenByTen[3][3] = 'X';
                tenByTen[3][4] = 'X';
                tenByTen[3][5] = 'X';
                tenByTen[3][6] = 'X';

                tenByTen[7][2] = 'X';
                tenByTen[7][3] = 'X';
                tenByTen[7][4] = 'X';
                tenByTen[7][5] = 'X';
                tenByTen[7][6] = 'X';

                tenByTen[2][7] = 'X';
                tenByTen[3][7] = 'X';
                tenByTen[4][7] = 'X';
                tenByTen[5][7] = 'X';
                tenByTen[6][7] = 'X';
                
                tenByTen[8][3] = '@';
                tenByTen[6][4] = '@';
                tenByTen[2][1] = '@';
                tenByTen[7][1] = '@';
                tenByTen[5][6] = '@';

                System.out.print(tenByTen[column][row] + " ");
            }
            System.out.println();
        }
        System.out.println("");

        // Quit mechanism: valid when player position 'P' is equal to home 'H'
        if (tenByTen[playerColumn][playerRow] == tenByTen[homeColumn][homeRow]) {
            System.out.println("Welcome home and...good bye!");
            System.exit(0);
        }
    }
}
