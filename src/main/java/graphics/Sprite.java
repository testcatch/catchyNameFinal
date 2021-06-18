package graphics;

import java.io.Serializable;

import domain.Tile;

public class Sprite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size;
	private int x;
	private int y;
	private int[] pixels;
	private SpriteSheet sheet = SpriteSheet.helloWorld;
	
	//playerSprites
	public static final Sprite testingSprite = new Sprite(32,2,4);
	//tiles
	private static final Sprite grass_shoppable = new Sprite(16,0,0);
	private static final Sprite grass_flower_shoppable = new Sprite(16,0,1);
	private static final Sprite grass_rocky_shoppable = new Sprite(16,0,2);
	private static final Sprite water = new Sprite(16,4,0);
	private static final Sprite void_pink = new Sprite(16,5,0);
 
	private static final Sprite shop00 = new Sprite(16,12,3);
	private static final Sprite shop01 = new Sprite(16,13,3);
	private static final Sprite shop02 = new Sprite(16,14,3);
	private static final Sprite shop10 = new Sprite(16,12,4);
	private static final Sprite shop11 = new Sprite(16,13,4);
	private static final Sprite shop12 = new Sprite(16,14,4);
	private static final Sprite shop20 = new Sprite(16,12,5);
	private static final Sprite shop21 = new Sprite(16,13,5);
	private static final Sprite shop22 = new Sprite(16,14,5);
 	
	private static final Sprite tree1TL = new Sprite(16,2,12);
	private static final Sprite tree1TR = new Sprite(16,3,12);		
	private static final Sprite tree1BL = new Sprite(16,2,13);
	private static final Sprite tree1BR = new Sprite(16,3,13);

	private static final Sprite tree2TL = new Sprite(16,2,12);
	private static final Sprite tree2TR = new Sprite(16,3,12);		
	private static final Sprite tree2BL = new Sprite(16,2,13);
	private static final Sprite tree2BR = new Sprite(16,3,13);

	private static final Sprite road00 = new Sprite(16,1,0);
	private static final Sprite road01 = new Sprite(16,2,0);
	private static final Sprite road02 = new Sprite(16,3,0);
	private static final Sprite road10 = new Sprite(16,1,1);
	private static final Sprite road11 = new Sprite(16,2,1);
	private static final Sprite road12 = new Sprite(16,3,1);
	private static final Sprite road20 = new Sprite(16,1,2);
	private static final Sprite road21 = new Sprite(16,2,2);
	private static final Sprite road22 = new Sprite(16,3,2);

	private static final Sprite cabin00 = new Sprite(16,9,3);
	private static final Sprite cabin01 = new Sprite(16,10,3);
	private static final Sprite cabin02 = new Sprite(16,11,3);
	private static final Sprite cabin10 = new Sprite(16,9,4);
	private static final Sprite cabin11 = new Sprite(16,10,4);
	private static final Sprite cabin12 = new Sprite(16,11,4);
	private static final Sprite cabin20 = new Sprite(16,9,5);
	private static final Sprite cabin21 = new Sprite(16,10,5);
	private static final Sprite cabin22 = new Sprite(16,11,5);

	private static final Sprite armory00 = new Sprite(16,0,12);
	private static final Sprite armory01 = new Sprite(16,1,12);
	private static final Sprite armory10 = new Sprite(16,0,13);
	private static final Sprite armory11 = new Sprite(16,1,13);

	private static final Sprite bridge00 = new Sprite(16,4,1);
	private static final Sprite bridge01 = new Sprite(16,5,1);
	private static final Sprite bridge02 = new Sprite(16,6,1);
	private static final Sprite bridge03 = new Sprite(16,7,1);
	private static final Sprite bridge10 = new Sprite(16,4,2);
	private static final Sprite bridge11 = new Sprite(16,5,2);
	private static final Sprite bridge12 = new Sprite(16,6,2);
	private static final Sprite bridge13 = new Sprite(16,7,2);
	private static final Sprite bridge20 = new Sprite(16,4,3);
	private static final Sprite bridge21 = new Sprite(16,5,3);
	private static final Sprite bridge22 = new Sprite(16,6,3);
	private static final Sprite bridge23 = new Sprite(16,7,3);
	private static final Sprite bridge30 = new Sprite(16,4,4);
	private static final Sprite bridge31 = new Sprite(16,5,4);
	private static final Sprite bridge32 = new Sprite(16,6,4);
	private static final Sprite bridge33 = new Sprite(16,7,4);

	private static final Sprite tree3_00 = new Sprite(16,3,10);
	private static final Sprite tree3_10 = new Sprite(16,3,11);
	
	private static final Sprite chinese00 = new Sprite(16,0,4);
	private static final Sprite chinese01 = new Sprite(16,1,4);
	private static final Sprite chinese02 = new Sprite(16,2,4);
	private static final Sprite chinese03 = new Sprite(16,3,4);
	private static final Sprite chinese10 = new Sprite(16,0,5);
	private static final Sprite chinese11 = new Sprite(16,1,5);
	private static final Sprite chinese12 = new Sprite(16,2,5);
	private static final Sprite chinese13 = new Sprite(16,3,5);
	private static final Sprite chinese20 = new Sprite(16,0,6);
	private static final Sprite chinese21 = new Sprite(16,1,6);
	private static final Sprite chinese22 = new Sprite(16,2,6);
	private static final Sprite chinese23 = new Sprite(16,3,6);
	private static final Sprite chinese30 = new Sprite(16,0,7);
	private static final Sprite chinese31 = new Sprite(16,1,7);
	private static final Sprite chinese32 = new Sprite(16,2,7);
	private static final Sprite chinese33 = new Sprite(16,3,7);

	private static final Sprite heart00 = new Sprite(16,0,8);
	private static final Sprite heart01 = new Sprite(16,1,8);
	private static final Sprite heart02 = new Sprite(16,2,8);
	private static final Sprite heart10 = new Sprite(16,0,9);
	private static final Sprite heart11 = new Sprite(16,1,9);
	private static final Sprite heart12 = new Sprite(16,2,9);
	private static final Sprite heart20 = new Sprite(16,0,10);
	private static final Sprite heart21 = new Sprite(16,1,10);
	private static final Sprite heart22 = new Sprite(16,2,10);
	private static final Sprite heart30 = new Sprite(16,0,11);
	private static final Sprite heart31 = new Sprite(16,1,11);
	private static final Sprite heart32 = new Sprite(16,2,11);
	
	private static final Sprite fence00 = new Sprite(16,0,14);
	private static final Sprite fence01 = new Sprite(16,1,14);
	private static final Sprite fence10 = new Sprite(16,0,15);
	private static final Sprite fence11 = new Sprite(16,1,15);

 	//not tiles
 	public static final Sprite potionAttackGreen = new Sprite(16,7,0);
 	public static final Sprite potionAttackRed = new Sprite(16,9,0);
 	public static final Sprite potionAttackPurple = new Sprite(16,1,3);
 	public static final Sprite swordAttackGray = new Sprite(16,8,1);
 	public static final Sprite swordAttackPink = new Sprite(16,9,1);
 	public static final Sprite swordAttackBlue = new Sprite(16,8,0);
 	public static final Sprite arrowAttackGray = new Sprite(16,3,3);
 	public static final Sprite arrowAttackRed = new Sprite(16,10,0);
 	public static final Sprite arrowAttackPurple = new Sprite(16,0,3);
 	public static final Sprite ultimateRedX = new Sprite(16,11,0);
 	public static final Sprite ultimateGreenX = new Sprite(16,2,3);
 	public static final Sprite ultimateCloud = new Sprite(16,12,0);
	
	//The below Constructor is used for Tiles only to put them into the tile HashMap
	public Sprite(int size, int x, int y) {
		this.size = size;
		this.x = x * size;// because every cell in the spritesheet is 16x16px
		this.y = y * size;
		pixels = new int[size * size];
		load();
	}
	
	public static void initTiles() {
		Tile.hashInsert(0xff006b00, grass_shoppable, false);
		Tile.hashInsert(0xff00ff21, grass_flower_shoppable, false);
		Tile.hashInsert(0xff4cff00, grass_rocky_shoppable, false);
		Tile.hashInsert(0xff0026ff, water, true);
		Tile.hashInsert(0xff696969, void_pink, true);
		
		Tile.hashInsert(0xff7F006E, shop00, true);
		Tile.hashInsert(0xff7F016E, shop01, true);
		Tile.hashInsert(0xff7F026E, shop02, true);
		Tile.hashInsert(0xff7F106E, shop10, true);
		Tile.hashInsert(0xff7F116E, shop11, true);
		Tile.hashInsert(0xff7F126E, shop12, true);
		Tile.hashInsert(0xff7F206E, shop20, true);
		Tile.hashInsert(0xff7F216E, shop21, true);
		Tile.hashInsert(0xff7F226E, shop22, true);
		
		
		Tile.hashInsert(0xffff0000, tree1TL, false);
		Tile.hashInsert(0xffffd800, tree1TR, false);
		Tile.hashInsert(0xff4800ff, tree1BL, false);
		Tile.hashInsert(0xffff006e, tree1BR, false);
		
		Tile.hashInsert(0xffB6E082, tree2TL, false);
		Tile.hashInsert(0xffB6E083, tree2TR, false);
		Tile.hashInsert(0xffB6E084, tree2BL, false);
		Tile.hashInsert(0xffB6E085, tree2BR, false);
		
		Tile.hashInsert(0xff808080, road00, false);
		Tile.hashInsert(0xff818080, road01, false);
		Tile.hashInsert(0xff828080, road02, false);
		Tile.hashInsert(0xff838080, road10, false);
		Tile.hashInsert(0xff848080, road11, false);
		Tile.hashInsert(0xff858080, road12, false);
		Tile.hashInsert(0xff868080, road20, false);
		Tile.hashInsert(0xff878080, road21, false);
		Tile.hashInsert(0xff888080, road22, false);
		
		Tile.hashInsert(0xff4d2780, cabin00, true);
		Tile.hashInsert(0xff4d2781, cabin01, true);
		Tile.hashInsert(0xff4d2782, cabin02, true);
		Tile.hashInsert(0xff4d2783, cabin10, true);
		Tile.hashInsert(0xff4d2784, cabin11, true);
		Tile.hashInsert(0xff4d2785, cabin12, true);
		Tile.hashInsert(0xff4d2786, cabin20, true);
		Tile.hashInsert(0xff4d2787, cabin21, true);
		Tile.hashInsert(0xff4d2788, cabin22, true);
		
		Tile.hashInsert(0xffe49fc2, armory00, true);
		Tile.hashInsert(0xffe49fc3, armory01, true);
		Tile.hashInsert(0xffe49fc4, armory10, true);
		Tile.hashInsert(0xffe49fc5, armory11, true);
		
		Tile.hashInsert(0xff6a7e23, bridge00, true);
		Tile.hashInsert(0xff6a7e24, bridge01, true);
		Tile.hashInsert(0xff6a7e25, bridge02, true);
		Tile.hashInsert(0xff6a7e26, bridge03, true);
		Tile.hashInsert(0xff6a7e27, bridge10, false);
		Tile.hashInsert(0xff6a7e28, bridge11, false);
		Tile.hashInsert(0xff6a7e29, bridge12, false);
		Tile.hashInsert(0xff6a7e2a, bridge13, false);
		Tile.hashInsert(0xff6a7e2b, bridge20, true);
		Tile.hashInsert(0xff6a7e2c, bridge21, true);
		Tile.hashInsert(0xff6a7e2d, bridge22, true);
		Tile.hashInsert(0xff6a7e2e, bridge23, true);
		Tile.hashInsert(0xff6a7e2f, bridge30, true);
		Tile.hashInsert(0xff6a8e2f, bridge31, true);
		Tile.hashInsert(0xff6a9e2f, bridge32, true);
		Tile.hashInsert(0xff6aae2f, bridge33, true);
		
		Tile.hashInsert(0xff3e593e, tree3_00, false);
		Tile.hashInsert(0xff3e593f, tree3_10, false);
		
		Tile.hashInsert(0xffe2b5d9, chinese00, true);
		Tile.hashInsert(0xffe2b5da, chinese01, true);
		Tile.hashInsert(0xffe2b5db, chinese02, true);
		Tile.hashInsert(0xffe2b5dc, chinese03, true);
		Tile.hashInsert(0xffe2b5dd, chinese10, true);
		Tile.hashInsert(0xffe2b5de, chinese11, true);
		Tile.hashInsert(0xffe2b5df, chinese12, true);
		Tile.hashInsert(0xffe3b5d0, chinese13, true);
		Tile.hashInsert(0xffe3b5d1, chinese20, true);
		Tile.hashInsert(0xffe3b5d2, chinese21, true);
		Tile.hashInsert(0xffe3b5d3, chinese22, true);
		Tile.hashInsert(0xffe3b5d4, chinese23, true);
		Tile.hashInsert(0xffe3b5d5, chinese30, true);
		Tile.hashInsert(0xffe3b5d6, chinese31, true);
		Tile.hashInsert(0xffe3b5d7, chinese32, true);
		Tile.hashInsert(0xffe3b5d8, chinese33, true);
		
		Tile.hashInsert(0xff6a7ee2, heart00, true);
		Tile.hashInsert(0xff6a7ee3, heart01, true);
		Tile.hashInsert(0xff6a7ee4, heart02, true);
		Tile.hashInsert(0xff6a7ee5, heart10, true);
		Tile.hashInsert(0xff6a7ee6, heart11, true);
		Tile.hashInsert(0xff6a7ee7, heart12, true);
		Tile.hashInsert(0xff6a7ee8, heart20, true);
		Tile.hashInsert(0xff6a7ee9, heart21, true);
		Tile.hashInsert(0xff6a7eea, heart22, true);
		Tile.hashInsert(0xff6a7eeb, heart30, true);
		Tile.hashInsert(0xff6a7eec, heart31, true);
		Tile.hashInsert(0xff6a7eed, heart32, true);
		
		Tile.hashInsert(0xffcd4c00, fence00, true);
		Tile.hashInsert(0xffcd4c01, fence01, true);
		Tile.hashInsert(0xffcd4c02, fence10, true);
		Tile.hashInsert(0xffcd4c03, fence11, true);
	}
	
	private void load() {
		for(int i=0 ; i < getSize() ; i++) {
			for(int j=0 ; j< getSize() ; j++) {
				getPixels()[j+i*getSize()] = sheet.getPixels()[( j + this.x) + ( i+ this.y) * sheet.getSIZE()];
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
