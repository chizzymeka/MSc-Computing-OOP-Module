/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class ComputerLab extends Room {
    //RoomNumber, capacity, projection inherited from Room class
    
    //child-specific attribute
    private String os;
    
    //Constructor #1
    public ComputerLab(String rm, int n, boolean p, String os){
        // Call to the parent constructor
        super(rm, n, p);
        this.os = os;
    }

    //Constructor #2
    public ComputerLab(String rm){
        super(rm, 20, true);
        os = "Windows";
    }

    //child-specific method
    public String getOS(){
        return os;
    }

    //child-specific method
    public void setOS(String update){
        os = update;
        getCapacity();
    }

    public String toString() {
        String s = super.toString();
        s = s+ " Operating System: " + os;
        
        return s;
    }
}