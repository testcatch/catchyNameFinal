package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.GameData;

public class PauseFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton resume;
	private JButton mainframe;
	private JButton inventory;

	public PauseFrame(GameFrame gameframe, GameData gamedata) {
		panel = new JPanel();
		resume = new JButton("Resume");
		mainframe = new JButton("Main Frame");
		inventory = new JButton("Inventory");
		
		panel.add(mainframe);
		panel.add(inventory);
		panel.add(resume);

		mainframe.addActionListener(e -> {
			new MainFrame();
			gameframe.stop();
    		dispose();
        });
		
		inventory.addActionListener(e -> {
			new InventoryFrame(gamedata);
        });
		
		resume.addActionListener(e -> {
			gameframe.resume();
    		dispose();
        });
		
		this.getContentPane().add(panel);
		
        this.setVisible(true);
        this.setSize(300,300);
        this.setTitle("PAUSED");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
