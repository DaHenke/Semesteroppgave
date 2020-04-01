package computer;

import javafx.beans.property.SimpleStringProperty;

public class Desktop extends Computer{
    public SimpleStringProperty mus, tastatur, monitor;

    public Desktop(SimpleStringProperty prosessor, SimpleStringProperty skjermkort, SimpleStringProperty minne,
                   SimpleStringProperty harddisk, SimpleStringProperty mus, SimpleStringProperty tastatur,
                   SimpleStringProperty monitor) {
        super(prosessor, skjermkort, minne, harddisk);
        this.mus = mus;
        this.tastatur = tastatur;
        this.monitor = monitor;
    }

    public String getMus() { return mus.get(); }
    public SimpleStringProperty musProerty(){ return mus; }

    public String getTastatur() { return tastatur.get(); }
    public SimpleStringProperty tastaturProperty(){ return tastatur; }

    public String getMonitor() { return monitor.get(); }
    public SimpleStringProperty monitorProperty(){ return monitor; }
}
