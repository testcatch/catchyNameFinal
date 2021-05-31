package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.GameData;

public class EndFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton ok;
	private JTextArea result;

	public EndFrame(int gamestate, GameData data) {
		panel = new JPanel();
		result = new JTextArea("Results");
	    result.setEditable(false);
		ok = new JButton("OK");
		
		panel.add(result);
		panel.add(ok);
		
		if(gamestate == 0) {
			result.setText("YOU LOSE\n\n");
		}else if(gamestate==1) {
			result.setText("YOU WIN\n\n");
		}
		
		result.append(data.printData());

	    ok.addActionListener(e -> {
    		    new MainFrame();
    		    dispose();
        });
		
		this.getContentPane().add(panel);
		
        this.setVisible(true);
        this.setSize(300,300);
        this.setTitle("GAME OVER");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
