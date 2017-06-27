/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class RoomManagement {

    /**
     * @param args the command line arguments
     */
    static boolean projector;
    static int option;

    public static void main(String[] args) {
        ArrayList<Room> wheatley = new ArrayList<Room>();

        Scanner scan = new Scanner(System.in);

        do {
            //User prompt
            System.out.println("Please enter '1' to add a general purpose room, '2' to add a computer room, '3' to view all rooms, '4' to view rooms with projectors, '5' to find out rooms that can accommodate your users and '0' to quit.");
            option = scan.nextInt();

            Scanner keyboard = new Scanner(System.in);

            switch (option) {
                case 1:
                    //Obtain room number
                    System.out.println("What is the room number?");
                    String roomNumber = keyboard.nextLine();

                    //Obtain room capacity
                    System.out.println("Please enter a number for room capacity?");
                    int roomCapacity = keyboard.nextInt();

                    //Obtain projector availability information
                    System.out.println("Does the room have a projector? Y/N");
                    char projectorAvailability = keyboard.next().charAt(0);

                    if (projectorAvailability == 'y' || projectorAvailability == 'Y') {
                        projector = true;
                    } else if (projectorAvailability == 'n' || projectorAvailability == 'N') {
                        projector = false;
                    }
                    //Add room to the arraylist
                    wheatley.add(new Room(roomNumber, roomCapacity, projector));
                    
                    //Confirmation message
                    System.out.println("Room now added to the list!");
                    break;
                case 2:
                    //Obtain computer lab room number
                    System.out.println("What is the computer room number?");
                    String computerRoomNumber = keyboard.nextLine();

                    //Obtain computer lab room capacity
                    System.out.println("Please enter a number for room capacity?");
                    int computerLabCapacity = keyboard.nextInt();

                    //Obtain projector availability information
                    System.out.println("Does the room have a projector? Y/N");
                    char computerLabProjectorAvailability = keyboard.next().charAt(0);
                    if (computerLabProjectorAvailability == 'y' || computerLabProjectorAvailability == 'Y') {
                        projector = true;
                    } else if (computerLabProjectorAvailability == 'n' || computerLabProjectorAvailability == 'N') {
                        projector = false;
                    }

                    //Obtain computer lab room OS
                    System.out.println("Which OS is used in the room?");
                    String os = keyboard.next();

                    //Add computer lab to the arraylist
                    wheatley.add(new ComputerLab(computerRoomNumber, computerLabCapacity, projector, os));
                    
                    //Confirmation message
                    System.out.println("Computer room now added to the list!");
                    break;
                case 3:
                    //Firstly, check if there any rooms in the list
                    if (wheatley.isEmpty()) {
                        System.out.println("There are no rooms in the list");
                    } else {
                        //Display all rooms in the arraylist
                        for (Room r : wheatley) {
                            System.out.println(r.toString());
                        }
                    }
                    break;
                case 4:
                    if (wheatley.isEmpty()) {
                        System.out.println("There are no rooms in the list");
                    } else {
                        //display all rooms with projectors
                        for (Room r : wheatley) {
                            if (r.hasProjector() == true) {
                                System.out.println("The rooms with projectors are:");
                                System.out.println(r.getRoomNumber());
                            }
                        }
                    }
                    break;
                case 5:
                    // Firstly, check if there any rooms in the list
                    if (wheatley.isEmpty()) {
                        System.out.println("There are no rooms in the list");
                    } else {
                        //Obtain the number of people that want to use a room
                        System.out.println("Please enter the number of intended users");
                        int intendedUsers = keyboard.nextInt();

                        //Check and display rooms that can accommodate them
                        for (Room r : wheatley) {
                            if (r.capacity >= intendedUsers) {
                                System.out.println("The rooms that can fit the intended users are:");
                                System.out.println(r.getRoomNumber());
                                break;
                            // if there requirement cannot be met, then let them know
                            }else if (r.capacity < intendedUsers){
                                System.out.println("There is no suitable room available at the moment, please check again later");
                                break;
                            }
                        }
                    }
                    break;
                case 0:
                    //Quit message
                    System.out.println("Thank you for using our room management system.");
                    break;
                default:
                    //Wrong input prompt
                    System.out.println("Please ensure you select the right option as outlined above");
                    break;
            }
        } while (option != 0);
    }
}
