/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing (2016/2017)
 */
public class StudentClass {
    private String name;
    private int age;
    
    public StudentClass(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
}
