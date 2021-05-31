package champions;

import java.awt.event.KeyEvent;

import com.game.catchyname.graphics.Sprite;

import domain.Champion;
import domain.GameData;
import domain.Level;
import domain.Mob;
import utilities.Coordinates;

public class Archer extends Champion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Archer(Coordinates playerSpawn,Sprite sprite) {
		super(playerSpawn,sprite,Sprite.testingSprite);
	}
		
	@Override
	public void update(Level level,boolean[] keyCode,GameData data) {
		super.update(level, keyCode, data);
		if(keyCode[KeyEvent.VK_C])this.lightAttack(data);
		if(keyCode[KeyEvent.VK_V])test(data);
	}

	protected void lightAttack(GameData data) {
		Mob temp = data.getAllmobs().getMob(this.getCoordinates());
		if(temp!=null) {
			super.damage(temp);
		}
	}
//TODO:
	public void test(GameData data) {
		int distance_traveled=0;
		int i=0;
		while(distance_traveled<=60) {
			distance_traveled+=10;
			attackmoves[i].shoot(this,distance_traveled,data);
		    i++;
		}
	}

	@Override
	public String printManual() {
		super.printManual();
		return super.printManual() + "\nC -> LIGHT ATTACK - IT SHOOTS TO A RANDOM MOB\n"
				         + " AT YOUR ATTACK RANGE WHILE IT IS PRESSED" + 
		                  "\nV -> YOU SHOOT AT YOUR SELECTED DIRECTION - IT\n"
				         + "SHOOTS TO THE CLOSEST MOB TO YOU WHERE THE BEAM IS";
	}
	//
}
