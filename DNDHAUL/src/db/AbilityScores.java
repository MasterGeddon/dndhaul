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
@Table(name= Konstanten.T_ABILITYSCORES)
public class AbilityScores implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_ABILITYSCORES_ID)
	private int absc_id;
	

	@Column(name = Konstanten.C_ABILITYSCORES_NAME)
	private String absc_name;
	
	@ManyToMany(mappedBy="sato")
	private Set<Classe> sato = new HashSet<>();

	public String getAbsc_name() {
		return absc_name;
	}

	public void setAbsc_name(String absc_name) {
		this.absc_name = absc_name;
	}

	public int getAbsc_id() {
		return absc_id;
	}
	
}
