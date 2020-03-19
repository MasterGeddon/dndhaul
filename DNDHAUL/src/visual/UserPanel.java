package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.CharCreatorController;
import controller.StaticClassObjects;
import controller.UserController;
import db.AccessRights;
import db.PlayerCharacter;
import db.UserCon;
import konsti.Konstanten;

public class UserPanel extends JPanel{

	
	// bereich read write
	public JButton newPasswordButton = new JButton("New Password");
	
	
	public JLabel userName = new JLabel("Username :");
	public JLabel userNameDisplay = new JLabel();
	public JLabel userCharacterCount = new JLabel("User Character count :");
	public JLabel userChracterCountDisplay = new JLabel();
	
	public JLabel userRight = new JLabel("User Rights :");
	public JLabel userRightDisplay = new JLabel();
	
	// delete 
	
	public JButton deleteAllCharactersButton = new JButton("Delete All Characters");
	
	// admin
	
	public JList userList = new JList();
	public String [] userArray ;
	public UserCon [] userConArray;
	
	public List<UserCon> usersss = new ArrayList<UserCon>();
	
	public JLabel selectedUserName = new JLabel();
	
	public JLabel radioRead = new JLabel ("Read");
	public JButton radioButtonRead = new JButton("O");
	public JLabel radioWrite = new JLabel ("Write");
	public JButton radioButtonWrite = new JButton("O");
	public JLabel radioDelete = new JLabel ("Delete");
	public JButton radioButtonDelete = new JButton("O");
	public JLabel radioAdmin = new JLabel ("Admin");
	public JButton radioButtonAdmin = new JButton("O");
	
	public UserCon selectedUser ;
	
	
	// panel
	public JPanel upperPanel = new JPanel();
	public JPanel adminPanel = new JPanel();
	public JPanel upperLeftPanel = new JPanel();
	public JPanel upperRightPanel = new JPanel();
	
	public JPanel adminUserListPanel = new JPanel();
	public JPanel adminRightsPanel = new JPanel();
	public JScrollPane userListScrollP = new JScrollPane();
	
