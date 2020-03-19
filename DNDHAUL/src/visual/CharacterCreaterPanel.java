package visual;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.CharCreatorController;
import controller.StaticClassObjects;
import controller.UserController;
import db.PlayerCharacter;

public class CharacterCreaterPanel extends JPanel {

	
	
	public JLabel usernameLabel , userNameField ,nameLabel ,rasseLabel ,klasseLabel , waffenProficiencyLabel , armorProficiencyLabel , standartWerteLabel ,rassenBoniLabel , gesamtWerteLabel= new JLabel();
	
	public JButton newCharCreateButton , saveButton , cancelButton , randomWerteGenerateButton , deleteButton= new JButton();
	
	public JTextArea weaponProfTextArea , armorProfTextArea = new JTextArea();
	
	public JSpinner strengthSpin , dexSpin, conSpin , intSpin , wisSpin , chaSpin = new JSpinner();
	
	public JComboBox<String> rasseCombo , klasseCombo  = new JComboBox<String>();
	
	public JLabel chararcterLabel = new JLabel("Character");
	public JScrollPane charaJScrollPane = new JScrollPane();
	public JList characters = new JList();
	
	
	public JPanel creatorPanel = new JPanel (new GridLayout(0,2));
	public JPanel charListPanel = new JPanel(new BorderLayout());
	public JPanel innerCharListPanel = new JPanel(new GridLayout(0,1));

	
	public JPanel bottomPanel = new JPanel(new GridLayout(0,2));
	
	public JPanel wertePanel = new JPanel(new GridLayout(0,5));
	
	
	public JLabel rasStrBLabel, rasDexBLabel , rasConBLabel , rasIntBLabel , rasWisBLabel , rasChaBLabel = new JLabel(); 
	public JLabel gesStrLabel ,gesDexLabel, gesConLabel, gesIntLabel , gesWisLabel , gesChaLabel = new JLabel();
	
	public String[] charsStringArray ;
	public PlayerCharacter [] pcArray ;
	
	public PlayerCharacter selectedChar ;
	
	public List<PlayerCharacter> pcList = new ArrayList<PlayerCharacter>();
	
	
	public CharacterCreaterPanel() {
		
		
		setLayout(new BorderLayout());
		
		add(BorderLayout.WEST, charListPanel);
		
		charListPanel.add(BorderLayout.NORTH,chararcterLabel);
		
		
		
		
		innerCharListPanel.add(BorderLayout.CENTER, charaJScrollPane);
		
		
		
		
		
		
	}
	
	public void fillCharacterList() {
		UserController ucon = new UserController();
		CharCreatorController ccon= new CharCreatorController();
		if(StaticClassObjects.currentUser.getUserRights().getAccessRights_id() == ucon.getAdminAccessRight(StaticClassObjects.entityManager).accessRights_id) {
			
			pcList	=ccon.getAllCharacter(StaticClassObjects.entityManager);
			fillList(pcList);
		}else {
			pcList =ccon.getAllCharacterByUser(StaticClassObjects.entityManager,StaticClassObjects.currentUser);
			fillList(pcList);
		}
		
	}
	public void fillList(List<PlayerCharacter> pcs) {
		
		charsStringArray = new String[pcs.size()];
		pcArray = new PlayerCharacter[pcs.size()];
		
		int count = 0 ;
		for(PlayerCharacter pc : pcs) {
			
			charsStringArray[count]=pc.getChar_name();
			pcArray[count]= pc;
			
		}
		
		
		
		characters = new JList(charsStringArray);
		charaJScrollPane = new JScrollPane(characters);
		
		characters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		characters.revalidate();
		characters.repaint();
		charaJScrollPane.revalidate();
		charaJScrollPane.repaint();
		innerCharListPanel.removeAll();
		innerCharListPanel.add(charaJScrollPane);
		innerCharListPanel.revalidate();
		innerCharListPanel.repaint();
		characters.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(characters.getSelectedIndex()>=0) {
				selectedChar = pcArray[characters.getSelectedIndex()];
				fillCharacterSheet();
				
				}
			}

			
		});
		
		charListPanel.revalidate();
		charListPanel.repaint();
		
		
		
	}
	
	public void fillCharName() {
		
	}
	public void fillCharRasse() {
		
	}
	
	public void fillCharKlasse() {
		
	}
	
	public void fillCharWeaponProf() {
		
	}
	
	public void fillCharArmorProf() {
		
	}
	
	public void fillCharStandardWerte() {
		
	}
	public void fillCharRassenBoni() {
		
	}
	public void fillCharGesamtWerte() {
		
	}
	
	
	private void fillCharacterSheet() {
		fillCharacterList();
		fillCharName();
		fillCharRasse();
		fillCharKlasse();
		fillCharArmorProf();
		fillCharWeaponProf();
		fillCharStandardWerte();
		fillCharRassenBoni();
		fillCharGesamtWerte();
	}
	
}
