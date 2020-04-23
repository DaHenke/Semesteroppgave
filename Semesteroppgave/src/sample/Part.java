package sample;

import exceptions.InvalidPartTypeException;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;


public class Part implements Serializable {
    transient public SimpleStringProperty Type,DelNavn;
    transient public SimpleDoubleProperty DelPris;

    public Part(String Type, String DelNavn, double DelPris){
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
        if(type.matches("CPU")){
            this.Type.set(type);
        }else if(type.matches("GPU")){
            this.Type.set(type);
        }else if(type.matches("Memory")){
            this.Type.set(type);
        }else if(type.matches("HDD")){
            this.Type.set(type);
        }else if(type.matches("Monitor")){
            this.Type.set(type);
        }else if(type.matches("Mouse")){
            this.Type.set(type);
        } else if(type.matches("Keyboard")){
            this.Type.set(type);
        }else if(type.matches("Cabinet")){
            this.Type.set(type);
        }else {
            throw new InvalidPartTypeException("Not a valid part type");
        }

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
