package tiles;

import graphics.Screen;
import graphics.Sprite;

public class SpawnVoidTile extends Tile{

	public SpawnVoidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);	//converting back to pixel  precision
	}

	public boolean solid() {
		return true;
	}
}
