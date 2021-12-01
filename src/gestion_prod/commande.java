package gestion_prod;
import gestion_personne.* ;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class commande {
	private int NumCommande;
	private Date dateCom;
	public Map<Client, ListProduits> CommandeClient;

	public commande(int NumCommande, Date dateCom) {
		this.NumCommande = NumCommande;
		this.dateCom = dateCom;
		CommandeClient = new TreeMap<>(Comparator.comparing(Client::getNom));

	}
	public commande() {
		CommandeClient = new TreeMap<>(Comparator.comparing(Client::getNom));

	}

	public int getNumCommande() {
		return NumCommande;
	}

	public void setNumCommande(int numCommande) {
		NumCommande = numCommande;
	}

	public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}

	public Map<Client, ListProduits> getCommandeClient() {
		return CommandeClient;
	}

	public void setCommandeClient(Map<Client, ListProduits> commandeClient) {
		CommandeClient = commandeClient;
	}

	public void ajouterClient(Client c) {

		CommandeClient.put(c,new ListProduits() ) ;
	}

	public void ajouterCommande(Client c, produit p) {
		if (!CommandeClient.containsKey(c)) {
			System.out.println("Client n'existe pas");
		} else {
			CommandeClient.get(c).ajouterProduit(p);
		}

	}
	////// STREAM////

	public void afficherCommande() {

		CommandeClient.entrySet().stream().forEach(e -> {
			System.out.println("****Client****");
			System.out.println(e.getKey());
			System.out.println("****Produits***");
			e.getValue().afficherProduits();
		});
	}

}