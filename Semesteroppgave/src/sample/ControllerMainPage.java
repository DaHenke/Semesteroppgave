package sample;

import exceptions.InvalidSelectedRemoval;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import pcSaver.CsvFiles;
import pcSaver.FileSaverPC;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    PartRegister newPartRegister = new PartRegister();
    PackageRegister newPackageRegister = new PackageRegister();
    DetailsRegister newNewDetails = new DetailsRegister();

    //mainPage.fxml
    @FXML
    public TableView<Part> tblPCdel;

    @FXML
    private TableColumn<Part, String> tblType;

    @FXML
    private TableColumn<Part, String> tblDel;

    @FXML
    private TableColumn<Part, Double> tblPris;

    @FXML
    private TableView<Package> tblPackage;

    @FXML
    private TableColumn<Package, String> tblPCPackage;

    @FXML
    private TableColumn<Package, Double> tblPricePackage;

    @FXML
    public ComboBox<Part> comboCPU;

    @FXML
    public ComboBox<Part> comboGPU;

    @FXML
    public ComboBox<Part> comboRAM;

    @FXML
    public ComboBox<Part> comboHDDSSDPC;

    @FXML
    public ComboBox<Part> comboMonitor;

    @FXML
    public ComboBox<Part> comboKeyboard;

    @FXML
    public ComboBox<Part> comboMouse;

    @FXML
    public ComboBox<Part> comboCabinett;

    @FXML
    private Label lblSum;

    @FXML
    private ComboBox<String> comboSearchColumn;

    @FXML
    private TextField txtSearchField;
    //end

    @FXML
    void openAdmin(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent loginPageParent = loader.load(getClass().getResource("logIn.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);

            Stage loginWindow = (Stage)((Node) event.getSource()).getScene().getWindow();

            loginWindow.setTitle("Log in as Admin");
            loginWindow.setScene(loginPageScene);
            loginWindow.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void buyPC(ActionEvent event) throws IOException, ClassNotFoundException {
        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
        checkConfiguration.checkAll();
        ButtonMethods.createPackage(lblSum,newPartRegister,tblPCdel,newPackageRegister,tblPackage);
        CsvFiles.save(newPackageRegister.array);
        checkConfiguration.clear(comboCPU,comboGPU,comboRAM,comboHDDSSDPC,comboMonitor,comboMouse,comboKeyboard,comboCabinett,
                            tblPCdel,lblSum);
    }

    @FXML
    void regCPU(ActionEvent event) throws InterruptedException {
        String type = "CPU";
        String CPUnavn = comboCPU.getValue().DelNavn;
        double CPUpris = comboCPU.getValue().DelPris;

        Part nyPart = new Part(type, CPUnavn, CPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(CPUnavn);
        nyPart.setDelPris(CPUpris);

        checkConfiguration.checkCPU();
        checkConfiguration.countMaxComponents();

        newPartRegister.registrerPCDel(type, CPUnavn, CPUpris);
        tblPCdel.setItems(newPartRegister.getArray());
        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
        }

    @FXML
    void regGPU(ActionEvent event) throws InterruptedException {
        String type = "GPU";
        String GPUnavn = comboGPU.getValue().DelNavn;
        double GPUpris = comboGPU.getValue().DelPris;

        Part nyPart = new Part(type, GPUnavn, GPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(GPUnavn);
        nyPart.setDelPris(GPUpris);

        checkConfiguration.checkGPU();
        //counter_GPU++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, GPUnavn, GPUpris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void regRAM(ActionEvent event) throws InterruptedException {
        String type = "Memory";
        String RAMnavn = comboRAM.getValue().DelNavn;
        double RAMpris = comboRAM.getValue().DelPris;

        Part nyPart = new Part(type, RAMnavn, RAMpris);
        nyPart.setType(type);
        nyPart.setDelNavn(RAMnavn);
        nyPart.setDelPris(RAMpris);

        checkConfiguration.checkRAM();
        //counter_RAM++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, RAMnavn, RAMpris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void regHDD(ActionEvent event) throws InterruptedException {
        String type = "HDD";
        String HDDnavn = comboHDDSSDPC.getValue().DelNavn;
        double HDDpris = comboHDDSSDPC.getValue().DelPris;

        Part nyPart = new Part(type, HDDnavn, HDDpris);
        nyPart.setType(type);
        nyPart.setDelNavn(HDDnavn);
        nyPart.setDelPris(HDDpris);

        checkConfiguration.checkHDD();
        //counter_HDD++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, HDDnavn, HDDpris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);

    }

    @FXML
    void regKeyboard(ActionEvent event) throws InterruptedException {
        String type = "Keyboard";
        String keyboardNavn = comboKeyboard.getValue().DelNavn;
        double keyboardPris = comboKeyboard.getValue().DelPris;

        Part nyPart = new Part(type, keyboardNavn, keyboardPris);
        nyPart.setType(type);
        nyPart.setDelNavn(keyboardNavn);
        nyPart.setDelPris(keyboardPris);

        checkConfiguration.checkKeyboard();
        //counter_KB++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, keyboardNavn, keyboardPris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void regMonitor(ActionEvent event) throws InterruptedException {
        String type = "Monitor";
        String monitorNavn = comboMonitor.getValue().DelNavn;
        double monitorPris = comboMonitor.getValue().DelPris;

        Part nyPart = new Part(type, monitorNavn, monitorPris);
        nyPart.setType(type);
        nyPart.setDelNavn(monitorNavn);
        nyPart.setDelPris(monitorPris);

        checkConfiguration.checkMonitor();
        //counter_Mon++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, monitorNavn, monitorPris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void regMouse(ActionEvent event) throws InterruptedException {
        String type = "Mouse";
        String mouseNavn = comboMouse.getValue().DelNavn;
        double mousePris = comboMouse.getValue().DelPris;

        Part nyPart = new Part(type, mouseNavn, mousePris);
        nyPart.setType(type);
        nyPart.setDelNavn(mouseNavn);
        nyPart.setDelPris(mousePris);

        checkConfiguration.checkMouse();
        //counter_Mou++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, mouseNavn, mousePris);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void regCabinett(ActionEvent event) {
        String type = "Cabinet";
        String cabinetName = comboCabinett.getValue().DelNavn;
        double cabinetPrice = comboCabinett.getValue().DelPris;

        Part nyPart = new Part(type, cabinetName, cabinetPrice);
        nyPart.setType(type);
        nyPart.setDelNavn(cabinetName);
        nyPart.setDelPris(cabinetPrice);

        checkConfiguration.checkCabinet();
        //counter_Cab++;
        checkConfiguration.countMaxComponents();
        newPartRegister.registrerPCDel(type, cabinetName, cabinetPrice);
        tblPCdel.setItems(newPartRegister.getArray());

        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }


    @FXML
    void btnRemoveGPU(ActionEvent event) throws InvalidSelectedRemoval {
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));
        removeSelected.remove(type);
        allParts.removeAll(chosenPart);
        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void loadFile(ActionEvent event) throws IOException { //TRENGER NOK IKKE DENNE
        newPartRegister = FileOpener.read();
        newPartRegister.attachTableView(tblPCdel);
        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void refreshPrice(ActionEvent event) {
        ButtonMethods.calculatePrice(tblPCdel,tblPris,lblSum);
    }

    @FXML
    void showDetails(ActionEvent event) throws IOException {
        ButtonMethods.saveDetails(tblPackage,newNewDetails);
        DetailsScene();
    }

    private void DetailsScene() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("showDetails.fxml"));

        Scene detailScene = new Scene(parent);
        Stage detailsStage = new Stage();
        detailsStage.setTitle("Details");
        detailsStage.setScene(detailScene);

        detailsStage.show();
    }

    @FXML
    public void searchEvent(KeyEvent event) {
        SearchFilter.searchParts(newPartRegister,txtSearchField,comboSearchColumn,tblPCdel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        newPartRegister.attachTableView(tblPCdel);
        newPackageRegister.attachTableView(tblPackage);
        tblType.setCellFactory(TextFieldTableCell.forTableColumn());
        tblDel.setCellFactory(TextFieldTableCell.forTableColumn());
        tblPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        newPackageRegister.runPackages(tblPackage);
        AddElementComboBox.addDefaultParts(comboCPU,comboGPU,comboRAM,comboHDDSSDPC,comboMonitor,comboMouse,comboKeyboard,comboCabinett,comboSearchColumn);
        AddElementComboBox.addNewParts(comboCPU,comboGPU,comboRAM,comboHDDSSDPC,comboMonitor,comboMouse,comboKeyboard,comboCabinett);
    }
}