package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class newPartRegister {
    public ObservableList<Part> array = FXCollections.observableArrayList();
    public static Path Path = Paths.get("Semesteroppgave\\src\\sample\\newParts");

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<Part> getArray(){
        return this.array;
    }

    public void registrerPCDel(Part enDel){
        array.add(enDel);
    }


    public void saveNewParts(ObservableList<Part> array, Path path) throws IOException {
        OutputStream fis = Files.newOutputStream(path);
        FileOutputStream output = new FileOutputStream(String.valueOf(path), true);
        ObjectOutputStream oos = new ObjectOutputStream(output);

        ArrayList<Part> newarray = new ArrayList<>(array);
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

    public void runDetails(TableView tv){
        try {
            array = loadNewParts(Path);
            tv.setItems(array);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void saveFileny() throws IOException {
        if(!array.isEmpty()) {
            saveNewParts(array, newPartRegister.Path);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Lagring vellykket!");
            alert.setHeaderText("Vellykket");
            alert.setContentText("Nye deler ligger inne i valgmenyene på hovedsiden");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lagring feilet!");
            alert.setHeaderText("Feil");
            alert.setContentText("Du har ikke lagt til nye deler");
            alert.showAndWait();
        }
    }
}
