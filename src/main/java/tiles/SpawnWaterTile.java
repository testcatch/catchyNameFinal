package tiles;

import graphics.Screen;
import graphics.Sprite;

public class SpawnWaterTile extends Tile{
	
	public SpawnWaterTile(Sprite sprite,int id) {
		super(sprite,id);	
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	//converting back to pixels precision
	}
}
