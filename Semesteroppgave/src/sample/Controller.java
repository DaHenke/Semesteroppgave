package sample;

import calculator.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Register newRegister = new Register();

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;

    //mainPage.fxml

    @FXML
    private TableView<PC> tblPCdel;

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
    private Label lblPrisCPU;

    @FXML
    private Label lblPrisGPU;

    @FXML
    private Label lblPrisRAM;

    @FXML
    private Label lblPrisHDD;

    @FXML
    private Label lblPrisMonitor;

    @FXML
    private Label lblPrisMouse;

    @FXML
    private Label lblPrisKeyboard;

    @FXML
    private Label lblSum;
    //end

    @FXML
    void logIn(ActionEvent event) throws Exception{
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){
            lblStatus.setText("Login successful");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            primaryStage.setTitle("Welcome");
            primaryStage.setScene(new Scene(root, 722, 519));

            primaryStage.show();
        }else{
            lblStatus.setText("Login failed");
        }

    }

    @FXML
    void register(ActionEvent event) {

        if(!comboCPU.getValue().equals("CPU...") || !comboGPU.getValue().equals("GPU...") || !comboRAM.getValue().equals("RAM...") || !comboHDDSSDPC.getValue().equals("HDD/SSD...")) {
            double sum = Calculator.calculateDesktop(comboCPU.getValue(), comboGPU.getValue(), comboRAM.getValue(), comboHDDSSDPC.getValue()
                    , comboMouse.getValue(), comboKeyboard.getValue(), comboMonitor.getValue());

            lblSum.setText(String.valueOf(sum));
        }else if (comboCPU.getValue().equals("CPU...") || comboGPU.getValue().equals("GPU...") || comboRAM.getValue().equals("RAM...") || comboHDDSSDPC.getValue().equals("HDD/SSD...")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Du må velge en for alle hovedkomponentene");
            alert.showAndWait();
            throw new IllegalArgumentException("Tomme tekstfelter...");
        }

    }

    @FXML
    void regCPU(ActionEvent event) {
        String CPUnavn = comboCPU.getValue();
        double CPUpris = Calculator.calculateCPU(CPUnavn);

        PC nyPC = new PC(CPUnavn,CPUpris);
        nyPC.setDelNavn(CPUnavn);
        nyPC.setDelPris(CPUpris);

        newRegister.registrerPCDel(CPUnavn,CPUpris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regGPU(ActionEvent event) {
        String GPUnavn = comboGPU.getValue();
        double GPUpris = Calculator.calculateGPU(GPUnavn);

        PC nyPC = new PC(GPUnavn,GPUpris);
        nyPC.setDelNavn(GPUnavn);
        nyPC.setDelPris(GPUpris);

        newRegister.registrerPCDel(GPUnavn,GPUpris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regRAM(ActionEvent event) {
        String RAMnavn = comboRAM.getValue();
        double RAMpris = Calculator.calculateRAM(RAMnavn);

        PC nyPC = new PC(RAMnavn,RAMpris);
        nyPC.setDelNavn(RAMnavn);
        nyPC.setDelPris(RAMpris);

        newRegister.registrerPCDel(RAMnavn,RAMpris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regHDD(ActionEvent event) {
        String HDDnavn = comboHDDSSDPC.getValue();
        double HDDpris = Calculator.calculateHDD(HDDnavn);

        PC nyPC = new PC(HDDnavn,HDDpris);
        nyPC.setDelNavn(HDDnavn);
        nyPC.setDelPris(HDDpris);

        newRegister.registrerPCDel(HDDnavn,HDDpris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regKeyboard(ActionEvent event) {
        String keyboardNavn = comboKeyboard.getValue();
        double keyboardPris = Calculator.calculateKeyboard(keyboardNavn);

        PC nyPC = new PC(keyboardNavn,keyboardPris);
        nyPC.setDelNavn(keyboardNavn);
        nyPC.setDelPris(keyboardPris);

        newRegister.registrerPCDel(keyboardNavn,keyboardPris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regMonitor(ActionEvent event) {
        String monitorNavn = comboMonitor.getValue();
        double monitorPris = Calculator.calculateMonitor(monitorNavn);

        PC nyPC = new PC(monitorNavn,monitorPris);
        nyPC.setDelNavn(monitorNavn);
        nyPC.setDelPris(monitorPris);

        newRegister.registrerPCDel(monitorNavn,monitorPris);
        tblPCdel.setItems(newRegister.getArray());
    }

    @FXML
    void regMouse(ActionEvent event) {
        String mouseNavn = comboMouse.getValue();
        double mousePris = Calculator.calculateMouse(mouseNavn);

        PC nyPC = new PC(mouseNavn,mousePris);
        nyPC.setDelNavn(mouseNavn);
        nyPC.setDelPris(mousePris);

        newRegister.registrerPCDel(mouseNavn,mousePris);
        tblPCdel.setItems(newRegister.getArray());
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
        tblDel.setCellFactory(TextFieldTableCell.forTableColumn());
        tblPris.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tblPCdel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


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
