package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerShowDetails implements Initializable {

    DetailsRegister newDetails = new DetailsRegister();

    @FXML
    private TableView<Package> tblParts;

    @FXML
    private TableColumn<?, ?> tblDetails;

    public void initialize(URL url, ResourceBundle resourceBundle){
        newDetails.attachTableView(tblParts);
    }

}
