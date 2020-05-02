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

import static java.lang.Integer.parseInt;

public class ControllerSecondPage implements Initializable {

    static newPartRegister newPart = new newPartRegister();



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
    void leggTilDel(ActionEvent event) throws IOException, ClassNotFoundException {
        if(txtNyDelnavn.getText() == "" || txtNyDelnavn.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Du har ikke lagt til navn på den nye delen");
            alert.showAndWait();
        }else if(txtNyPris.getText().isEmpty() || Double.parseDouble(txtNyPris.getText())<=0){
            try{
                double pris = Double.parseDouble(txtNyPris.getText());
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feil!");
                alert.setContentText("Prisen må være et tall større enn 0");
                alert.showAndWait();
            }
        }else if(comboType.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Du må velge en av komponenttypene.");
            alert.showAndWait();
        }else{
            Part nyDel = new Part(comboType.getValue(),txtNyDelnavn.getText(),Double.parseDouble(txtNyPris.getText()));
            newPart.array=newPart.loadNewParts(newPart.Path);
            newPart.attachTableView(tblNyDel);
            newPart.registrerPCDel(nyDel);
            saveFileny();
        }


        comboType.getSelectionModel().clearSelection();
        txtNyDelnavn.setText("");
        txtNyPris.setText("");
    }

    @FXML
    void removeNewPart(ActionEvent event) {
        ObservableList<Part> newPartChosen, allNewPartsChosen;
        allNewPartsChosen = tblNyDel.getItems();
        newPartChosen =tblNyDel.getSelectionModel().getSelectedItems();
        allNewPartsChosen.removeAll(newPartChosen);
    }

    void saveFileny() throws IOException {
        if(!newPart.array.isEmpty()) {
            newPart.saveNewParts(newPart.array, newPartRegister.Path);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Lagring vellykket!");
            alert.setHeaderText("Vellykket");
            alert.setContentText("Nye deler ligger inne i valgmenyene på hovedsiden");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lagring feilet!");
            alert.setHeaderText("Feil");
            alert.setContentText("Du har ikke lagt til nye deler");
            alert.showAndWait();
        }
    }

    @FXML
    void saveFile(ActionEvent event) throws IOException {
        if(!newPart.array.isEmpty()) {
            newPart.saveNewParts(newPart.array, newPartRegister.Path);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Lagring vellykket!");
            alert.setHeaderText("Vellykket");
            alert.setContentText("Nye deler ligger inne i valgmenyene på hovedsiden");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lagring feilet!");
            alert.setHeaderText("Feil");
            alert.setContentText("Du har ikke lagt til nye deler");
            alert.showAndWait();
        }
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
        newPart.runDetails(tblNyDel);
        comboType.getItems().addAll("CPU","GPU","Memory","HDD","Monitor","Mouse","Keyboard","Cabinet");
    }
}
