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
	public String toString() {
		return  super.toString()+"le numéro de l'employé "+this.num_employe;
	}
	
	
	
	
}