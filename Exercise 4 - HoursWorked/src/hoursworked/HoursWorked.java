/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoursworked;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */

public class HoursWorked {
    
    int i;
    int weekNumber;
    int dailyHours;
    int totalHoursWorked = 0;
    
    Scanner scan = new Scanner(System.in);
    
    public void input(){
        //Week number user input
        System.out.println("Please enter the week number" 
                + "(Between '1' and '52')");
        weekNumber = scan.nextInt();
        calculate();
    }
    
    public void calculate(){
        //Check to ensure the week number falls between '1' and '52'
        if (weekNumber<1 || weekNumber>52){
            System.out.println("Please ensure the week number falls between "
                    + "'1' and '52', as per the number of weeks in a "
                    + "calendar year. Start again...");
            System.out.println("");
            input();
         
        //main program logic
        }else{
            for (i=1; i<=5; i++){
                System.out.println("");
                System.out.println("Enter the daily hours consecutively?");
                    dailyHours = scan.nextInt();
                    
                    //Check to ensure the number of hours per day is realistic
                    if (dailyHours > 12){
                        System.out.println("That is too much hours of work "
                                + "per day, please start afresh");
                        System.out.println("");
                        input();
                                
                    }else{
                        totalHoursWorked = totalHoursWorked + dailyHours;

            System.out.println("The total number of hours completed in week"
                + " number " + weekNumber + " is " 
                    + totalHoursWorked + " hours");
                    }
            }
        }
    }
    
    public static void main(String[] args){
        HoursWorked hw = new HoursWorked();
        hw.input();
    }
}
