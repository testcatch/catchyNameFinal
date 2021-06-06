package frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.catchyname.graphics.Screen;

import domain.GameData;
import domain.GameDataList;

public class GameFrame extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int screenWidth = 300;
	private int screenHeight = screenWidth / 16*9;
	private int scale = 3;
	private transient BufferedImage image = new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_RGB); //creating an image with an accesible buffer
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private GameDataList datalist;
	private GameData gamedata;
    
	private boolean running;
	private transient Thread gameThread;
	private boolean paused;
	
	private Screen screen;
	private JFrame frame;
	private JButton pauseButton;
	private transient Keyboard key;
	
	private JFrame pauseFrame;
	
	class Keyboard implements KeyListener{
		private boolean[] keycodes = new boolean[125];

		public void keyTyped(KeyEvent e) {
			//I DON'T KNOW WHAT TO WRITE HERE
		}
		public void keyPressed(KeyEvent e) {
			keycodes[e.getKeyCode()] = true; 
		}
		public void keyReleased(KeyEvent e) {
			keycodes[e.getKeyCode()] = false; 
		}
	}
	
	public GameFrame(GameDataList datalist, String name) {
		this.datalist = datalist;
		this.gamedata = datalist.getData(name);
		screen = new Screen(screenWidth, screenHeight);
		gamedata.setScreen(screen);


		paused = false;

		frame = new JFrame();
		pauseButton = new JButton("  Pause  ");
		
		frame.setLayout(new FlowLayout ());
		frame.add(pauseButton);
		
		pauseButton.addActionListener(e -> {
			//TODO:
			pause(pauseFrame);
		});
		
		key = new Keyboard();
		this.addKeyListener(key);

		frame.setVisible(true);
		frame.setResizable(true);
		frame.getContentPane().add(this);
		this.setPreferredSize(new Dimension(screenWidth * scale, screenHeight * scale));
		frame.setSize(screenWidth * scale + 150,screenHeight * scale+50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start();
	}
	
	public void resume() {
		paused = false;
		pauseButton.setText(" Pause ");
	}
	
	private synchronized void saveGame() {
		datalist.saveGame();
		frame.setTitle("SAVED");
	}
	
	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "Game");
		gameThread.start(); 
	}

	public synchronized void stop() {
		running = false;
		frame.dispose();
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	
	private void pause(JFrame f) {
		//TODO:
		if(!paused) {
			pauseButton.setText("Resume");
			f = new PauseFrame(this,gamedata);		
		}else {
			pauseButton.setText(" Pause ");
			f.dispose();
		}
		paused = !paused;
	}

	@Override
	public void run() {
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		final double nanoConversion = 1000000000.0 / 60.0 ;// limits to 60 updates per second Timer
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			int gamestate = gamedata.gameIsOn();
			if(gamestate != 2) {
			   new EndFrame(gamestate,gamedata);
			   stop();
			}
			if(!paused) {
			   long now = System.nanoTime();
			   delta += (now - lastTime)/nanoConversion; //millis 
			   lastTime = now;
			   while(delta>=1) {
				   this.requestFocus(true);
				   if(key.keycodes[KeyEvent.VK_F1]) {
					   saveGame();
				   }
                   gamedata.update(key.keycodes);
				   delta--; 
				   updates++;
				   frames++;
				   repaint();
			    }
			       if(System.currentTimeMillis()  - timer > 1000) {//1sec = 1000 millis
				        timer+= 1000;// to display other than the first time correctly the FPS AND UPDATES			
				        frame.setTitle("Game" +"|" +updates+" UPS |"+frames+" FPS");
				        frames=0;
				        updates=0;
			       }
		      }
		}
	}

	@Override
	public void paintComponent(Graphics g) {	
		for(int i=0;i<pixels.length;i++) {
			pixels[i] = screen.pixels[i];
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose(); 
	}
}
