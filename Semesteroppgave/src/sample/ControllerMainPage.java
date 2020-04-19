package sample;

import calculator.Calculator;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    Register newRegister = new Register();
    int counter_CPU = 0;
    int counter_GPU = 0;
    int counter_RAM = 0;
    int counter_HDD = 0;
    int counter_KB = 0;
    int counter_Mon = 0;
    int counter_Mou = 0;
    double sum = 0;

    //mainPage.fxml

    @FXML
    private TableView<PC> tblPCdel;

    @FXML
    private TableColumn<PC, String> tblType;

    @FXML
    private TableColumn<PC, String> tblDel;

    @FXML
    private TableColumn<PC, Double> tblPris;

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

        PC nyPC = new PC(type, CPUnavn, CPUpris);
        nyPC.setType(type);
        nyPC.setDelNavn(CPUnavn);
        nyPC.setDelPris(CPUpris);

        checkConfiguration.checkCPU(counter_CPU);
        counter_CPU++;

        newRegister.registrerPCDel(type, CPUnavn, CPUpris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, GPUnavn, GPUpris);
        nyPC.setType(type);
        nyPC.setDelNavn(GPUnavn);
        nyPC.setDelPris(GPUpris);

        checkConfiguration.checkGPU(counter_GPU);
        counter_GPU++;
        newRegister.registrerPCDel(type, GPUnavn, GPUpris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, RAMnavn, RAMpris);
        nyPC.setType(type);
        nyPC.setDelNavn(RAMnavn);
        nyPC.setDelPris(RAMpris);

        checkConfiguration.checkRAM(counter_RAM);
        counter_RAM++;
        newRegister.registrerPCDel(type, RAMnavn, RAMpris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, HDDnavn, HDDpris);
        nyPC.setType(type);
        nyPC.setDelNavn(HDDnavn);
        nyPC.setDelPris(HDDpris);

        checkConfiguration.checkHDD(counter_HDD);
        counter_HDD++;
        newRegister.registrerPCDel(type, HDDnavn, HDDpris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, keyboardNavn, keyboardPris);
        nyPC.setType(type);
        nyPC.setDelNavn(keyboardNavn);
        nyPC.setDelPris(keyboardPris);

        checkConfiguration.checkKeyboard(counter_KB);
        counter_KB++;
        newRegister.registrerPCDel(type, keyboardNavn, keyboardPris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, monitorNavn, monitorPris);
        nyPC.setType(type);
        nyPC.setDelNavn(monitorNavn);
        nyPC.setDelPris(monitorPris);

        checkConfiguration.checkMonitor(counter_Mon);
        counter_Mon++;
        newRegister.registrerPCDel(type, monitorNavn, monitorPris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
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

        PC nyPC = new PC(type, mouseNavn, mousePris);
        nyPC.setType(type);
        nyPC.setDelNavn(mouseNavn);
        nyPC.setDelPris(mousePris);

        checkConfiguration.checkMouse(counter_Mou);
        counter_Mou++;
        newRegister.registrerPCDel(type, mouseNavn, mousePris);
        tblPCdel.setItems(newRegister.getArray());

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveCPU(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();

        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeCPU(type,counter_CPU);

        counter_CPU--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveGPU(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();

        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeGPU(type,counter_GPU);
        counter_GPU--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveHDD(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeHDD(type,counter_HDD);

        counter_HDD--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveKB(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeKB(type,counter_KB);

        counter_KB--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));

    }

    @FXML
    void btnRemoveMon(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeMon(type,counter_Mon);

        counter_Mon--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveMou(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeMou(type,counter_Mou);

        counter_Mou--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void btnRemoveRAM(ActionEvent event) throws InvalidSelectedRemoval {
        sum=0;
        ObservableList<PC> chosenPart, allParts;
        allParts = tblPCdel.getItems();
        chosenPart = tblPCdel.getSelectionModel().getSelectedItems();
        String type = String.valueOf((tblPCdel.getSelectionModel().getSelectedItem().getType()));

        System.out.println(type);
        removeSelected.removeRAM(type,counter_RAM);

        counter_RAM--;
        allParts.removeAll(chosenPart);

        for(PC price : tblPCdel.getItems()){
            double pris = tblPris.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    @FXML
    void visCPU(MouseEvent event) {
        /*lblPrisCPU.setText(String.valueOf(Calculator.calculateCPU(comboCPU.getValue())));*/
    }

    @FXML
    void visGPU(MouseEvent event) {
        /*lblPrisGPU.setText(String.valueOf(Calculator.calculateGPU(comboGPU.getValue())));*/
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
    }

}
