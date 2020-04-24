package FileSaver;

import javafx.scene.shape.Path;
import sample.PackageRegister;
import sample.Part;

import java.io.IOException;

public interface FileSaver {
    void save(Part del, Path filepath) throws IOException;
}
