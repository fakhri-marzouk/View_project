package gestion_personne;

public class Fournisseur extends Personne {
	private int num_fournisseur ;

	public Fournisseur(int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph,int num_fournisseur) {
		super(cin, nom, prenom, age, mail, adresse, numero_telph);
		this.num_fournisseur = num_fournisseur;
	}

	public int getNum_fournisseur() {
		return num_fournisseur;
	}

	public void setNum_fournisseur(int num_fournisseur) {
		this.num_fournisseur = num_fournisseur;
	}

	@Override
	public String toString() {
		return super.toString()+"le numero du fournisseur "+this.num_fournisseur;
	}
	
}