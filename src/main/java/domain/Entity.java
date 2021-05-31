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
		
		if(!collision(xa,ya,level)) {
			x += xa;
			y += ya;
		}
		coordinates.update(x,y);
		updateAttacks();
	}
	
	public boolean collision(int xa, int ya,Level level) {	
		for(int c=0 ; c<4 ; c++) {	
			//-16 ΠΑΡΑΔΟΧΗ for player to be rendered in the middle of the screen, because to be pretty I have to render +1 tile in width
			// and +1 in height
			//checking 4 neighboring tiles if any of them or more are solid.If so doesn't allow moving toward them
			//	%2 and /2 because 4 corners in a tile, *10 how big is the hitbox, +-B(BUFFER)
			int xt = ((x + xa) + c % 2 *10 - 16 +2)/16;	//  how wide is the horizontal hitbox
			int yt = ((y + ya) + c / 2 * 14  -16 +1)/16;	//	how big vertically is the hitbox
			if(level.getTile(xt,yt).solid()) {
				return true;
			}
		}
		return false;	
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
	
	public void update(Level level, boolean[] keyCode, GameData gameData) {
        if(keyCode[KeyEvent.VK_A])setDirection(0);
        if(keyCode[KeyEvent.VK_W])setDirection(1);
        if(keyCode[KeyEvent.VK_D])setDirection(2);
        if(keyCode[KeyEvent.VK_S])setDirection(3);
    }
	
	
}
