package domain;

import java.io.Serializable;

import com.game.catchyname.graphics.Sprite;

import utilities.Coordinates;

public class Item extends Renderables implements Serializable,Comparable<Item>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinates target;	

	public Item(Coordinates coordinates, Sprite sprite, Coordinates target) {
		super(coordinates,sprite);
		this.target = target;
	}
	
	@Override
	public int compareTo(Item o) {
		double distance_this_target = Math.sqrt(Math.pow((double)this.coordinates.getX()-target.getX(),2) + Math.pow((double)this.coordinates.getY()-target.getY(),2));
		double distance_temp_target = Math.sqrt(Math.pow((double)o.coordinates.getX()-target.getX(),2) + Math.pow((double)o.coordinates.getY()-target.getY(),2));
		if(distance_this_target>distance_temp_target) {
			return 1;
		}else if(distance_this_target==distance_temp_target) {
		    return 0;
		}else {
			return -1;
		}
	}
}
