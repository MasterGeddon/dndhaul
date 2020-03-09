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
import db.Weapon;
import konsti.Konstanten;

public class CharCreatorController {
	
	
	DBAbfragen dbCon = new DBAbfragen();
	
	public List<PlayerCharacter> getAllCharacter(EntityManager entityManager) {
		return (List<PlayerCharacter>)dbCon.getListTable(entityManager, Konstanten.T_PLAYERCHARACTER);
	}
	
	
	public String getCharName (PlayerCharacter character) {
		return character.getChar_name();
	}
	
	
	public String getCharRasseSubName(PlayerCharacter character) {
		return character.getChar_rasu_id().getRasu_name();
	}
	
	public String getCharClasseName(PlayerCharacter character) {
		return character.getChar_clas_id().getClas_name();
	}
	
	public Classe getCharClasse(PlayerCharacter character) {
		return character.getChar_clas_id();
	}
	
	public List<Weapon> getClasseWeapon(Classe classe){      
		 
		List<Weapon> list = new ArrayList<Weapon>();
		list.addAll(classe.getWetc());
		 return list;
	}
	
	public List<Armor> getClasseArmor(Classe classe){      
		 
		List<Armor> list = new ArrayList<Armor>();
		list.addAll(classe.getArtc());
		 return list;
	}
	
	public List<AbilityScores> getClasseAbilityScores(Classe classe){      
		 
		List<AbilityScores> list = new ArrayList<AbilityScores>();
		list.addAll(classe.getSato());
		 return list;
	}
	
	public List<Rasse_to_AbilityScore> getRasseToAbilityScores(EntityManager entityManager , RasseSub rassSub){
		
	 List<Rasse_to_AbilityScore> list = (List<Rasse_to_AbilityScore>)dbCon.selectObjectFromTable(entityManager , Konstanten.T_RASSE_TO_ABILITYSCORE , rassSub.getRasu_id(), Konstanten.C_RASSE_TO_ABILITYSCORE_RASSESUB_ID);
		
		return list ; 
	}

}
