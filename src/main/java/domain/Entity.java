package domain;

import java.io.Serializable;

import graphics.Screen;
import graphics.Sprite;

public abstract class Entity extends Renderables implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Projectiles[] projectiles = new Projectiles[15];
	
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
		for(int i=0;i<projectiles.length;i++) {
			projectiles[i] = new Projectiles(new Coordinates(x/16,y/16,5),projectilesprite);
		}
	}
	
	@Override
	public int hashCode() {
		return coordinates.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(this.getClass() == o.getClass()) {
			Entity temp = (Entity) o;
		   return this.coordinates.equals(temp.coordinates);
		}else {
			return false;
		}
	}
	
	@Override
	public void setScreen(Screen screen) {
		for(int i=0;i<projectiles.length;i++) {
			projectiles[i].setScreen(screen);
		}
		super.setScreen(screen);
	}

	public void updateAttacks() {
		for(int i=0;i<projectiles.length;i++) {
			projectiles[i].coordinates.update(x, y);
		}
	}
	
	public void setDirection(int dir) {
		for(int i=0;i<projectiles.length;i++) {
			projectiles[i].setDirection(dir);
		}
	}
}
