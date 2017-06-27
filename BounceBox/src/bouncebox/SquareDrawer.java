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
public class SquareDrawer implements Drawable {
    private Square square;
    
    public SquareDrawer(Square square) {
        this.square = square;
    }
    
    public void draw(Graphics2D g) {
        g.setColor(square.getColor());
        int width = square.getWidth();
        int left = (int) (square.getX()-width/2);
        int top = (int) (square.getY()-width/2);
        
        int rad = (int) square.getContactRadius();
        
        g.fillRect(left,top, width, width);
        
        int cleft = (int)(square.getX()-rad);
        int ctop = (int) (square.getY()-rad);
        g.drawOval(cleft,ctop,rad*2,rad*2);
    }
}
