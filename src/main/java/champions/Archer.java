package champions;

import java.awt.event.KeyEvent;

import domain.Champion;
import domain.Coordinates;
import domain.GameData;
import graphics.Sprite;

public class Archer extends Champion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Archer(Coordinates playerSpawn,Sprite sprite) {
		super(playerSpawn,sprite,Sprite.testingSprite);
	}
		
	@Override
	public void update(boolean[] keyCode,GameData data) {
		super.update(keyCode, data);
		if(keyCode[KeyEvent.VK_V])test(data);
	}
//TODO:
	public void test(GameData data) {
		int distance_traveled=0;
		int i=0;
		while(distance_traveled<=60) {
			distance_traveled+=10;
			projectiles[i].shoot(this,distance_traveled,data);
		    i++;
		}
	}

	@Override
	public String printManual() {
		return super.printManual() + "\nC -> LIGHT ATTACK - IT SHOOTS TO A RANDOM MOB\n"
				         + " AT YOUR ATTACK RANGE WHILE IT IS PRESSED" + 
		                  "\nV -> YOU SHOOT AT YOUR SELECTED DIRECTION - IT\n"
				         + "SHOOTS TO THE CLOSEST MOB TO YOU WHERE THE BEAM IS";
	}
}
