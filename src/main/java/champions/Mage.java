package champions;

import java.awt.event.KeyEvent;

import domain.Champion;
import domain.Coordinates;
import domain.GameData;
import graphics.Sprite;

public class Mage extends Champion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mage(Coordinates playerSpawn,Sprite sprite) {
		super(playerSpawn,sprite,Sprite.testingSprite);
	}

	@Override
	public void update(boolean[] keyCode,GameData data) {
		super.update(keyCode, data);
		if(keyCode[KeyEvent.VK_C]);
		if(keyCode[KeyEvent.VK_V]);
	}

	@Override
	public String printManual() {
		return super.printManual();
	}
}
