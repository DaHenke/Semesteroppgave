package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


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
}
