/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentscheduler;

import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class AppointmentScheduler {

    int startTime;
    int startTime2;
    int duration;
    int duration2;
    int endTime;
    int endTime2;
    
    /**
     * @param args the command line arguments
     */
    
    Scanner scan = new Scanner(System.in);
    
    //user input mechanism for first appointment start time
    public void Input(){
        System.out.println("Enter the first appointment start time");
        startTime = scan.nextInt();
        
        OfficeHoursCheck();
    }
    
    //user input mechanism for second appointment
    public void Input2(){
        System.out.println("Enter the second appointment start time");
        startTime2 = scan.nextInt();
        
        OfficeHoursCheck2();
    }
    
    //Office hours restriction for first appointment booking
    public void OfficeHoursCheck(){
        if(startTime<9 || startTime>17){
            System.out.println("Ensure the appointment start time"
                    + " is within office hours");
        }else{
            Continue();
        }
    }
    
    //Office hours restriction for second appointment booking
    public void OfficeHoursCheck2(){
        if(startTime2<9 || startTime2>17){
            System.out.println("");
            System.out.println("Ensure the appointment start time"
                    + " is within office hours");
        }else{
            Continue2();
        }
    }
    
    //user input mechanism for first appointment duration
    public void Continue(){
        System.out.println("Enter the duration in hours");
        duration = scan.nextInt();
        endTime = startTime + duration;
        
        AppointmentEndTimeCheck();
    }
    
    //user input mechanism for second appointment duration
    public void Continue2(){
        System.out.println("Enter the duration in hours");
        duration2 = scan.nextInt();
        endTime2 = startTime2 + duration2;
        
        AppointmentEndTimeCheck2();
    }
    
    public void AppointmentEndTimeCheck(){
        //Restriction for first appointment end time
        if (endTime > 17){
            System.out.println("");
            System.out.println("Appointment has to start and end"
                    + " within office hours");
            Continue();
        }else{
            Input2();
        }
    }
    
    //Restriction for second appointment end time
    public void AppointmentEndTimeCheck2(){
        if (endTime2 > 17){
            System.out.println("");
            System.out.println("Appointment has to start and end"
                    + " within office hours");
            Continue();
        
        //test conditions
        }else{
            if(startTime<startTime2 & endTime<endTime2){
                if(startTime2<endTime){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
                }else{
                    System.out.println("");
                    System.out.println("No Overlap, you may proceed to book"
                            + " it in!");
                }
            }else if(startTime>startTime2 & endTime>endTime2){
                if(startTime<endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
                }else{
                    System.out.println("");
                    System.out.println("No Overlap, you may proceed to book"
                            + " it in!");
                }
            }else if(startTime<startTime2 & endTime>endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
            }else if(startTime>startTime2 & endTime<endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
            }else if(startTime<startTime2 & endTime==startTime2){
                    System.out.println("");
                    System.out.println("Cutting it close but First and second"
                            + " are booked!");
            }else if(startTime>startTime2 & startTime==startTime2){
                    System.out.println("");
                    System.out.println("Cutting it close but First and second"
                            + " are booked!");
            }else if(startTime<startTime2 & endTime<=endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
            }else if(startTime>startTime2 & endTime>=endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
            }else if(startTime<=startTime2 & endTime<endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
            }else if(startTime>=startTime2 & endTime>endTime2){
                    System.out.println("");
                    System.out.println("There will be an overlap!");
        }
    }
}
    
    public static void main(String[] args) {
        AppointmentScheduler as = new AppointmentScheduler();
        as.Input();
    }
    
}
