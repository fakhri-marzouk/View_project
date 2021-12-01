package gestion_personne;

public class Client extends Personne {
	private int num ;

	public Client( int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph, int num) throws personneException {
		super(cin, nom, prenom, age, mail, adresse, numero_telph);
		this.num = num;
	}
	

	@Override
	public void afficher() {
		System.out.println("*********************");
		System.out.println("le identifiant du client est : "+ this.num);
		super.afficher();
	}

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


}
