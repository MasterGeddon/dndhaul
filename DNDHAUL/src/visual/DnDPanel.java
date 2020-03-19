package visual;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DnDPanel extends JPanel {

	public JTabbedPane tabbi = new JTabbedPane();
	
	public UserPanel uPanel = new UserPanel();
	
	public DnDPanel () {
		
		this.setLayout(new BorderLayout());
		this.add(tabbi);
		tabbi.addTab("User", uPanel);
		
		this.setVisible(true);
	}
	
}
