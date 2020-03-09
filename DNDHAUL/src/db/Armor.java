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

@Entity
@Table(name = Konstanten.T_ARMOR)
public class Armor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_ARMOR_ID)
	public int armo_id;
	
	@Column(name = Konstanten.C_ARMOR_TYP)
	public String armo_typ;

	public String getArmo_typ() {
		return armo_typ;
	}

	public void setArmo_typ(String armo_typ) {
		this.armo_typ = armo_typ;
	}

	public int getArmo_id() {
		return armo_id;
	}
	
	@ManyToMany(mappedBy = "artc")
	private Set<Classe> artc = new HashSet<>();
	
	
}
