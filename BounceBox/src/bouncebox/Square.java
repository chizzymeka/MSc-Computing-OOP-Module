/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bouncebox;

/**
 *
 * @author p0073862
 */
public class Square extends Shape {
    
    private double contactRadius;
    private int width;
    
    public Square(int x, int y, int width) {
        super(x,y);
        this.width = width;
        contactRadius = Math.sqrt(width*width/2);
    }
    
    public int getWidth(){return width;}
    
    public double getContactRadius() {return contactRadius;}
    public double getMass() {return width*width;}
}
