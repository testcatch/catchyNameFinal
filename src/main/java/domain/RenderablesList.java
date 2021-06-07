package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import graphics.Screen;
import graphics.Sprite;

public class RenderablesList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<Renderables> renderables;
	protected Random random;
	
	public RenderablesList(Level level, Coordinates target) {
		renderables = new ArrayList<>();
		createItems(level,target);
		createMobs(level,target);
	}
	
	private void createMobs(Level level, Coordinates target) {
		random = new Random();
		int mobCounter = random.nextInt(1000);
		int hitbox = 5;
		
		for(int i=0;i<mobCounter;i++) {
			int xLimit = random.nextInt(100); 
		    int yLimit = random.nextInt(100);
		    if(!level.getTile(xLimit, yLimit).solid()) {
		    	Coordinates temp = new Coordinates(xLimit,yLimit,hitbox);
		    	renderables.add(new Mob(temp,Sprite.testingSprite,target));
		    }
		}
	}

	private void createItems(Level level, Coordinates target) {
		random = new Random();
		int itemCounter = random.nextInt(1000);
		int hitbox = 5;

		for(int i=0;i<itemCounter;i++) {
			int xLimit = random.nextInt(100); 
		    int yLimit = random.nextInt(100);
		    if(!level.getTile(xLimit, yLimit).solid()) {
			    Coordinates temp = new Coordinates(xLimit,yLimit,hitbox);
			    renderables.add(new Item(temp,Sprite.testingSprite,target));
		    }
		}	
	}

	public void render() {
		if(renderables!=null) {
		   for(Renderables temp:renderables) {
			   if(temp!=null) {
				   temp.render();
			       }
			   }
			}
	}
	
	public Renderables getRenderable(Coordinates coordinates) {
		if(renderables!=null) {
		   for(Renderables temp:renderables) {
			  if(temp!=null&&temp.getCoordinates().equals(coordinates)) {
				  return temp;
			  }
			}
		}
		return null;
	}
	
	public void sort() {
		renderables.removeAll(Collections.singleton(null));
		Collections.sort(renderables);
	}

	public void setScreen(Screen screen) {
		for(Renderables temp : renderables) {
			if(temp!=null) {
				temp.setScreen(screen);
			}
		}
	}

	public void remove(Renderables temp) {
		renderables.remove(temp);
	}
	
	public void update(GameData gameData) {
		  if(renderables!=null) {
			for(Renderables temp:renderables) {	
				if(temp instanceof Mob) {
				   ((Mob) temp).update(gameData);
				}
			}
		  }
	}
	
	public void addItem(Item item) {
		renderables.add(item);
	}

	public boolean mobsExist() {
		for(Renderables temp : renderables) {
			if(temp instanceof Mob) {
				return true;
			}
		}
		return false;
	}

}
