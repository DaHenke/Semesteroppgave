package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DetailsRegister {
    public static ObservableList<PC> array = FXCollections.observableArrayList();
    Path PartPath = Paths.get("Semesteroppgave\\src\\sample\\Package.txt");

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<PC> getArray(){
        return this.array;
    }

    public void save() throws IOException {
            OutputStream fis = Files.newOutputStream(PartPath);
            ObjectOutputStream oos = new ObjectOutputStream(fis);

            ArrayList<PC> newarray = new ArrayList<>(array);
            oos.writeObject(newarray);
        }

        public ObservableList<PC> loadData() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(String.valueOf(PartPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<PC> d = (ArrayList<PC>) ois.readObject();
            ObservableList<PC> o = FXCollections.observableArrayList(d);
            return o;
        }
}
