package db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import konsti.Konstanten;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = Konstanten.T_RASSESUB)
public class RasseSub implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_RASSESUB_ID)
	private int rasu_id;

	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name =Konstanten.C_RASSESUB_RASSE_ID)
	private Rasse rasu_rass_id;
	

	@Column(name = Konstanten.C_RASSESUB_NAME)
	private String rasu_name;

	@Column(name = Konstanten.C_RASSESUB_AGE)
	private int rasu_age;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = Konstanten.C_RASSESUB_SIZE_ID,nullable = false)
	private Size rasu_size_id;
	
	@Column(name = Konstanten.C_RASSESUB_SPEED)
	private int rasu_speed;
	
	public String getRasu_name() {
		return rasu_name;
	}


	public void setRasu_name(String rasu_name) {
		this.rasu_name = rasu_name;
	}


	public int getRasu_age() {
		return rasu_age;
	}


	public void setRasu_age(int rasu_age) {
		this.rasu_age = rasu_age;
	}


	public int getRasu_speed() {
		return rasu_speed;
	}


	public void setRasu_speed(int rasu_speed) {
		this.rasu_speed = rasu_speed;
	}


	public int getRasu_id() {
		return rasu_id;
	}


	public Rasse getRasu_rass_id() {
		return rasu_rass_id;
	}


	public Size getRasu_size_id() {
		return rasu_size_id;
	}
	
}
