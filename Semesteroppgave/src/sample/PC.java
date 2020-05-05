package sample;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class PC implements Serializable {
    public String CABINET,CPU,GPU1,RAM,HDD1,MONITOR,MOUSE,KEYBOARD,GPU2,HDD2;

    public PC(String CABINET, String CPU, String GPU1, String RAM,
              String HDD1, String MONITOR, String MOUSE, String KEYBOARD, String GPU2, String HDD2) {
        this.CABINET = CABINET;
        this.CPU = CPU;
        this.GPU1 = GPU1;
        this.RAM = RAM;
        this.HDD1 = HDD1;
        this.MONITOR = MONITOR;
        this.MOUSE = MOUSE;
        this.KEYBOARD = KEYBOARD;
        this.GPU2 = GPU2;
        this.HDD2 = HDD2;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU1() {
        return GPU1;
    }

    public void setGPU1(String GPU1) {
        this.GPU1 = GPU1;
    }

    public String getGPU2() {
        return GPU2;
    }

    public void setGPU2(String GPU2) {
        this.GPU2 = GPU2;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHDD1() {
        return HDD1;
    }

    public void setHDD1(String HDD1) {
        this.HDD1 = HDD1;
    }

    public String getHDD2() {
        return HDD2;
    }

    public void setHDD2(String HDD2) {
        this.HDD2 = HDD2;
    }

    public String getMONITOR() {
        return MONITOR;
    }

    public void setMONITOR(String MONITOR) {
        this.MONITOR = MONITOR;
    }

    public String getMOUSE() {
        return MOUSE;
    }

    public void setMOUSE(String MOUSE) {
        this.MOUSE = MOUSE;
    }

    public String getKEYBOARD() {
        return KEYBOARD;
    }

    public void setKEYBOARD(String KEYBOARD) {
        this.KEYBOARD = KEYBOARD;
    }

    public String getCABINET() {
        return CABINET;
    }

    public void setCABINET(String CABINET) {
        this.CABINET = CABINET;
    }

    @Override
    public String toString() {
        return CABINET;
    }



}
