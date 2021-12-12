package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class signUpController {

    @FXML
    private PasswordField cpasswordField;

    @FXML
    private TextField email;

    @FXML
    private PasswordField passwordField;

    @FXML
    void addAccount(MouseEvent event) {
    	
    	boolean trouve = false ;
    	String m = email.getText();
    	if(m.equals("")) {trouve =true;}
    	if(trouve==true) {
    		Alert alert = new Alert(AlertType.WARNING,"Please fill the form !", javafx.scene.control.ButtonType.OK);
    		alert.setTitle("Error!!");
    		alert.setHeaderText(null);
    		alert.showAndWait();
    	}else {
    	
         
         try
         {
             String query="INSERT INTO admin (email,password) VALUES ('"+email.getText()+"','"+passwordField.getText()+"');";                              
        	 Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query);
             stmnt.executeUpdate(query);
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
                 alert.setContentText("account was created successfully!");
                 alert.showAndWait();
                 try {
         			Node node =(Node) event.getSource();
         			Stage stage1=(Stage) node.getScene().getWindow();
         			stage1.close();
         	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/homeClient.fxml"));
         	        Stage stage = new Stage();
         	        Scene scene = new Scene(root1,750,500);
         			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         			stage.setScene(scene);
         			stage.show();
         	        stage.setResizable(false);

         	    } catch (IOException e) {
         	        e.printStackTrace();
         	    }
                 
         } catch (SQLException ex) {
             System.out.println("Erreur d'ajout !");
         }
    	}
    }

    @FXML
    void getLogin(MouseEvent event) {
    	try {
			Node node =(Node) event.getSource();
			Stage stage1=(Stage) node.getScene().getWindow();
			stage1.close();
	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/login2.fxml"));
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

}
