package tiles;

import graphics.Screen;
import graphics.Sprite;

public class SpawnWallTile extends Tile{

	public SpawnWallTile(Sprite sprite,int id) {
		super(sprite,id);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	//converting back to pixel precision
	}
	
	public boolean solid() {
		return true;
	}
}
