/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle.test;

/**
 *
 * @author Chizzy Meka | MSc. Computing (2016/2017) | Student Number: 16036630
 */
public class CircleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle myCircle = new Circle(10, 15);
        
        myCircle.changeX(-5);
        System.out.println(myCircle.getX());
        
        System.out.println(myCircle.calculateArea());
    }
    
}
