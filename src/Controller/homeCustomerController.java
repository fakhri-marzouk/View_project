package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DB.DBConnection;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.customer;

public class homeCustomerController {

	 @FXML
	    private TableColumn<?, ?> Date_column;

	    @FXML
	    private TableColumn<?, ?> id_column;

	    @FXML
	    private TableColumn<?, ?> idc_column;

	    @FXML
	    private TableColumn<?, ?> price_column;

	    @FXML
	    private TableView<?> tab_commands;

	    @FXML
	    void getOrder(ActionEvent event) {
	    	try {
	    		Node node =(Node) event.getSource();
	    		Stage stage1=(Stage) node.getScene().getWindow();
	    		stage1.close();
	            Parent root1 = FXMLLoader.load(getClass().getResource("../view/order.fxml"));
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
	    void getProduct(ActionEvent event) {
	    	try {
	    		Node node =(Node) event.getSource();
	    		Stage stage1=(Stage) node.getScene().getWindow();
	    		stage1.close();
	            Parent root1 = FXMLLoader.load(getClass().getResource("../view/productClient.fxml"));
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
	    void getHomeClient(MouseEvent event) {
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
	    }
	    
	    @FXML
	    void getWelcome(MouseEvent event) {
	    	  try {
	    			Node node =(Node) event.getSource();
	    			Stage stage1=(Stage) node.getScene().getWindow();
	    			stage1.close();
	    	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/signup.fxml"));
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
	    void getAccount(MouseEvent event) {
	    	try {
	    		Node node =(Node) event.getSource();
	    		Stage stage1=(Stage) node.getScene().getWindow();
	    		stage1.close();
	            Parent root1 = FXMLLoader.load(getClass().getResource("../view/customer.fxml"));
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
	    void logOut(MouseEvent event) {
	    	 try {
	   			Node node =(Node) event.getSource();
	   			Stage stage1=(Stage) node.getScene().getWindow();
	   			stage1.close();
	   	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/signup.fxml"));
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
