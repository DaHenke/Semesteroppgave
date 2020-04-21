package sample;

import calculator.Calculator;
import exceptions.InvalidSelectedRemoval;
import javafx.collections.ObservableList;
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
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    Register newRegister = new Register();
    static int counter_CPU = 0;
    static int counter_GPU = 0;
    static int counter_RAM = 0;
    static int counter_HDD = 0;
    static int counter_KB = 0;
    static int counter_Mon = 0;
    static int counter_Mou = 0;
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
    private ComboBox<String> comboCPU;

    @FXML
    private ComboBox<String> comboGPU;

    @FXML
    private ComboBox<String> comboRAM;

    @FXML
    private ComboBox<String> comboHDDSSDPC;

    @FXML
    private ComboBox<String> comboMonitor;

    @FXML
    private ComboBox<String> comboKeyboard;

    @FXML
    private ComboBox<String> comboMouse;

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
    void buyPC(ActionEvent event) {
        checkConfiguration.checkPurchase();
        checkConfiguration.checkComponents();
        checkConfiguration.checkAmountCPU();
        checkConfiguration.checkAmountGPU();
        checkConfiguration.checkAmountRAM();
        checkConfiguration.checkAmountHDD();
        checkConfiguration.checkAmountMon();
        checkConfiguration.checkAmountMou();
        checkConfiguration.checkAmountKB();
        FileSaverPC.save();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kjøpt");
        alert.setHeaderText("Takk for handelen!");
        alert.setContentText("Produktet er kjøpt.");
        alert.showAndWait();
    }

    @FXML
    void regCPU(ActionEvent event) throws InterruptedException {
        sum = 0;
        String type = "CPU";
        String CPUnavn = comboCPU.getValue();
        double CPUpris = Calculator.calculateCPU(CPUnavn);

        Part nyPart = new Part(type, CPUnavn, CPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(CPUnavn);
        nyPart.setDelPris(CPUpris);

        checkConfiguration.checkCPU(counter_CPU);
        counter_CPU++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;

        newRegister.registrerPCDel(type, CPUnavn, CPUpris);
        tblPCdel.setItems(newRegister.getArray());

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
        String GPUnavn = comboGPU.getValue();
        double GPUpris = Calculator.calculateGPU(GPUnavn);

        Part nyPart = new Part(type, GPUnavn, GPUpris);
        nyPart.setType(type);
        nyPart.setDelNavn(GPUnavn);
        nyPart.setDelPris(GPUpris);

        checkConfiguration.checkGPU(counter_GPU);
        counter_GPU++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, GPUnavn, GPUpris);
        tblPCdel.setItems(newRegister.getArray());

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
        String RAMnavn = comboRAM.getValue();
        double RAMpris = Calculator.calculateRAM(RAMnavn);

        Part nyPart = new Part(type, RAMnavn, RAMpris);
        nyPart.setType(type);
        nyPart.setDelNavn(RAMnavn);
        nyPart.setDelPris(RAMpris);

        checkConfiguration.checkRAM(counter_RAM);
        counter_RAM++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, RAMnavn, RAMpris);
        tblPCdel.setItems(newRegister.getArray());

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
        String HDDnavn = comboHDDSSDPC.getValue();
        double HDDpris = Calculator.calculateHDD(HDDnavn);

        Part nyPart = new Part(type, HDDnavn, HDDpris);
        nyPart.setType(type);
        nyPart.setDelNavn(HDDnavn);
        nyPart.setDelPris(HDDpris);

        checkConfiguration.checkHDD(counter_HDD);
        counter_HDD++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, HDDnavn, HDDpris);
        tblPCdel.setItems(newRegister.getArray());

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
        String keyboardNavn = comboKeyboard.getValue();
        double keyboardPris = Calculator.calculateKeyboard(keyboardNavn);

        Part nyPart = new Part(type, keyboardNavn, keyboardPris);
        nyPart.setType(type);
        nyPart.setDelNavn(keyboardNavn);
        nyPart.setDelPris(keyboardPris);

        checkConfiguration.checkKeyboard(counter_KB);
        counter_KB++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, keyboardNavn, keyboardPris);
        tblPCdel.setItems(newRegister.getArray());

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
        String monitorNavn = comboMonitor.getValue();
        double monitorPris = Calculator.calculateMonitor(monitorNavn);

        Part nyPart = new Part(type, monitorNavn, monitorPris);
        nyPart.setType(type);
        nyPart.setDelNavn(monitorNavn);
        nyPart.setDelPris(monitorPris);

        checkConfiguration.checkMonitor(counter_Mon);
        counter_Mon++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, monitorNavn, monitorPris);
        tblPCdel.setItems(newRegister.getArray());

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
        String mouseNavn = comboMouse.getValue();
        double mousePris = Calculator.calculateMouse(mouseNavn);

        Part nyPart = new Part(type, mouseNavn, mousePris);
        nyPart.setType(type);
        nyPart.setDelNavn(mouseNavn);
        nyPart.setDelPris(mousePris);

        checkConfiguration.checkMouse(counter_Mou);
        counter_Mou++;
        checkConfiguration.MAX_NO_OF_COMPONENTS++;
        newRegister.registrerPCDel(type, mouseNavn, mousePris);
        tblPCdel.setItems(newRegister.getArray());

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveCPU(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();

        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeCPU(type);

        allParts.removeAll(chosenPart);

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
        removeSelected.removeGPU(type,counter_GPU);
        counter_GPU--;
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveHDD(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeHDD(type,counter_HDD);

        counter_HDD--;
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveKB(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeKB(type,counter_KB);

        counter_KB--;
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));

    }

    @FXML
    void btnRemoveMon(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeMon(type,counter_Mon);

        counter_Mon--;
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveMou(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeMou(type,counter_Mou);

        counter_Mou--;
        allParts.removeAll(chosenPart);

        for(Part price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveRAM(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<Part> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeRAM(type,counter_RAM);

        counter_RAM--;
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

        newRegister = FileOpener.read();
        newRegister.attachTableView(tblPCdel);

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

    @FXML
    public void searchEvent(KeyEvent event) {
        FilteredList<Part> filteredParts = new FilteredList<>(newRegister.array, b -> true);

        txtSearchField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredParts.setPredicate(part -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String smallLetter = newValue.toLowerCase();

                if(comboSearchColumn.getValue().equals("Type")){
                    if(part.getType().toLowerCase().contains(smallLetter)){
                        return true;
                    }
                }else if(comboSearchColumn.getValue().equals("Part")){
                    if(part.getDelNavn().toLowerCase().contains(smallLetter)){
                        return true;
                    }
                }else if(comboSearchColumn.getValue().equals("Price")){
                    if(Double.toString(part.getDelPris()).toLowerCase().contains(smallLetter)){
                        return true;
                    }
                }
                return false;
            });
            SortedList<Part> sortedParts = new SortedList<>(filteredParts);
            sortedParts.comparatorProperty().bind(tblPCdel.comparatorProperty());
            tblPCdel.setItems(sortedParts);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        newRegister.attachTableView(tblPCdel);
        tblType.setCellFactory(TextFieldTableCell.forTableColumn());
        tblDel.setCellFactory(TextFieldTableCell.forTableColumn());
        tblPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        comboCPU.getItems().addAll("AMD Athlon 3000G",
                                    "Intel Pentium Gold G5600",
                                    "AMD Ryzen 3 3200G",
                                    "Intel Core i5-9600");

        comboGPU.getItems().addAll("ASUS GeForce GT710 1GB",
                                    "Gigabyte GeForce GT 1030 2GB Low Profile",
                                    "PNY Quadro P400 2GB DVI",
                                    "Gainward GeForce GTX 1650 SUPER Pegasus OC");

        comboRAM.getItems().addAll("HyperX Fury DDR3 1600MHz 4GB",
                                    "Crucial DDR4 2400MHz 8GB",
                                    "Kingston Value DDR4 3400MHz 16GB",
                                    "HyperX Fury DDR4 2666MHZ 32GB");

        comboHDDSSDPC.getItems().addAll("Seagate Barracuda 1TB",
                                    "Seagate Barracuda 3TB",
                                    "Seagate SkyHawk 6TB",
                                    "Seagate IronWolf 10TB");

        comboMonitor.getItems().addAll("Acer 24 skjerm KA242Y",
                                    "Samsung 24 skjerm S24E450F",
                                    "Acer 27 skjerm KA272",
                                    "Samsung 28 4K LED FreeSync U28E570D");

        comboMouse.getItems().addAll("Logitech M90 Mus",
                                    "Microsoft Mobile Mouse 3600",
                                    "Surface ARC mus",
                                    "Logitech MX Master3 Adv trådløs");

        comboKeyboard.getItems().addAll("Microsoft Wired Keyboard 600",
                                    "Logitech K400 Plus Trådløs Tastatur",
                                    "Kanex MultiSync Premium Slim Keyboard",
                                    "Logitech ERGO K860 Trådløs Tastatur");

        comboSearchColumn.getItems().addAll("Type","Part","Price");
    }
}
