package pcSaver;

import exceptions.InvalidFileEndException;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import sample.FileStringWriter;
import sample.PCFormatter;
import sample.fileEnding;
import sample.Register;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaverPC {
    public static void save() throws InvalidFileEndException {
        FileChooser saveAs = new FileChooser();
        File saveFile = saveAs.showSaveDialog(null);

        String formatted = PCFormatter.formatParts(Register.array);
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
