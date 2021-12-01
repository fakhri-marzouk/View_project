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
		System.out.println("donnez le num�ro de carte d'identit�e");
		Scanner clavier1=new Scanner(System.in) ;
        int id=clavier1.nextInt() ;
        for (Personne p :tablePersonne.values()) {
        	if(p.getCin()==id) {
        		System.out.println("Personne trouv� ");
        		trouve=true ;
        	}
        }
		if(trouve==false)
			System.out.println("personne n'est pas trouv� ");
	}
	public void updateSalaire() {
		boolean trouve=false ;
		System.out.println("donnez le num�ro de cate d'identit�e");
		Scanner clavier1=new Scanner(System.in) ;
		int cin =clavier1.nextInt() ;
		for (Personne p :tablePersonne.values()) {
			if(p.getCin()==cin) {
				System.out.println("donnez le num�ro le nouveau salaire");
				Scanner clavier2=new Scanner(System.in) ;
				float salaire =clavier1.nextFloat() ;
				((Employe)p).setSalaire(salaire);
				System.out.println("salaire � �t� mis � jour");	
				trouve=true ;
			}
		}
		if(trouve==false)
		System.out.println("employ� n'est pas trouv� !");
	}
	public Client chercherByCinReturn(){
		boolean trouve=false ;
		System.out.println("donnez le num�ro de carte d'identit�e");
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
