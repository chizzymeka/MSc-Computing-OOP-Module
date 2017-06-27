/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bouncebox;

import java.awt.Graphics2D;

/**
 *
 * @author p0073862
 */
public class CircleDrawer implements Drawable {
    private Circle circle;
    
    public CircleDrawer(Circle circle) {
        this.circle = circle;
    }
    
    public void draw(Graphics2D g) {
        g.setColor(circle.getColor());
        double left = circle.getX() - circle.getRadius();
        double top = circle.getY() - circle.getRadius();
        g.fillOval((int)left,(int)top,circle.getRadius()*2,
                                      circle.getRadius()*2);
    }
}
