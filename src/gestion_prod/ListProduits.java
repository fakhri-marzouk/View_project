package gestion_prod;

import java.util.ArrayList;
import java.util.List;

 
public class ListProduits {
private List<produit> ListP;

public ListProduits(){
	ListP=new ArrayList<>();
	}

public List<produit> getListP() {
	return ListP;
}

public void setListP(List<produit> listP) {
	ListP = listP;
}
public void ajouterProduit(produit p){
	ListP.add(p);
	}
//////////STREAM////////
public boolean rechercherProduit (int id) {
 return ListP.stream().anyMatch(e-> e.getId()==id);
}

public void supprimerProduit(produit p)
{
	ListP.remove(p);
	}


public void afficherProduits() {
    ListP.forEach(e->System.out.println(e));
}

}
