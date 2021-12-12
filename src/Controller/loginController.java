package Controller;
import DB.* ;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class loginController implements Initializable {
	
	
    	@FXML 
	  private TextField txtUsername ;
	  @FXML
	  private TextField txtPassword ;
	  @FXML 
	  private Button btnsignin ;
	  
	  @FXML
	   private Label lblErrors;
	  
	  
	  Connection con =null ;
		PreparedStatement preparedStatement =null ;
		ResultSet resultSet =null ;
		
	@FXML
	   void gethome(ActionEvent event) {
		  
	            if (logIn().equals("admin")) {
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
	            else {
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
	           
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 if (con == null) {
	            lblErrors.setTextFill(Color.TOMATO);
	            lblErrors.setText("Server Error : Check");
	        } else {
	            lblErrors.setTextFill(Color.GREEN);
	            lblErrors.setText("Server is up : Good to go");
	        }
		
	}

	 public  loginController() throws SQLException {
	        con = DBConnection.conDB();
	    }

	private String logIn() {
        String status = "";
		String email =this.txtUsername.getText().toString() ;
		String password =this.txtPassword.getText().toString() ;
		//query 
		 if(email.isEmpty() || password.isEmpty()) {
	            setLblError(Color.TOMATO, "Empty credentials");
	            status = "Error";
	        } else if(txtUsername.getText().equals("admin")) {
	            //query
	            String sql = "SELECT * FROM admin Where email = ? and password = ?";
	            try {
	                preparedStatement = con.prepareStatement(sql);
	                preparedStatement.setString(1, email);
	                preparedStatement.setString(2, password);
	                resultSet = preparedStatement.executeQuery();
	                if (!resultSet.next()) {
	                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
	                    status = "Error";
	                } else {
	                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
	                    status ="admin"	 ;               
	                    		}
	            } catch (SQLException ex) {
	                System.err.println(ex.getMessage());
	                status = "Exception";
	            }
	        }
	        else {
	        	 String sql = "SELECT * FROM admin Where email = ? and password = ?";
		            try {
		                preparedStatement = con.prepareStatement(sql);
		                preparedStatement.setString(1, email);
		                preparedStatement.setString(2, password);
		                resultSet = preparedStatement.executeQuery();
		                if (!resultSet.next()) {
		                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
		                    status = "Error";
		                } else {
		                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
		                    status ="user"	 ;               
		                    		}
		            } catch (SQLException ex) {
		                System.err.println(ex.getMessage());
		                status = "Exception";
		            }
	        	
	        }
	        
	        return status;
	    }
	    
	private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }
}
