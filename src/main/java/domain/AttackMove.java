package domain;

import com.game.catchyname.graphics.Sprite;

import utilities.Coordinates;

public class AttackMove extends Renderables{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int direction=0;

	public AttackMove(Coordinates coordinates, Sprite sprite) {
		super(coordinates, sprite);
	}
	//TODO:
	public void shoot(Champion champ,int location,GameData data) {
		int xa=location;
		int ya=location;
		switch(direction) {
		   case 0:
			  this.coordinates.update(this.coordinates.getX()-xa,this.coordinates.getY());
			  break;
		   case 1:
			  this. coordinates.update(this.coordinates.getX(),this.coordinates.getY()-ya);
		      break;
		   case 2:
			  this.coordinates.update(this.coordinates.getX()+xa, this.coordinates.getY());
			  break;
		   case 3:
			  this.coordinates.update(this.coordinates.getX(),this.coordinates.getY()+ya);
			  break;
		   default:
			  break;
		 }   
		 render();
		 data.getAllmobs().sort();
	     Mob temp = data.getAllmobs().getMob(this.coordinates);
	     if(temp!=null) {
		    champ.damage(temp);
		 }
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
