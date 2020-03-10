package db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import konsti.Konstanten;
/**
 * @author Gregor Ober 
 * 
 * **/
@Entity
@Table(name = Konstanten.T_WEAPON)
public class Weapon implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_WEAPON_ID)
	private int weap_id;

	@Column(name = Konstanten.C_WEAPON_TYP)
	private String weap_typ;

	public String getWeap_typ() {
		return weap_typ;
	}

	public void setWeap_typ(String weap_typ) {
		this.weap_typ = weap_typ;
	}

	public int getWeap_id() {
		return weap_id;
	}
	
	@ManyToMany(mappedBy = "wetc")
	private Set<Classe> wetc = new HashSet<>();
	
}
