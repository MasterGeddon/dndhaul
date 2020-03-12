package db;

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
@Table(name = Konstanten.T_ACCESSRIGHTS)
public class AccessRights {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Konstanten.C_ACCESSRIGHTS_ID)
	public int accessRights_id;
	
	@Column(name = Konstanten.C_ACCESSRIGHTS_NAME)
	public String accessRights_name;
	
	@Column(name = Konstanten.C_ACCESSRIGHTS_DESCRIPTION)
	public String accessRights_description;

	public String getAccessRights_name() {
		return accessRights_name;
	}

	public void setAccessRights_name(String accessRights_name) {
		this.accessRights_name = accessRights_name;
	}

	public String getAccessRights_description() {
		return accessRights_description;
	}

	public void setAccessRights_description(String accessRights_description) {
		this.accessRights_description = accessRights_description;
	}

	public int getAccessRights_id() {
		return accessRights_id;
	}
	
}
