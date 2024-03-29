package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DetailsRegister<T> {
    public ObservableList<T> array = FXCollections.observableArrayList();
    static Path path = Paths.get("Semesteroppgave\\src\\sample\\Details");

    public void addToPackage(T part){
        array.add(part);
    }

    public void removeAll(){
        array.clear();
    }

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public void save(ObservableList<T> array, Path path) throws IOException {
            OutputStream fis = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fis);

            ArrayList<T> newarray = new ArrayList<>(array);
            oos.writeObject(newarray);
    }

        public ObservableList<T> loadData(Path path) throws IOException, ClassNotFoundException {
        try {
            InputStream fis = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<T> d = (ArrayList<T>) ois.readObject();
            ObservableList<T> o = FXCollections.observableArrayList(d);


            return o;
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
        }

        public void runDetails(TableView tv){
            try {
                array = loadData(path);
                tv.setItems(array);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


}
