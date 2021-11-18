package gestion_personne;
import java.util.Scanner;
import gestion_prod.* ;
public class Main {
	public static Scanner clavier=new Scanner(System.in) ;

	public static void main(String[] args) {
		TablePersonne tabPers =new TablePersonne() ;
		
		
		
		boolean quit = false;
         
		 do { /***********Menu*****************/
			
                       System.out.println("******Menu******");
			System.out.println("Veuillez choisir Ã  partir du menu");
			System.out.println("a . Ajouter une personne");
			System.out.println("b . Ajouter un fourisseur");
			System.out.println("c . Ajouter Employe");
			System.out.println("e . Quitter");
			
                String val=clavier.nextLine();
                char x=val.charAt(0);
		
      switch (x) {
		 case 'a':
		
			System.out.println("Tapez D pour Client");
			System.out.println("Tapez V pour Vendeur");
			System.out.println("Tapez E pour Employee");
			Scanner s1 = new Scanner(System.in);
			String choix=s1.nextLine();
			char c=choix.charAt(0);
					if (c=='D')
					{
						System.out.println("Vous avez choisi d'ajouter un client");
						 System.out.println("Veuillez saisir le identifiant du client");
					    int num=s1.nextInt();
					   System.out.println("Veuillez saisir le numero de CIN");
					   int cin=s1.nextInt();
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
										
				       tabPers.addPersonne(new Client(cin,nom,prenom,age,mail,adresse,num_telph,num)); ;
				     
					   tabPers.afficher();
										
				  		System.out.println("Client inseré .");
										
					}
					if (c=='E')
					{
						System.out.println("Vous avez choisi d'ajouter un employe");
						 System.out.println("Veuillez saisir le identifiant de l'employe");
					    int num=s1.nextInt();
					   System.out.println("Veuillez saisir le numero de CIN");
					   int cin=s1.nextInt();
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
										
				       tabPers.addPersonne(new Employe(cin,nom,prenom,age,mail,adresse,num_telph,num)); ;
				     
					   tabPers.afficher();
										
				  		System.out.println("Client inseré .");
										
					}
		 case 'b' :
			 
			
			 

		 case 'e':
				
				System.exit('e');
				break;
			
			default: System.out.println("Choix invalide");
				break;}
      } while (!quit);
	       System.out.println("Vous avez choisi de quitter") ;
}
}

	       


