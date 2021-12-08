package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class welcomeController  implements Initializable   {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    public void add()
    {
    	System.out.println("lollolol");
    }
	public void closeAction() {
    	System.exit(0);
    }
    public void minusAction() {
    	System.out.println("helloooo");
    }
    
    @FXML
    void getLogin(MouseEvent event) {
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
    void getClient(ActionEvent event) {
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

			System.out.println("heloooo");
        } catch (IOException e) {
            e.printStackTrace();
    }
 }
    @FXML
    void getAdmin(ActionEvent event) {
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

			System.out.println("heloooo");
        } catch (IOException e) {
            e.printStackTrace();
    }

    }
 }
  
	

