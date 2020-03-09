package db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import konstanten.Konstanten;

@Entity
@Table(name = Konstanten.T_PLAYERCHARACTER)
public class PlayerCharacter implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= Konstanten.C_PLAYERCHARACTER_ID)
	public int char_id;
	
	@Column(name= Konstanten.C_PLAYERCHARACTER_BACKSTORY)
	public String char_backstory ;

	@Column(name= Konstanten.C_PLAYERCHARACTER_NAME)
	public String char_name ;
	
	@Column(name= Konstanten.C_PLAYERCHARACTER_STR , nullable = false)
	public int char_str =0;
	@Column(name= Konstanten.C_PLAYERCHARACTER_DEX , nullable = false)
	public int char_dex =0;
	@Column(name= Konstanten.C_PLAYERCHARACTER_CON , nullable = false)
	public int char_con =0;
	@Column(name= Konstanten.C_PLAYERCHARACTER_INT , nullable = false)
	public int char_int =0;
	@Column(name= Konstanten.C_PLAYERCHARACTER_WIS , nullable = false)
	public int char_wis =0;
	@Column(name= Konstanten.C_PLAYERCHARACTER_CHA , nullable = false)
	public int char_cha =0;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name= Konstanten.C_PLAYERCHARACTER_CLASSE_ID)
	public Classe char_clas_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name= Konstanten.C_PLAYERCHARACTER_RASSE_ID)
	public RasseSub char_rasu_id;
	
	
	public PlayerCharacter (String char_backstory , String char_name ,Classe char_clas_id ,RasseSub char_rasu_id,
			int char_str,int char_dex, int char_con,int char_int, int char_wis, int char_cha) {
		this.char_backstory = char_backstory ;
		this.char_name = char_name;
		this.char_clas_id = char_clas_id;
		this.char_rasu_id = char_rasu_id;
		
		this.char_str = char_str;
		this.char_dex = char_dex;
		this.char_con = char_con;
		this.char_int = char_wis;
		this.char_wis = char_wis;
		this.char_cha = char_cha;
		
	}
	
	public PlayerCharacter (String char_backstory , String char_name) {
		this.char_backstory = char_backstory ;
		this.char_name = char_name;
		
	}
	public PlayerCharacter () {
		this.char_backstory = "Diese Character backstory ist leer" ;
		this.char_name = "BOB";
		
	}
	
	
	
	public String getChar_name() {
		return char_name;
	}

	public void setChar_name(String char_name) {
		this.char_name = char_name;
	}

	public Classe getChar_clas_id() {
		return char_clas_id;
	}

	public void setChar_clas_id(Classe char_clas_id) {
		this.char_clas_id = char_clas_id;
	}

	public RasseSub getChar_rasu_id() {
		return char_rasu_id;
	}

	public void setChar_rasu_id(RasseSub char_rasu_id) {
		this.char_rasu_id = char_rasu_id;
	}

	public int getChar_id() {
		return char_id;
	}

	public String getChar_backstory() {
		return char_backstory;
	}

	public void setChar_backstory(String char_backstory) {
		this.char_backstory = char_backstory;
	}

	public int getChar_str() {
		return char_str;
	}

	public void setChar_str(int char_str) {
		this.char_str = char_str;
	}

	public int getChar_dex() {
		return char_dex;
	}

	public void setChar_dex(int char_dex) {
		this.char_dex = char_dex;
	}

	public int getChar_con() {
		return char_con;
	}

	public void setChar_con(int char_con) {
		this.char_con = char_con;
	}

	public int getChar_int() {
		return char_int;
	}

	public void setChar_int(int char_int) {
		this.char_int = char_int;
	}

	public int getChar_wis() {
		return char_wis;
	}

	public void setChar_wis(int char_wis) {
		this.char_wis = char_wis;
	}

	public int getChar_cha() {
		return char_cha;
	}

	public void setChar_cha(int char_cha) {
		this.char_cha = char_cha;
	}

	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}
	
	
}
