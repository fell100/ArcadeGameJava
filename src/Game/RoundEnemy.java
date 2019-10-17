
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RoundEnemy extends GameObject {
    
    private Handler handler;
    
    private double a, b , c, d, e, f = 1;
    
    

    public RoundEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 5;
        velY = 5;
        
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    
    public void tick() {
        // create a curved movement
        f += 0.01;
        c = Math.PI;
                
        e = (float) (a + b*Math.sin(c*f + d));
        
        velX *= e;
        velY *= e;
        
        x += velX;
        y += velY;
        
        /*
        Game.clamp(x, Game.WIDTH / 4, Game.WIDTH * 3 / 4);
        if(x <= Game.WIDTH / 4 || x >= Game.WIDTH * 3 / 4) velX *= -1;
        
        Game.clamp(y, Game.HEIGHT / 4, Game.HEIGHT * 3 / 4);
        if(y <= Game.HEIGHT / 4 || y >= Game.HEIGHT * 3 / 4) velY *= -1;
        */
        
        
            
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.pink, 16, 16, 0.03f, handler));
    }

    
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
