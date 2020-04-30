package sample;

import java.io.IOException;
import java.nio.file.Path;

import exceptions.InvalidFileEndException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Paths;

public class FileSaver {
    public static void save(ObservableList<Part> array,Path path) throws InvalidFileEndException {
        FileChooser saveAs = new FileChooser();
        File saveFile = saveAs.showSaveDialog(null);

        String formatted = PCFormatter.formatParts(array);
        try{
            Path filePath = Paths.get(saveFile.getAbsolutePath());
            fileEnding.file(filePath.toString());
            FileStringWriter.writeString(filePath,formatted);
        } catch (InvalidFileEndException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Noe gikk galt: "+e.getMessage());
            alert.showAndWait();
            System.out.println("Noe gikk galt: "+e.getMessage());
        }
    }
}
