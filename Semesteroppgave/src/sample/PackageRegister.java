package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PackageRegister implements Serializable {

    static Path path = Paths.get("Semesteroppgave\\src\\sample\\Packages");
    public ObservableList<Package> array = FXCollections.observableArrayList();

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<Package> getArray(){
        return this.array;
    }

    public void removeAll(){array.clear();}

    public void addPart(Package p){array.add(p);}


    public void registrerPackage(PC packageName, double packagePrice){
        Package enPackage = new Package(packageName,packagePrice);
        array.add(enPackage);
    }

    public void save(ObservableList<Package> array, Path path) throws IOException {
        //FileOutputStream fos = new FileOutputStream(String.valueOf(path),true);
        OutputStream fis = Files.newOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fis);

        ArrayList<Package> newarray = new ArrayList<>(array);
        oos.writeObject(newarray);
    }

    public ObservableList<Package> loadData(Path path) throws IOException, ClassNotFoundException {
        try {
            InputStream fis = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Package> d = (ArrayList<Package>) ois.readObject();

            ObservableList<Package> o = FXCollections.observableArrayList(d);

            return o;
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void runPackages(TableView tv){
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
