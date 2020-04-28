package computer;

import javafx.beans.property.SimpleStringProperty;

public class Desktop extends Computer{
    public SimpleStringProperty mous, keybord, monitor;

    public Desktop(SimpleStringProperty CPU, SimpleStringProperty GPU, SimpleStringProperty RAM,
                   SimpleStringProperty hardDrive, SimpleStringProperty mous, SimpleStringProperty keyboard,
                   SimpleStringProperty monitor) {
        super(CPU, GPU, RAM, hardDrive);
        this.mous = mous;
        this.keybord = keyboard;
        this.monitor = monitor;
    }

    public String getMous() { return mous.get(); }
    public SimpleStringProperty mousProerty(){ return mous; }

    public String getTastatur() { return keybord.get(); }
    public SimpleStringProperty tastaturProperty(){ return keybord; }

    //public String getMonitor() { return monitor.get(); }
    public SimpleStringProperty monitorProperty(){ return monitor; }
}
