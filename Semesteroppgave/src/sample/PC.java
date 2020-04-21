package sample;

import javafx.beans.property.SimpleStringProperty;

public class PC {
    public SimpleStringProperty CPU,GPU1,GPU2,RAM,HDD1,HDD2,MONITOR,MOUSE,KEYBOARD;

    public PC(String CPU, String GPU1, String GPU2, String RAM,
              String HDD1, String HDD2, String MONITOR, String
                      MOUSE, String KEYBOARD) {
        this.CPU = new SimpleStringProperty(CPU);
        this.GPU1 = new SimpleStringProperty(GPU1);
        this.GPU2 = new SimpleStringProperty(GPU2);
        this.RAM = new SimpleStringProperty(RAM);
        this.HDD1 = new SimpleStringProperty(HDD1);
        this.HDD2 = new SimpleStringProperty(HDD2);
        this.MONITOR = new SimpleStringProperty(MONITOR);
        this.MOUSE = new SimpleStringProperty(MOUSE);
        this.KEYBOARD = new SimpleStringProperty(KEYBOARD);
    }

    public String getCPU() {
        return CPU.get();
    }

    public SimpleStringProperty CPUProperty() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU.set(CPU);
    }

    public String getGPU1() {
        return GPU1.get();
    }

    public SimpleStringProperty GPU1Property() {
        return GPU1;
    }

    public void setGPU1(String GPU1) {
        this.GPU1.set(GPU1);
    }

    public String getGPU2() {
        return GPU2.get();
    }

    public SimpleStringProperty GPU2Property() {
        return GPU2;
    }

    public void setGPU2(String GPU2) {
        this.GPU2.set(GPU2);
    }

    public String getRAM() {
        return RAM.get();
    }

    public SimpleStringProperty RAMProperty() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM.set(RAM);
    }

    public String getHDD1() {
        return HDD1.get();
    }

    public SimpleStringProperty HDD1Property() {
        return HDD1;
    }

    public void setHDD1(String HDD1) {
        this.HDD1.set(HDD1);
    }

    public String getHDD2() {
        return HDD2.get();
    }

    public SimpleStringProperty HDD2Property() {
        return HDD2;
    }

    public void setHDD2(String HDD2) {
        this.HDD2.set(HDD2);
    }

    public String getMONITOR() {
        return MONITOR.get();
    }

    public SimpleStringProperty MONITORProperty() {
        return MONITOR;
    }

    public void setMONITOR(String MONITOR) {
        this.MONITOR.set(MONITOR);
    }

    public String getMOUSE() {
        return MOUSE.get();
    }

    public SimpleStringProperty MOUSEProperty() {
        return MOUSE;
    }

    public void setMOUSE(String MOUSE) {
        this.MOUSE.set(MOUSE);
    }

    public String getKEYBOARD() {
        return KEYBOARD.get();
    }

    public SimpleStringProperty KEYBOARDProperty() {
        return KEYBOARD;
    }

    public void setKEYBOARD(String KEYBOARD) {
        this.KEYBOARD.set(KEYBOARD);
    }
}
