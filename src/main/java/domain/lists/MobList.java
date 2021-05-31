package domain.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.game.catchyname.graphics.Screen;
import com.game.catchyname.graphics.Sprite;

import domain.GameData;
import domain.Level;
import domain.Mob;
import domain.Player;
import utilities.Coordinates;

public class MobList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Mob> mobs;
	private Random random;
	
	public MobList(Level level, Coordinates target) {
		mobs = new ArrayList<>();
		
		random = new Random();
		int mobCounter = random.nextInt(1000);
		int hitbox = 5;
		
		for(int i=0;i<mobCounter;i++) {
			int xLimit = random.nextInt(100); 
		    int yLimit = random.nextInt(100);
		    if(!level.getTile(xLimit, yLimit).solid()) {
		    	Coordinates temp = new Coordinates(xLimit,yLimit,hitbox);
			     mobs.add(new Mob(temp,Sprite.testingSprite,target));
		    }
			
		}
	}
	
	public void render(ItemList allItems, Player player) {
		if(mobs!=null) {
		   ArrayList<Mob> temps = new ArrayList<Mob>();
		   for(Mob temp:mobs) {
			   if(temp!=null) {
				   if(temp.isAlive()) {
			          temp.render();
		           }else {
		              temp.givePoints(player);
			          allItems.addItem(temp.getItem());
			          temp.removeItem();
			          temps.add(temp);
			       }
			   }
			}mobs.removeAll(temps);
	    }
		
	}

	public Mob getMob(Coordinates coordinates) {
		Mob temp;
		if(mobs!=null) {
		   for(Mob mob:mobs) {
			  if(mob!=null&&mob.getCoordinates().equals(coordinates)) {
				  temp =mob;
				  return temp;
			  }
			}
		}
		return null;
	}

	public void update(Level level, boolean[] keyCode, GameData gameData) {
		for(Mob mob:mobs) {		
			mob.update(level,keyCode,gameData);
		}
	}

	public void sort() {
		Collections.sort(mobs);
	}

	public void setScreen(Screen screen) {
		for(Mob mob : mobs) {
			if(mob!=null) {
			  mob.setScreen(screen);
			}
		}
	}
}
