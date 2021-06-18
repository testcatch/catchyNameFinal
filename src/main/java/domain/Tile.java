package domain;

import java.util.HashMap;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
	
	private Sprite sprite;
	private static HashMap<Integer,Tile> tileHash = new HashMap<>();
	private boolean solid;
	
	public Tile(Sprite sprite,boolean solid) {
		this.sprite = sprite;
		this.solid = solid;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	
	}
	
	public boolean solid() {
		return solid;
	}
	
	public static Tile getTile(int key) {
		return tileHash.get(key);
	}
	
	public static void hashInsert(int key, Sprite sprite, boolean solid) {
		tileHash.put(key,new Tile(sprite,solid));
	}

	public Sprite getSprite() {
		return sprite;
	}
}
