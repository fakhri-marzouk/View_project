package gestion_personne;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

 

public class SetClients {
 private  Set <Client> setC; 
 public SetClients ()
 {
	   setC= new HashSet <Client>();
 }
 
	 
 public Set<Client> getSetC() {
	return setC;
}

 public boolean rechercheClient(int cin) {
return  setC.stream()
        .anyMatch(e-> e.getCin()==cin);
  }

public void setSetC(Set<Client> setC) {
	this.setC = setC;
}


public void ajouterClient(Client clt) throws ClientException {
	    if (! setC.add(clt)) {
	      throw new ClientException("Client existe");
	    }  
	    }

public void afficherClient(){
    
    Iterator <Client> lt = setC.iterator();
    System.out.println("liste des clients:");
    while(lt.hasNext()){
        System.out.print(lt.next()+"    ");}
}

public TreeSet<Client> trierClient(){
    return setC.stream()
            .collect(Collectors.toCollection(TreeSet::new));
     
 }
 
    

}
