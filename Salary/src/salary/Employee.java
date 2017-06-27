/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class Employee {
    String name;
    double payRate;
    int hours;
    double salary;
    
    // initialize employee's details
    public Employee(String name, double payRate, int hours){
        this.name = name;
        this.payRate = payRate;
        this.hours = hours;
    }
    
    // get employee's name
    public String getName(){
        return name;
    }
    
    // get employee's salary
    public double calculateSalary(){
        salary = hours * payRate;
        
        if(hours > 40){
            salary = salary + ((payRate*0.5) * (hours-40));
        }
        return salary;
    }
}
