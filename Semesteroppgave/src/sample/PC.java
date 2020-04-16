package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


public class PC {
    public SimpleStringProperty DelNavn;
    public SimpleDoubleProperty DelPris;

    public PC(String DelNavn, double DelPris){
        this.DelNavn = new SimpleStringProperty(DelNavn);
        this.DelPris = new SimpleDoubleProperty(DelPris);
    }

    public String getDelNavn() {
        return DelNavn.get();
    }

    public SimpleStringProperty delNavnProperty() {
        return DelNavn;
    }

    public void setDelNavn(String delNavn) {
        this.DelNavn.set(delNavn);
    }

    public double getDelPris() {
        return DelPris.get();
    }

    public SimpleDoubleProperty delPrisProperty() {
        return DelPris;
    }

    public void setDelPris(double delPris) {
        this.DelPris.set(delPris);
    }
}
