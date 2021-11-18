package gestion_personne;
import java.util.HashMap;
import java.util.Map;

public class TablePersonne {
	private Integer numPersonne ; 
	private Map<Integer,Personne> tablePersonne ;
	public TablePersonne() {
		tablePersonne=new HashMap<>() ;
		numPersonne =new Integer(0) ;
	}
	public void addPersonne(Personne p) {
		 tablePersonne.put(numPersonne ++,p) ;
	}
	public void afficher() {
		for(Personne p : tablePersonne.values()) {
			p.afficher();
		}
	}
	
	

}
