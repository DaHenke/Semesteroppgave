package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import trådprogrammering.Threads;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static trådprogrammering.tråder.*;

public class ControllerLogIn {


    @FXML
    private Button logIn;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;




    @FXML
    private void logIn(ActionEvent event) throws Exception{
        try {
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){


            Thread tr1 = new Thread(Threads::tr1);
            Threads tr2 = new Threads();

            tr1.start();
            tr2.tr2(lblStatus);
            tr1.join();


            FXMLLoader loader = new FXMLLoader();
            Parent loginPageParent = loader.load(getClass().getResource("secondPage.fxml"));

            Scene loginPageScene = new Scene(loginPageParent);

            Stage loginWindow = (Stage)((Node) event.getSource()).getScene().getWindow();

            loginWindow.setTitle("Log in as Admin");
            loginWindow.setScene(loginPageScene);
            loginWindow.show();
        }else{
            lblStatus.setText("Login failed");
        }

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    void backToMainPage(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            Parent loginPageParent = loader.load(getClass().getResource("mainPage.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);

            Stage loginWindow = (Stage)((Node) event.getSource()).getScene().getWindow();

            loginWindow.setTitle("Welcome");
            loginWindow.setScene(loginPageScene);
            loginWindow.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void register(ActionEvent event) {

    }


}