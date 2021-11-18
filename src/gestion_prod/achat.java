package gestion_prod;

import java.util.Date;

public class achat extends produit {
private String fournisseur ;

public achat (int id,float prix ,Type type, Date dateExp,String fournisseur )
{
	super(id,prix,type,dateExp);
	this.fournisseur=fournisseur;
}
public String getFournisseur() {
	return fournisseur;
}

public void setFournisseur(String fournisseur) {
	this.fournisseur = fournisseur;
}
@Override
public String toString() {
	return super.toString()+ "fournisseur=" + fournisseur ;
}

}
