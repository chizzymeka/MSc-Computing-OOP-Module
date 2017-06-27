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
public class Move {

    private final int pColumn;
    private final int pRow;
    private final int nCol;
    private final int nRow;
    private final boolean dCheck;

    // Initialise the variables with the corresponding values that the variables passed into the constructor hold
    public Move(int playerCol, int playerRow, int newCol, int newRow, boolean doughnutCheck) {
        pColumn = playerCol;
        pRow = playerRow;
        nCol = newCol;
        nRow = newRow;
        dCheck = doughnutCheck;
    }

    // Make the value available for use operations that involve the ArrayList
    public int getFromCol() {
        return pColumn;
    }// End of getFromCol Method

    // Make the value available for use operations that involve the ArrayList
    public int getFromRow() {
        return pRow;
    }// End of getFromRow Method

    // Make the value available for use operations that involve the ArrayList
    public int getToCol() {
        return nCol;
    }// End of getToCol Method

    // Make the value available for use operations that involve the ArrayList
    public int getToRow() {
        return nRow;
    }// End of getToRow Method

    // Make the value available for use operations that involve the ArrayList
    public boolean isDoughnutEaten() {
        return dCheck;
    }// End of isDoughnutEaten Method
}