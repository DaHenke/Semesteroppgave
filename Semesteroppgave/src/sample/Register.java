package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Register {
        public static ObservableList<PC> array = FXCollections.observableArrayList();

        public void attachTableView(TableView tv){
            tv.setItems(array);
        }

        public ObservableList<PC> getArray(){
            return this.array;
        }

        public void registrerPCDel(String type, String delNavn, double delPris){
            PC enDel = new PC(type,delNavn,delPris);
            array.add(enDel);
        }
}
