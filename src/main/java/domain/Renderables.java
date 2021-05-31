package domain;

import java.io.Serializable;

import com.game.catchyname.graphics.Screen;
import com.game.catchyname.graphics.Sprite;

import utilities.Coordinates;

public abstract class Renderables implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Sprite sprite;
	protected Coordinates coordinates;
	protected Screen screen;
	
	protected Renderables(Coordinates spawn, Sprite sprite) {
		this.sprite = sprite;
		this.coordinates = spawn;
	}

	public void render() {
		screen.renderPlayer(coordinates.getX()-16, coordinates.getY()-16, sprite);
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
}
