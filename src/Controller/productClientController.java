package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DB.DBConnection;
import application.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.product;

public class productClientController implements Initializable {

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
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tab_produits.setRowFactory(tv -> {
			TableRow<product> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Integer priceColumn =Integer.parseInt(row.getItem().getPrice());
					TextInputDialog dialog = new TextInputDialog("1");
					dialog.setTitle("Text Input Quantity");
					dialog.setHeaderText("Quantity ");
					dialog.setContentText("Please enter the desired quantity:");

					Optional<String> result = dialog.showAndWait();
					result.ifPresent(valueEntered -> {
						if(Integer.parseInt(row.getItem().getQuantity())<Integer.parseInt(valueEntered))  {
							Alert alert = new Alert(AlertType.WARNING,"Please verify the quantity!", javafx.scene.control.ButtonType.OK);
				    		alert.setTitle("Error!!");
				    		alert.setHeaderText(null);
				    		alert.showAndWait();
						}
						else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
			                alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
			                alert.setContentText("Order was added successfully !");
			                alert.showAndWait();
							 Store.setPriceTotal(Store.getPriceTotal()+(priceColumn*Integer.parseInt(valueEntered)));
							 
						}
					});

				}
			});
			return row;
		});
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

	    			System.out.println("heloooo");
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	        System.out.println("holaaaa");
	    	    }
	    }
	 
}


