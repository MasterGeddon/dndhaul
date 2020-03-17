package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.DBAbfragen;
import controller.StaticClassObjects;
import controller.UserController;
import db.UserCon;

public class LogInPanel extends JPanel{
	
	public static DBAbfragen dbFragen = new DBAbfragen();
	
	public JLabel userLabel = new JLabel("Username:");
	public JLabel passwordLabel = new JLabel("Password:");
	public JTextField userTextField  = new JTextField();
	public JPasswordField passwordTextField = new JPasswordField();
	public JButton loginButton = new JButton("Login");
	public JButton newUserButton = new JButton("Register");
	public JLabel welcomeLabel = new JLabel ("Willkommen wir freuen uns das sie sich für unseren DnDCreator entschieden haben ");
	public JLabel errorLabel = new JLabel();
	
	public JPanel inputPanel = new JPanel();
	
	public JPanel welcomePanel = new JPanel();
	
	
	
	
	public LogInPanel () {
		
		dbFragen.startUp();
		
		this.setLayout(new BorderLayout());
		
		
		this.welcomePanel.setLayout(new GridLayout(0,1));
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(errorLabel);
		welcomePanel.setVisible(true);
		welcomePanel.revalidate();
		errorLabel.setForeground(Color.RED);
		
		this.inputPanel.setLayout(new GridLayout(2,0));
		
		inputPanel.add(userLabel);
		inputPanel.add(userTextField);
		inputPanel.add(passwordLabel);
		inputPanel.add(passwordTextField);
		inputPanel.setVisible(true);
		inputPanel.revalidate();
		
		this.add(BorderLayout.CENTER,inputPanel);
		this.add(BorderLayout.NORTH,welcomePanel);
		
		this.add(BorderLayout.EAST,loginButton);
		this.add(BorderLayout.SOUTH,newUserButton);
		
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
    
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// this tries to log in
				
				EntityManager em = StaticClassObjects.entityManager;
				UserController usC = new UserController();
				try {
				StaticClassObjects.currentUser = (UserCon) usC.getThisUser(em, userTextField.getText(), new String(passwordTextField.getPassword()));
				}catch(Exception es) {
					errorLabel.setText("Fehler beim Login");
					refreshYourPanel();
				}
				refreshYourPanel();
				System.out.println("this User is "+StaticClassObjects.currentUser.getUserName());
			}
		});
		
		newUserButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
			        NewUserDialog dialog = new NewUserDialog();
			        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        dialog.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				
				
			}
		});
		
	}
	
	
	public void refreshYourPanel() {
		this.revalidate();
		this.repaint();
	}
	
	
	
	
	

}
