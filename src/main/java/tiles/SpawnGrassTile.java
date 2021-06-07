package tiles;

import graphics.Screen;
import graphics.Sprite;

public class SpawnGrassTile extends Tile{

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	//converting back to pixels precision
	}

}
