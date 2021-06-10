package tiles;

import java.util.HashMap;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
	
	
	// a tile will have a sprite 
	//even when an error will occur a sprite will be displayed
	public int x,y;
	public Sprite sprite;
	private int colorId;
	private static HashMap<Integer,Tile> tileHash = new HashMap<Integer,Tile>();
	
	private static Tile spawnGrassTile = new SpawnGrassTile(Sprite.spawnGrass,0xff00ff21);
	private static Tile spawnWaterTile = new SpawnWaterTile(Sprite.spawnWater, 0xff0026ff);
	//public static Tile spawnWood = new SpawnWoodTile(Sprite.spawnWood);
	private static Tile spawnBricks1 = new SpawnWallTile(Sprite.spawnBricks1,0xff404040);
	private static Tile spawnBricks2 = new SpawnWallTile(Sprite.spawnBricks2,0xffffd800);
	private static Tile spawnBlood = new SpawnBloodTile(Sprite.spawnBlood,0xffff0000);
	private static Tile spawnVoid = new SpawnVoidTile(Sprite.spawnVoid,0xff000000);
	
	
	// colors used in Spawn image for representing Spawn Level Tiles
//	public final static int colSpawnGrass = 0xff00ff21;
//	public final static int colSpawnBlood = 0xffff0000;
//	public final static int colSpawnBricks1 = 0xff404040;
//	public final static int colSpawnBricks2 = 0xffffd800; 
//	public final static int colSpawnWater = 0xff0026ff;
//	public final static int colSpawnLocation = 0xff00ffff;
	
	
	public Tile(Sprite sprite,int colorId) {
		this.sprite = sprite;
		this.colorId = colorId;
		tileHash.put(colorId, this);
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
	
	public static Tile getTile(int key) {
		return tileHash.get(key);
	}
	
	
	
	
	
	
	
	
	
	
}
