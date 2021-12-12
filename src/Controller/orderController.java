package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

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
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.order;

public class orderController implements Initializable {
		
	private static ObservableList<order> orderList=FXCollections.observableArrayList();
	
	 static int  num ;

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
    private TableColumn<order,String> phone_column;

    @FXML
    private TableColumn<order,String> price_column;

    @FXML
    private TableColumn<order,String> date_column;

    
    @FXML
    private TableView<order> tab_orders;
    

    @FXML
    void addOrder(MouseEvent event) {
     /*String query="INSERT INTO order (CIN ,Nameproduct ,Quantity,address) VALUES ('"+CIN.getText()+"','"+Nameproduct.getText()+"','"+Quantity.getText()+"','"+Address.getText()+"');";                              
         
         try
         {
        	 Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query);
             stmnt.executeUpdate(query);

             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
                 alert.setContentText("Order was added successfully! and the price is "+ Store.getPriceTotal());
                 alert.showAndWait();
         } catch (SQLException ex) {
             System.out.println("Erreur d'ajout !");
         }
         tab_orders.getItems().clear();
 		cin_column.setCellValueFactory(new PropertyValueFactory<>("CIN"));
 		name_column.setCellValueFactory(new PropertyValueFactory<>("Nameproduct"));
 		quantity_column.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
 		address_column.setCellValueFactory(new PropertyValueFactory<>("Address"));
 		orderList.clear();
 		String query2="SELECT * FROM ORDER ;" ;
 		try {
 			Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query2);
 			ResultSet result=stmnt.executeQuery();
 			while (result.next()) {
 				orderList.add(new order(result.getString("CIN"),result.getString("Nameproduct"),result.getString("Quantity"),result.getString("Address")));
 			}
 			tab_orders.setItems(orderList);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		clean() ;*/
 		
    }
    
    
    @FXML
    private void clean() {
        CIN.setText(null);
        Nameproduct.setText(null);
        Address.setText(null);
        Quantity.setText(null);
        
    }

    

    @FXML
    void getHomeAdmin(MouseEvent event) {
    	   
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cin_column.setCellValueFactory(new PropertyValueFactory<>("CIN"));
 		name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
 		phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
 		address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
 		price_column.setCellValueFactory(new PropertyValueFactory<>("total_price"));
 		date_column.setCellValueFactory(new PropertyValueFactory<>("date_command"));

 		orderList.clear();
 		String query2="SELECT * FROM `order` ;" ;
 		try {
 			Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query2);
 			ResultSet result=stmnt.executeQuery();
 			while (result.next()) {
 				orderList.add(new order(result.getString("cin"),result.getString("name"),result.getString("phone"),result.getString("Address"),result.getString("total_price"),result.getDate("date_command")));
 			}
 			tab_orders.setItems(orderList);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
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
	    private void fichePat(MouseEvent event) {
	        String snom = tab_orders.getSelectionModel().getSelectedItem().getCIN();
	        String sprenom = tab_orders.getSelectionModel().getSelectedItem().getName();
	        String sid = tab_orders.getSelectionModel().getSelectedItem().getPhone();
	        String sage = tab_orders.getSelectionModel().getSelectedItem().getAddress();
	        String stel = tab_orders.getSelectionModel().getSelectedItem().getTotal_price();
	        Date sadresse = tab_orders.getSelectionModel().getSelectedItem().getDate_command();
	        
	        Document document = new Document();
	        try{
	            PdfWriter.getInstance(document, new FileOutputStream(snom+".pdf"));
	            document.open();

	            Font f=new Font();
	            f.setColor(206, 106, 107);
	            
	            Font f2=new Font();
	            f2.setColor(0,0,0);
	            Paragraph p1 = new Paragraph("Order:  "+num++ ,f);
	            p1.setAlignment(Paragraph.ALIGN_CENTER);
	            Paragraph p0 = new Paragraph("     ");
	            Paragraph pe = new Paragraph("____________________________________________________________________________");     
	            Paragraph p2 = new Paragraph("\n\n    -  CIN : ");
	            p2.add("             "+snom);            
	            Paragraph p3 = new Paragraph("   -   Name client : ");
	            p3.add("        "+sprenom);
	            Paragraph p4 = new Paragraph("   -   Phone :   " +"            "+sid);
	            Paragraph p5 = new Paragraph("   -   Address :  "+"  "+sage);
	            Paragraph p6 = new Paragraph("   -   Total price  :  ");
	            p6.add("      "+stel);
	            Paragraph p7 = new Paragraph("   -   Date command  :  ");
	            p7.add("    "+sadresse) ;

		        document.add(p0);
	            document.add(p1);
	            document.add(pe);
	            document.add(p0);
	            document.add(p2);
	            document.add(p3);
	            document.add(p4);
	            document.add(p5);
	            document.add(p6);
	            document.add(p7);
	            document.add(p0);
	            document.add(pe);
	            document.add(p0);
	            
	                Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setHeaderText("INVENTORY MANGMENET STOCK");
	                alert.setContentText("Card  -  " + snom + " was added successfully  !");
	                alert.showAndWait();
	        }
	        catch(DocumentException | FileNotFoundException e){
	            System.out.println(e);
	        }
	        document.close();
	    }



}
