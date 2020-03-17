package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.DBAbfragen;
import controller.StaticClassObjects;
import controller.UserController;

public class NewUserDialog extends JDialog {

	public JPanel mainPanel = new JPanel();
	public TopPanel topPanel = new TopPanel("Register");
	
	public NewUserPanel registerPanel = new NewUserPanel();
	
	
	public JButton registerButton = new JButton ("Register");

	
	public NewUserDialog() {
		
		this.setContentPane(mainPanel);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(BorderLayout.NORTH,topPanel);
		mainPanel.add(BorderLayout.CENTER,registerPanel);
		registerPanel.add(BorderLayout.EAST,registerButton);
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// RegisterNew User
				DBAbfragen dbF = new DBAbfragen();
				UserController usC = new UserController();
				try {
					usC.setNewUser(StaticClassObjects.entityManager, registerPanel.userTextField.getText(), new String(registerPanel.passwordTextField.getPassword()), usC.getDeleteAccessRight(StaticClassObjects.entityManager));
					System.out.println(new String(registerPanel.passwordTextField.getPassword()));

					disposeing();
					
				}catch(Exception es) {
					System.out.println("Error on register");
					
				}
				
			}
		});
		registerPanel.setVisible(true);
		registerPanel.revalidate();
		registerPanel.repaint();
		mainPanel.setVisible(true);
		mainPanel.revalidate();
		mainPanel.repaint();
		pack();
		
	}
	
	public void disposeing() {
		this.dispose();
	}
	
}
