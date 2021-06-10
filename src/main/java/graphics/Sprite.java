package graphics;

import java.io.Serializable;

import tiles.Tile;

public class Sprite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	private int givenCoins,price;
	
	
	//Player Sprites
	public static Sprite playerFront = new Sprite(16,5,0,SpriteSheet.tiles);
	public static Sprite playerRight = new Sprite(16,6,0,SpriteSheet.tiles);
	public static Sprite playerLeft = new Sprite(16,3,1,SpriteSheet.tiles);
	public static Sprite playerBehind = new Sprite(16,4,1,SpriteSheet.tiles);
	//General Sprites
	public static Sprite grass = new Sprite(16,0,0,SpriteSheet.tiles);  
	public static Sprite rock = new Sprite(16,0,2,SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0x1b87e0);
	//Spawn Level Sprites
	public static Sprite spawnGrass= new Sprite(16,1,0,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnWater= new Sprite(16,0,1,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnBricks1= new Sprite(16,0,0,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnBricks2= new Sprite(16,0,2,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnWood= new Sprite(16,1,1,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnBlood= new Sprite(16,2,0,SpriteSheet.spawnLevelTiles);
	public static Sprite spawnVoid = new Sprite(16,1,2,SpriteSheet.spawnLevelTiles);
	//Attack Sprites
	public static Sprite potion = new Sprite(16,9,0,SpriteSheet.tiles);
	public static Sprite arrow = new Sprite(16,10,0,SpriteSheet.tiles);
	public static Sprite ultimate = new Sprite(16,11,0,SpriteSheet.tiles);
	public static Sprite lightning = new Sprite(16,12,0,SpriteSheet.tiles);

	public static Sprite testingSprite = new Sprite(32,0,0,SpriteSheet.test);
	//-------------------------------------------------------------------------------------------
	//from the new HelloWorld SpriteSheet images
	public static Sprite grass_shoppable = new Sprite(16,0,0,SpriteSheet.helloWorld,0xff006b00,false);
 	public static Sprite grass_flower_shoppable = new Sprite(16,0,1,SpriteSheet.helloWorld,0xff00ff21,false);
 	public static Sprite grass_rocky_shoppable = new Sprite(16,0,2,SpriteSheet.helloWorld,0xff4cff00,false);
 	public static Sprite water = new Sprite(16,4,0,SpriteSheet.helloWorld,0xff0026ff,true);
 	public static Sprite void_pink = new Sprite(16,5,0,SpriteSheet.helloWorld,0xff696969,false);
 	//------------------------------SHOP----------------------------
 	public static Sprite shop00 = new Sprite(16,1,0,SpriteSheet.helloWorld,0xff7F006E,true);
 	public static Sprite shop01 = new Sprite(16,2,0,SpriteSheet.helloWorld,0xff7F016E,true);
 	public static Sprite shop02 = new Sprite(16,3,0,SpriteSheet.helloWorld,0xff7F026E,true);
 	public static Sprite shop10 = new Sprite(16,1,1,SpriteSheet.helloWorld,0xff7F106E,true);
 	public static Sprite shop11 = new Sprite(16,2,1,SpriteSheet.helloWorld,0xff7F116E,true);
 	public static Sprite shop12 = new Sprite(16,3,1,SpriteSheet.helloWorld,0xff7F126E,true);
 	public static Sprite shop20 = new Sprite(16,1,2,SpriteSheet.helloWorld,0xff7F206E,true);
 	public static Sprite shop21 = new Sprite(16,2,2,SpriteSheet.helloWorld,0xff7F216E,true);
	public static Sprite shop22 = new Sprite(16,3,2,SpriteSheet.helloWorld,0xff7F226E,true);
 	//-----------------------TREE1(WITH APPLES)---------------------------
 	public static Sprite tree1TL = new Sprite(16,7,1,SpriteSheet.helloWorld,0xffff0000,false);
 	public static Sprite tree1TR = new Sprite(16,8,1,SpriteSheet.helloWorld,0xffffd800,false);		
 	public static Sprite tree1BL = new Sprite(16,7,2,SpriteSheet.helloWorld,0xff4800ff,false);
 	public static Sprite tree1BR = new Sprite(16,8,2,SpriteSheet.helloWorld,0xffff006e,false);
 	//------------------------TREE2(WITHOUT APPLES)---------------------------
 	public static Sprite tree2TL = new Sprite(16,9,1,SpriteSheet.helloWorld,0xffB6E082,false);
 	public static Sprite tree2TR = new Sprite(16,10,1,SpriteSheet.helloWorld,0xffB6E083,false);		
 	public static Sprite tree2BL = new Sprite(16,9,2,SpriteSheet.helloWorld,0xffB6E084,false);
 	public static Sprite tree2BR = new Sprite(16,10,2,SpriteSheet.helloWorld,0xffB6E085,false);
 	//----------------------------------ROAD----------------------------------
 	public static Sprite road00 = new Sprite(16,4,1,SpriteSheet.helloWorld,0xff808080,false);
 	public static Sprite road01 = new Sprite(16,5,1,SpriteSheet.helloWorld,0xff818080,false);
 	public static Sprite road02 = new Sprite(16,6,1,SpriteSheet.helloWorld,0xff828080,false);
 	public static Sprite road10 = new Sprite(16,4,2,SpriteSheet.helloWorld,0xff838080,false);
 	public static Sprite road11 = new Sprite(16,5,2,SpriteSheet.helloWorld,0xff848080,false);
 	public static Sprite road12 = new Sprite(16,6,2,SpriteSheet.helloWorld,0xff858080,false);
 	public static Sprite road20 = new Sprite(16,4,3,SpriteSheet.helloWorld,0xff868080,false);
 	public static Sprite road21 = new Sprite(16,5,3,SpriteSheet.helloWorld,0xff878080,false);
 	public static Sprite road22 = new Sprite(16,6,3,SpriteSheet.helloWorld,0xff888080,false);
 	//-------------------------------CABIN-----------------------------------
 	public static Sprite cabin00 = new Sprite(16,13,0,SpriteSheet.helloWorld,0xff4d2780,true);
 	public static Sprite cabin01 = new Sprite(16,14,0,SpriteSheet.helloWorld,0xff4d2781,true);
 	public static Sprite cabin02 = new Sprite(16,15,0,SpriteSheet.helloWorld,0xff4d2782,true);
 	public static Sprite cabin10 = new Sprite(16,13,1,SpriteSheet.helloWorld,0xff4d2783,true);
 	public static Sprite cabin11 = new Sprite(16,14,1,SpriteSheet.helloWorld,0xff4d2784,true);
 	public static Sprite cabin12 = new Sprite(16,15,1,SpriteSheet.helloWorld,0xff4d2785,true);
 	public static Sprite cabin20 = new Sprite(16,13,2,SpriteSheet.helloWorld,0xff4d2786,true);
 	public static Sprite cabin21 = new Sprite(16,14,2,SpriteSheet.helloWorld,0xff4d2787,true);
 	public static Sprite cabin22 = new Sprite(16,15,2,SpriteSheet.helloWorld,0xff4d2788,true);
 	//--------------------------------ARMORY---------------------------------
 	public static Sprite armory00 = new Sprite(16,0,3,SpriteSheet.helloWorld,0xffe49fc2,true);
 	public static Sprite armory01 = new Sprite(16,1,3,SpriteSheet.helloWorld,0xffe49fc3,true);
 	public static Sprite armory10 = new Sprite(16,0,4,SpriteSheet.helloWorld,0xffe49fc4,true);
 	public static Sprite armory11 = new Sprite(16,1,4,SpriteSheet.helloWorld,0xffe49fc5,true);
 	//-------------------------------BRIDGE----------------------------------
 	public static Sprite bridge00 = new Sprite(16,7,5,SpriteSheet.helloWorld,0xff6a7e23,true);
 	public static Sprite bridge01 = new Sprite(16,8,5,SpriteSheet.helloWorld,0xff6a7e24,true);
 	public static Sprite bridge02 = new Sprite(16,9,5,SpriteSheet.helloWorld,0xff6a7e25,true);
 	public static Sprite bridge03 = new Sprite(16,10,5,SpriteSheet.helloWorld,0xff6a7e26,true);
 	public static Sprite bridge10 = new Sprite(16,7,6,SpriteSheet.helloWorld,0xff6a7e27,false);
 	public static Sprite bridge11 = new Sprite(16,8,6,SpriteSheet.helloWorld,0xff6a7e28,false);
 	public static Sprite bridge12 = new Sprite(16,9,6,SpriteSheet.helloWorld,0xff6a7e29,false);
 	public static Sprite bridge13 = new Sprite(16,10,6,SpriteSheet.helloWorld,0xff6a7e2a,false);
 	public static Sprite bridge20 = new Sprite(16,7,7,SpriteSheet.helloWorld,0xff6a7e2b,true);
 	public static Sprite bridge21 = new Sprite(16,8,7,SpriteSheet.helloWorld,0xff6a7e2c,true);
 	public static Sprite bridge22 = new Sprite(16,9,7,SpriteSheet.helloWorld,0xff6a7e2d,true);
 	public static Sprite bridge23 = new Sprite(16,10,7,SpriteSheet.helloWorld,0xff6a7e2e,true);
 	public static Sprite bridge30 = new Sprite(16,7,8,SpriteSheet.helloWorld,0xff6a7e2f,true);
 	public static Sprite bridge31 = new Sprite(16,8,8,SpriteSheet.helloWorld,0xff6a8e2f,true);
 	public static Sprite bridge32 = new Sprite(16,9,8,SpriteSheet.helloWorld,0xff6a9e2f,true);
 	public static Sprite bridge33 = new Sprite(16,10,8,SpriteSheet.helloWorld,0xff6aae2f,true);
 	//-------------------------------TREE3----------------------------------
 	public static Sprite tree3_00 = new Sprite(16,11,6,SpriteSheet.helloWorld,0xff3e593e,false);
 	public static Sprite tree3_10 = new Sprite(16,11,7,SpriteSheet.helloWorld,0xff3e593f,false);
 	//--------------------------------CHINESE HOUSE----------------------------
 	public static Sprite chinese00 = new Sprite(16,0,5,SpriteSheet.helloWorld,0xffe2b5d9,true);
 	public static Sprite chinese01 = new Sprite(16,1,5,SpriteSheet.helloWorld,0xffe2b5da,true);
 	public static Sprite chinese02 = new Sprite(16,2,5,SpriteSheet.helloWorld,0xffe2b5db,true);
 	public static Sprite chinese03 = new Sprite(16,3,5,SpriteSheet.helloWorld,0xffe2b5dc,true);
 	public static Sprite chinese10 = new Sprite(16,0,6,SpriteSheet.helloWorld,0xffe2b5dd,true);
 	public static Sprite chinese11 = new Sprite(16,1,6,SpriteSheet.helloWorld,0xffe2b5de,true);
 	public static Sprite chinese12 = new Sprite(16,2,6,SpriteSheet.helloWorld,0xffe2b5df,true);
 	public static Sprite chinese13 = new Sprite(16,3,6,SpriteSheet.helloWorld,0xffe3b5d0,true);
 	public static Sprite chinese20 = new Sprite(16,0,7,SpriteSheet.helloWorld,0xffe3b5d1,true);
 	public static Sprite chinese21 = new Sprite(16,1,7,SpriteSheet.helloWorld,0xffe3b5d2,true);
 	public static Sprite chinese22 = new Sprite(16,2,7,SpriteSheet.helloWorld,0xffe3b5d3,true);
 	public static Sprite chinese23 = new Sprite(16,3,7,SpriteSheet.helloWorld,0xffe3b5d4,true);
 	public static Sprite chinese30 = new Sprite(16,0,8,SpriteSheet.helloWorld,0xffe3b5d5,true);
 	public static Sprite chinese31 = new Sprite(16,1,8,SpriteSheet.helloWorld,0xffe3b5d6,true);
 	public static Sprite chinese32 = new Sprite(16,2,8,SpriteSheet.helloWorld,0xffe3b5d7,true);
 	public static Sprite chinese33 = new Sprite(16,3,8,SpriteSheet.helloWorld,0xffe3b5d8,true);
 	//----------------------------HEART MONUMENT----------------------------
 	public static Sprite heart00 = new Sprite(16,4,5,SpriteSheet.helloWorld,0xff6a7ee2,true);
 	public static Sprite heart01 = new Sprite(16,5,5,SpriteSheet.helloWorld,0xff6a7ee3,true);
 	public static Sprite heart02 = new Sprite(16,6,5,SpriteSheet.helloWorld,0xff6a7ee4,true);
 	public static Sprite heart10 = new Sprite(16,4,6,SpriteSheet.helloWorld,0xff6a7ee5,true);
 	public static Sprite heart11 = new Sprite(16,5,6,SpriteSheet.helloWorld,0xff6a7ee6,true);
 	public static Sprite heart12 = new Sprite(16,6,6,SpriteSheet.helloWorld,0xff6a7ee7,true);
 	public static Sprite heart20 = new Sprite(16,4,7,SpriteSheet.helloWorld,0xff6a7ee8,true);
 	public static Sprite heart21 = new Sprite(16,5,7,SpriteSheet.helloWorld,0xff6a7ee9,true);
 	public static Sprite heart22 = new Sprite(16,6,7,SpriteSheet.helloWorld,0xff6a7eea,true);
 	public static Sprite heart30 = new Sprite(16,4,8,SpriteSheet.helloWorld,0xff6a7eeb,true);
 	public static Sprite heart31 = new Sprite(16,5,8,SpriteSheet.helloWorld,0xff6a7eec,true);
  	public static Sprite heart32 = new Sprite(16,6,8,SpriteSheet.helloWorld,0xff6a7eed,true);
 	//-----------------------------FENCE----------------------------------
 	public static Sprite fence00 = new Sprite(16,0,14,SpriteSheet.helloWorld,0xffcd4c00,true);
 	public static Sprite fence01 = new Sprite(16,1,14,SpriteSheet.helloWorld,0xffcd4c01,true);
 	public static Sprite fence10 = new Sprite(16,0,15,SpriteSheet.helloWorld,0xffcd4c02,true);
 	public static Sprite fence11 = new Sprite(16,1,15,SpriteSheet.helloWorld,0xffcd4c03,true);
 	//----------------------------ATTACKS---------------------------------
 	//not tiles
 	
 	public static Sprite potionAttackGreen = new Sprite(16,11,3,SpriteSheet.helloWorld);
 	public static Sprite potionAttackRed = new Sprite(16,9,0,SpriteSheet.helloWorld);
 	public static Sprite potionAttackPurple = new Sprite(16,11,4,SpriteSheet.helloWorld);
 	public static Sprite swordAttackGray = new Sprite(16,11,2,SpriteSheet.helloWorld);
 	public static Sprite swordAttackPink = new Sprite(16,12,2,SpriteSheet.helloWorld);
 	public static Sprite swordAttackBlue = new Sprite(16,12,3,SpriteSheet.helloWorld);
 	public static Sprite arrowAttackGray = new Sprite(16,10,3,SpriteSheet.helloWorld);
 	public static Sprite arrowAttackRed = new Sprite(16,10,0,SpriteSheet.helloWorld);
 	public static Sprite arrowAttackPurple = new Sprite(16,10,4,SpriteSheet.helloWorld);
 	public static Sprite ultimateRedX = new Sprite(16,11,0,SpriteSheet.helloWorld);
 	public static Sprite ultimateGreenX = new Sprite(16,12,4,SpriteSheet.helloWorld);
 	public static Sprite ultimateCloud = new Sprite(16,12,0,SpriteSheet.helloWorld);
 	public static Sprite coin50 = new Sprite(16,11,1,SpriteSheet.helloWorld,0,50);
 	public static Sprite coin100 = new Sprite(16,12,1,SpriteSheet.helloWorld,0,100);
	
	//If I am correct this constructor will have to be deleted cause not enough information 
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * size;// because every cell in the spritesheet is 16x16px
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}
	//The below Constructor is used for Tiles only to put them into the tile HashMap
	public Sprite(int size, int x, int y, SpriteSheet sheet,int colorId,boolean solid) {
		SIZE = size;
		this.x = x * size;// because every cell in the spritesheet is 16x16px
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
		Tile.hashInsert(colorId, this, solid);
	}
	//this constructor exists only for the items cause they must have a price and Coins given
	//the dont have to be in the tile hashMap cause they are in pixel precision and movable
	public Sprite(int size, int x, int y, SpriteSheet sheet,int price,int givenCoins) {
		SIZE = size;
		this.x = x * size;// because every cell in the spritesheet is 16x16px
		this.y = y * size;
		this.sheet = sheet;
		this.price = price;
		this.givenCoins = givenCoins;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
	 	for(int i=0 ; i< SIZE*SIZE ; i++) {
	 		pixels[i] = color;
	 	}
	}
	
	private void load() {
		for(int i=0 ; i < SIZE ; i++) {
			for(int j=0 ; j< SIZE ; j++) {
				pixels[j+i*SIZE] = sheet.pixels[( j + this.x) + ( i+ this.y) * sheet.SIZE];
			}
		}
	}
}
