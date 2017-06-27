/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondproject;

import java.util.ArrayList;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class Move {

    private static int pColumn;
    private static int pRow;
    private static int nCol;
    private static int nRow;
    private static boolean dCheck;
    
    public Move(int playerCol, int playerRow, int newCol, int newRow, boolean doughnutCheck) {
        pColumn = playerCol;
        pRow = playerRow;
        nCol = newCol;
        nRow = newRow;
        dCheck = doughnutCheck;
    }

    public static int getFromCol() {
        return pColumn;
    }

    public static int getFromRow() {
        return pRow;
    }

    public static int getToCol() {
        return nCol;
    }

    public static int getToRow() {
        return nRow;
    }

    public static boolean isDoughnutEaten() {
        return dCheck;
    }
}