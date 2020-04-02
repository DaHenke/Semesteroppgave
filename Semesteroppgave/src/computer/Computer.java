package computer;

import javafx.beans.property.SimpleStringProperty;

public class Computer {
    public SimpleStringProperty CPU, GPU, RAM, hardDrive;

    public Computer(SimpleStringProperty CPU, SimpleStringProperty GPU, SimpleStringProperty RAM,
                    SimpleStringProperty hardDrive){
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.hardDrive = hardDrive;
    }
    public String getCPU() {
        return CPU.get();
    }
    public SimpleStringProperty CPUProperty(){ return this.CPU; }

    public String getGPU() { return GPU.get(); }
    public SimpleStringProperty GPUtProperty(){ return this.GPU; }

    public String getRAN() { return RAM.get(); }
    public SimpleStringProperty RANProperty(){ return this.RAM; }

    public String getHardDrive() { return hardDrive.get(); }
    public SimpleStringProperty hardDriveProperty(){ return this.hardDrive; }
}
