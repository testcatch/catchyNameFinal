package domain;

import java.io.Serializable;

import graphics.Sprite;

public class Item extends Renderables implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Item(Coordinates coordinates, Sprite sprite, Coordinates target) {
		super(coordinates,sprite);
		this.target = target;
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
			Item temp = (Item) o;
		   return this.coordinates.equals(temp.coordinates);
		}else {
			return false;
		}
	}
}
