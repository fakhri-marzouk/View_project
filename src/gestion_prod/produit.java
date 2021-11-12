package gestion_prod;

import java.util.Date;

 

public class produit   {
	  private int id;
	  private float prix ;
	    private Type type;
	    private Date dateExp;
	    public produit (int id,float prix ,Type type, Date dateExp)
	    {
	    	this.id=id;
	    	this.prix=prix;
	    	this.type=type;
	    	this.dateExp=dateExp;
	    }
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		 
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix = prix;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public Date getDateExp() {
			return dateExp;
		}
		public void setDateExp(Date dateExp) {
			this.dateExp = dateExp;
		}
		@Override
		public String toString() {
			return "produit [id=" + id +  ",prix=" + prix + ", type="
					+ type + ", dateExp=" + dateExp + "]";
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
