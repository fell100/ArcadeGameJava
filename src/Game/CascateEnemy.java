
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class CascateEnemy extends GameObject {
    
    private Handler handler;
    Random r = new Random();
    
    private int timer1 = 100;
    private int timer2 = 200;
    
    public CascateEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        
        
        velX = 0;
        
        Game.clamp(velY, 1, 7);
        velY = r.nextInt(7);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    
    public void tick() {
        //x += velX;
        y += velY;
        timer1 --;
        if(timer1 < 0){
            velY = 0;
            timer2--;
        }
            if(timer2 == 0) {
                // delete this entity and create other 3 into 3 diferent directions
            }
        
        //if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
            
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.ORANGE, 16, 16, 0.03f, handler));
    }

    
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x, (int)y, 16, 16);
        
    }
    
}
