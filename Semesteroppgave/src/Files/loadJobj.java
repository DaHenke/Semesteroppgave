package Files;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class loadJobj {
    public static ObservableList loadJobj(Path path) throws IOException, ClassNotFoundException {
        try {
            InputStream fis = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList d = (ArrayList) ois.readObject();
            ObservableList<Part> o = FXCollections.observableArrayList(d);


            return o;
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
