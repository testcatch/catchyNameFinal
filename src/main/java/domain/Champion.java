package domain;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import graphics.Sprite;

public abstract class Champion extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> inventory;
	private Item active;
	
	protected Champion(Coordinates playerSpawn,Sprite sprite,Sprite projectilesprite) {
		super(playerSpawn,sprite,projectilesprite);
		inventory = new ArrayList<>();
	}
	
	public List<Item> getInventory() {
		return inventory;
	}
	
	public void update(boolean[] keyCode, GameData gameData) {
        if(keyCode[KeyEvent.VK_A])setDirection(0);
        if(keyCode[KeyEvent.VK_W])setDirection(1);
        if(keyCode[KeyEvent.VK_D])setDirection(2);
        if(keyCode[KeyEvent.VK_S])setDirection(3);
		if(keyCode[KeyEvent.VK_F2])pickItem(gameData);
		int xa=0;
	    int ya=0;
        if(keyCode[KeyEvent.VK_UP]) ya--;
        if(keyCode[KeyEvent.VK_DOWN])ya++;
        if(keyCode[KeyEvent.VK_RIGHT]) xa++;
        if(keyCode[KeyEvent.VK_LEFT]) xa--;
        move(xa,ya,gameData.getLevel());
    }
	
	private void pickItem(GameData data) {
		RenderablesList list = data.getRenderables();
		list.sort();
		 Renderables object = list.getRenderable(this.coordinates);
		 if(object instanceof Item) {
			Item temp = (Item) object;
			inventory.add(temp);
			list.remove(temp);
		}
	}

	public String printManual() {
		return"F1 -> SAVE YOUR GAME\n"+
		"F2 -> PICK ITEM NEAR YOU\n"+
		"UP ARROW -> MOVE UP\n"+
		"DOWN ARROW -> MOVE DOWN\n"+
		"LEFT ARROW -> MOVE LEFT\n"+
		"RIGHT ARROW -> MOVE RIGHT\n"+
		"W -> DIRECTION OF SHOOTING UP\n"+
		"S -> DIRECTION OF SHOOTING UP DOWN\n"+
		"A -> DIRECTION OF SHOOTING UP LEFT\n"+
		"D -> DIRECTION OF SHOOTING UP RIGHT\n";
	}

	public Item getActiveItem() {
		return active;
	}

	public void setActiveItem(Item selected) {
		active = selected;
	}
	
	@Override
	public int hashCode() {
		return coordinates.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(this.getClass() == o.getClass()) {
			Champion temp = (Champion) o;
		   return this.coordinates.equals(temp.coordinates);
		}else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Renderables o) {
		return 0;
	}
}
