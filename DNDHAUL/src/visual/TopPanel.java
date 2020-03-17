package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import konsti.KonstantenColor;

public class TopPanel extends JPanel {
	
	
	public JButton minimizeButton = new JButton();
	public JButton closeButton = new JButton();
	
	public JLabel labelName = new JLabel();
	
	
	public TopPanel(String Titel) {
		this.setLayout(new BorderLayout());
		labelName.setText(Titel);
		this.setBackground(KonstantenColor.TopPlaneBackgroundColor);
		
		
		
		
		
		
	}
	

}
