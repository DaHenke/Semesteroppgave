package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerShowDetails {

    DetailsRegister newDetails = new DetailsRegister();

    @FXML
    public TableView<Part> tblParts;

    @FXML
    public void initialize(){
        newDetails.runDetails(tblParts);
        newDetails.attachTableView(tblParts);
    }
}
