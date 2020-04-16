package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


public class PC {
    public SimpleStringProperty Type,DelNavn;
    public SimpleDoubleProperty DelPris;

    public PC(String Type, String DelNavn, double DelPris){
        this.Type = new SimpleStringProperty(Type);
        this.DelNavn = new SimpleStringProperty(DelNavn);
        this.DelPris = new SimpleDoubleProperty(DelPris);
    }

    public String getType() {
        return Type.get();
    }

    public SimpleStringProperty typeProperty() {
        return Type;
    }

    public void setType(String type) {
        this.Type.set(type);
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
