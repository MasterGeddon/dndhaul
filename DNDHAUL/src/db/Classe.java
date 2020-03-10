package db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import konsti.Konstanten;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * @author Gregor Ober 
 * 
 * **/
@Entity
@Table(name = Konstanten.T_CLASSE)
public class Classe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_CLASSE_ID)
	private int clas_id;
	
	@Column(name = Konstanten.C_CLASSE_NAME)
	private String clas_name;
	@Column(name = Konstanten.C_CLASSE_DESCRIPTION)
	private String clas_description;
	@Column(name = Konstanten.C_CLASSE_HITDIE)
	private int clas_hitDie;
	@Column(name = Konstanten.C_CLASSE_ABILITYSTRONG)
	private String clas_ability_strong;
	
	
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private Set<Weapon> wetc = new HashSet<>();
	

	@ManyToMany
	@JoinColumn(nullable = false)
	private Set<Armor> artc = new HashSet<>();
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private Set<AbilityScores> sato = new HashSet<>();
	
	public String getClas_name() {
		return clas_name;
	}
	public void setClas_name(String clas_name) {
		this.clas_name = clas_name;
	}
	public String getClas_description() {
		return clas_description;
	}
	public void setClas_description(String clas_description) {
		this.clas_description = clas_description;
	}
	public int getClas_hitDie() {
		return clas_hitDie;
	}
	public void setClas_hitDie(int clas_hitDie) {
		this.clas_hitDie = clas_hitDie;
	}
	public String getClas_ability_strong() {
		return clas_ability_strong;
	}
	public void setClas_ability_strong(String clas_ability_strong) {
		this.clas_ability_strong = clas_ability_strong;
	}
	public int getClas_id() {
		return clas_id;
	}
	public Set<Weapon> getWetc() {
		return wetc;
	}
	public void setWetc(Set<Weapon> wetc) {
		this.wetc = wetc;
	}
	public Set<Armor> getArtc() {
		return artc;
	}
	public void setArtc(Set<Armor> artc) {
		this.artc = artc;
	}
	public Set<AbilityScores> getSato() {
		return sato;
	}
	public void setSato(Set<AbilityScores> sato) {
		this.sato = sato;
	}
	
}
