package sample;

import calculator.Calculator;
import convert.fromSimpleString;
import convert.fromString;
import exceptions.InvalidSelectedRemoval;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import pcSaver.FileSaverPC;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    PartRegister newPartRegister = new PartRegister();
    PackageRegister newPackageRegister = new PackageRegister();
    DetailsRegister newNewDetails = new DetailsRegister();

    static int counter_CPU = 0;
    static int counter_GPU = 0;
    static int counter_RAM = 0;
    static int counter_HDD = 0;
    static int counter_KB = 0;
    static int counter_Mon = 0;
    static int counter_Mou = 0;
    static int counter_Cab = 0;
    double sum = 0;

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
        sum = 0;

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }

        lblSum.setText(String.valueOf(sum));
        checkConfiguration.checkAll();

        double price = Double.parseDouble(lblSum.getText());

        ArrayList<String> array = new ArrayList<>();
        for(Part p : newPartRegister.getArray()){
            System.out.println(p.getDelNavn());
            array.add(p.getDelNavn());
        }

        PC pc = new PC(array.get(0),array.get(1),array.get(2),array.get(3),array.get(4),array.get(5),array.get(6),array.get(7),array.get(8),array.get(9));

        Package newPackage = new Package(pc,price);
        newPackage.setPackagePrice(price);

        FileSaverPC.save();

        tblPCdel.setItems(newPartRegister.getArray());
        newPackageRegister.array = newPackageRegister.loadData(newPackageRegister.path);
        newPackageRegister.registrerPackage(pc,price);
        tblPackage.setItems(newPackageRegister.getArray());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kjøpt");
        alert.setHeaderText("Takk for handelen!");
        alert.setContentText("Produktet er kjøpt.");
        alert.showAndWait();


        clear();
    }

    public void clear(){
        comboCPU.getSelectionModel().clearSelection();
        comboGPU.getSelectionModel().clearSelection();
        comboHDDSSDPC.getSelectionModel().clearSelection();
        comboRAM.getSelectionModel().clearSelection();
        comboMonitor.getSelectionModel().clearSelection();
        comboMouse.getSelectionModel().clearSelection();
        comboKeyboard.getSelectionModel().clearSelection();
        comboCabinett.getSelectionModel().clearSelection();

        tblPCdel.getItems().clear();
        lblSum.setText("");

        counter_CPU=0;
        counter_GPU=0;
        counter_RAM=0;
        counter_HDD=0;
        counter_Mou=0;
        counter_Mon=0;
        counter_KB=0;
        counter_Cab=0;
    }

    @FXML
    void regCPU(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = comboCPU.getValue().Type;
        String CPUnavn = comboCPU.getValue().DelNavn;
        double CPUpris = comboCPU.getValue().DelPris;

        Part nyPart = new Part(type, CPUnavn, CPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(CPUnavn);
        nyPart.setDelPris(CPUpris);

        checkConfiguration.checkCPU(counter_CPU);
        counter_CPU++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;

        newPartRegister.registrerPCDel(type, CPUnavn, CPUpris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
        }

    @FXML
    void regGPU(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "GPU";
        String GPUnavn = comboGPU.getValue().DelNavn;
        double GPUpris = comboGPU.getValue().DelPris;

        Part nyPart = new Part(type, GPUnavn, GPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(GPUnavn);
        nyPart.setDelPris(GPUpris);

        checkConfiguration.checkGPU(counter_GPU);
        counter_GPU++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, GPUnavn, GPUpris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void regRAM(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "Memory";
        String RAMnavn = comboRAM.getValue().DelNavn;
        double RAMpris = comboRAM.getValue().DelPris;

        Part nyPart = new Part(type, RAMnavn, RAMpris);
        nyPart.setType(type);
        nyPart.setDelNavn(RAMnavn);
        nyPart.setDelPris(RAMpris);

        checkConfiguration.checkRAM(counter_RAM);
        counter_RAM++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, RAMnavn, RAMpris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void regHDD(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "HDD";
        String HDDnavn = comboHDDSSDPC.getValue().DelNavn;
        double HDDpris = comboHDDSSDPC.getValue().DelPris;

        Part nyPart = new Part(type, HDDnavn, HDDpris);
        nyPart.setType(type);
        nyPart.setDelNavn(HDDnavn);
        nyPart.setDelPris(HDDpris);

        checkConfiguration.checkHDD(counter_HDD);
        counter_HDD++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, HDDnavn, HDDpris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));

    }

    @FXML
    void regKeyboard(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "Keyboard";
        String keyboardNavn = comboKeyboard.getValue().DelNavn;
        double keyboardPris = comboKeyboard.getValue().DelPris;

        Part nyPart = new Part(type, keyboardNavn, keyboardPris);
        nyPart.setType(type);
        nyPart.setDelNavn(keyboardNavn);
        nyPart.setDelPris(keyboardPris);

        checkConfiguration.checkKeyboard(counter_KB);
        counter_KB++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, keyboardNavn, keyboardPris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void regMonitor(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "Monitor";
        String monitorNavn = comboMonitor.getValue().DelNavn;
        double monitorPris = comboMonitor.getValue().DelPris;

        Part nyPart = new Part(type, monitorNavn, monitorPris);
        nyPart.setType(type);
        nyPart.setDelNavn(monitorNavn);
        nyPart.setDelPris(monitorPris);

        checkConfiguration.checkMonitor(counter_Mon);
        counter_Mon++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, monitorNavn, monitorPris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void regMouse(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "Mouse";
        String mouseNavn = comboMouse.getValue().DelNavn;
        double mousePris = comboMouse.getValue().DelPris;

        Part nyPart = new Part(type, mouseNavn, mousePris);
        nyPart.setType(type);
        nyPart.setDelNavn(mouseNavn);
        nyPart.setDelPris(mousePris);

        checkConfiguration.checkMouse(counter_Mou);
        counter_Mou++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, mouseNavn, mousePris);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void regCabinett(ActionEvent event) {
        sum = 0;
        String type = "Cabinet";
        String cabinetName = comboCabinett.getValue().DelNavn;
        double cabinetPrice = comboCabinett.getValue().DelPris;

        Part nyPart = new Part(type, cabinetName, cabinetPrice);
        nyPart.setType(type);
        nyPart.setDelNavn(cabinetName);
        nyPart.setDelPris(cabinetPrice);

        checkConfiguration.checkCabinet(counter_Cab);
        counter_Cab++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newPartRegister.registrerPCDel(type, cabinetName, cabinetPrice);
        tblPCdel.setItems(newPartRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }


    @FXML
    void btnRemoveGPU(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();

        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.remove(type);
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void loadFile(ActionEvent event) throws IOException {
        sum = 0;

        newPartRegister = FileOpener.read();
        newPartRegister.attachTableView(tblPCdel);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void refreshPrice(ActionEvent event) {
        sum = 0;

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    public void saveDetails() throws IOException{
        ObservableList<Package> nylist = tblPackage.getSelectionModel().getSelectedItems();

        PC nyPc = new PC(null,null,null,null,null,null,null,null,null,null);

        for (Package pack: nylist) {
            nyPc=pack.getPackageName();
        }


        newNewDetails.addToPackage(new Part("CPU",nyPc.getCPU(),0.0));
        newNewDetails.addToPackage(new Part("GPU",nyPc.getGPU1(),0.0));
        newNewDetails.addToPackage(new Part("GPU",nyPc.getGPU2(),0.0));
        newNewDetails.addToPackage(new Part("Memory",nyPc.getRAM(),0.0));
        newNewDetails.addToPackage(new Part("HDD",nyPc.getHDD1(),0.0));
        newNewDetails.addToPackage(new Part("HDD",nyPc.getHDD2(),0.0));
        newNewDetails.addToPackage(new Part("Monitor",nyPc.getMONITOR(),0.0));
        newNewDetails.addToPackage(new Part("Mouse",nyPc.getMOUSE(),0.0));
        newNewDetails.addToPackage(new Part("Keyboard",nyPc.getKEYBOARD(),0.0));
        newNewDetails.addToPackage(new Part("Cabinet",nyPc.getCABINET(),0.0));

        newNewDetails.save(newNewDetails.array,DetailsRegister.path);
        newNewDetails.removeAll();
    }

    @FXML
    void showDetails(ActionEvent event) throws IOException {
        saveDetails();
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
        FilteredList<Part> filteredParts = new FilteredList<>(newPartRegister.array, b -> true);

        txtSearchField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredParts.setPredicate(part -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String smallLetter = newValue.toLowerCase();

                switch (comboSearchColumn.getValue()) {
                    case "Type":
                        return part.getType().toLowerCase().contains(smallLetter);
                    case "Part":
                        return part.getDelNavn().toLowerCase().contains(smallLetter);
                    case "Price":
                        return Double.toString(part.getDelPris()).toLowerCase().contains(smallLetter);
                }
                return false;
            });
            SortedList<Part> sortedParts = new SortedList<>(filteredParts);
            sortedParts.comparatorProperty().bind(tblPCdel.comparatorProperty());
            tblPCdel.setItems(sortedParts);
            if(txtSearchField.getText().isEmpty()){
                tblPCdel.setItems(newPartRegister.getArray());
            }
            
        });
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
