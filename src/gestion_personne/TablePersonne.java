package gestion_personne;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TablePersonne  {
	private Integer numPersonne ; 
	private Map<Integer,Personne> tablePersonne ;
	public TablePersonne() {
		tablePersonne=new HashMap<>() ;
		numPersonne =new Integer(0) ;
	}
	public void addPersonne (Personne p) throws personneException {
		 tablePersonne.putIfAbsent(numPersonne ++,p) ;
	}
	public void afficher() {
		for(Personne p : tablePersonne.values()) {
				p.afficher();
		}
	}
	public void chercherByCin(){
		boolean trouve=false ;
		System.out.println("donnez le numéro de carte d'identitée");
		Scanner clavier1=new Scanner(System.in) ;
        int id=clavier1.nextInt() ;
        for (Personne p :tablePersonne.values()) {
        	if(p.getCin()==id) {
        		System.out.println("Personne trouvé ");
        		trouve=true ;
        	}
        }
		if(trouve==false)
			System.out.println("personne n'est pas trouvé ");
	}
	public void updateSalaire() {
		boolean trouve=false ;
		System.out.println("donnez le numéro de cate d'identitée");
		Scanner clavier1=new Scanner(System.in) ;
		int cin =clavier1.nextInt() ;
		for (Personne p :tablePersonne.values()) {
			if(p.getCin()==cin) {
				System.out.println("donnez le numéro le nouveau salaire");
				Scanner clavier2=new Scanner(System.in) ;
				float salaire =clavier1.nextFloat() ;
				((Employe)p).setSalaire(salaire);
				System.out.println("salaire à été mis à jour");	
				trouve=true ;
			}
		}
		if(trouve==false)
		System.out.println("employé n'est pas trouvé !");
	}
	public Client chercherByCinReturn(){
		boolean trouve=false ;
		System.out.println("donnez le numéro de carte d'identitée");
		Scanner clavier1=new Scanner(System.in) ;
        int id=clavier1.nextInt() ;
        for (Personne p :tablePersonne.values()) {
        	if(p.getCin()==id) {
        		return (Client) p ;
        	}
        }
		return null;
        
	}
	public void supprimer(){
		
	}
}
