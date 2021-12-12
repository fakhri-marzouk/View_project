package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.customer;
import models.product;

public class customerController implements Initializable {
	
	private static ObservableList<customer> customerList=FXCollections.observableArrayList();

    @FXML
    private TextField CIN;

    @FXML
    private TextField IDC;

    @FXML
    private TextField NameC;

    @FXML
    private TextField PhoneC;

    @FXML
    private TextField address;

    @FXML
    private TableColumn<customer,String> address_column;

    @FXML
    private TableColumn<customer,String> cin_column;

    @FXML
    private TableColumn<customer,String> id_column;

    @FXML
    private TableColumn<customer,String> name_column;

    @FXML
    private TableColumn<customer,String> phone_column;
    
    @FXML
    private TableView<customer> tab_customer;

    @FXML
    void DeleteCustomer(ActionEvent event) {
    	PreparedStatement stmnt ;
    	String x = tab_customer.getSelectionModel().getSelectedItem().getId();
    	tab_customer.getItems().removeAll(tab_customer.getSelectionModel().getSelectedItem());
        String requete3="DELETE FROM customer WHERE id_customer =?";
        try {
          stmnt = DBConnection.conDB().prepareStatement(requete3);
            stmnt.setString(1,x);
            
            stmnt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
            alert.setContentText("Customer was deleted successfully!");
            alert.showAndWait();
                    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
  
    @FXML
    void EditCustomer(ActionEvent event) {
    	try {
  		  PreparedStatement stmnt  ;
  		  Connection con = DBConnection.conDB() ;
            String sql = "UPDATE customer SET id_customer=? ,cin=? ,phone=?,name=?,address=?  WHERE id_customer =? ; ";
            stmnt= con.prepareStatement(sql);
            stmnt.setString(1, IDC.getText());
            stmnt.setNString(2, CIN.getText());
            stmnt.setString(3, PhoneC.getText());
            stmnt.setString(4, NameC.getText());
            stmnt.setString(5, address.getText());
            stmnt.setString(6, IDC.getText());
            stmnt.executeUpdate() ;
            UpdateTable() ;
            clean() ;
            Alert alert = new Alert(AlertType.INFORMATION,"", javafx.scene.control.ButtonType.OK);
            alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
            alert.setContentText("Customer was edited successfully!");
            alert.showAndWait();
        } catch (Exception e) {
        	 Alert alert = new Alert(AlertType.WARNING,"", javafx.scene.control.ButtonType.OK);
             alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
        }
  }

    public void UpdateTable(){
    	id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		cin_column.setCellValueFactory(new PropertyValueFactory<>("cin"));
		phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
		name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
		address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
		customerList.clear();

		String query2="SELECT * FROM customer ;" ;

		try {
			Connection con=DBConnection.conDB() ;
			PreparedStatement stmnt=con.prepareStatement(query2);
			ResultSet result=stmnt.executeQuery();
			while (result.next()) {
				customerList.add(new customer(result.getString("id_customer"),result.getString("cin"),result.getString("name"),result.getString("phone"),result.getString("address")));
				System.out.println(result.getString("id_customer"));
			}
			tab_customer.setItems(customerList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }


    @FXML
    void addCustomet(ActionEvent event) {
    	boolean trouve = false ;
    	String idp = CIN.getText();
    	if(idp.equals("")) {trouve =true;}
    	if(trouve==true) {
    		Alert alert = new Alert(AlertType.WARNING,"Please fill the form !", javafx.scene.control.ButtonType.OK);
    		alert.setTitle("Error!!");
    		alert.setHeaderText(null);
    		alert.showAndWait();
    		}
    	else {
        
        try
        {
        	String query="INSERT INTO CUSTOMER (id_customer ,cin ,phone,name,address) VALUES ('"+IDC.getText()+"','"+CIN.getText()+"','"+PhoneC.getText()+"','"+NameC.getText()+"','"+address.getText()+"');";                              

       	 Connection con=DBConnection.conDB() ;
			PreparedStatement stmnt=con.prepareStatement(query);
            stmnt.executeUpdate(query);
            System.out.println("Customer was addes successfully  !");
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("INVENTORY MANGEMENT SYSTEM");
                alert.setContentText("Customer was added successfully !");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout !");
        }
        tab_customer.getItems().clear();
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		cin_column.setCellValueFactory(new PropertyValueFactory<>("cin"));
		phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
		name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
		address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		customerList.clear();
		String query2="SELECT * FROM CUSTOMER  ;" ;
		try {
			Connection con=DBConnection.conDB() ;
			PreparedStatement stmnt=con.prepareStatement(query2);
			ResultSet result=stmnt.executeQuery();
			while (result.next()) {
				customerList.add(new customer(result.getString("id_customer"),result.getString("CIN"),result.getString("Name"),result.getString("Phone"),result.getString("address")));
			}
			tab_customer.setItems(customerList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clean() ;
    	}
    }

    @FXML
    void closeAction(ActionEvent event) {

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
    void minusAction(ActionEvent event) {

    }
    
    private void clean() {
        IDC.setText(null);
        NameC.setText(null);
        PhoneC.setText(null);
        address.setText(null);
        CIN.setText(null);

        
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
			cin_column.setCellValueFactory(new PropertyValueFactory<>("cin"));
			phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
			name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
			address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
			customerList.clear();

			String query2="SELECT * FROM customer ;" ;

			try {
				Connection con=DBConnection.conDB() ;
				PreparedStatement stmnt=con.prepareStatement(query2);
				ResultSet result=stmnt.executeQuery();
				while (result.next()) {
					customerList.add(new customer(result.getString("id_customer"),result.getString("cin"),result.getString("name"),result.getString("phone"),result.getString("address")));
					System.out.println(result.getString("id_customer"));
				}
				tab_customer.setItems(customerList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		
	}
	
	  @FXML
	    void getItem(MouseEvent event) {
		  int index = tab_customer.getSelectionModel().getSelectedIndex();
		    IDC.setText(id_column.getCellData(index).toString());
		    PhoneC.setText(phone_column.getCellData(index).toString());
		    NameC.setText(name_column.getCellData(index).toString());
		    address.setText(address_column.getCellData(index).toString());
		    CIN.setText(cin_column.getCellData(index).toString());

	    }
	  

}
