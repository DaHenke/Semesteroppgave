package computer;

import javafx.beans.property.SimpleStringProperty;

public class Laptop extends Computer {
    public Laptop(SimpleStringProperty prosessor, SimpleStringProperty skjermkort, SimpleStringProperty minne,
                  SimpleStringProperty harddisk){
        super(prosessor, skjermkort, minne, harddisk);
    }

    public String getProsessor() {
        return prosessor.get();
    }
    public SimpleStringProperty prosessorProperty(){ return this.prosessor; }

    public String getSkjermkort() { return skjermkort.get(); }
    public SimpleStringProperty skjermkortProperty(){ return this.skjermkort; }

    public String getMinne() { return minne.get(); }
    public SimpleStringProperty minneProperty(){ return this.skjermkort; }

    public String getHarddisk() { return harddisk.get(); }
    public SimpleStringProperty harddiskProperty(){ return this.harddisk; }
}