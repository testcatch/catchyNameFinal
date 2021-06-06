package domain;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import com.game.catchyname.graphics.Screen;
import com.game.catchyname.graphics.Sprite;

import utilities.Coordinates;

public abstract class Entity extends Renderables implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AttackMove[] attackmoves = new AttackMove[15];
	
	protected int x;
	protected int y;
	
	protected int hp = 1000;
	protected int attack = 2;

	protected Entity(Coordinates spawn,Sprite sprite,Sprite projectilesprite) {
		super(spawn,sprite);
		x = spawn.getX();
		y = spawn.getY();
		createProjectiles(projectilesprite);
	}	
	
	protected void move(int xa , int ya,Level level) {
		if(xa != 0 && ya != 0) {
			move(xa,0,level);
			move(0,ya,level);
			return ;	//if I dont return the will be moving slowly
		}
		
		if(!level.collision(xa,ya,coordinates)) {
			x += xa;
			y += ya;
		}
		coordinates.update(x,y);
		updateAttacks();
	}
	
	public boolean isAlive() {
		return hp>0;
	}
	
	public void damage(Entity temp) {
		temp.hp -= this.attack;
	}
	
	public void createProjectiles(Sprite projectilesprite) {
		for(int i=0;i<attackmoves.length;i++) {
			attackmoves[i] = new AttackMove(new Coordinates(x/16,y/16,5),projectilesprite);
		}
	}
	
	public void setScreen(Screen screen) {
		for(int i=0;i<attackmoves.length;i++) {
		    attackmoves[i].setScreen(screen);
		}
		super.setScreen(screen);
	}

	public void updateAttacks() {
		for(int i=0;i<attackmoves.length;i++) {
		    attackmoves[i].coordinates.update(x, y);
		}
	}
	
	public void setDirection(int dir) {
		for(int i=0;i<attackmoves.length;i++) {
		       attackmoves[i].setDirection(dir);
		}
	}
	
	public void update(boolean[] keyCode, GameData gameData) {
        if(keyCode[KeyEvent.VK_A])setDirection(0);
        if(keyCode[KeyEvent.VK_W])setDirection(1);
        if(keyCode[KeyEvent.VK_D])setDirection(2);
        if(keyCode[KeyEvent.VK_S])setDirection(3);
    }
	
	
}
