package domain;

import java.io.Serializable;

import graphics.Screen;

public final class GameData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * The only object that is NOT INSIDE RenderablesList is champion
	 */
	private Player player;
	private Champion champion;
	private Level level;
	private RenderablesList renderableslist;
	private Screen screen;
	
	public GameData(Player player,String levelid) {
		this.player = player;
		this.champion = player.getChampion();
		level = new Level(levelid);
		renderableslist = new RenderablesList(level,champion.coordinates);
	}
	
	public String printData() {
		return player.printData();
	}

	public void render() {
		screen.clear();
		level.render(champion.getCoordinates().getX(),champion.getCoordinates().getY());
		champion.render();
		renderableslist.render();	
	}

	public void update(boolean[] keyCode) {
		render();
	    champion.update(keyCode,this);
	    renderableslist.update(this);
	}
	
	public Player getPlayer() {
		return player;
	}

	public RenderablesList getRenderables() {
		return renderableslist;
	}

	public Level getLevel() {
		return level;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
		level.setScreen(screen);
		champion.setScreen(screen);
		renderableslist.setScreen(screen);	
	}

	public int gameIsOn() {
		if(!renderableslist.mobsExist()) {
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
