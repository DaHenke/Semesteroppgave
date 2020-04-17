package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogIn implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;

    @FXML
    private ComboBox<String> comboType;

    @FXML
    void logIn(ActionEvent event) throws Exception{
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){
            lblStatus.setText("Login successful");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("secondPage.fxml"));
            primaryStage.setTitle("Welcome");
            primaryStage.setScene(new Scene(root, 1542, 786));

            primaryStage.show();
        }else{
            lblStatus.setText("Login failed");
        }
    }

    @FXML
    void register(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboType.getItems().addAll("test2","test1");
    }

}