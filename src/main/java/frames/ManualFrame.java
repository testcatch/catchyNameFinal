package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.GameDataList;

public class ManualFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton ok;
	private JTextArea result;

	public ManualFrame(GameDataList datalist, String name) {
		panel = new JPanel();
		result = new JTextArea("Results");
	    result.setEditable(false);
		ok = new JButton("OK");
		
		panel.add(result);
		panel.add(ok);

		result.setText(datalist.getData(name).printManual());

	    ok.addActionListener(e -> {
    		  new GameFrame(datalist,name);
    		  dispose();
        });
		
		this.getContentPane().add(panel);
		
        this.setVisible(true);
        this.setSize(500,500);
        this.setTitle("Manual");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
