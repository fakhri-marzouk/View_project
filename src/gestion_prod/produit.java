package gestion_prod;

import java.util.Date;

 

public class produit   {
	  private int id;
	  private String nom ;
	  private float prix ;
	    private Date dateExp;
	    private float quantiteStock ;
	    public produit (int id,String nom ,float prix ,Date dateExp,int quantiteStock)
	    {
	    	this.id=id;
	    	this.nom=nom ;
	    	this.prix=prix;
	    	this.dateExp=dateExp;
	    	this.quantiteStock=quantiteStock ;
	    }
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		 
		public float getQuantiteStock() {
			return quantiteStock;
		}
		public void setQuantiteStock(float quantiteStock) {
			this.quantiteStock = quantiteStock;
		}
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix = prix;
		}
		
		
		public Date getDateExp() {
			return dateExp;
		}
		public void setDateExp(Date dateExp) {
			this.dateExp = dateExp;
		}
		
		

		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		@Override
		public String toString() {
			return "produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", dateExp=" + dateExp + ", quantiteStock="
					+ quantiteStock + "]";
		}
		public boolean equals(produit p){
			if (p.getId()==this.id ){
			    System.out.println("il ont le meme ID");
			    return true;    
			}

			else { System.out.println("il n'ont pas le meme ID");
			return false;}
			}
		
 

	    
}
