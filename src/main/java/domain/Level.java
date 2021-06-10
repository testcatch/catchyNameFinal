package domain;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import graphics.Screen;
import tiles.Tile;

public final class Level implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Because will have only 1 level loaded at a time I am gonna make a global variable level
	private int width;	
	private int height;
	private int[] tiles;	
	private Screen screen;
	
	public Level(String path) {
		try {
			BufferedImage image = ImageIO.read(Level.class.getResource("/levels/"+ path +"Spawn.png/"));
			width = image.getWidth();
			height = image.getHeight();	
			tiles = new int[width*height];
			image.getRGB(0, 0,width,height,tiles,0,width);// converting image to array of every pixel color
		}catch(IOException e) {
			System.err.println("Exception! Could not load level file");
		}
	}
	
	public void render(int xScroll, int yScroll) {
		xScroll -= screen.getWidth() /2;
		yScroll -= screen.getHeight() /2;
		//CORNER PINS
		//x0 left side of the screen
		//>>4 == /16 . I am dividing into tiles instead of pixels
		// Because I am dealing with rendering tiles its not the same as rendering a player cause a player can be in between 2 tiles but a tile is after the other.Bitwise is a lot faster 
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4; 
		int x1 = (xScroll + screen.getWidth() + 16) >> 4; 		
		int y0 = yScroll >>4;
		int y1 = (yScroll + screen.getHeight() +16) >>4;		
		
		//rendering z amount of tiles right,left,up,bottom of the player location on screen.He'll be in the middle
		for(int y = y0 ; y < y1 ; y++) {				// render every pixel that is seen in the frame
			for(int x = x0 ; x < x1 ; x++) {
				getTile(x,y).render(x,y,screen);			//tile precision not pixel precision
			}
		}	
	}
	
	public boolean collision(int xa, int ya,Coordinates coordinates) {	
		for(int c=0 ; c<4 ; c++) {	
			//-16 ΠΑΡΑΔΟΧΗ for player to be rendered in the middle of the screen, because to be pretty I have to render +1 tile in width
			// and +1 in height
			//checking 4 neighboring tiles if any of them or more are solid.If so doesn't allow moving toward them
			//	%2 and /2 because 4 corners in a tile, *10 how big is the hitbox, +-B(BUFFER)
			int xt = ((coordinates.getX() + xa) + c % 2 *10 - 16 +2)/16;	//  how wide is the horizontal hitbox
			int yt = ((coordinates.getY() + ya) + c / 2 * 14  -16 +1)/16;	//	how big vertically is the hitbox
			if(getTile(xt,yt).solid()) {
				return true;
			}
		}
		return false;	
	}
	
	
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x>= width || y>= height)return Tile.getTile(0xff696969);
		if(tiles[x+y*width] == 0xff006b00)return Tile.getTile(0xff006b00);
		if(tiles[x+y*width] ==  0xff00ff21 )return Tile.getTile(0xff00ff21);
		if(tiles[x+y*width] == 0xff4cff00 )return Tile.getTile(0xff4cff00);
		if(tiles[x+y*width] ==  0xff0026ff)return Tile.getTile(0xff0026ff);
		if(tiles[x+y*width] ==  0xffff0000)return Tile.getTile(0xffff0000);
		if(tiles[x+y*width] == 0xffffd800)return Tile.getTile( 0xffffd800);
		if(tiles[x+y*width] ==  0xff0026ff )return Tile.getTile(0xff0026ff);//first 5
		
		if(tiles[x+y*width] == 0xff7F006E )return Tile.getTile(0xff7F006E);
		if(tiles[x+y*width] ==  0xff7F016E)return Tile.getTile(0xff7F016E);
		if(tiles[x+y*width] ==  0xff7F026E)return Tile.getTile(0xff7F026E);
		if(tiles[x+y*width] == 0xff7F106E)return Tile.getTile( 0xff7F106E);//
		if(tiles[x+y*width] ==  0xff7F116E )return Tile.getTile(0xff7F116E);
		if(tiles[x+y*width] == 0xff7F126E )return Tile.getTile(0xff7F126E);
		if(tiles[x+y*width] ==  0xff7F206E)return Tile.getTile(0xff7F206E);
		if(tiles[x+y*width] ==  0xff7F216E)return Tile.getTile(0xff7F216E);
		if(tiles[x+y*width] == 0xff7F226E)return Tile.getTile( 0xff7F226E);//shop
		
		if(tiles[x+y*width] ==  0xffff0000 )return Tile.getTile(0xffff0000);
		if(tiles[x+y*width] == 0xffffd800 )return Tile.getTile(0xffffd800);
		if(tiles[x+y*width] ==  0xff4800ff)return Tile.getTile(0xff4800ff);
		if(tiles[x+y*width] ==  0xffff006e)return Tile.getTile(0xffff006e);//tree1
		
		if(tiles[x+y*width] == 0xffB6E082)return Tile.getTile( 0xffB6E082);
		if(tiles[x+y*width] ==  0xffB6E083 )return Tile.getTile(0xffB6E083);
		if(tiles[x+y*width] == 0xffB6E084 )return Tile.getTile(0xffB6E084);//tree2
		if(tiles[x+y*width] ==  0xffB6E085)return Tile.getTile(0xffB6E085);
		
		if(tiles[x+y*width] ==  0xff808080)return Tile.getTile(0xff808080);
		if(tiles[x+y*width] == 0xff818080)return Tile.getTile( 0xff818080);
		if(tiles[x+y*width] ==  0xff828080 )return Tile.getTile(0xff828080);
		if(tiles[x+y*width] == 0xff838080 )return Tile.getTile(0xff838080);
		if(tiles[x+y*width] ==  0xff848080)return Tile.getTile(0xff848080);//road
		if(tiles[x+y*width] ==  0xff858080)return Tile.getTile(0xff858080);
		if(tiles[x+y*width] == 0xff868080)return Tile.getTile( 0xff868080);
		if(tiles[x+y*width] ==  0xff878080 )return Tile.getTile(0xff878080);
		if(tiles[x+y*width] == 0xff888080 )return Tile.getTile(0xff888080);
		
		if(tiles[x+y*width] ==  0xffcd4c00)return Tile.getTile(0xffcd4c00);
		if(tiles[x+y*width] ==  0xffcd4c01)return Tile.getTile(0xffcd4c01);//fence
		if(tiles[x+y*width] == 0xffcd4c02)return Tile.getTile( 0xffcd4c02);
		if(tiles[x+y*width] ==  0xffcd4c03 )return Tile.getTile(0xffcd4c03);
		
		if(tiles[x+y*width] == 0xffe2b5d9 )return Tile.getTile(0xffe2b5d9);
		if(tiles[x+y*width] ==  0xffe2b5da)return Tile.getTile(0xffe2b5da);
		if(tiles[x+y*width] ==  0xffe2b5db)return Tile.getTile(0xffe2b5db);
		if(tiles[x+y*width] == 0xffe2b5dc)return Tile.getTile( 0xffe2b5dc);
		if(tiles[x+y*width] ==  0xffe2b5dd )return Tile.getTile(0xffe2b5dd);
		if(tiles[x+y*width] == 0xffe2b5de )return Tile.getTile(0xffe2b5de);
		if(tiles[x+y*width] ==  0xffe2b5df)return Tile.getTile(0xffe2b5df);
		if(tiles[x+y*width] ==  0xffe3b5d0)return Tile.getTile(0xffe3b5d0);
		if(tiles[x+y*width] ==  0xffe3b5d1)return Tile.getTile(0xffe3b5d1);
		if(tiles[x+y*width] ==  0xffe3b5d2)return Tile.getTile(0xffe3b5d2);
		if(tiles[x+y*width] ==  0xffe3b5d3)return Tile.getTile(0xffe3b5d3);//chinese
		if(tiles[x+y*width] ==  0xffe3b5d4)return Tile.getTile(0xffe3b5d4);
		if(tiles[x+y*width] ==  0xff6a7e23)return Tile.getTile(0xff6a7e23);
		if(tiles[x+y*width] ==  0xff6a7e24)return Tile.getTile(0xff6a7e24);
		if(tiles[x+y*width] ==  0xffe3b5d5)return Tile.getTile(0xffe3b5d5);
		if(tiles[x+y*width] ==  0xffe3b5d6)return Tile.getTile(0xffe3b5d6);
		if(tiles[x+y*width] ==  0xffe3b5d7)return Tile.getTile(0xffe3b5d7);
		if(tiles[x+y*width] ==  0xffe3b5d8)return Tile.getTile(0xffe3b5d8);
		
		
		if(tiles[x+y*width] ==  0xff6a7ee2)return Tile.getTile(0xff6a7ee2);
		if(tiles[x+y*width] ==  0xff6a7ee3)return Tile.getTile(0xff6a7ee3);
		if(tiles[x+y*width] ==  0xff6a7ee4)return Tile.getTile(0xff6a7ee4);
		if(tiles[x+y*width] ==  0xff6a7ee5)return Tile.getTile(0xff6a7ee5);
		if(tiles[x+y*width] ==  0xff6a7ee6)return Tile.getTile(0xff6a7ee6);//heart
		if(tiles[x+y*width] ==  0xff6a7ee7)return Tile.getTile(0xff6a7ee7);
		if(tiles[x+y*width] ==  0xff6a7ee8)return Tile.getTile(0xff6a7ee8);
		if(tiles[x+y*width] ==  0xff6a7ee9)return Tile.getTile(0xff6a7ee9);
		if(tiles[x+y*width] ==  0xff6a7eea)return Tile.getTile(0xff6a7eea);
		if(tiles[x+y*width] ==  0xff6a7eeb)return Tile.getTile(0xff6a7eeb);
		if(tiles[x+y*width] ==  0xff6a7eec)return Tile.getTile(0xff6a7eec);
		if(tiles[x+y*width] ==  0xff6a7eed)return Tile.getTile(0xff6a7eed);
		
		if(tiles[x+y*width] ==  0xff3e593e)return Tile.getTile(0xff3e593e);
		if(tiles[x+y*width] ==  0xff3e593f)return Tile.getTile(0xff3e593f);//tree3
		
		if(tiles[x+y*width] ==  0xff6a7e23)return Tile.getTile(0xff6a7e23);
		if(tiles[x+y*width] ==  0xff6a7e24)return Tile.getTile(0xff6a7e24);
		if(tiles[x+y*width] ==  0xff6a7e25)return Tile.getTile(0xff6a7e25);
		if(tiles[x+y*width] ==  0xff6a7e26)return Tile.getTile(0xff6a7e26);
		if(tiles[x+y*width] ==  0xff6a7e27)return Tile.getTile(0xff6a7e27);
		if(tiles[x+y*width] ==  0xff6a7e28)return Tile.getTile(0xff6a7e28);
		if(tiles[x+y*width] ==  0xff6a7e29)return Tile.getTile(0xff6a7e29);
		if(tiles[x+y*width] ==  0xff6a7e2a)return Tile.getTile(0xff6a7e2a);//bridge
		if(tiles[x+y*width] ==  0xff6a7e2b)return Tile.getTile(0xff6a7e2b);
		if(tiles[x+y*width] ==  0xff6a7e2c)return Tile.getTile(0xff6a7e2c);
		if(tiles[x+y*width] ==  0xff6a7e2d)return Tile.getTile(0xff6a7e2d);
		if(tiles[x+y*width] ==  0xff6a7e2e)return Tile.getTile(0xff6a7e2e);
		if(tiles[x+y*width] ==  0xff6a7e2f)return Tile.getTile(0xff6a7e2f);
		if(tiles[x+y*width] ==  0xff6a8e2f)return Tile.getTile(0xff6a8e2f);
		if(tiles[x+y*width] ==  0xff6a9e2f)return Tile.getTile(0xff6a9e2f);
		if(tiles[x+y*width] ==  0xff6aae2f)return Tile.getTile(0xff6aae2f);
		
		if(tiles[x+y*width] ==  0xffe49fc2)return Tile.getTile(0xffe49fc2);//armory
		if(tiles[x+y*width] ==  0xffe49fc3)return Tile.getTile(0xffe49fc3);
		if(tiles[x+y*width] ==  0xffe49fc4)return Tile.getTile(0xffe49fc4);
		if(tiles[x+y*width] ==  0xffe49fc5)return Tile.getTile(0xffe49fc5);
		return Tile.getTile(0xff696969);
	}	
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
}
