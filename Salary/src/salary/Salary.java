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
public class Salary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an object harry
        Employee harry = new Employee("Harry", 5.5, 41);
        
        // print out Harry's salary
        System.out.println("The salary for " + harry.getName() + " is: " + harry.calculateSalary());
    }
    
}
