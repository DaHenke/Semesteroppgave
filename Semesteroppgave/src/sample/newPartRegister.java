package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class newPartRegister<T> {
    public ObservableList<T> array = FXCollections.observableArrayList();
    public static Path Path = Paths.get("Semesteroppgave\\src\\sample\\newParts");

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<T> getArray(){
        return this.array;
    }

    public void registrerPCDel(T enDel){
        array.add(enDel);
    }


    public void saveNewParts(ObservableList<T> array, Path path) throws IOException {
       OutputStream fis = Files.newOutputStream(path);
       FileOutputStream output = new FileOutputStream(String.valueOf(path), true);
       ObjectOutputStream oos = new ObjectOutputStream(output);

       ArrayList<T> newarray = new ArrayList<>(array);
       try{
           oos.writeObject(newarray);
       }finally {
           oos.close();
       }


    }

    public ObservableList loadNewParts(Path path) throws IOException, ClassNotFoundException {
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
    public void removeAll(){
        array.clear();
    }
}
