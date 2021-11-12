package gestion_personne;


public class Client extends Personne {
	private int numClient ;

	public Client(int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph, int numClient) {
		super(cin, nom, prenom, age, mail, adresse, numero_telph);
		this.numClient = numClient;
	}

	public int getNumClient() {
		return numClient;
	}


	public void setNum(int numClient) {
		this.numClient = numClient;
	}


	@Override
	public String toString( ) {
		return  super.toString()+"le numéro du client "+this.numClient;
	}
}