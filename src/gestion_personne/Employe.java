package gestion_personne;

public class Employe extends Personne  {
	private int num_employe ;

	public Employe(int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph,int num_employe) {
		super(cin, nom, prenom, age, mail, adresse, numero_telph);
		this.num_employe = num_employe;
	}

	public int getNum_employe() {
		return num_employe;
	}

	public void setNum_employe(int num_employe) {
		this.num_employe = num_employe ;
	}
	@Override
	public void afficher() {
		System.out.println("*********************");
		System.out.println("le identifiant du employe est : "+ this.num_employe);
		super.afficher();
	}

	

}
