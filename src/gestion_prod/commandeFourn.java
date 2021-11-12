package gestion_prod;

import gestion_personne.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class commandeFourn {
	private int NumCommandeF;
	private Date dateComF;
	public Map<Fournisseur, ListAchats> CommandeFournisseur;

	public commandeFourn(int NumCommandeF, Date dateComF) {
		this.NumCommandeF = NumCommandeF;
		this.dateComF = dateComF;
		CommandeFournisseur = new TreeMap<>(Comparator.comparing(Fournisseur::getNom));
	}

	public int getNumCommandeF() {
		return NumCommandeF;
	}

	public void setNumCommandeF(int numCommande) {
		NumCommandeF = numCommande;
	}

	public Date getDateComF() {
		return dateComF;
	}

	public void setDateComF(Date dateComF) {
		this.dateComF = dateComF;
	}

	public Map<Fournisseur, ListAchats> getCommandeFournisseur() {
		return CommandeFournisseur;
	}

	public void setCommandeFournisseur(Map<Fournisseur, ListAchats> commandeFournisseur) {
		CommandeFournisseur = commandeFournisseur;
	}

	public void ajouterFournisseur(Fournisseur f) {

		CommandeFournisseur.putIfAbsent(f, new ListAchats());
	}

	public void ajouterProduit(Fournisseur f, achat a) {
		if (!CommandeFournisseur.containsKey(f)) {
			System.out.println("Fournisseur n'existe pas");
		} else {
			CommandeFournisseur.get(f).ajouterAchat(a);
		}

	}
	////// STREAM////

	public void afficherCommandeFournisseur() {

		CommandeFournisseur.entrySet().stream().forEach(e -> {

			System.out.println("****Client****");
			System.out.println(e.getKey());
			System.out.println("****Produits***");
			e.getValue().afficherAchats();
		});
	}

}