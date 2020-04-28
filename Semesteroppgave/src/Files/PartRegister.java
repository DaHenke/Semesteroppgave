package Files;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sample.Part;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PartRegister {

    public static ObservableList<Part> array = FXCollections.observableArrayList();

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<Part> getArray(){
        return this.array;
    }

    public void registrerPCDel(String type, String delNavn, double delPris){
        Part enDel = new Part(type,delNavn,delPris);
        array.add(enDel);
    }

    @Override
    public String toString() {
        return String.valueOf(super.toString());
    }

        /*public void save() throws IOException {
            OutputStream fis = Files.newOutputStream(PartPath);
            ObjectOutputStream oos = new ObjectOutputStream(fis);

            ArrayList<Part> newarray = new ArrayList<>(array);
            oos.writeObject(newarray);
        }

        public ObservableList<Part> loadData() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(String.valueOf(PartPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Part> d = (ArrayList<Part>) ois.readObject();
            ObservableList<Part> o = FXCollections.observableArrayList(d);
            return o;
        }*/
}
