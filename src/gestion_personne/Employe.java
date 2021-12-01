package gestion_personne;

public class Employe extends Personne  {
	private int num_employe ;
	private float salaire ;

	public Employe(int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph,int num_employe,float salaire) throws personneException {
		super(cin, nom, prenom, age, mail, adresse, numero_telph);
		this.num_employe = num_employe;
		this.salaire=salaire ;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
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
		System.out.println("le identifiant de l'employe est : "+ this.num_employe);
		System.out.println("le salaire de l'employe est : "+ this.salaire );
		super.afficher();
	}

	

}
