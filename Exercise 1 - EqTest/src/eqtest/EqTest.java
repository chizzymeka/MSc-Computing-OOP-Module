/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eqtest;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing
 */
public class EqTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Jam");
        StringBuilder s2 = new StringBuilder("Jam");

        if (s1==s2) {
            System.out.println("The same");
        } else {
            System.out.println("Not the same");
        }
    }

}
