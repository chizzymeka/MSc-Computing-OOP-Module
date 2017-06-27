/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondcoursework;

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
    private static final char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static final Scanner scan = new Scanner(System.in);
    private static int playerCol = INITIAL_PLAYER_COL;
    private static int playerRow = INITIAL_PLAYER_ROW;
    private static int nbrDoughnuts = 0;
    private static int nbrMoves = 0;
    private static Random random = new Random();

    // Declare a variable for undo actions
    private static final char UNDO_MOVE_CHAR = 'Z';

    // Declare a variable to reveal movement and doughnut trail
    private static final char TRAIL_CHAR = 'M';

    // Declare a variable to mark the position(s) a player passed through
    private static final char SQUARE_TRAIL = '+';

    // Declare a variable to mark the position(s) a doughnut was picked up from
    private static final char DOUGHNUT_TRAIL = '*';

    // Declare a variable to represent the normal board before the 'M' key is pressed
    private static boolean TRAIL_MARKED = false;

    // Give the player one life by default
    private static int lives = 1;

    // Initialise a variable to hold the lives accumulated from eating doughnuts
    private static int doughnutLives;

    // Declare a variable that holds information on whether a subject move object has a doughnut eaten or not
    private static boolean doughnutCheck;

    // Declare a variable to hold values for use in regular movements
    private static char opt1;

    // Declare a variable to hold values for use in specifying square numbers for super moves
    private static int opt2;

    // Declare an ArrayList of Move type
    private static ArrayList<Move> movement;

    public static void main(String[] args) {

        // create and ArrayList to hold Move class objects
        movement = new ArrayList<Move>();
        setUpBoard();
        showBoard();
        String opt;
        do {
            System.out.print("Next option ?");
            opt = scan.next();
            // If the player's life is one
            if (lives == 1) {

                // Use their char input for basic movement
                opt1 = opt.charAt(0);

                // If their life is more than one,
            } else if (lives > 1) {

                // If the number of their input is still one, despite having the option of making supermoves
                if (opt.length() == 1) {

                    // Use their char input for basic movement
                    opt1 = opt.charAt(0);

                    checkLivesAndInput();

                    // If they enter more than to two characters
                } else if (opt.length() > 1) {

                    // Use the first one for movement
                    opt1 = opt.charAt(0);

                    // And transform the second one into a number that will be used for supermove purposes
                    opt2 = Character.getNumericValue(opt.charAt(1));
                }
            }

            // If 'Z' is pressed
            if (opt1 == UNDO_MOVE_CHAR) {

                // Check that the ArrayList is not empty, that is, ensure it contains previous Move objects to revert to
                if (!movement.isEmpty()) {

                    // Then proceed to call the undoMove method and pass in the target index value of the move object to revert to
                    undoMove(movement.get(movement.size() - 1));

                    // Remove the last move object
                    movement.remove(movement.size() - 1);

                } else {
                    System.out.println("There is no move to be undone!");
                }
            }

            // If use enters 'M'
            if (opt1 == TRAIL_CHAR) {

                // Check that the ArrayList is not empty, that is, ensure that there will actually be a trail to be marked or unmarked
                if (!movement.isEmpty()) {

                    // If the trail is already marked
                    if (TRAIL_MARKED) {

                        // Then unmark it
                        UnMarkTrail();
                    } else {

                        // Mark trail
                        MarkTrail();
                    }
                } else {

                    // If the ArrayList is empty, that is, if no moves have been made yet, then tell the user that there is no trail to be marked
                    System.out.println("There is no trail to be marked!");
                }
            }
            if (opt1 == UP_MOVE_CHAR || opt1 == DOWN_MOVE_CHAR || opt1 == LEFT_MOVE_CHAR || opt1 == RIGHT_MOVE_CHAR || opt1 == TRAIL_CHAR || opt1 == UNDO_MOVE_CHAR) {
                if (opt1 == UP_MOVE_CHAR || opt1 == DOWN_MOVE_CHAR || opt1 == LEFT_MOVE_CHAR || opt1 == RIGHT_MOVE_CHAR) {
                    move(opt1);
                }
            } else {
                System.out.println("Allowed commands are: + " + UP_MOVE_CHAR + "," + DOWN_MOVE_CHAR + "," + LEFT_MOVE_CHAR + "," + RIGHT_MOVE_CHAR + "," + UNDO_MOVE_CHAR + "," + TRAIL_CHAR);
            }

            showBoard();
            System.out.println("Number of moves made = " + nbrMoves);
            System.out.println("Number of doughnuts eaten = " + nbrDoughnuts);
            System.out.println("Lives = " + lives);
        } while (board[HOME_ROW][HOME_COL] == HOME_CHAR);
        System.out.println("Thank you and goodbye");
    }// End of main method

    private static void MarkTrail() {

        //Iterate through the ArrayList of Move objects
        for (Move m : movement) {

            // Obtain the value of the last move object's column and put it in a variable called prevCol
            int prevCol = m.getFromCol();

            // Obtain the value of the last move object's Row and put it in a variable called prevRow
            int prevRow = m.getFromRow();

            // If a doughnut was in a cell
            if (m.isDoughnutEaten()) {

                // Obtain the value of the doughnut's column and put it in a variable called prevCol
                prevCol = m.getToCol();

                // Obtain the value of the doughnut's row and put it in a variable called prevRow
                prevRow = m.getToRow();

                // Put doughnuts trail(s) in the relevant positions, that is '*'
                board[prevRow][prevCol] = DOUGHNUT_TRAIL;
            } else {

                // If a doughnut was not in the cell
                if (board[prevRow][prevCol] != DOUGHNUT_TRAIL) {

                    // Put a square trail there, that is '+'
                    board[prevRow][prevCol] = SQUARE_TRAIL;
                }

                // Put the values of the Move objects for the columns and rows into the corresponding variables
                prevCol = m.getToCol();
                prevRow = m.getToRow();
                if (board[prevRow][prevCol] != DOUGHNUT_TRAIL) {
                    board[prevRow][prevCol] = SQUARE_TRAIL;
                }
            }
        }

        // Toggle trail to on to reveal the trail
        TRAIL_MARKED = true;

    }// End of MarkTrail method

    private static void UnMarkTrail() {

        //Iterate through the ArrayList of Move objects
        for (Move m : movement) {

            // Obtain the value of the last move object's column and put it in a variable called prevCol
            int prevCol = m.getFromCol();

            // Obtain the value of the last move object's Row and put it in a variable called prevRow
            int prevRow = m.getFromRow();

            // Fill them up with square trails
            board[prevRow][prevCol] = FREE_SQUARE_CHAR;

            // If the index of the ArrayList is the same as the current object in the iteration
            if (movement.get(movement.size() - 1) == m) {

                // Put the values of the Move objects for the columns and rows into the corresponding variables
                prevCol = m.getToCol();
                prevRow = m.getToRow();

                // Put the player in that position
                board[prevRow][prevCol] = PLAYER_CHAR;
            }
        }

        // Toggle trail to off to hide the trail
        TRAIL_MARKED = false;

    }// End of UnMarkTrail method

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
    }// End of setUpBoard method

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
    }// End of addVerticalWall method

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
    }// End of addHorizontalWall method

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
    }// End of showBoard method

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
    }// End of intialiseBoard method

    /**
     * Undo Move
     */
    private static void undoMove(Move m) {
        // Retrieve the value of the column of the Move object specified by the method call in the main method and put it in newCol
        int newCol = m.getToCol();

        // Retrieve the value of the row of the Move object specified by the method call in the main method and put it in newRow
        int newRow = m.getToRow();

        // Set this new column as the player's column
        playerCol = newCol;

        // Set this new row as the player's row
        playerRow = newRow;

        // Revert the number of moves by one
        nbrMoves--;

        // If a doughnut was eaten
        if (m.isDoughnutEaten()) {

            // Regenarate it
            nbrDoughnuts--;

            // Reduce the number of lives obtained from the doughnut by one
            doughnutLives--;

            //  Reduce the total number of lives by one
            lives--;

            // Put back the doughnut character
            board[playerRow][playerCol] = DOUGHNUT_CHAR;
        } else {
            // Put back the square character
            board[playerRow][playerCol] = FREE_SQUARE_CHAR;
        }

        // Set this new column as the player's column
        playerCol = m.getFromCol();

        // Set this new row as the player's row
        playerRow = m.getFromRow();

        //Put back the player character in this new player position
        board[playerRow][playerCol] = PLAYER_CHAR;
    }// End of undoMove method

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

                // If lives is just one
                if (lives == 1) {

                    // Just perform a normal move
                    newRow--;

                    // If lives is above one
                } else if (lives > 1) {

                    // Put any number they specify after their move character into variable 'number'
                    int number = opt2;

                    // If the user selects a number lower than or equal to the number of lives, then perform the action
                    if (number <= lives) {
                        newRow = newRow - number;
                    } else {

                        // If they select a number higher than the number of lives they have at that point in time, then stop them
                        checkLivesAndInput();
                    }
                }
                break;
            case DOWN_MOVE_CHAR:

                // If lives is just one
                if (lives == 1) {

                    // Just perform a normal move
                    newRow++;

                    // If lives is above one
                } else if (lives > 1) {

                    // Put any number they specify after their move character into variable 'number'
                    int number = opt2;

                    // If the user selects a number lower than or equal to the number of lives, then perform the action
                    if (number <= lives) {
                        newRow = newRow + number;
                    } else {

                        // If they select a number higher than the number of lives they have at that point in time, then stop them
                        checkLivesAndInput();
                    }
                }
                break;

            case LEFT_MOVE_CHAR:

                // If lives is just one
                if (lives == 1) {

                    // Just perform a normal move
                    newCol--;

                    // If lives is above one
                } else if (lives > 1) {

                    // Put any number they specify after their move character into variable 'number'
                    int number = opt2;

                    // If the user selects a number lower than or equal to the number of lives, then perform the action
                    if (number <= lives) {
                        newCol = newCol - number;
                    } else {

                        // If they select a number higher than the number of lives they have at that point in time, then stop them
                        checkLivesAndInput();
                    }
                }
                break;
            case RIGHT_MOVE_CHAR:

                // If lives is just one
                if (lives == 1) {

                    // Just perform a normal move
                    newCol++;

                    // If lives is above one
                } else if (lives > 1) {

                    // Put any number they specify after their move character into variable 'number'
                    int number = opt2;

                    // If the user selects a number lower than or equal to the number of lives, then perform the action
                    if (number <= lives) {
                        newCol = newCol + number;
                    } else {

                        // If they select a number higher than the number of lives they have at that point in time, then stop them
                        checkLivesAndInput();
                    }
                }
                break;
        }
        if (newRow < 0 || newRow >= BOARD_SIZE || newCol < 0 || newCol >= BOARD_SIZE) {
            System.out.println("Sorry that move will take you off the board!");
        } else {
            char dest = board[newRow][newCol];
            if (dest == WALL_CHAR) {
                System.out.println("Sorry you will crash into a wall!");
            } else {
                nbrMoves++;
                if (dest == DOUGHNUT_CHAR) {
                    // Let the user know that (s)he is now eligible to make jump moves
                    doughnutCheck = true;
                    nbrDoughnuts++;
                    if (nbrDoughnuts == 1) {
                        System.out.println("You can now make super moves!");
                    } else if (nbrDoughnuts > 1) {
                        System.out.println("Super moves improved!");
                    }
                    doughnutLives++;
                    lives = (doughnutLives + 1);
                } else {
                    doughnutCheck = false;
                }
                // If the input movement character is a valid option
                if (moveChar == UP_MOVE_CHAR || moveChar == DOWN_MOVE_CHAR || moveChar == LEFT_MOVE_CHAR || moveChar == RIGHT_MOVE_CHAR) {

                    // Create a new Move object holding the details of the move
                    movement.add(new Move(playerCol, playerRow, newCol, newRow, doughnutCheck));
                }
                board[playerRow][playerCol] = FREE_SQUARE_CHAR;
                playerCol = newCol;
                playerRow = newRow;
                board[playerRow][playerCol] = PLAYER_CHAR;

                // If trail is not marked
                if (TRAIL_MARKED) {

                    // Mark trail
                    MarkTrail();
                }
            }
        }
    }// End of move method

    public static void checkLivesAndInput() {

        // Prompt then to re-enter the movement character, alongside the number of grids they want to jump
        System.out.println("Two inputs expected: A valid character and an integer less than or equal to the number of lives you currently have!");
        System.out.println("Also, ideally you should complete this step before attempting any undo actions or trail reveals.");

    }//End of checkLivesAndInput method

}//End of Game Class