package exceptions;

import javafx.scene.control.Alert;

public class InvalidFileEndException extends IllegalArgumentException {
    public InvalidFileEndException(String msg){
        super(msg);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Feil!");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
