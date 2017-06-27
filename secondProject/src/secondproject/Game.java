/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int BOARD_SIZE = 10;
    private static final int INITIAL_PLAYER_COL = 0;
    private static final int INITIAL_PLAYER_ROW = BOARD_SIZE - 1;
    private static final int HOME_COL = BOARD_SIZE - 1;
    private static final int HOME_ROW = 0;
    private static final int WALL_LENGTH = 5;
    private static final char PLAYER_CHAR = 'P';
    private static final char HOME_CHAR = 'H';
    private static final char WALL_CHAR = 'X';
    private static final char FREE_SQUARE_CHAR = '.';
    private static final char DOUGHNUT_CHAR = '@';
    private static final char UP_MOVE_CHAR = 'U';
    private static final char DOWN_MOVE_CHAR = 'D';
    private static final char LEFT_MOVE_CHAR = 'L';
    private static final char RIGHT_MOVE_CHAR = 'R';
    private static final char UNDO_MOVE_CHAR = 'Z';
    private static final char TRAIL_CHAR = 'M';

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static Scanner scan = new Scanner(System.in);
    private static Scanner keyBoard = new Scanner(System.in);

    private static int playerCol = INITIAL_PLAYER_COL;
    private static int playerRow = INITIAL_PLAYER_ROW;
    private static int nbrDoughnuts = 0;
    private static int nbrMoves = 0;
    private static Random random = new Random();

    private static int lives = 1;
    private static int doughnutLives;
    private static boolean doughnutCheck;
    static ArrayList<Move> movement = new ArrayList<Move>();

    public static void main(String[] args) {

        setUpBoard();
        showBoard();
        String opt;
        do {
            System.out.print("Next option ?");
            opt = scan.next();
            char opt1 = opt.charAt(0);
            if (opt1 == UP_MOVE_CHAR || opt1 == DOWN_MOVE_CHAR || opt1 == LEFT_MOVE_CHAR || opt1 == RIGHT_MOVE_CHAR || opt1 == UNDO_MOVE_CHAR) {
                move(opt1);
            } else {
                System.out.println("Allowed commands are: + " + UP_MOVE_CHAR + "," + DOWN_MOVE_CHAR + "," + LEFT_MOVE_CHAR + "," + RIGHT_MOVE_CHAR);
            }
            showBoard();
            System.out.println("Number of moves made = " + nbrMoves);
            System.out.println("Number of doughnuts eaten = " + nbrDoughnuts);
            System.out.println("Lives = " + lives);
        } while (board[HOME_ROW][HOME_COL] == HOME_CHAR);
        System.out.println("Thank you and goodbye");
    }

    /**
     * Set up the initial state of the board
     */
    private static void setUpBoard() {
        intialiseBoard(); // Fill the board with . characters
        //Add  the first vertical wall
        int v1StartCol = 1 + random.nextInt(BOARD_SIZE - 2);
        int v1StartRow = 1 + random.nextInt(BOARD_SIZE - WALL_LENGTH - 1);
        addVerticalWall(v1StartCol, v1StartRow, WALL_LENGTH);

        //Add the second vertical wall
        int v2StartCol;
        do {
            v2StartCol = 1 + random.nextInt(BOARD_SIZE - 2);
        } while (v2StartCol == v1StartCol);
        int v2StartRow = 1 + random.nextInt(BOARD_SIZE - WALL_LENGTH - 1);
        addVerticalWall(v2StartCol, v2StartRow, WALL_LENGTH);

        //Add the horizontal wall
        int h1StartRow = 1 + random.nextInt(BOARD_SIZE - 2);
        int h1StartCol = 1 + random.nextInt(BOARD_SIZE - WALL_LENGTH - 1);
        addHorizontalWall(h1StartCol, h1StartRow, WALL_LENGTH);

        //Add the dougnuts
        int nbrDoughnutsAdded = 0;
        while (nbrDoughnutsAdded < 5) {
            int dRow = 1 + random.nextInt(BOARD_SIZE - 2);
            int dCol = 1 + random.nextInt(BOARD_SIZE - 2);
            if (board[dRow][dCol] == FREE_SQUARE_CHAR) {
                board[dRow][dCol] = DOUGHNUT_CHAR;
                nbrDoughnutsAdded++;
            }
        }

        //Add the player and the home square
        board[playerRow][playerCol] = PLAYER_CHAR;
        board[HOME_ROW][HOME_COL] = HOME_CHAR;
    }

    /**
     * Add a vertical wall to the board
     *
     * @param startCol Column on which wall is situated
     * @param startRow Row on which top of wall is situated
     * @param length Number of squares occupied by wall
     */
    private static void addVerticalWall(int startCol, int startRow, int length) {
        for (int row = startRow; row < startRow + length; row++) {
            board[row][startCol] = WALL_CHAR;
        }
    }

    /**
     * Add a horizontal wall to the board
     *
     * @param startCol Column on which leftmost end of wall is situated
     * @param startRow Row on which wall is situated
     * @param length Number of squares occupied by wall
     */
    private static void addHorizontalWall(int startCol, int startRow, int length) {
        for (int col = startCol; col < startCol + length; col++) {
            board[startRow][col] = WALL_CHAR;
        }
    }

    /**
     * Display the board
     */
    private static void showBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * Fill the board with FREE_SQUARE_CHAR characters.
     */
    private static void intialiseBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = FREE_SQUARE_CHAR;
            }
            System.out.println();
        }
    }

    /**
     * Move the player
     *
     * @param moveChar Character indicating the move to be made
     */
    private static void move(char moveChar) {
        int newCol = playerCol;
        int newRow = playerRow;

        switch (moveChar) {
            case UP_MOVE_CHAR:
                if (lives == 1) {
                    newRow--;
                } else if (lives > 1) {
                    squareNumberPrompt();
                    int number = keyBoard.nextInt();
                    if (number <= lives) {
                        newRow = newRow - number;
                    } else {
                        checkLives();
                    }
                }
                break;
            case DOWN_MOVE_CHAR:
                if (lives == 1) {
                    newRow++;
                } else if (lives > 1) {
                    squareNumberPrompt();
                    int number = keyBoard.nextInt();
                    if (number <= lives) {
                        newRow = newRow + number;
                    } else {
                        checkLives();
                    }
                }
                break;
            case LEFT_MOVE_CHAR:
                if (lives == 1) {
                    newCol--;
                } else if (lives > 1) {
                    squareNumberPrompt();
                    int number = keyBoard.nextInt();
                    if (number <= lives) {
                        newCol = newCol - number;
                    } else {
                        checkLives();
                    }
                }
                break;
            case RIGHT_MOVE_CHAR:
                if (lives == 1) {
                    newCol++;
                } else if (lives > 1) {
                    squareNumberPrompt();
                    int number = keyBoard.nextInt();
                    if (number <= lives) {
                        newCol = newCol + number;
                    } else {
                        checkLives();
                    }
                }
                break;
            case UNDO_MOVE_CHAR:
                if (movement.size() >= 1) {
                    movement.remove(movement.size() - 1);
                    System.out.println("The decreasing  size of the arraylist is now " + movement.size()); // Test Line
                } else if (movement.size() < 1) {
                    System.out.println("There is no move to be undone!");
                }
                break;
        }
        if (newRow < 0 || newRow >= BOARD_SIZE || newCol < 0 || newCol >= BOARD_SIZE) {
            System.out.println("Sorry that move takes you off the board!");
        } else {
            char dest = board[newRow][newCol];
            if (dest == WALL_CHAR) {
                System.out.println("Sorry you landed on a wall!");
            } else {
                nbrMoves++;
                if (dest == DOUGHNUT_CHAR) {
                    doughnutCheck = true;
                    nbrDoughnuts++;
                    doughnutLives++;
                    lives = (doughnutLives + 1);
                }
                board[playerRow][playerCol] = FREE_SQUARE_CHAR;
                playerCol = newCol;
                playerRow = newRow;
                board[playerRow][playerCol] = PLAYER_CHAR;
            }
        }
        if (moveChar == UP_MOVE_CHAR || moveChar == DOWN_MOVE_CHAR || moveChar == LEFT_MOVE_CHAR || moveChar == RIGHT_MOVE_CHAR) {
            movement.add(new Move(playerCol, playerRow, newCol, newRow, doughnutCheck));
            System.out.println("The increasing  size of the arraylist is now " + movement.size()); // Test Line
        }
    }

    public static void squareNumberPrompt() {
        System.out.println("Enter the number of squares to be moved");
    }

    public static void checkLives() {
        System.out.println("Invalid number! The number must be"
                + " equal to or less than the number of lives you have");
    }
}