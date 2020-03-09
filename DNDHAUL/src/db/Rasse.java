package db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import konsti.Konstanten;

@Entity
@Table(name = Konstanten.T_RASSE)
public class Rasse implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_RASSE_ID)
	private int rasse_id;
	
	@Column(name = Konstanten.C_RASSE_NAME)
	private String rasse_name;
	

	public int getRasse_id() {
		return rasse_id;
	}

	public String getRasse_name() {
		return rasse_name;
	}

	public void setRasse_name(String rasse_name) {
		this.rasse_name = rasse_name;
	}


	
}
