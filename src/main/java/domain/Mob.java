package domain;

import java.util.Random;

import graphics.Sprite;

public class Mob extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Random random;
	private Item loot;
	private int points = 5;
	
	public Mob(Coordinates spawn,Sprite sprite, Coordinates target) {
		super(spawn,sprite,Sprite.testingSprite);
		this.target = target;
	}
	
	public Item getItem() {
		return loot;
	}

	public void removeItem() {
		loot = null;
	}
	
	public void update(GameData gameData) {
		random = new Random();
		int xa = random.nextInt(4); 
	    int ya = random.nextInt(4); 
		move(xa,ya,gameData.getLevel());
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
			Mob temp = (Mob) o;
		   return this.coordinates.equals(temp.coordinates);
		}else {
			return false;
		}
	}
	
	@Override
	public void move(int xa , int ya,Level level) {
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
	}

	public void givePoints(Player player) {
		player.addPoints(points);
	}
}
