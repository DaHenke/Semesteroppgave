package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.ControllerMainPage;

public class ControllerLogIn {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;

    @FXML
    void logIn(ActionEvent event) throws Exception{
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){
            lblStatus.setText("Login successful");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("secondPage.fxml"));
            primaryStage.setTitle("Welcome");
            primaryStage.setScene(new Scene(root, 722, 519));

            primaryStage.show();
        }else{
            lblStatus.setText("Login failed");
        }
    }

    @FXML
    void register(ActionEvent event) {

    }

}