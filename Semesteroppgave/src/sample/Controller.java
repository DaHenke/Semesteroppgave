package sample;

import calculator.Calculator;
import computer.Desktop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblStatus;


    //mainPage.fxml

    @FXML
    private ComboBox<String> comboCPU;

    @FXML
    private ComboBox<String> comboGPU;

    @FXML
    private ComboBox<String> comboRAM;

    @FXML
    private ComboBox<String> comboHDDSSDPC;

    @FXML
    private ComboBox<String> comboHDDSSDLaptop;

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

        double sum = Calculator.calculateDesktop(comboCPU.getValue(),comboGPU.getValue(),comboRAM.getValue(),comboHDDSSDPC.getValue()
                ,comboMouse.getValue(),comboKeyboard.getValue(),comboMonitor.getValue());

        lblSum.setText(String.valueOf(sum));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
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

        comboHDDSSDLaptop.getItems().addAll("WD Mobile Black 1TB Harddisk",
                                    "Seagate Firecuda 2TB",
                                    "Seagate Barracuda 4TB");

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
