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
public class Circle {
    private double radius;
    private double cx;
    private double cy;
    private double area;
    
    public Circle(double cx, double cy){
        this.cx = cx;
        this.cy = cy;
        radius = 10;
    }
    
    public void changeX(double modifyCx){
        cx = cx + modifyCx;
    }
    
    public double getX(){
        return cx;
    }
    
    public double calculateArea(){
        area = (Math.PI) * (radius * radius);
        
        if (area > 100){
            System.out.println("Area is greater than 100");
        }
        
        return area;
    }
}
