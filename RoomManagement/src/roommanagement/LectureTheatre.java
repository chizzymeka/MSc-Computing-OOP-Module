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
public class LectureTheatre extends Room {
    
    public LectureTheatre(String rm, int n){
        super(rm, n, true);
    }
    
    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " Capacity: " + capacity;
    }
}
