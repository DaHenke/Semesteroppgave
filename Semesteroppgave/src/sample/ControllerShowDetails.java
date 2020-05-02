package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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
