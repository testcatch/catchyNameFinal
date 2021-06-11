package domain;

import graphics.Sprite;

public class Projectiles extends Renderables{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int direction=0;

	public Projectiles(Coordinates coordinates, Sprite sprite) {
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
		 RenderablesList list = data.getRenderables();
		 list.sort();
		 Renderables object = list.getRenderable(this.coordinates);
		 if(object instanceof Mob) {
	        Mob temp = (Mob) object;
		    champ.damage(temp);
			   if(temp.isAlive()) {
		          temp.givePoints(data.getPlayer());
		          list.addItem(temp.getItem());
			      temp.removeItem();
			      list.remove(temp);
			   }
		 }
	}

	public void setDirection(int direction) {
		this.direction = direction;
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
			Projectiles temp = (Projectiles) o;
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
