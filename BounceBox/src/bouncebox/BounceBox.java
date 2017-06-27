/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bouncebox;

/**
 *
 * @author p0073862
 */
public class BounceBox {
    BounceModel model;
    BounceView view;
    BounceController controller;
    public static final int TIMER_INTERVAL = 50;
    
    public BounceBox(int width, int height) {
        
        model = new BounceModel();
        
        model.addWall(new Wall(1,0,0));
        model.addWall(new Wall(-1, 0, width));
        model.addWall(new Wall(0, 1, 0));
        model.addWall(new Wall(0, -1, height));
        
        view = new BounceView(width, height, model);
        controller = new BounceController(model, TIMER_INTERVAL);
    }
    
    public void addCircle(Circle c) {
        model.addShape(c);
        view.addDrawable(new CircleDrawer(c));
    }
    
    public void addSquare(Square s) {
        model.addShape(s);
        view.addDrawable(new SquareDrawer(s));
    }
    
    public void start() {
        controller.start();
    }

}
