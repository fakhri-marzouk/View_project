package gestion_personne;

 
	public class Personne {
		protected int cin ;
		protected String nom ;
		protected String prenom ;
		protected int age ;
		protected String mail ;
		protected String adresse ;
		protected int numero_telph ;
		
		public Personne(int cin, String nom, String prenom, int age, String mail, String adresse, int numero_telph) {
			this.cin = cin;
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.mail = mail;
			this.adresse = adresse;
			this.numero_telph = numero_telph;
		}
		
		@Override
		public String toString() {
			return "Personne [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", mail=" + mail
					+ ", adresse=" + adresse + ", numero_telph=" + numero_telph + "]";
		}

		public int getCin() {
			return cin;
		}
		public void setCin(int cin) {
			this.cin = cin;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public int getAge() {
			return age;
		}

}
