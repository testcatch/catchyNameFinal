package domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public final class GameDataList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String,GameData> data;
	
	public GameDataList() {
		data = new HashMap<>();
	}
	
	public GameData getData(String name) {
		return data.get(name);
	}
	
	public void saveData(String name, GameData gamedata) {
		this.data.put(name, gamedata);
	}
	
	public void saveGame() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.ser"))) {
			out.writeObject(this);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	public static GameDataList loadGame() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.ser"))){
			GameDataList data = (GameDataList)in.readObject();
		    return data;
		} catch (IOException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String printData() {
		String string = "Player's Name ||| score!!!";
		for(Entry<String, GameData> pair: data.entrySet()) {
			String temp = pair.getValue().getPlayer().printData();
			string += temp;
		}
		return string;
	}
}
