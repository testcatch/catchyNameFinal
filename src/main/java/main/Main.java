package main;

import frames.MainFrame;
import graphics.Sprite;

/*
 * this is a class start the sequence - > creates a MainFrame
 */

public class Main {

	public static void main(String[] args) {
		Sprite.initTiles();
		new MainFrame();
	}

}
