/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingagechecker;

import java.util.Scanner;
/**
 *
 * @author chizz
 */
public class VotingAgeChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your age");
        age = scan.nextInt();
        if (age >= 18) {
            System.out.println("You can vote in the UK!");
        } else {
            System.out.println("Sorry you are not old enough to vote");
        }
    }
    
}
