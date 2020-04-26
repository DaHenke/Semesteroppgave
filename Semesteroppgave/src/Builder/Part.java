package Builder;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Part<T> implements Serializable {
    private static final long serialVerisonUIT = 1;

    private transient SimpleStringProperty type;
    private transient SimpleStringProperty navn;
    private transient SimpleDoubleProperty pris;

    public Part(String type, String navn, double pris){
        this.type=new SimpleStringProperty(type);
        this.navn=new SimpleStringProperty(navn);
        this.pris=new SimpleDoubleProperty(pris);
    }


    public String getType(){return type.getValue();}
    public void setType(String type){this.type.set(type);}

    public String getNavn(){return navn.getValue();}
    public void setNavn(String navn){this.navn.set(navn);}

    public double getPris(){return pris.getValue();}
    public void setPris(double pris){this.pris.set(pris);}


    public String toString(){
        return String.format("%s;%s;%s",type.getValue(),navn.getValue(),pris.getValue());
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeUTF(getType());
        s.writeUTF(getNavn());
        s.writeDouble(getPris());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        String type = s.readUTF();
        String navn = s.readUTF();
        double pris = s.readDouble();

        this.type = new SimpleStringProperty(type);
        this.navn = new SimpleStringProperty(navn);
        this.pris = new SimpleDoubleProperty(pris);

        setType(type);
        setNavn(navn);
        setPris(pris);
    }
}
