package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    private Threads task;



    @FXML
    private void logIn(ActionEvent event) throws Exception{
        try {
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){
            lblStatus.setText("Login successful");
            FXMLLoader loader = new FXMLLoader();
            Parent loginPageParent = loader.load(getClass().getResource("secondPage.fxml"));

//            task = new Threads(7);
  //          task.setOnSucceeded(this::threadDone);
    //        trådLogin();
      //      logIn.setDisable(true);

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

    private void threadDone(WorkerStateEvent e){
        Integer result = task.getValue();
        lblStatus.setText("Login successful");
        logIn.setDisable(false);
    }

    private void threadFailed(WorkerStateEvent e){
        lblStatus.setText("Login failed");
        logIn.setDisable(false);
    }

    @FXML
    void backToMainPage(ActionEvent event) {
        try {
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