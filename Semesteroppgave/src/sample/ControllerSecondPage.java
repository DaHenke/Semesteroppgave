package sample;

import exceptions.InvalidPartTypeException;
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
    public TableView<Part> tblNyDel;

    @FXML
    private TableColumn<Part, String> tblNyType;

    @FXML
    private TableColumn<Part, String> tblNyDelnavn;

    @FXML
    private TableColumn<Part, Double> tblNyPris;

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

        Part nyPart = new Part(type, CPUnavn, CPUpris);

        if(!txtNyDelnavn.getText().isEmpty() && !txtNyPris.getText().isEmpty()) {
            try {
                nyPart.setType(type);
                nyPart.setDelNavn(CPUnavn);
                nyPart.setDelPris(CPUpris);

                newPart.registrerPCDel(type, CPUnavn, CPUpris);
                tblNyDel.setItems(newPart.getArray());
                comboType.setValue("Type");
                txtNyDelnavn.setText("");
                txtNyPris.setText("");
            }catch(InvalidPartTypeException e){
                System.out.println(e.getMessage());
            }
        }else if(txtNyDelnavn.getText() == "" || txtNyDelnavn.getText().isEmpty() ||
                txtNyPris.getText() == null || txtNyPris.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Du har tomme tekstfelt(er)...");
            alert.showAndWait();
            throw new IllegalArgumentException("Empty input fields");
        }
    }

    @FXML
    void removeNewPart(ActionEvent event) {
        ObservableList<Part> newPartChosen, allNewPartsChosen;
        allNewPartsChosen = tblNyDel.getItems();
        newPartChosen =tblNyDel.getSelectionModel().getSelectedItems();
        allNewPartsChosen.removeAll(newPartChosen);
    }

    @FXML
    void saveFile(ActionEvent event) {
        FileSaver.save();
    }

    @FXML
    void txtDataEditedDelPris(TableColumn.CellEditEvent<Part, Double> event) {
        Part part = tblNyDel.getSelectionModel().getSelectedItem();
        try{
            part.setDelPris(event.getNewValue());
        }catch (InvalidPartTypeException e){
            System.out.println("Not a valid price");
        }
        tblNyDel.refresh();
    }

    @FXML
    void txtDataEditedDelType(TableColumn.CellEditEvent<Part, String> event) {
        Part part = tblNyDel.getSelectionModel().getSelectedItem();
        try{
            part.setType(event.getNewValue());
        }catch (InvalidPartTypeException e){
            System.out.println("Not a valid part type");
        }
        tblNyDel.refresh();
    }

    @FXML
    void txtDataEditedDelnavn(TableColumn.CellEditEvent<Part, String> event) {
        Part part = tblNyDel.getSelectionModel().getSelectedItem();
        try{
            part.setDelNavn(event.getNewValue());
        }catch (InvalidPartTypeException e){
            System.out.println("Not a valid part name");
        }
        tblNyDel.refresh();
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
