package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class homeController  implements Initializable   {
	
	
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
    void getProduct(MouseEvent event) {
    	try {
    		Node node =(Node) event.getSource();
    		Stage stage1=(Stage) node.getScene().getWindow();
    		stage1.close();
            Parent root1 = FXMLLoader.load(getClass().getResource("../view/product.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root1,750,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
	        stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
      
    }}
    @FXML
    void getCustomer(MouseEvent event) {
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
    public void loginAction() {
    	
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
    void getUser(MouseEvent event) {
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
    void getOrder(MouseEvent event) {
    	 try {
 			Node node =(Node) event.getSource();
 			Stage stage1=(Stage) node.getScene().getWindow();
 			stage1.close();
 	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/orderAdmin.fxml"));
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
    void getProvider(MouseEvent event) {
    	 try {
  			Node node =(Node) event.getSource();
  			Stage stage1=(Stage) node.getScene().getWindow();
  			stage1.close();
  	        Parent root1 = FXMLLoader.load(getClass().getResource("../view/provider.fxml"));
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
	

