package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSecondPage implements Initializable {

    @FXML
    private ComboBox<String> comboType;

    @FXML
    void backToMainPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent loginPageParent = loader.load(getClass().getResource("mainPage.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);

            Stage loginWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

            loginWindow.setTitle("Welcome");
            loginWindow.setScene(loginPageScene);
            loginWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboType.getItems().addAll("CPU","GPU","Memory","HDD","Monitor","Mouse","Keyboard");
    }
}
