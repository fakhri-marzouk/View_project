package Controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class userController {

    @FXML
    private TextField Uname;

    @FXML
    private PasswordField password;

    @FXML
    void closeAction(ActionEvent event) {

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

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void minusAction(ActionEvent event) {

    }

}