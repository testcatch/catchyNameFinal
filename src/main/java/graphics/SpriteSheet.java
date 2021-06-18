package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class SpriteSheet implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	private int size;
	private int[] pixels;

	
	
	public static final SpriteSheet helloWorld = new SpriteSheet("SpriteSheet1.png/",256);
	
	
	public SpriteSheet(String path, int size) {
		
		this.path = path;
		this.size = size;
		pixels = new int[getSIZE() * getSIZE()];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource("/textures/sheets/"+ path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, getPixels(), 0, w);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getSIZE() {
		return size;
	}

	public int[] getPixels() {
		return pixels;
	}
	
	
	
	
	
	
}
