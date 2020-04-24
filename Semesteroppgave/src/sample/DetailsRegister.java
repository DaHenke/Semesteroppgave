package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import sample.ControllerMainPage;

public class DetailsRegister {
    public static ObservableList<Part> array = FXCollections.observableArrayList();
    static Path PartPath = Paths.get("C:\\Users\\henke\\IdeaProjects\\Semesteroppgave\\Semesteroppgave\\src\\sample\\Details");

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<Part> getArray(){
        return this.array;
    }

    public static void save() throws IOException {
        Path path = Paths.get("filnavn.jobj");
        try (OutputStream fis = Files.newOutputStream(PartPath);

            ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(array);
        }
            //ArrayList<Part> newarray = new ArrayList<>(array);
            //test test = new test("HEI");
            //oos.writeObject(newarray);
            //oos.writeObject(test);
    }

        public static ObservableList<Part> loadData() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(String.valueOf(PartPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Part> d = (ArrayList<Part>) ois.readObject();
            ObservableList<Part> o = FXCollections.observableArrayList(d);
            for (Part part: o) {
                System.out.println("test"+part.getDelNavn());
            }
            //test test = (sample.test) ois.readObject();
            //System.out.println("test"+test.getDelNavn());
            return o;
        }
}
