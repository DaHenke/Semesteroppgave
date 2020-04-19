package sample;

import calculator.Calculator;
import javafx.collections.ObservableList;
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
import sun.java2d.cmm.PCMM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSecondPage implements Initializable {

    newPartRegister newPart = new newPartRegister();

    @FXML
    private ComboBox<String> comboType;


    @FXML
    private TextField txtNyDelnavn;

    @FXML
    private TextField txtNyPris;

    @FXML
    private TableView<PC> tblNyDel;

    @FXML
    private TableColumn<PC, String> tblNyType;

    @FXML
    private TableColumn<PC, String> tblNyDelnavn;

    @FXML
    private TableColumn<PC, Double> tblNyPris;

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


    @FXML
    void leggTilDel(ActionEvent event) {
        String type = comboType.getValue();
        String CPUnavn = txtNyDelnavn.getText();
        double CPUpris = Double.parseDouble(txtNyPris.getText());

        PC nyPC = new PC(type, CPUnavn, CPUpris);
        nyPC.setType(type);
        nyPC.setDelNavn(CPUnavn);
        nyPC.setDelPris(CPUpris);
        System.out.println(type+" "+CPUnavn+" "+CPUpris);

        newPart.registrerPCDel(type, CPUnavn, CPUpris);
        tblNyDel.setItems(newPart.getArray());
    }

    @FXML
    void removeNewPart(ActionEvent event) {
        ObservableList<PC> newPartChosen, allNewPartsChosen;
        allNewPartsChosen = tblNyDel.getItems();
        newPartChosen =tblNyDel.getSelectionModel().getSelectedItems();
        allNewPartsChosen.removeAll(newPartChosen);
    }

    @FXML
    void saveFile(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newPart.attachTableView(tblNyDel);
        tblNyType.setCellFactory(TextFieldTableCell.forTableColumn());
        tblNyDelnavn.setCellFactory(TextFieldTableCell.forTableColumn());
        tblNyPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tblNyDel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        comboType.getItems().addAll("CPU","GPU","Memory","HDD","Monitor","Mouse","Keyboard");
    }
}
