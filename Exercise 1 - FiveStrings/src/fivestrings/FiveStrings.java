/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fivestrings;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class FiveStrings {

    /**
     * @param args the command line arguments
     */
    
    static String [] names = new String[5];
            
    public static void main(String[] args) {
        initialise();
        printStudents();
    }
    
    static void printStudents(){
        for(int i=0; i<names.length; i++){
            System.out.println(names[i]);
        }
    }
    
    static void initialise(){
        names = new String[] {"Jam", "Spam", "Ham", "Spam", "Eggs"};
    }
}
