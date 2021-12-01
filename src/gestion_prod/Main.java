package gestion_prod;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import gestion_personne.* ;
public class Main {
	public static Scanner clavier=new Scanner(System.in) ;

	static commande comclt = new commande();
	public static void main(String[] args) throws personneException {
		TablePersonne tabPers =new TablePersonne() ;
		ListProduits listProd=new ListProduits() ;

		boolean quit = false;
         
		 do { /***********Menu*****************/
			
                       System.out.println("******Menu******");
			System.out.println("Veuillez choisir Ã  partir du menu");
			System.out.println("a . Ajouter une personne");
			System.out.println("b. chercher une personne");
			System.out.println("c. modifier une personne");
			System.out.println("d. supprimer une personne");
			System.out.println("e. afficher tous les personne");
			System.out.println("f. ajouter un produit ");
			System.out.println("i. afficher les produits ");
			System.out.println("j. ajouter des commande client ");
			System.out.println("k. afficher les commandes clients ");
			System.out.println("l. ajouter des commande fournisseur ");
			System.out.println("m. afficher les commandes fournisseur ");
			System.out.println("x . Quitter");
			
                String val=clavier.nextLine();
                char x=val.charAt(0);
		
      switch (x) {
		 case 'a':
		
			System.out.println("Tapez C pour ajouter un Client");
			System.out.println("Tapez E pour ajouter un Employee");
			System.out.println("Taper F pour ajouter un fourisseur");

			Scanner s1 = new Scanner(System.in);
			String choix=s1.nextLine();
			char c=choix.charAt(0);
					if (c=='C')
					{
					   System.out.println("Vous avez choisi d'ajouter un client");
					   System.out.println("Veuillez saisir le identifiant du client");
					   int num=s1.nextInt();
					   System.out.println("Veuillez saisir le numero de CIN");
					   int cin=s1.nextInt();
					   if(cin<0) throw new personneException(" cin negatif !") ;
				       System.out.println("Veuillez saisir le nom");
				       String nom=s1.next() ;
				       System.out.println("Veuillez saisir le prenom");
				       String prenom=s1.next() ;
				       System.out.println("Veuillez saisir l'age");
					   int age=s1.nextInt();
					   System.out.println("Veuillez saisir l'adresse mail");
				       String mail=s1.next();
				       System.out.println("Veuillez saisir l'adresse personnel");
				       String adresse=s1.next();
				       System.out.println("Veuillez saisir le numero de telephone");
				       int num_telph=s1.nextInt();
						try {			
				       tabPers.addPersonne(new Client(cin,nom,prenom,age,mail,adresse,num_telph,num)); ;
						}	
						catch(personneException e) {
							e.toString() ; 
		
						}
										
				  		System.out.println("Client inseré .");
										
					}
					if (c=='E')
					{
						System.out.println("Vous avez choisi d'ajouter un employe");
						 System.out.println("Veuillez saisir le identifiant de l'employe");
					    int num=s1.nextInt();
					   System.out.println("Veuillez saisir le numero de CIN");
					   int cin=s1.nextInt();
					   if(cin<0) throw new personneException(" cin negatif !") ;
				       System.out.println("Veuillez saisir le nom");
				       String nom=s1.next() ;
				       System.out.println("Veuillez saisir le prenom");
				       String prenom=s1.next() ;
				       System.out.println("Veuillez saisir l'age");
					   int age=s1.nextInt();
					   System.out.println("Veuillez saisir l'adresse mail");
				       String mail=s1.next();
				       System.out.println("Veuillez saisir l'adresse personnel");
				       String adresse=s1.next();
				       System.out.println("Veuillez saisir le numero de telephone");
				       int num_telph=s1.nextInt();
				       System.out.println("Veuillez saisir le salaire ");
				       float salaire=s1.nextFloat() ;
						try {				
				       tabPers.addPersonne(new Employe(cin,nom,prenom,age,mail,adresse,num_telph,num,salaire)); ;}
						catch(personneException e) {
							e.printStackTrace();
						}
										
				  		System.out.println("employé inseré .");
										
					}
					if (c=='F') {
						System.out.println("Vous avez choisi d'ajouter un fournisseur");
						 System.out.println("Veuillez saisir le identifiant de fournisseur");
					    int num=s1.nextInt();
					   System.out.println("Veuillez saisir le numero de CIN");
					   int cin=s1.nextInt();
					   if(cin<0) throw new personneException(" cin negatif !") ;
				       System.out.println("Veuillez saisir le nom");
				       String nom=s1.next() ;
				       System.out.println("Veuillez saisir le prenom");
				       String prenom=s1.next() ;
				       System.out.println("Veuillez saisir l'age");
					   int age=s1.nextInt();
					   System.out.println("Veuillez saisir l'adresse mail");
				       String mail=s1.next();
				       System.out.println("Veuillez saisir l'adresse personnel");
				       String adresse=s1.next();
				       System.out.println("Veuillez saisir le numero de telephone");
				       int num_telph=s1.nextInt();
						try {				
				       tabPers.addPersonne(new Fournisseur(cin,nom,prenom,age,mail,adresse,num_telph,num)); ;}
						catch (personneException e) {
							e.printStackTrace();
						}
				     
										
				  		System.out.println("fournisseur inseré .");
						
					}
					break;
		 case 'b':
			 
				System.out.println("Tapez C pour chercher un client ");
				System.out.println("Tapez E pour chercher un fournisseur");
				System.out.println("Taper F pour chercher un employe");

				Scanner s2 = new Scanner(System.in);
				String choix1=s2.nextLine();
				char c1=choix1.charAt(0);
						if (c1=='C')
						{
						 tabPers.chercherByCin();
											
						}
						if (c1=='E')
						{
							 tabPers.chercherByCin();

						}
						if (c1=='F') {
							 tabPers.chercherByCin();

							
						}			
				break;
			
		 case 'c':
			 tabPers.updateSalaire() ;
			 break ;

		 case 'v' :
			 
			 	/*produit p1=new produit(1,"f",5,new Date(),5);
			 	produit p2=new produit(2,"e",5,new Date(),5);
			 	ListProduits lp = new ListProduits() ;
			 	lp.ajouterProduit(p1) ;
			 	commande comclt = new commande(4,new Date()) ;
			 	Client clt =new Client(1,"f","f",4,"f","f",5,5) ;
			 	comclt.ajouterClient(clt) ;
			 	comclt.ajouterCommande(clt, p2);
			 	comclt.ajouterCommande(clt, p2);
			 	comclt.afficherCommande() ;*/
			 	
			 	break;
		 case 'd': 
			 //supprimer 
		 case 'e':
			 tabPers.afficher();
			 
			 break ;
			 
		 case 'f': {
			 
				Scanner s3 = new Scanner(System.in);
			 	System.out.println("donnez l'identifiant de produit");
			 	int id=s3.nextInt() ;
			 	System.out.println("donner le nom de produit") ;
			 	String nom =s3.next();
			 	System.out.println("donnez le prix de produit");
			 	float prix=s3.nextFloat();
			 	System.out.println("donner la date d'expiration");
			 	System.out.println("donner le jour ");
			 	int j =s3.nextInt() ;
			 	System.out.println("donner le mois ");
			 	int m =s3.nextInt();
			 	System.out.println("donner l'anneé ");
			 	int a =s3.nextInt() ;
			 	Date date=new Date(j-m-a);
			 	System.out.println("donner le stock disponible");
			 	int qt =s3.nextInt();
			 	listProd.ajouterProduit(new produit(id,nom,prix,date,qt));
			 	System.out.println("produit inseré !");
			 	break ;
			 
		 }
		 case 'i':{
			 
			 listProd.afficherProduits();
			 break ;
		 }
		 case 'j':{
			 Scanner s4 = new Scanner(System.in);
			 System.out.println("donner le numero de la commande : ");
			 int id =s4.nextInt();
			 commande comclt = new commande(id,new Date()) ;
			 System.out.println("donner l'id du produit voulu commandeé ");
			 int idprod =s4.nextInt();
			 Client clt =tabPers.chercherByCinReturn();
			 comclt.ajouterClient(clt) ;
			comclt.ajouterCommande(clt,listProd.rechercheProduitId(idprod));
			 System.out.println("commande insereé");
			 comclt.afficherCommande();
			 break ;
			 
		 }
		 case 'k':{
			 comclt.afficherCommande();
			 break ;
		 }
		 case 'l':{
			 Scanner s5 = new Scanner(System.in);
			 System.out.println("donner le numero de la commande : ");
			 int id =s5.nextInt();
			 commande comclt = new commande(id,new Date()) ;
			 System.out.println("donner l'id du produit voulu commandeé ");
			 int idprod =s5.nextInt();
		 }

		 case 'x':
				
				System.exit('e');
			    System.out.println("Vous avez choisi de quitter") ;
				break;
			
		default: System.out.println("Choix invalide");
				break;
		}
      } while (!quit);
	       System.out.println("Vous avez choisi de quitter") ;
}
}

	       


