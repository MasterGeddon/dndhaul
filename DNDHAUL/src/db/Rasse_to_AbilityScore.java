package db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import konstanten.Konstanten;

@Entity
@IdClass(Rasse_to_AbilityScore_Id.class)
@Table(name = Konstanten.T_RASSE_TO_ABILITYSCORE)
public class Rasse_to_AbilityScore implements Serializable{

	
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = Konstanten.C_RASSE_TO_ABILITYSCORE_RASSESUB_ID , nullable = false)
	private RasseSub rtas_rasu_id;
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = Konstanten.C_RASSE_TO_ABILITYSCORE_ABILITYSCORES_ID, nullable = false)
	private AbilityScores rtas_absc_id;
	
	@Column(name = Konstanten.C_RASSE_TO_ABILITYSCORE_RTAS_IMPROV_ANZ)
	private int rtas_improv_anz;


	public RasseSub getRtas_rasu_id() {
		return rtas_rasu_id;
	}


	public void setRtas_rasu_id(RasseSub rtas_rasu_id) {
		this.rtas_rasu_id = rtas_rasu_id;
	}


	public AbilityScores getRtas_absc_id() {
		return rtas_absc_id;
	}


	public void setRtas_absc_id(AbilityScores rtas_absc_id) {
		this.rtas_absc_id = rtas_absc_id;
	}


	public int getRtas_improv_anz() {
		return rtas_improv_anz;
	}


	public void setRtas_improv_anz(int rtas_improv_anz) {
		this.rtas_improv_anz = rtas_improv_anz;
	}
	
}
