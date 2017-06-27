/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grader;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Grader {

    /**
     * @param args the command line arguments
     */
    
    int gd;
    
    public void Input(){
            //user input
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the student's grade");
            gd = scan.nextInt();
            
            Check();
    }
    
    public void Check(){
        //check to ensure the grade is between '1' and '100'
        if(gd<0 || gd>100){
            System.out.println("Out of range! "
                + "Please ensure the grade is between 0 & 100");
                System.out.println("Once again...");
                System.out.println("");
                Input();
        //main program logic
        }else{    
            if (gd>=70){
                System.out.println("You have achieved Grade A!");
            }else if(gd>60){
                System.out.println("You have achieved Grade B+!");
            }else if(gd>50){
                System.out.println("You have achieved Grade B!");
            }else if (gd>40){
                System.out.println("You have achieved Grade C!");
            }else if (gd>30){
                System.out.println("You need to take another Resit!");
            }else if (gd<30){
                System.out.println("Fail!");
            }
        }
    }

    public static void main(String[] args){
        Grader gr = new Grader();
        gr.Input();
    }
}
