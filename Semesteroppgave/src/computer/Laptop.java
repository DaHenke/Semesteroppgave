package computer;

import javafx.beans.property.SimpleStringProperty;

public class Laptop extends Computer {

    public Laptop(SimpleStringProperty CPU, SimpleStringProperty GPU, SimpleStringProperty RAM,
                  SimpleStringProperty harddisk){
        super(CPU, GPU, RAM, harddisk);
    }

}