package domain;

import java.io.Serializable;

import com.game.catchyname.graphics.Screen;

import domain.lists.ItemList;
import domain.lists.MobList;

public final class GameData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private Champion champion;
	private Level level;
	private MobList allmobs;
	private ItemList allItems;
	private Screen screen;
	
	public GameData(Player player,String levelid) {
		this.player = player;
		this.champion = player.getChampion();
		level = new Level(levelid);
		allmobs = new MobList(level,champion.coordinates);
		allItems = new ItemList(level,champion.coordinates);
	}
	
	public String printData() {
		return player.printData();
	}

	public void render() {
		screen.clear();
		level.render(champion.getCoordinates().getX(),champion.getCoordinates().getY());
		allmobs.render(allItems, player);
		allItems.render();
		champion.render();
	}

	public void update(boolean[] keyCode) {
		render();
	    champion.update(keyCode,this);
	    allmobs.update(keyCode,this);
	}
	
	public Player getPlayer() {
		return player;
	}

	public MobList getAllmobs() {
		return allmobs;
	}

	public Level getLevel() {
		return level;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
		level.setScreen(screen);
		allmobs.setScreen(screen);
		allItems.setScreen(screen);
		champion.setScreen(screen);
	}

	public ItemList getAllItems() {
		return allItems;
	}

	public int gameIsOn() {
		if(allmobs == null) {
			return 0;
		}else if(!champion.isAlive()) {
			return 1;
		}else {
			return 2;
		}
	}

	public String printManual() {
		return champion.printManual();
	}
}