	public UserPanel() {
		
		this.setLayout(new GridLayout(0,1));
		
		//userpanel
		this.add(upperPanel);
		//adminpanel
		if(StaticClassObjects.currentUser.getUserRights().getAccessRights_id() == Konstanten.I_ACCESSRIGHT_ADMIN) {
			this.add(adminPanel);
		}
		
		//userpanel standard
		upperPanel.setLayout(new BorderLayout());
		upperPanel.add(BorderLayout.WEST,upperLeftPanel);
		upperPanel.add(BorderLayout.CENTER,upperRightPanel);
		
		//
		upperLeftPanel.setLayout(new GridLayout(0,1));
		upperLeftPanel.add(newPasswordButton);
		
		newPasswordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePasswordDialog cpd = new ChangePasswordDialog();
				cpd.pack();
				cpd.setVisible(true);
			}
		});
		if(StaticClassObjects.currentUser.getUserRights().getAccessRights_id() != Konstanten.I_ACCESSRIGHT_READ &&
				StaticClassObjects.currentUser.getUserRights().getAccessRights_id() != Konstanten.I_ACCESSRIGHT_WRITE) {
			upperLeftPanel.add(deleteAllCharactersButton);
			deleteAllCharactersButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					CharCreatorController charCon = new CharCreatorController();
					charCon.deleteAllCharacterByUser(StaticClassObjects.currentUser, StaticClassObjects.entityManager);
					refreshAllPanels();
				}
			});
			
		}
		
		upperRightPanel.setLayout(new GridLayout(0,2));
		upperRightPanel.add(userName);
		upperRightPanel.add(userNameDisplay);
		upperRightPanel.add(userCharacterCount);
		upperRightPanel.add(userChracterCountDisplay);
		upperRightPanel.add(userRight);
		upperRightPanel.add(userRightDisplay);
		
		adminPanel.setLayout(new GridLayout(0,2));
		fillUserList();
		adminPanel.add(adminUserListPanel);
		adminUserListPanel.setVisible(true);
		adminUserListPanel.setLayout(new GridLayout(0,1));
		adminUserListPanel.add(userListScrollP);
		
		userList.setVisible(true);
		userListScrollP.setVisible(true);
		
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		
		
		adminPanel.add( adminRightsPanel);
		
		adminRightsPanel.setLayout(new GridLayout(0,4));
		adminRightsPanel.add(radioRead);
		adminRightsPanel.add(radioWrite);
		adminRightsPanel.add(radioDelete);
		adminRightsPanel.add(radioAdmin);
		

		adminRightsPanel.add(radioButtonRead);
		adminRightsPanel.add(radioButtonWrite);
		adminRightsPanel.add(radioButtonDelete);
		adminRightsPanel.add(radioButtonAdmin);
		
		
		radioButtonRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController husky = new UserController();
				if(selectedUser !=null) {
				changeRights(selectedUser, husky.getReadAccessRight(StaticClassObjects.entityManager));
				refreshAllPanels();
				}
			}
		});		
		radioButtonWrite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController husky = new UserController();
				if(selectedUser !=null) {
				changeRights(selectedUser, husky.getWriteAccessRight(StaticClassObjects.entityManager));
				refreshAllPanels();
				}
			}
		});		
		radioButtonDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController husky = new UserController();
				if(selectedUser !=null) {
				changeRights(selectedUser, husky.getDeleteAccessRight(StaticClassObjects.entityManager));
				refreshAllPanels();
				}
			}
		});
		radioButtonAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserController husky = new UserController();
				if(selectedUser !=null) {
				changeRights(selectedUser, husky.getAdminAccessRight(StaticClassObjects.entityManager));
				refreshAllPanels();
				}
			}
		});
		
		
		
		adminPanel.setVisible(true);
		adminRightsPanel.setVisible(true);
		upperPanel.setVisible(true);
		upperLeftPanel.setVisible(true);
		upperRightPanel.setVisible(true);
		this.setVisible(true);
		refreshAllPanels();
		
	}
	
	
	public void fillUserList() {
		UserController usCon = new UserController();
		usersss =usCon.getAllUser(StaticClassObjects.entityManager);
		
		userArray = new String[usersss.size()];
		userConArray = new UserCon[usersss.size()];
		int count=0;
		for(UserCon usher : usersss) {
			userArray[count]=usher.getUserName();
			userConArray[count]=usher;
			count++;
		} 
		userList = new JList(userArray);
		userListScrollP = new JScrollPane(userList);
		
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.revalidate();
		userList.repaint();
		userListScrollP.revalidate();
		userListScrollP.repaint();
		adminUserListPanel.removeAll();
		adminUserListPanel.add(userListScrollP);
		adminUserListPanel.revalidate();
		adminUserListPanel.repaint();
		userList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(userList.getSelectedIndex());
				System.out.println(userList.getSelectedValue());
				if(userList.getSelectedIndex()>=0) {
				selectedUser = userConArray[userList.getSelectedIndex()];
				}
			}
		});
		
		adminPanel.revalidate();
		adminPanel.repaint();
		
		
		
	}
	
	public void fillUserName() {
		userNameDisplay.setText(" "+StaticClassObjects.currentUser.getUserName());
	}
	public void fillUserCharacterCount() {
		
		CharCreatorController cCon= new CharCreatorController();
		List<PlayerCharacter> plList = cCon.getAllCharacterByUser(StaticClassObjects.entityManager, StaticClassObjects.currentUser);
		
		int count=0;
		for(PlayerCharacter pc : plList) {
			count++;
		}
		userChracterCountDisplay.setText(" "+count);
		
	}
	public void fillUserCharacterRights() {
		userRightDisplay.setText(" "+StaticClassObjects.currentUser.getUserRights().accessRights_name );
	}
	
	public void changeRights(UserCon user,AccessRights accRights) {
		try {
		System.out.println(user.getUserName()+" hat recht "+user.getUserRights().accessRights_name);
		user.setUserRights(accRights);
		EntityManager entityManager = StaticClassObjects.entityManager;
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.flush();
		entityManager.getTransaction().commit();
		System.out.println(user.getUserName()+" hat recht "+user.getUserRights().accessRights_name);
		}catch(Exception e ) {
			
		}
	}
	
	public void refreshAllPanels() {
		fillUserList();
		fillUserName();
		fillUserCharacterRights();
		fillUserCharacterCount();
		revalidate();
		repaint();
	}
	
	
}
