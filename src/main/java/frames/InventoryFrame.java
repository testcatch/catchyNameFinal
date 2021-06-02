package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.GameData;

public class InventoryFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton back;
	private JButton swap;
	//private JList<Object> inventory;
	private JTextArea activeitem;

	public InventoryFrame(GameData data) {
		panel = new JPanel();
		back = new JButton("back");
		swap = new JButton("swap");
		activeitem = new JTextArea("Active Item");
		
		//panel.add(inventory);
		panel.add(activeitem);
		panel.add(swap);
		panel.add(back);

	    swap.addActionListener(e -> {
	    	//TODO

        });
	    
	    back.addActionListener(e -> {
    		    dispose();
        });
		
		this.getContentPane().add(panel);
		
        this.setVisible(true);
        this.setSize(600,600);
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
