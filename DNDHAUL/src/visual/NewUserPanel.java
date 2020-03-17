package visual;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUserPanel extends JPanel {

	
	public JLabel userLabel = new JLabel("Name:");
	public JLabel passwordLabel = new JLabel("Password:");
	public JLabel passwordLabel2 = new JLabel("re-Password:");
	public JTextField userTextField  = new JTextField();
	public JPasswordField  passwordTextField = new JPasswordField ();
//	public JPasswordField  passwordTextField2 = new JPasswordField ();
	

	
	public JPanel inputPanel = new JPanel();

	public NewUserPanel() {
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH,new JLabel("DnD User Registrierung"));

		inputPanel.setLayout(new GridLayout(2,0));

		this.setSize(400, 500);
//		
		inputPanel.add(userLabel);
		inputPanel.add(userTextField);
		inputPanel.add(passwordLabel);
		inputPanel.add(passwordTextField);
//		inputPanel.add(passwordLabel2);
//		inputPanel.add(passwordTextField2);
		
		inputPanel.setVisible(true);
		inputPanel.revalidate();
		inputPanel.repaint();
		
		add(BorderLayout.CENTER,inputPanel);
		
		
		
	}
	
}
