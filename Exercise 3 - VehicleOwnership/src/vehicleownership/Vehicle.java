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
public class Vehicle {

    private String regNumber;
    private String make;
    private String year;

    public Vehicle(String rg, String mk, String yr){
        this.regNumber = rg;
        this.make = mk;
        this.year = yr;
    }
    
    public String getRegNumber() {
        return regNumber;
    }

    public String getMake() {
        return make;
    }

    public String getYear() {
        return year;
    }

    public void setRegNumber(String reg) {
        this.regNumber = reg;
    }

    public void setMake(String mk) {
        this.make = mk;
    }

    public void setYear(String yr) {
        this.year = yr;
    }
}
