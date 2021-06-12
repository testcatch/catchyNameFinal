package graphics;

import java.io.Serializable;
import java.util.Random;

import domain.Tile;

public class Screen implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapSize = 8;
	
	private int tiles=64;
	private int[]tilesarray = new int[tiles*tiles]; 
	
	private int width;
	private int height;
	private int[] pixels;
	private int xOffset;
	private int yOffset;
	private Random random = new Random();   
	
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];    //0-50.399 pixels
		
		for(int i=0; i< mapSize *mapSize ;i++) {
			tilesarray[i]= random.nextInt(0xffffff);
			tilesarray[0] = 0;
		}
	}
	
	//set everything to black
	public void clear() {
		for(int i=0; i<getPixels().length;i++) {
			getPixels()[i] = 0;
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void render(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for( int y=0; y< sprite.getSize(); y++) {	
			int ya = y + yp;    					
			for( int x=0; x< sprite.getSize() ; x++) {
				int xa = x + xp;   
				if(xa < -sprite.getSize() || xa >= getWidth() || ya < 0 || ya >= getHeight())break;
				if(xa<0) xa=0;
				int col = sprite.getPixels()[x+y*sprite.getSize()];
				if(col != 0xffffac75)
				//^^^^^^^^^only render the tiles I am seeing and not all the map, important line of code
					getPixels()[xa+ya*getWidth()] = sprite.getPixels()[x+y*sprite.getSize()];
				//where the sprite is rendered------>which pixels of the sprite are rendered
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}
}
