package Controller;

import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Provider;

public class providerController implements Initializable {
	
	public ArrayList<Provider> lp = new ArrayList<Provider>() ;
	
	File file = new File("listproviders.txt");
	
    public ObservableList<String> data = FXCollections.observableArrayList();

	ObjectOutputStream oos = null;
	
	ObjectInputStream ois = null;
	
	ListIterator<Provider> it ;

    @FXML
    private TextField IDP;

    @FXML
    private TextField NameP;

    @FXML
    private TextField PhoneP;

    @FXML
    private TextField Product;

    @FXML
    private TextField address;

    @FXML
    private TableColumn<?, ?> address_column;

    @FXML
    private TableColumn<?, ?> id_column;

    @FXML
    private TableColumn<?, ?> name_column;

    @FXML
    private TableColumn<?, ?> phone_column;

    @FXML
    private TableView<String> tab_provider;

    @FXML
    private TableColumn<?, ?> type_column;

    @FXML
    void DeleteProvider(ActionEvent event) {

    }

    @FXML
    void EditProvider(ActionEvent event) {

    }

    @FXML
    void addProvider(ActionEvent event) throws IOException {
    	boolean trouve =false;
    	String idp = IDP.getText();
    	it= lp.listIterator();
    	while(it.hasNext()) {
    		if(it.next().getId().equals(idp))
    			trouve = true;
    	}
    	if(trouve==true) {
    		Alert alert = new Alert(AlertType.WARNING,"idendified already exist", javafx.scene.control.ButtonType.OK);
    		alert.setTitle("Error!!");
    		alert.setHeaderText(null);
    		alert.showAndWait();}
    	
    	else {
    		if(!IDP.getText().equals("")) {
    		Provider p = new Provider(IDP.getText(),NameP.getText(),PhoneP.getText(),Product.getText(),address.getText());
        	lp.add(p) ;
        	
        	oos=new ObjectOutputStream(new FileOutputStream(file));
    		oos.writeObject(lp);
    		oos.close();
    		Alert alert = new Alert(AlertType.CONFIRMATION, "Provider was added successfully ",javafx.scene.control.ButtonType.OK);
    		alert.setTitle("Succes");
    		alert.setHeaderText(null);
    		alert.showAndWait();
    		data.clear();
        	lp.clear();}
    		else {
    			Alert alert = new Alert(AlertType.WARNING,"Please fill in the field!", javafx.scene.control.ButtonType.OK);
	    		alert.setTitle("Error!!");
	    		alert.setHeaderText(null);
	    		alert.showAndWait();
    		}
    	}
    	
    clean () ;
    }

    @FXML
    void closeAction(ActionEvent event) {

    }

    private void clean() {
        IDP.setText(null);
        NameP.setText(null);
        PhoneP.setText(null);
        address.setText(null);
        Product.setText(null);

        
    }
    
    @FXML
    void getHome(MouseEvent event) {
    	  try {
    			Node node =(Node) event.getSource();
    			Stage stage1=(Stage) node.getScene().getWindow();
    			stage1.close();
    	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/home.fxml"));
    	        Stage stage = new Stage();
    	        Scene scene = new Scene(root1,750,500);
    			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			stage.setScene(scene);
    			stage.show();
    	        stage.setResizable(false);

    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }

    @FXML
    void getItem(MouseEvent event) {

    }

    @FXML
    void minusAction(ActionEvent event) {

    }

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		if(file.isFile()) {
    		ois = new ObjectInputStream(new FileInputStream(file));
    		lp = (ArrayList<Provider>)ois.readObject();
    		System.out.println(lp.get(0));
    		ois.close();
    	}else {
    		System.out.print("Fichier introuvable!!");
    	}
		}
		catch(Exception e){
			e.getMessage();
		}
    	lp.stream().forEach(p->data.addAll(p.getId(),p.getAddress(),p.getName(),p.getProduct(),p.getTel()));
    	tab_provider.setItems(data);
		
	}

}
