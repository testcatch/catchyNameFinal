package domain.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.game.catchyname.graphics.Screen;
import com.game.catchyname.graphics.Sprite;

import domain.Item;
import domain.Level;
import utilities.Coordinates;

public class ItemList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> items;
	private Random random;
	
	public ItemList(Level level, Coordinates target) {
		items = new ArrayList<>();
		
		random = new Random();
		int itemCounter = random.nextInt(1000);
		int hitbox = 5;

		for(int i=0;i<itemCounter;i++) {
			int xLimit = random.nextInt(100); 
		    int yLimit = random.nextInt(100);
		    if(!level.getTile(xLimit, yLimit).solid()) {
			    Coordinates temp = new Coordinates(xLimit,yLimit,hitbox);
			    items.add(new Item(temp,Sprite.testingSprite,target));
		    }
		}
	}
	
	public void addItem(Item item) {
	    items.add(item);
	}
	
	public Item getItem(Coordinates coordinates){
		if(items!=null) {
		   for(Item item:items) {
			  if(item!=null&&item.getCoordinates().equals(coordinates)) {
				 return item;
			  }
			}
		}
		return null;
	}

	public void render() {
		if(items!=null) {
		   for(Item item:items) {
			   if(item!=null) {
			      item.render();
			   }
		   }
	    }
	}
	
	public void remove(Item temp) {
		items.remove(temp);
	}

	public void setScreen(Screen screen) {
		for(Item item : items) {
			if(item!=null) {
				item.setScreen(screen);
			}
		}
	}
	
	public void sort() {
		Collections.sort(items);
	}

}
