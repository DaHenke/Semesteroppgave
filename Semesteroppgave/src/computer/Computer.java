package computer;

import javafx.beans.property.SimpleStringProperty;

public class Computer {
    public SimpleStringProperty prosessor, skjermkort, minne, harddisk;

    public Computer(SimpleStringProperty prosessor, SimpleStringProperty skjermkort, SimpleStringProperty minne,
                    SimpleStringProperty harddisk){
        this.prosessor = prosessor;
        this.skjermkort = skjermkort;
        this.minne = minne;
        this.harddisk = harddisk;
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
