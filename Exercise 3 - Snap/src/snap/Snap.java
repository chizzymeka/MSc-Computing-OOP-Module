/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snap;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing
 */
public class Snap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Jam");
        StringBuilder s2 = new StringBuilder("Jam");
        StringBuilder s3 = new StringBuilder("Sausages");

        s3 = s2;
        s2.append(" Today!");
        if (s3 == s2) {
            System.out.println("Snap!");
        } else {
            System.out.println("s1 =" + s1);
            System.out.println("s2 =" + s2);
            System.out.println("s3 =" + s3);
        }
    }

}
