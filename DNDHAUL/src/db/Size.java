package db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import konsti.Konstanten;
/**
 * @author Gregor Ober 
 * 
 * **/
@Entity
@Table(name = Konstanten.T_SIZE)
public class Size implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = Konstanten.C_SIZE_ID)
	private int size_id;
	@Column(name = Konstanten.C_SIZE_TYP)
	private String size_typ;

	public String getSize_typ() {
		return size_typ;
	}

	public void setSize_typ(String size_typ) {
		this.size_typ = size_typ;
	}

	public int getSize_id() {
		return size_id;
	}
	
	
}
