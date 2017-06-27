/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleownership;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class VehicleOwnership {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person chizzy = new Person("Chizzy");
        
        Vehicle hyosung = new Vehicle("BX61 LEJ", "Hyosung GV125", "2012");
        
        chizzy.addVehicle(hyosung);
        
        System.out.println("Chizzy owns a: ");
        chizzy.printVehicle();
    }
}
