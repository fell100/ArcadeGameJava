
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
       
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp((int)x, 0, Game.WIDTH -39);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 61);
        
         handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
        
        collision();
    }
    
    public void collision() {
        for(int i = 0;  i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy
                    || tempObject.getId() == ID.EnemyBoss || tempObject.getId() == ID.EnemyBossBullet) { // tempobject is now the enemy collisor
                //collision code
                if(getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
           
        }
    }
    
    public void render(Graphics g){
        /*if(id == ID.Player)*/g.setColor(Color.white);
        //else if(id == ID.Player2) g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 32, 32);
    }
}
