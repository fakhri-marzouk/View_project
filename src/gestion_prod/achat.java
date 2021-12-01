package gestion_prod;

import java.util.Date;

public class achat extends produit {
private int fournisseur ;

public achat (int id,String nom ,float prix , Date dateExp,int fournisseur ,int quantite)
{
	super(id,nom,prix,dateExp,quantite);
	this.fournisseur=fournisseur;
}
public int getFournisseur() {
	return fournisseur;
}

public void setFournisseur(int fournisseur) {
	this.fournisseur = fournisseur;
}
@Override
public String toString() {
	return super.toString()+ "fournisseur=" + fournisseur ;
}

}
