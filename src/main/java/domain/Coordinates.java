package domain;

import java.io.Serializable;

public class Coordinates implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int TILE_SIZE=16;
	private int hitbox;
	
	public Coordinates(int x,int y,int hitbox) {
		this.x = x*TILE_SIZE;
		this.y = y*TILE_SIZE;
		this.hitbox = hitbox;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return hitbox;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(this.getClass() == o.getClass()) {
			Coordinates temp = (Coordinates) o;
		    int totalHitbox = temp.hitbox + this.hitbox;
		    return (Math.abs(temp.x - this.x)<=totalHitbox)&&(Math.abs(temp.y - this.y)<=totalHitbox);
		}else {
			return false;
		}
	}
	
	public void update(int x2, int y2) {
		this.x = x2;
		this.y = y2;
	}
}
