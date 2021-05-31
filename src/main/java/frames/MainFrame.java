package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.GameDataList;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton newGame;
	private JButton loadGame;
	private JButton clearAllData;
	private JButton scoreboard;
	private GameDataList datalist;
	
	public MainFrame() {
		datalist = GameDataList.loadGame();
		if(datalist==null) {
			datalist = new GameDataList();
		}
	    panel= new JPanel();
	    newGame = new JButton("New Game");
	    loadGame = new JButton("Load Game");
	    scoreboard = new JButton("Score Board");
	    clearAllData = new JButton("Clear All Data");
	    
	    
	    panel.add(newGame);
	    panel.add(loadGame);
	    panel.add(scoreboard);
	    panel.add(clearAllData);
	    
	    newGame.addActionListener(e -> {
    			new NewGameFrame(datalist);
    			dispose();
        });
	    loadGame.addActionListener(e -> {
    			new LoadFrame(datalist);
    			dispose();
        });
	    scoreboard.addActionListener(e -> {
    			new ScoreBoardFrame(datalist);
    			dispose();
        });
		clearAllData.addActionListener(e -> {
    			datalist = new GameDataList();
    			datalist.saveGame();
        });

		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setSize(300,300);
		setTitle("Main Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
