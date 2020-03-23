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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.CharCreatorController;
import controller.StaticClassObjects;
import controller.UserController;
import db.Armor;
import db.Classe;
import db.PlayerCharacter;
import db.RasseSub;
import db.Rasse_to_AbilityScore;
import db.Weapon;

public class CharacterCreaterPanel extends JPanel {

	
	
	public JLabel usernameLabel , userNameField ,nameLabel ,backstoryLabel ,rasseLabel ,klasseLabel , waffenProficiencyLabel , armorProficiencyLabel , standartWerteLabel ,rassenBoniLabel , gesamtWerteLabel= new JLabel();
	
	
	public JTextField nameField = new JTextField();
	
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
	
	public RasseSub [] rassenArray ;
	public String [] rassenStringArray;
	
	public Classe [] classeArray;
	public String [] classeStringArray;
	
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
			count++;
			
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
	public void fillUserName() {
		if(selectedChar!=null) {
		userNameField.setText(selectedChar.getChar_user_id().getUserName());
		}
	}
	public void fillCharName() {
		if(selectedChar!= null||(!selectedChar.getChar_name().contentEquals("")&&selectedChar.getChar_name()!= null)) {
			nameField.setText(selectedChar.getChar_name());
		}
	}
	public void fillCharRasse() {
		if(selectedChar!=null) {
			for(int i=0 ; i<rassenArray.length;i++) {
				
				if(rassenArray[i].equals(selectedChar.getChar_rasu_id())) {
					rasseCombo.setSelectedIndex(i);
				}
			}
		}else {

			rasseCombo.setSelectedIndex(rassenArray.length-1);
		}
	}
	
	public void fillCharKlasse() {
		if(selectedChar!=null) {
			for(int i=0 ; i<classeArray.length;i++) {
				if(classeArray[i].equals(selectedChar.getChar_clas_id())) {
					klasseCombo.setSelectedIndex(i);
				}
			}
		}else {
			klasseCombo.setSelectedIndex(classeArray.length-1);
		}
	}
	
	public void fillCharWeaponProf() {
		if(selectedChar != null) {
			CharCreatorController chaCon = new CharCreatorController();
			List<Weapon> weap = chaCon.getClasseWeapon(selectedChar.getChar_clas_id());
			
			String s ="";
			for(Weapon w :weap) {
				s = s+w.getWeap_typ()+"; ";
			}

			weaponProfTextArea.setText(s);
		}
	}
	
	public void fillCharArmorProf() {
		if(selectedChar != null) {
			CharCreatorController chaCon = new CharCreatorController();
			List<Armor> armor = chaCon.getClasseArmor(selectedChar.getChar_clas_id());
			
			String s ="";
			for(Armor a :armor) {
				s = s+a.getArmo_typ()+"; ";
			}
			armorProfTextArea.setText(s);
		}
	}
	
	public void startJSpinner() {
		
		SpinnerModel sm = new SpinnerNumberModel(10,0,20,1);
		strengthSpin = new JSpinner(sm);
		dexSpin = new JSpinner(sm);
		conSpin = new JSpinner(sm);
		intSpin = new JSpinner(sm);
		wisSpin = new JSpinner(sm);
		chaSpin = new JSpinner(sm);
	}
	
	public void fillCharStandardWerte() {
		
		if(selectedChar!=null) {
			strengthSpin.setValue(selectedChar.getChar_str());
			dexSpin.setValue(selectedChar.getChar_dex());
			conSpin.setValue(selectedChar.getChar_con());
			intSpin.setValue(selectedChar.getChar_int());
			wisSpin.setValue(selectedChar.getChar_wis());
			chaSpin.setValue(selectedChar.getChar_cha());
		}
		
		
	}
	public void fillCharRassenBoni() {
		CharCreatorController con = new CharCreatorController();
		 List<Rasse_to_AbilityScore> pp = con.getRasseToAbilityScores(StaticClassObjects.entityManager, selectedChar.getChar_rasu_id());
    	 for(Rasse_to_AbilityScore ps : pp) {
    		 ps.getRtas_absc_id().getAbsc_id();
    		 ps.getRtas_improv_anz();
    	 }
	}
	public void fillCharGesamtWerte() {
		
	}
	
	public void fillJComboboxes() {
		CharCreatorController charCon = new CharCreatorController();
		List<RasseSub> rasseSubList = charCon.getALLRasseSub(StaticClassObjects.entityManager);
		
		rassenArray = new RasseSub[rasseSubList.size()];
		rassenStringArray = new String [rasseSubList.size()];
		int count = 0;
		for(RasseSub rasu : rasseSubList) {
			rassenArray[count]= rasu;
			rassenStringArray[count]= ""+rasu.getRasu_name()+" "+rasu.getRasu_rass_id().getRasse_name();
			count++;
		}
		
		List<Classe> classeS = charCon.getALLClasse(StaticClassObjects.entityManager);
		
		classeArray = new Classe[classeS.size()];
		classeStringArray = new String [classeS.size()];
		int count2 = 0;
		for(Classe clas : classeS) {
			classeArray[count2]= clas;
			classeStringArray[count2]= ""+clas.getClas_name();
			count2++;
		}
		
		rasseCombo = new JComboBox<String>(rassenStringArray);
		klasseCombo = new JComboBox<String>(classeStringArray);
		
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
