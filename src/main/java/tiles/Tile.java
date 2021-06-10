package tiles;

import java.util.HashMap;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
	
	public int x,y;
	public Sprite sprite;
	protected static HashMap<Integer,Tile> tileHash = new HashMap<Integer,Tile>();
	

	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	
	}
	
	public boolean solid() {
		return false;
	}
	
	public static Tile getTile(int key) {
		return tileHash.get(key);
	}
	
	public static void hashInsert(int key, Sprite sprite, boolean solid) {
		if(solid) {
			tileHash.put(key,new SolidTile(sprite));
		}
		else{
			tileHash.put(key,new Tile(sprite));
		}
	}
}
