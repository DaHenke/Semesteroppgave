package Files;

import javafx.collections.ObservableList;
import sample.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class saveJobj {
    public static void saveJobj(ObservableList<Part> array, Path path) throws IOException {

        FileOutputStream output = new FileOutputStream(String.valueOf(path), true);
        ObjectOutputStream oos = new ObjectOutputStream(output);

        ArrayList<Part> newarray = new ArrayList<>(array);
        try {
            oos.writeObject(newarray);
        } finally {
            oos.close();
        }
    }
}
