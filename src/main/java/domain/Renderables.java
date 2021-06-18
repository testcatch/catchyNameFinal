package domain;

import java.io.Serializable;

import graphics.Screen;
import graphics.Sprite;

public abstract class Renderables implements Serializable, Comparable<Renderables>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Sprite sprite;
	protected Coordinates coordinates;
	protected Screen screen;

	protected Coordinates target;
	
	protected Renderables(Coordinates spawn, Sprite sprite) {
		this.sprite = sprite;
		this.coordinates = spawn;
	}

	public void render() {
		screen.render(coordinates.getX()-16, coordinates.getY()-16, sprite);
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
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
			Renderables temp = (Renderables) o;
		   return this.coordinates.equals(temp.coordinates);
		}else {
			return false;
		}
	}
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	@Override
	public int compareTo(Renderables o) {
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
