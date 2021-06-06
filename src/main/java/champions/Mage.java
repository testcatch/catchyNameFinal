package champions;

import java.awt.event.KeyEvent;

import com.game.catchyname.graphics.Sprite;

import domain.Champion;
import domain.GameData;
import utilities.Coordinates;

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
