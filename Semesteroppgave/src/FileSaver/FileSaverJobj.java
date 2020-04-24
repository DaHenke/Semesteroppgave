package FileSaver;

import javafx.scene.shape.Path;
import sample.PackageRegister;
import sample.Part;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class FileSaverJobj implements FileSaver {
    @Override
    public void save(Part part, Path filepath) throws IOException {
        try(OutputStream os = Files.newOutputStream((java.nio.file.Path) filepath);
        ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.write(null);
        }
    }
}
