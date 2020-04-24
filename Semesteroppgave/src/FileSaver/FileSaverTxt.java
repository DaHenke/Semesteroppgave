package FileSaver;

import javafx.scene.shape.Path;
import sample.PackageRegister;
import sample.Part;

import java.io.IOException;
import java.nio.file.Files;

public class FileSaverTxt implements FileSaver {
    @Override
    public void save(Part del, Path filepath) throws IOException {
        Files.write((java.nio.file.Path) filepath, del.toString().getBytes());

    }
}
