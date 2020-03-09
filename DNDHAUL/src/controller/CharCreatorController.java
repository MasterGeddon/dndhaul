package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import db.AbilityScores;
import db.Armor;
import db.Classe;
import db.PlayerCharacter;
import db.Rasse;
import db.RasseSub;
import db.Rasse_to_AbilityScore;
import db.Size;
import db.Weapon;
import konsti.Konstanten;

public class CharCreatorController {
	
	
	DBAbfragen dbCon = new DBAbfragen();
	
	public List<PlayerCharacter> getAllCharacter(EntityManager entityManager) {
		return (List<PlayerCharacter>)dbCon.getListTable(entityManager, Konstanten.T_PLAYERCHARACTER);
	}
	
	
	// gibt den Namen des Characters zurück
	public String getCharName (PlayerCharacter character) {
		return character.getChar_name();
	}
	
	// gibt den Namen des Characters zurück
	public String getCharBackstory (PlayerCharacter character) {
		return character.getChar_backstory();
	}	
	// gibt die Rasse des Characters zurück
	public String getCharRasseSubName(PlayerCharacter character) {
		return character.getChar_rasu_id().getRasu_name();
	}
	
	// gibt die Classe des Characters zurück
	public String getCharClasseName(PlayerCharacter character) {
		return character.getChar_clas_id().getClas_name();
	}
	
	// gibt die Classe des Characters zurück
	public Classe getCharClasse(PlayerCharacter character) {
		return character.getChar_clas_id();
	}
	
	// gibt die proficiency der Waffe zur Classe zurück
	public List<Weapon> getClasseWeapon(Classe classe){      
		 
		List<Weapon> list = new ArrayList<Weapon>();
		list.addAll(classe.getWetc());
		 return list;
	}
	
	// gibt die proficiency der Armor zur Classe zurück
	public List<Armor> getClasseArmor(Classe classe){      
		 
		List<Armor> list = new ArrayList<Armor>();
		list.addAll(classe.getArtc());
		 return list;
	}
	
	// gibt die saving throws zurück
	public List<AbilityScores> getClasseAbilityScores(Classe classe){      
		 
		List<AbilityScores> list = new ArrayList<AbilityScores>();
		list.addAll(classe.getSato());
		 return list;
	}
	
		// gibt die ability score improvements für die rasse zurück 
	public List<Rasse_to_AbilityScore> getRasseToAbilityScores(EntityManager entityManager , RasseSub rassSub){
		
	 List<Rasse_to_AbilityScore> list = (List<Rasse_to_AbilityScore>)dbCon.selectObjectFromTable(entityManager , Konstanten.T_RASSE_TO_ABILITYSCORE , rassSub.getRasu_id(), Konstanten.C_RASSE_TO_ABILITYSCORE_RASSESUB_ID);
		
		return list ; 
	}
	// gibt die leere classe zurück um einen leeren spieler zu erzeugen
	public Classe getEmptyClasse(EntityManager entityManager) {
		return entityManager.find(Classe.class , 9999);
	}
	
	// gibt die leere rasse zurück um einen leeren spieler zu erzeugen
	public RasseSub getEmptyRasseSub(EntityManager entityManager) {
		return entityManager.find(RasseSub.class , 9999);
	}
	
	// fügt einen leeren Spieler hinzu
	public PlayerCharacter addPlayerCharacter(EntityManager em) {
		
		PlayerCharacter pc = new PlayerCharacter();
		pc.setChar_clas_id(getEmptyClasse(em));
		pc.setChar_rasu_id(getEmptyRasseSub(em));
		em.getTransaction().begin();
		em.persist(pc);
		em.flush();
		em.getTransaction().commit();
		System.out.println("Charakter Created with ID: "+pc.getChar_id());
		return pc ; 
	}
	
	// Speichert einen charakter 
	public PlayerCharacter savePlayerCharacter (
			EntityManager em , String char_backstory , String char_name ,Classe char_clas_id ,RasseSub char_rasu_id,
			int char_str,int char_dex, int char_con,int char_int, int char_wis, int char_cha , 
			PlayerCharacter pc) {
		pc.setChar_backstory(char_backstory);
		pc.setChar_name(char_name);
		pc.setChar_rasu_id(char_rasu_id);
		pc.setChar_clas_id(char_clas_id);
		pc.setChar_str(char_str);
		pc.setChar_dex(char_dex);
		pc.setChar_con(char_con);
		pc.setChar_int(char_int);
		pc.setChar_wis(char_wis);
		pc.setChar_cha(char_cha);
		
		em.getTransaction().begin();
		em.persist(pc);
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("Charakter Saved with ID: "+pc.getChar_id());
		
		return pc;
	}
	
	
	//zur Erstellung der Random werte für die Stats
	public int randomWert() {
		int i =1+(int)(Math.random()*20);
		System.out.println("Randomwert "+i);

		return i;
	}
	
	public PlayerCharacter setStatsRandom(PlayerCharacter pc) {
		pc.setChar_str(randomWert());
		pc.setChar_dex(randomWert());
		pc.setChar_con(randomWert());
		pc.setChar_int(randomWert());
		pc.setChar_wis(randomWert());
		pc.setChar_cha(randomWert());
		
		return pc;
	}
	
	public PlayerCharacter cancelEditingPC(EntityManager em, PlayerCharacter pc) {
		pc = em.find(PlayerCharacter.class , pc.getChar_id());
		return pc;
	}
	
	public List<Classe> getALLClasse(EntityManager em){      
		 
		List<Classe> list = (List<Classe>)dbCon.getListTable(em, Konstanten.T_CLASSE);
		 return list;
	}
	
	public List<Weapon> getALLWeapon(EntityManager em){      
		 
		List<Weapon> list = (List<Weapon>)dbCon.getListTable(em, Konstanten.T_WEAPON);
		 return list;
	}
	
	public List<Armor> getALLArmor(EntityManager em){      
		 
		List<Armor> list = (List<Armor>)dbCon.getListTable(em, Konstanten.T_ARMOR);
		 return list;
	}
	
	public List<RasseSub> getALLRasseSub(EntityManager em){      
		 
		List<RasseSub> list = (List<RasseSub>)dbCon.getListTable(em, Konstanten.T_RASSESUB);
		 return list;
	}
	
	public List<AbilityScores> getALLAbilityScores(EntityManager em){      
		 
		List<AbilityScores> list = (List<AbilityScores>)dbCon.getListTable(em, Konstanten.T_ABILITYSCORES);
		 return list;
	}

	public List<Rasse> getALLRasse(EntityManager em){      
		 
		List<Rasse> list = (List<Rasse>)dbCon.getListTable(em, Konstanten.T_RASSE);
		 return list;
	}
	
	public List<Size> getALLSize(EntityManager em){      
		 
		List<Size> list = (List<Size>)dbCon.getListTable(em, Konstanten.T_SIZE);
		 return list;
	}
	
	

}
