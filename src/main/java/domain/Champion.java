package domain;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.game.catchyname.graphics.Sprite;

import domain.lists.ItemList;
import utilities.Coordinates;

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
		inventory.add(new Item(new Coordinates(0,0,6), projectilesprite, playerSpawn));
		active = new Item(new Coordinates(0,0,8), projectilesprite, playerSpawn);
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	@Override
	public void update(boolean[] keyCode, GameData gameData) {
		super.update(keyCode,gameData);
		if(keyCode[KeyEvent.VK_F2])pickItem(gameData);
		int xa=0,ya=0;
        if(keyCode[KeyEvent.VK_UP]) ya--;
        if(keyCode[KeyEvent.VK_DOWN])ya++;
        if(keyCode[KeyEvent.VK_RIGHT]) xa++;
        if(keyCode[KeyEvent.VK_LEFT]) xa--;
        move(xa,ya,gameData.getLevel());
    }
	
	private void pickItem(GameData data) {
		
		ItemList list = data.getAllItems();
		list.sort();
		Item temp = list.getItem(this.getCoordinates());
		if(temp!=null) {
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
}
