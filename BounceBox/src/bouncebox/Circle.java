/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bouncebox;

/**
 *
 * @author p0073862
 */
public class Circle extends Shape {
    
    private int radius;
    public Circle(int x, int y, int radius) {
        super(x,y);
        this.radius = radius;
    }
    
    public int getRadius(){return radius;}
    
    public double getContactRadius() {return radius;}
    public double getMass() {return Math.PI*radius*radius;}
}
