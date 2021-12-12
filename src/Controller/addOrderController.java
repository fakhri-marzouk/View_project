package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DB.DBConnection;
import application.Store;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.order;
import models.product;

public class addOrderController implements Initializable {

	  boolean trouve =false;
	  product p ;
	@FXML
    private TextField CIN;

    @FXML
    private TextField Nameproduct;

    @FXML
    private TextField Quantity;
    
    @FXML
    private TextField Address;

    
    @FXML
    private TableColumn<order,String> address_column;

    @FXML
    private TableColumn<order,String> cin_column;

    @FXML
    private TableColumn<order,String> name_column;

    @FXML
    private TableColumn<order,String> quantity_column;

    @FXML
    private TableView<order> tab_orders;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	  @FXML
	    void addOrder(MouseEvent event) {
		  
	    	String idp = CIN.getText();
	    	if(idp.equals("")) {trouve =true;}
	    	if(trouve==true) {
	    		Alert alert = new Alert(AlertType.WARNING,"Please fill the form !", javafx.scene.control.ButtonType.OK);
	    		alert.setTitle("Error!!");
	    		alert.setHeaderText(null);
	    		alert.showAndWait();}
	    	else {
	    	
	     String query="INSERT INTO `ORDER`(cin,name,phone,address,total_price,date_command)VALUES('"+CIN.getText()+"','"+Nameproduct.getText()+"','"+Quantity.getText()+"','"+Address.getText()+"','"+Store.getPriceTotal().toString()+"',CURRENT_TIMESTAMP);";                                               
	         try
	         {
	        	Connection con=DBConnection.conDB() ;
	 			PreparedStatement stmnt=con.prepareStatement(query);
	 		       System.out.println(stmnt);
	              stmnt.executeUpdate(query);
	             Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                 alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
	                 alert.setContentText("Order was added successfully! and the price is "+ Store.getPriceTotal());
	                 alert.showAndWait();
	                 edit_button();
	                 sendmail() ;
	                 clean() ;
	         } catch (SQLException ex) {
	        	 Alert alert = new Alert(AlertType.WARNING,"idendified already exist", javafx.scene.control.ButtonType.OK);
	     		alert.setTitle("Error!!");
	     		alert.setHeaderText(null);
	     		alert.showAndWait();}
             
	             System.out.println("Erreur d'ajout !");
	    	}
	         }
	        /* tab_orders.getItems().clear();
	 		cin_column.setCellValueFactory(new PropertyValueFactory<>("cin"));
	 		name_column.setCellValueFactory(new PropertyValueFactory<>("nameproduct"));
	 		quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	 		address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
	 		orderList.clear();
	 		String query2="SELECT * FROM ORDER ;" ;
	 		try {
	 			Connection con=DBConnection.conDB() ;
	 			PreparedStatement stmnt=con.prepareStatement(query2);
	 			ResultSet result=stmnt.executeQuery();
	 			while (result.next()) {
	 				orderList.add(new order(result.getString("cin"),result.getString("name"),result.getString("phone"),result.getString("Address")));

	 			}
	 			tab_orders.setItems(orderList);
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		*/
	    
	  
	  @FXML
	    private void clean() {
	        CIN.setText(null);
	        Nameproduct.setText(null);
	        Address.setText(null);
	        Quantity.setText(null);
	        
	    }
	 
	    void edit_button() {

	    	  try {
	    		  PreparedStatement stmnt  ;
	    		  Connection con = DBConnection.conDB() ;
	              String sql = "UPDATE PRODUCT SET quantity=? WHERE id =1 ; ";
	              stmnt= con.prepareStatement(sql);
	              stmnt.setString(1,"4");
	              
	              System.out.println(stmnt.toString());
	              stmnt.executeUpdate() ;
	          } catch (Exception e) {
	        	  Alert alert = new Alert(AlertType.WARNING ,"", javafx.scene.control.ButtonType.OK);
	              alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
	              alert.setContentText(e.getMessage());
	              alert.showAndWait();
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
	  
	  
	  public void sendmail()
	    {
	         try{
	            String host ="smtp.gmail.com" ;
	            String user = "fakhrimarzouki199@gmail.com";
	            String pass = "fpumqmrbaehdfuvi";
	            String to = "fakhrieddine.marzouk@enicar.ucar.tn";
	            String from = "fakhrimarzouki199@gmail.com";
	            String subject = "[New order was added] ";
	            String messageText = "New order was added go check ! "
	            					  + "have a nice day !"
	            					  + "Coridialy " ;
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");

	            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new java.util.Date());
	            msg.setText(messageText);

	             try (Transport transport = mailSession.getTransport("smtp")) {
	                 transport.connect(host, user, pass);
	                 transport.sendMessage(msg, msg.getAllRecipients());
	             }
	           System.out.println("message send successfully");
	        }catch(MessagingException ex)
	        {
	            System.out.println(ex);
	        }
	    }
	      


}

