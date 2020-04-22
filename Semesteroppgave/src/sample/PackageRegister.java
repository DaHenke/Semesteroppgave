package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class PackageRegister {
    public static ObservableList<Package> array = FXCollections.observableArrayList();

    public void attachTableView(TableView tv){
        tv.setItems(array);
    }

    public ObservableList<Package> getArray(){
        return this.array;
    }

    public void registrerPackage(PC packageName, double packagePrice){
        Package enPackage = new Package(packageName,packagePrice);
        array.add(enPackage);
    }
}
