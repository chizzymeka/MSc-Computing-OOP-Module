/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleownership;

import java.util.ArrayList;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class Person {

    private String name;
    
    private ArrayList<Vehicle> owns = new ArrayList<Vehicle>();
    
    public Person(String nm){
        this.name = nm;
    }

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        this.name = nm;
    }
    
    public void addVehicle(Vehicle vehicle){
        owns.add(vehicle);
    }
    
    public void deleteVehicle(Vehicle vehicle){
        owns.remove(vehicle);
    }
}
