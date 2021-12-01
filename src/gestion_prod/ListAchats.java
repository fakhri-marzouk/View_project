package gestion_prod;
import java.util.ArrayList;
import java.util.List;

import gestion_personne.*;
public class ListAchats    {
	private List<achat> ListA;

	public ListAchats(){
		ListA=new ArrayList<>();
		}

	public List<achat> getListA() {
		return ListA;
	}

	public void setListP(List<achat> listA) {
		ListA = listA;
	}
	public void ajouterAchat(achat A){
		ListA.add(A);
		}
	//////////STREAM////////
	public boolean rechercherAchat (int id) {
	 return ListA.stream().anyMatch(e-> e.getId()==id);
	}

	public void supprimerAchat(achat a)
	{
		ListA.remove(a);
		}


	public void afficherAchats() {
	    ListA.forEach(e->System.out.println(e));
	}

	}