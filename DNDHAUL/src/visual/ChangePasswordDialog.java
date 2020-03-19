package visual;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.Encryption;
import controller.StaticClassObjects;
import db.UserCon;

public class ChangePasswordDialog extends JDialog {

	
	
	public JPanel mainPanel = new JPanel() ;
	public JPanel dialogPanel = new JPanel();
	
	public JPasswordField oldPassword = new JPasswordField();
	public JPasswordField newPassword = new JPasswordField();
	public JPasswordField repassPassword = new JPasswordField();
	
	public JLabel oldPasswordLabel = new JLabel("Old Password :");
	public JLabel newPasswordLabel = new JLabel("New Password :");
	public JLabel repassPasswordLabel = new JLabel("Re-New Password :");
	
	public JButton savePassword = new JButton("Save Password");
	
	
	public ChangePasswordDialog() {
		this.setTitle("Password Change");
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setContentPane(dialogPanel);
		dialogPanel.setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(0,2));
		
		dialogPanel.add(BorderLayout.CENTER, mainPanel);
		dialogPanel.add(BorderLayout.SOUTH,savePassword);
		
		mainPanel.add(oldPasswordLabel);
		mainPanel.add(oldPassword);
		mainPanel.add(newPasswordLabel);
		mainPanel.add(newPassword);
		mainPanel.add(repassPasswordLabel);
		mainPanel.add(repassPassword);
		mainPanel.setVisible(true);
		mainPanel.revalidate();
		mainPanel.repaint();
		
		savePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					if(StaticClassObjects.currentUser.getUserPassword().contentEquals(Encryption.firstencryptString(new String(oldPassword.getPassword())))) {
						if((new String(newPassword.getPassword())).contentEquals(new String(repassPassword.getPassword()))){
							EntityManager entityManager = StaticClassObjects.entityManager;
							 StaticClassObjects.currentUser.setUserPassword(new String(newPassword.getPassword()));
							 UserCon user = StaticClassObjects.currentUser;
							entityManager.getTransaction().begin();
							entityManager.persist(user);
							entityManager.flush();
							entityManager.getTransaction().commit();
							
							disposal();
						}
					}
				} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
						| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
					// TODO Auto-generated catch block
					
				}
				
			}
		});
		

		dialogPanel.setVisible(true);
		dialogPanel.revalidate();
		dialogPanel.repaint();
		pack();
	}
	public void disposal() {
		this.dispose();
	}
	
}
