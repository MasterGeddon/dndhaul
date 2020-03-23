package konsti;
/**
 * @author Gregor Ober 
 * 
 * **/
public class Konstanten {
	
	
	// Table
	public static final String T_ARMOR = "Armor";
	public static final String T_CLASSE = "Classe";
	public static final String T_RASSE_TO_ABILITYSCORE = "Rasse_to_AbilityScore";
	public static final String T_RASSE = "Rasse";
	public static final String T_RASSESUB = "RasseSub";
	public static final String T_SIZE = "Size";
	public static final String T_WEAPON = "Weapon";
	public static final String T_ABILITYSCORES = "AbilityScores";
	public static final String T_PLAYERCHARACTER = "PlayerCharacter";
	
	// join Table
	
	public static final String TT_CLASSE_WEAPON = T_CLASSE+"_"+T_WEAPON;
	public static final String TT_CLASSE_ARMOR = T_CLASSE+"_"+T_ARMOR;
	
	
	//id Felder
		//armor
	public static final String C_ARMOR_ID = "armo_id";
	public static final String C_ARMOR_TYP = "armo_typ";
		//weapon
	public static final String C_WEAPON_ID = "weap_id";
	public static final String C_WEAPON_TYP = "weap_typ";
		//rasse
	public static final String C_RASSE_ID = "rasse_id";
	public static final String C_RASSE_NAME = "rasse_name";
		//classe
	public static final String C_CLASSE_ID = "clas_id";
	public static final String C_CLASSE_NAME = "clas_name";
	public static final String C_CLASSE_DESCRIPTION = "clas_description";
	public static final String C_CLASSE_HITDIE = "clas_hitDie";
	public static final String C_CLASSE_ABILITYSTRONG = "clas_ability_strong";
	

	
		//Rasse_to_AbilityScore
	public static final String C_RASSE_TO_ABILITYSCORE_RASSESUB_ID = "rtas_rasu_id";
	public static final String C_RASSE_TO_ABILITYSCORE_ABILITYSCORES_ID = "rtas_absc_id";
	public static final String C_RASSE_TO_ABILITYSCORE_RTAS_IMPROV_ANZ = "rtas_improv_anz";
	
		//size
	public static final String C_SIZE_ID = "size_id";
	public static final String C_SIZE_TYP = "size_typ";
		//RasseSub
	public static final String C_RASSESUB_ID = "rasu_id";
	public static final String C_RASSESUB_RASSE_ID = "rasu_rass_id";
	public static final String C_RASSESUB_NAME = "rasu_name";
	public static final String C_RASSESUB_AGE = "rasu_age";
	public static final String C_RASSESUB_SIZE_ID = "rasu_size_id";
	public static final String C_RASSESUB_SPEED = "rasu_speed";
		//AbilityScores
	public static final String C_ABILITYSCORES_ID = "absc_id";
	public static final String C_ABILITYSCORES_NAME = "absc_name";
	
	//PlayerCharacter
	public static final String C_PLAYERCHARACTER_ID = "char_id";
	public static final String C_PLAYERCHARACTER_BACKSTORY = "char_backstory";
	public static final String C_PLAYERCHARACTER_NAME = "char_name";
	public static final String C_PLAYERCHARACTER_CLASSE_ID = "char_clas_id";
	public static final String C_PLAYERCHARACTER_RASSE_ID = "char_rasu_id";
	public static final String C_PLAYERCHARACTER_USER_ID = "char_user_id";

	
	public static final String C_PLAYERCHARACTER_STR ="char_str";
	public static final String C_PLAYERCHARACTER_DEX ="char_dex";
	public static final String C_PLAYERCHARACTER_CON ="char_con";
	public static final String C_PLAYERCHARACTER_INT ="char_int";
	public static final String C_PLAYERCHARACTER_WIS ="char_wis";
	public static final String C_PLAYERCHARACTER_CHA ="char_cha";
	
	public static final Integer I_PLAYERCHARACTER_DEF_STAT = 10 ; 
	
	
	//ColumnFeld Tabelle classe_armor
	public static final String C_CLASSE_TO_ARMOR_S = "artc"+'_';
	public static final String C_CLASSE_TO_ARMOR_CLASSE_ID = C_CLASSE_TO_ARMOR_S+C_CLASSE_ID;
	public static final String C_CLASSE_TO_ARMOR_ARMOR_ID = C_CLASSE_TO_ARMOR_S+C_ARMOR_ID;
	//ColumnFeld Tabelle classe_weapon
	public static final String C_CLASSE_TO_WEAPON_S = "wetc"+'_';
	public static final String C_CLASSE_TO_WEAPON_CLASSE_ID = C_CLASSE_TO_WEAPON_S+C_CLASSE_ID;
	public static final String C_CLASSE_TO_WEAPON_WEAPON_ID = C_CLASSE_TO_WEAPON_S+C_WEAPON_ID;	
	//ColumnFeld Tabelle classe_abilityScores SavingThrows
	public static final String C_CLASSE_TO_ABILITYSCORES_S = "sato"+'_';
	public static final String C_CLASSE_TO_ABILITYSCORES_CLASSE_ID = C_CLASSE_TO_ABILITYSCORES_S+C_CLASSE_ID;
	public static final String C_CLASSE_TO_ABILITYSCORES_ABILITYSCORES_ID = C_CLASSE_TO_ABILITYSCORES_S+C_ABILITYSCORES_ID;
	
	// Stats 
	public static final String L_STAT_STRENGTH = "Strength";  
	public static final String L_STAT_DEXTERITY = "Dexterity";  
	public static final String L_STAT_CONSTITUTION = "Constitution";  
	public static final String L_STAT_INTELLIGENCE = "Intelligence";  
	public static final String L_STAT_WISDOM = "Wisdom";  
	public static final String L_STAT_CHARISMA = "Charisma";  
	
	
	//User Login
	
	public static final String T_USER ="UserCon";
	public static final String C_USER_ID = "user_id";
	public static final String C_USER_NAME = "user_name";
	public static final String C_USER_PASSWORD = "user_pw";
	public static final String C_USER_MAXCHARACTER = "user_max_char";
	public static final int I_MAXCHARACTER =10;
	//Access Rights
	
	public static final String T_ACCESSRIGHTS ="AccessRights";
	public static final String C_ACCESSRIGHTS_ID ="aces_id";
	public static final String C_ACCESSRIGHTS_NAME ="aces_name";
	public static final String C_ACCESSRIGHTS_DESCRIPTION ="aces_description";

	//Only read
	public static final int I_ACCESSRIGHT_READ = 25;
	//read and write
	public static final int I_ACCESSRIGHT_WRITE = 666;
	// read , write and delete
	public static final int I_ACCESSRIGHT_DELETE = 999;
	//admin 
	public static final int I_ACCESSRIGHT_ADMIN = 42069;
	
	//USER ACCESSRIGHTS
	public static final String C_USER_ACCESSRIGHTS = "user_aces_id";

	
	//User problem konstanten
	
	public static final String EX_S_NOUSER = "NOUSER";
	public static final String EX_S_NOUNIQUEUSER = "NOUNIQUEUSER";
	public static final String EX_S_ENCRYPTION = "ENCRYPTION ERROR";
	
	
}
