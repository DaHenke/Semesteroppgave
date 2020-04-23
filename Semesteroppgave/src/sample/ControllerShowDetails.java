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

public class ControllerShowDetails implements Initializable {

    static DetailsRegister newDetails = new DetailsRegister();

    @FXML
    public static TableView<Part> tblParts;

    @FXML
    private TableColumn<Part, String> tblDetails;

    public void initialize(URL url, ResourceBundle resourceBundle){

        System.out.println(newDetails.array);
        try {
            newDetails.array = DetailsRegister.loadData();
            System.out.println(newDetails.array);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*tblDetails.setCellFactory(TextFieldTableCell.forTableColumn());
        try {
            ObservableList<Part> details = DetailsRegister.loadData();
            System.out.println(details.toString());
            newDetails.array = details;
            //tblParts.setItems(newDetails.getArray());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        newDetails.attachTableView(tblParts);

    }
}
