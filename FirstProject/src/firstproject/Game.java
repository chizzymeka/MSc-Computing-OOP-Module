package firstproject;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class Game {

    /**
     * @param args the command line arguments
     */

    //Board Dimension Variables
    static final int C = 10;
    static final int R = 10;
    //Board Setup
    static char[][] gameBoard = new char[C][R];

    //Counters
    static int moveCounter;
    static int totalEatenDoughnuts;

    //Doughnut Coordinates
    //Doughnut 1
    static int d1C = 5;
    static int d1R = 6;
    //Doughnut 2
    static int d2C = 7;
    static int d2R = 1;
    //Doughnut 3
    static int d3C = 3;
    static int d3R = 3;
    //Doughnut 4
    static int d4C = 2;
    static int d4R = 8;
    //Doughnut 5
    static int d5C = 5;
    static int d5R = 8;
    //Doughnut Variable Declaration
    static char d1 = '@';
    static char d2 = '@';
    static char d3 = '@';
    static char d4 = '@';
    static char d5 = '@';

    //Coordinate Declarartion for Initial Home Position
    static int homeColumn = 9;
    static int homeRow = 0;
    //Variable Declaration for Home
    static char home = 'H';

    //Coordinate Declarartion for Initial Player Position
    static int playerColumn = 0;
    static int playerRow = 9;
    //Variable Declaration for Player
    static char player = 'P';

    //Variable Declaration for Game board
    static char grid = '.';

    //Variable Declaration for Game Win
    static char gameWin = '.';

    //User Input Variable
    static char inputCharacter;

    //Wall Variable
    static char wall = 'X';

    public static void main(String[] args) {
        do {
            //To aid comprehension of the code, the method implementations have been placed in the order in which they are invoked
            insertGrid();
            insertPlayer();
            insertHome();
            insertDoughnuts();
            verticalWallOne();
            verticalWallTwo();
            horizontalWall();
            countManager();
            preUpdateBoardState();
            userInput();
            checkDoughnutOne();
            checkDoughnutTwo();
            checkDoughnutThree();
            checkDoughnutFour();
            checkDoughnutFive();
            postUpdateBoardState();
            wrongInputPrompt();
            validateMove();
        } while (gameBoard[playerColumn][playerRow] != gameBoard[homeColumn][homeRow]);
        //Call the wrapUp method to finish off the session
        wrapUp();
    }//End of main method

    public static void insertGrid() {
        //Iterate through R
        for (int row = 0; row < gameBoard.length; row++) {
            //Iterate through C
            for (int column = 0; column < gameBoard[row].length; column++) {
                //Insert '.' in all indexes to form a grid
                gameBoard[column][row] = grid;
            }
        }
    }//End of insertGrid method
    
    public static void insertPlayer() {
        //Position the player as per coordinates defined at class level
        gameBoard[playerColumn][playerRow] = player;
    }//End of insertPlayer method

    public static void insertHome() {
        //Position the  home as per coordinates defined at class level
        gameBoard[homeColumn][homeRow] = home;
    }//End of insertHome method

    public static void insertDoughnuts() {
        //Place doughtnuts at the specified coordinates
        gameBoard[d1C][d1R] = d1;
        gameBoard[d2C][d2R] = d2;
        gameBoard[d3C][d3R] = d3;
        gameBoard[d4C][d4R] = d4;
        gameBoard[d5C][d5R] = d5;
    }//End of insertDoughnuts method

    public static void verticalWallOne() {
        //Initialise the coordinates for the first vertical wall
        int vw1x = 2;
        int vw1y = 1;
        //Fill the coordinate with a wall and do so four more times, while going down on the Y-axis
        for (int i = 0; i < 5; i++) {
            gameBoard[vw1x][vw1y++] = wall;
        }
    }//End of verticalWallOne method

    public static void verticalWallTwo() {
        //Initialise the coordinates for the second vertical wall
        int vw2x = 7;
        int vw2y = 3;
        //Fill the coordinate with a wall and do so four more times, while going down on the Y-axis
        for (int i = 0; i < 5; i++) {
            gameBoard[vw2x][vw2y++] = wall;
        }
    }//End of verticalWallTwo method

    public static void horizontalWall() {
        //Initialise the coordinates for the horizontal wall
        int hwx = 3;
        int hwy = 5;
        //Fill the coordinate with a wall and do so four more times, while going right on the X-axis
        for (int i = 0; i < 5; i++) {
            gameBoard[hwx++][hwy] = wall;
        }
    }//End of horizontalWall method

    public static void countManager() {
        int count = 0;
        //Iterate through R
        for (int row = 0; row < gameBoard.length; row++) {
            //Iterate through C
            for (int column = 0; column < gameBoard[row].length; column++) {
                //On every loop, count how many doughnuts are remaining on the board
                if (gameBoard[column][row] == '@') {
                    //Increment 'count' by 1 as soon as a doughnut is found
                    count++;
                }
            }
        }
        //Firstly show and update the total number of moves made so far
        System.out.println("Number of moves made so far: " + moveCounter);
        //Secondly, show and update the difference between the total number of obtainable doughnuts (5) and the number of remaining doughnuts. The answer will equate to the number of doughnuts consumed
        System.out.println("Number of doughnuts eaten so far: " + (5 - count));
        //Assign the value of count to variable totalEatenDoughnuts for use in reporting the final number of eaten doughnuts, after the game is finished
        totalEatenDoughnuts = count;
    }//End of countManager method

    public static void preUpdateBoardState() {
        //Show the State of the Board Before Any Changes
        //Iterate through R
        for (int row = 0; row < gameBoard.length; row++) {
            //Iterate through C
            for (int column = 0; column < gameBoard[row].length; column++) {
                System.out.print(gameBoard[column][row] + " ");
            }
            System.out.println();
        }
        //Add extra spaces to make the board more square in shape
        System.out.println("");
    }//End of preUpdateBoardState method

    public static char userInput() {
        //User Prompt Message
        System.out.println("Press 'U' to move up, 'D' to move down, 'L' to move left and 'R' to move right");
        // Create a scanner object
        Scanner scan = new Scanner(System.in);
        //Initialise Variable with User Input
        inputCharacter = scan.nextLine().charAt(0);
        //Make the value of inputCharacter available for use in validateMove method
        return inputCharacter;
    }//End of userInput method

    public static void checkDoughnutOne() {
        //Check if the player column and row matches that of the first doughnut...
        if (playerColumn == d1C && playerRow == d1R) {
            //...and if they are, switch the doughnut to a grid
            d1 = '.';
        }
    }//End of checkDoughnutOne method

    public static void checkDoughnutTwo() {
        //Check if the player column and row matches that of the second doughnut...
        if (playerColumn == d2C && playerRow == d2R) {
            //...and if they are, switch the doughnut to a grid
            d2 = '.';
        }
    }//End of checkDoughnutTwo method

    public static void checkDoughnutThree() {
        //Check if the player column and row matches that of the third doughnut...
        if (playerColumn == d3C && playerRow == d3R) {
            //...and if they are, switch the doughnut to a grid
            d3 = '.';
        }
    }//End of checkDoughnutThree method

    public static void checkDoughnutFour() {
        //Check if the player column and row matches that of the four doughnut...
        if (playerColumn == d4C && playerRow == d4R) {
            //...and if they are, switch the doughnut to a grid
            d4 = '.';
        }
    }//End of checkDoughnutFour method

    public static void checkDoughnutFive() {
        //Check if the player column and row matches that of the fifth doughnut...
        if (playerColumn == d5C && playerRow == d5R) {
            //...and if they are, switch the doughnut to a grid
            d5 = '.';
        }
    }//End of checkDoughnutFive method

    public static void postUpdateBoardState() {
        //Iterate through R
        for (int row = 0; row < gameBoard.length; row++) {
            //Iterate through C
            for (int column = 0; column < gameBoard[row].length; column++) {
                //Render the whole board with all the updates that occured between the preUpdateBoardState method and the postUpdateBoardState method
                System.out.print(gameBoard[column][row] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }//End of postUpdateBoardState method

    public static void wrongInputPrompt() {
        if (inputCharacter == 'u' || inputCharacter == 'd' || inputCharacter == 'l' || inputCharacter == 'r') {
            //Just a space reserved right above the display, it displays an empty string anytime the input is correct but prompts user to enter the correct key if the recieved character is outside of the allowed options
            System.out.println("");
        } else {
            System.out.println("Please ensure you enter the correct character: 'U', 'D', 'L', or 'R'");
        }
    }//End of wrongInputPrompt method

    public static void validateMove() {
        switch (inputCharacter) {
            case 'u':
                //If player is already at the top of the board
                if (playerRow == 0) {
                    //Issue warning to the user that they are trying to go beyond the border of the grid
                    borderWarning();
                    //unless the player is attempting to displace an 'X'
                } else if (gameBoard[playerColumn][playerRow - 1] == wall) {
                    //Warn Player that they cannot go through the Walls
                    collisionWarning();
                } else {
                    //Increment move counter by 1
                    moveCounter++;
                    //Shift 'P' up by 1 by reducing the originally assigned row
                    playerRow = --playerRow;
                }
                break;
            case 'd':
                //If player is already at the bottom of the board
                if (playerRow == 9) {
                    //Issue warning to the user that they are trying to go beyond the border of the grid
                    borderWarning();
                    //unless the player is attempting to displace an 'X'
                } else if (gameBoard[playerColumn][playerRow + 1] == wall) {
                    //Warn Player that they cannot go through the Walls
                    collisionWarning();
                } else {
                    //Increment move counter by 1
                    moveCounter++;
                    //Shift 'P' down by 1 by increasing the originally assigned row
                    playerRow = ++playerRow;
                }
                break;
            case 'l':
                //If player is already at the leftmost part of the board
                if (playerColumn == 0) {
                    //Issue warning to the user that they are trying to go beyond the border of the grid
                    borderWarning();
                    //unless the player is attempting to displace an 'X'
                } else if (gameBoard[playerColumn - 1][playerRow] == wall) {
                    //Warn Player that they cannot go through the Walls
                    collisionWarning();
                } else {
                    //Increment move counter by 1
                    moveCounter++;
                    //Shift 'P' left by 1 by reducing the originally assigned column
                    playerColumn = --playerColumn;
                }
                break;
            case 'r':
                //If player is already at the rightmost part of the board
                if (playerColumn == 9) {
                    //Issue warning to the user that they are trying to go beyond the border of the grid
                    borderWarning();
                    //unless the player is attempting to displace an 'X'
                } else if (gameBoard[playerColumn + 1][playerRow] == wall) {
                    //Warn Player that they cannot go through the Walls
                    collisionWarning();
                } else {
                    //Increment move counter by 1
                    moveCounter++;
                    //Shift 'P' right by 1 by increasing the originally assigned column
                    playerColumn = ++playerColumn;
                }
                break;
        }
    }//End of validateMove method

    /*
     Other methods conditionally invoked from other methods
     */
    //Conditionally invoked from validateMove() method
    public static void borderWarning() {
        System.out.println("Sorry, that move takes you off the board");
    }//End of borderWarning method

    //Conditionally invoked from validateMove() method
    public static void collisionWarning() {
        System.out.println("That move is not allowed");
    }//End of collisionWarning method

    //Invoked from the main method upon session completion
    public static void wrapUp() {
        //Search player position on the board and replce it with a grid
        if (gameBoard[playerColumn][playerRow] == gameBoard[homeColumn][homeRow]) {
            //Replace the two naturally only possible paths (immediate left of 'Home' and immediate bottom of 'Home') the player will take to hit 'H', with '.' out of which, one must contain 'P' to create an illusion of the player entering 'Home'
            gameBoard[homeColumn][homeRow + 1] = '.';
            gameBoard[homeColumn - 1][homeRow] = '.';
        }
        //Report overall number of moves
        System.out.println("Number of moves made so far: " + moveCounter);
        //Report overall number of eaten doughnuts
        System.out.println("Number of doughnuts eaten so far: " + (5 - totalEatenDoughnuts));
        //Final grid state render
        postUpdateBoardState();
        //End of game message
        System.out.println("Welcome home and...good bye!");
    }//End of wrapUp method
}//End of Game class
