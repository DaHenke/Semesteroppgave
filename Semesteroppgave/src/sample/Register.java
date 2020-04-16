package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Register {
        public static ObservableList<PC> array = FXCollections.observableArrayList();

        public void attachTableView(TableView tv){
            tv.setItems(array);
        }

        public ObservableList<PC> getArray(){
            return this.array;
        }

        public void registrerPCDel(String delNavn, double delPris){
            PC enDel = new PC(delNavn,delPris);
            array.add(enDel);
        }

}
