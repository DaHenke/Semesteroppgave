package sample;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SearchFilter {
    public static void searchParts(PartRegister newPartRegister, TextField txtSearchField, ComboBox comboSearchColumn, TableView tblPCdel) {
        FilteredList<Part> filteredParts = new FilteredList<>(newPartRegister.array, b -> true);

        txtSearchField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredParts.setPredicate(part -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String smallLetter = newValue.toLowerCase();

                Object value = comboSearchColumn.getValue();
                if ("Type".equals(value)) {
                    return part.getType().toLowerCase().contains(smallLetter);
                } else if ("Part".equals(value)) {
                    return part.getDelNavn().toLowerCase().contains(smallLetter);
                } else if ("Price".equals(value)) {
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
}
