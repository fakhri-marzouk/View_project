package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import models.product;
import DB.* ;

public class productController implements Initializable{
	
	private static ObservableList<product> productList=FXCollections.observableArrayList();

    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private TextField Price;

    @FXML
    private TextField Quantity;

    @FXML
    private TableColumn<product, String> id_column;

    @FXML
    private TableColumn<product, String> name_column;

    @FXML
    private TableColumn<product, String> price_column;

    @FXML
    private TableColumn<product, String> quantity_column;

    @FXML
    private TableView<product> tab_produits;

    @FXML
    void add_button(ActionEvent event) {
         String query="INSERT INTO PRODUCT (ID ,Price ,Name,Quantity) VALUES ('"+ID.getText()+"','"+Price.getText()+"','"+Name.getText()+"','"+Quantity.getText()+"');";                              
         
         try
         {
        	 Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query);
             stmnt.executeUpdate(query);
             System.out.println("Product was addes successfully  !");
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
                 alert.setContentText("Product was added successfully!");
                 alert.showAndWait();
         } catch (SQLException ex) {
             System.out.println("Erreur d'ajout !");
         }
         tab_produits.getItems().clear();
 		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
 		name_column.setCellValueFactory(new PropertyValueFactory<>("Name"));
 		price_column.setCellValueFactory(new PropertyValueFactory<>("Price"));
 		quantity_column.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
 		productList.clear();
 		String query2="SELECT * FROM PRODUCT ;" ;
 		try {
 			Connection con=DBConnection.conDB() ;
 			PreparedStatement stmnt=con.prepareStatement(query2);
 			ResultSet result=stmnt.executeQuery();
 			while (result.next()) {
 				productList.add(new product(result.getString("ID"),result.getString("Name"),result.getString("Price"),result.getString("Quantity")));
 			}
 			tab_produits.setItems(productList);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		clean() ;
 		
 	}


    @FXML
    void closeAction(ActionEvent event) {

    }

    @FXML
    void delete_button(ActionEvent event) {
    	PreparedStatement stmnt ;
    	String x = tab_produits.getSelectionModel().getSelectedItem().getId();
    	tab_produits.getItems().removeAll(tab_produits.getSelectionModel().getSelectedItem());
        String requete3="DELETE FROM PRODUCT WHERE id =?";
        try {
          stmnt = DBConnection.conDB().prepareStatement(requete3);
            stmnt.setString(1,x);
            
            stmnt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
            alert.setContentText("Product was deleted successfully!");
            alert.showAndWait();
            
            System.out.println("Produit supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void edit_button(ActionEvent event) {

    	  try {
    		  PreparedStatement stmnt  ;
    		  Connection con = DBConnection.conDB() ;
              String sql = "UPDATE PRODUCT SET id=? ,Price=? ,Name=?,Quantity=?  WHERE id =? ; ";
              stmnt= con.prepareStatement(sql);
              stmnt.setString(1, ID.getText());
              stmnt.setNString(2, Price.getText());
              stmnt.setString(3, Name.getText());
              stmnt.setString(4, Quantity.getText());
              stmnt.setString(5, ID.getText());
              System.out.println(stmnt.toString());
              stmnt.executeUpdate() ;
              UpdateTable() ;
              clean() ;
              JOptionPane.showMessageDialog(null, "Update");
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
          }
    }
    public void UpdateTable(){
       
        
        
    tab_produits.getItems().clear();
	id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
	name_column.setCellValueFactory(new PropertyValueFactory<>("Name"));
	price_column.setCellValueFactory(new PropertyValueFactory<>("Price"));
	quantity_column.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
	productList.clear();
	String query2="SELECT * FROM PRODUCT ;" ;
	try {
		Connection con=DBConnection.conDB() ;
		PreparedStatement stmnt=con.prepareStatement(query2);
		ResultSet result=stmnt.executeQuery();
		while (result.next()) {
			productList.add(new product(result.getString("ID"),result.getString("Name"),result.getString("Price"),result.getString("Quantity")));
		}
		tab_produits.setItems(productList);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
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

    			System.out.println("heloooo");
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        System.out.println("holaaaa");
    	    }
   }


    @FXML
    void minusAction(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		name_column.setCellValueFactory(new PropertyValueFactory<>("Name"));
		price_column.setCellValueFactory(new PropertyValueFactory<>("Price"));
		quantity_column.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
		productList.clear();
		String query="SELECT * FROM PRODUCT ;" ;
		try {
			Connection con=DBConnection.conDB() ;
			PreparedStatement stmnt=con.prepareStatement(query);
			ResultSet result=stmnt.executeQuery();
			while (result.next()) {
				productList.add(new product(result.getString("ID"),result.getString("Name"),result.getString("Price"),result.getString("Quantity")));
			}
			tab_produits.setItems(productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 @FXML
	    private void clean() {
	        ID.setText(null);
	        Price.setText(null);
	        Name.setText(null);
	        Quantity.setText(null);
	        
	    }
	 @FXML
	 public void getItem()
	   {
		 int index = tab_produits.getSelectionModel().getSelectedIndex();
		    ID.setText(id_column.getCellData(index).toString());
		    Price.setText(price_column.getCellData(index).toString());
		    Name.setText(name_column.getCellData(index).toString());
		    Quantity.setText(quantity_column.getCellData(index).toString());

		    
	   }
	 @FXML
	    void getWelcome(MouseEvent event) {
	    	   
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
	    	        System.out.println("holaaaa");
	    	    }
	    }
}