package db;

import java.io.Serializable;

public class Rasse_to_AbilityScore_Id implements Serializable{

	
	
	private int rtas_rasu_id;
	private int rtas_absc_id;
	
	public int getRtas_rasu_id() {
		return rtas_rasu_id;
	}

	public int getRtas_absc_id() {
		return rtas_absc_id;
	}

	public Rasse_to_AbilityScore_Id() {
		super();
	}
	
	public Rasse_to_AbilityScore_Id(RasseSub rasu,AbilityScores absc ) {
		this.rtas_rasu_id= rasu.getRasu_id();
		this.rtas_absc_id= absc.getAbsc_id();
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Rasse_to_AbilityScore_Id ) {
			Rasse_to_AbilityScore_Id rtas = (Rasse_to_AbilityScore_Id) obj;
			return (rtas_absc_id == rtas.getRtas_absc_id())&&
					(rtas_rasu_id == rtas.getRtas_rasu_id());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		long l = rtas_rasu_id * 100000 + rtas_absc_id;
		while (l>Integer.MAX_VALUE) {
			l=l/2;
		}
		return (int)l ;
	}
	
}
