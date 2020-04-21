package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Register {
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
}
