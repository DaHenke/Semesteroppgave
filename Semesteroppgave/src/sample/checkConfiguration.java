package sample;

import exceptions.InvalidPCConfigurationException;
        import exceptions.InvalidPartTypeException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class checkConfiguration {
    static int MAX_NO_OF_COMPONENTS = 0;
    static int counter_CPU = 0;
    static int counter_GPU = 0;
    static int counter_RAM = 0;
    static int counter_HDD = 0;
    static int counter_KB = 0;
    static int counter_Mon = 0;
    static int counter_Mou = 0;
    static int counter_Cab = 0;

    public static void countMaxComponents(){
        MAX_NO_OF_COMPONENTS++;
    }

    public static int checkCPU()throws InvalidPCConfigurationException {
        if(counter_CPU == 0){
            counter_CPU++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en CPU");
        }
        return counter_CPU;
    }
    public static int checkGPU()throws InvalidPCConfigurationException{
        if(counter_GPU == 0 || counter_GPU == 1){
            counter_GPU++;
        }else if(counter_GPU == 2){
            throw new InvalidPCConfigurationException("Du kan kun velge opp til to GPUer");
        }
        return counter_GPU;
    }
    public static int checkRAM()throws InvalidPCConfigurationException{
        if(counter_RAM == 0){
            counter_RAM++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en RAM");
        }
        return counter_RAM;

    }
    public static int checkHDD()throws InvalidPCConfigurationException{
        if(counter_HDD == 0 || counter_HDD == 1){
            counter_HDD++;
        }else if(counter_HDD == 2){
            throw new InvalidPCConfigurationException("Du kan kun velge opp til to HDDer/SSDer");
        }
        return counter_HDD;

    }
    public static int checkKeyboard()throws InvalidPCConfigurationException{
        if(counter_KB == 0){
            counter_KB++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge ett keyboard");
        }
        return counter_KB;

    }
    public static int checkMonitor()throws InvalidPCConfigurationException{
        if(counter_Mon == 0){
            counter_Mon++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en skjerm");
        }
        return counter_Mon;
    }
    public static int checkMouse()throws InvalidPCConfigurationException{
        if(counter_Mou == 0){
            counter_Mou++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en PC-mus");
        }
        return counter_Mou;
    }
    public static int checkCabinet()throws InvalidPCConfigurationException{
        if(counter_Cab == 0){
            counter_Cab++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge ett kabinett");
        }
        return counter_Cab;
    }

    public static void checkPurchase()throws  InvalidPCConfigurationException{
        if(counter_CPU == 0 || counter_GPU == 0 || counter_RAM == 0 ||
                counter_HDD == 0 || counter_Cab == 0){
            throw new InvalidPCConfigurationException("Missing necessary parts");
        }
    }

    public static int checkAmountCPU()throws InvalidPCConfigurationException{
        if(counter_CPU < 2){
            return counter_CPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en CPU");
        }


    }
    public static int checkAmountGPU()throws InvalidPCConfigurationException {
        if(counter_GPU < 3) {
            return counter_GPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha opp til to GPUer");
        }
    }
    public static int checkAmountRAM()throws InvalidPCConfigurationException {
        if(counter_RAM < 2) {
            return counter_RAM;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en RAM-komponent");
        }
    }
    public static int checkAmountHDD()throws InvalidPCConfigurationException {
        if(counter_HDD < 3) {
            return counter_HDD;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha opp til to HDDer");
        }
    }
    public static int checkAmountMon()throws InvalidPCConfigurationException {
        if(counter_Mon < 2) {
            return counter_Mon;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en skjerm");
        }
    }
    public static int checkAmountMou()throws InvalidPCConfigurationException {
        if(counter_Mou < 2) {
            return counter_GPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en mus");
        }
    }
    public static int checkAmountKB()throws InvalidPCConfigurationException {
        if(counter_KB < 2) {
            return counter_KB;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha ett tastatur");
        }
    }
    public static int checkAmountCab()throws InvalidPCConfigurationException {
        if(counter_Cab < 2) {
            return counter_Cab;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha ett kabinett");
        }
    }

    /*public static int checkComponents()throws InvalidPCConfigurationException{
        if(MAX_NO_OF_COMPONENTS < 11){
            return MAX_NO_OF_COMPONENTS;
        }else{
            throw new InvalidPCConfigurationException("Too many parts");
        }
    }*/

    public static void clear(ComboBox comboCPU, ComboBox comboGPU, ComboBox comboRAM, ComboBox comboHDDSSDPC, ComboBox comboMonitor,
                             ComboBox comboMouse, ComboBox comboKeyboard, ComboBox comboCabinett, TableView tblPCdel, Label lblSum){
        comboCPU.getSelectionModel().clearSelection();
        comboGPU.getSelectionModel().clearSelection();
        comboHDDSSDPC.getSelectionModel().clearSelection();
        comboRAM.getSelectionModel().clearSelection();
        comboMonitor.getSelectionModel().clearSelection();
        comboMouse.getSelectionModel().clearSelection();
        comboKeyboard.getSelectionModel().clearSelection();
        comboCabinett.getSelectionModel().clearSelection();

        tblPCdel.getItems().clear();
        lblSum.setText("");

        counter_CPU=0;
        counter_GPU=0;
        counter_RAM=0;
        counter_HDD=0;
        counter_Mou=0;
        counter_Mon=0;
        counter_KB=0;
        counter_Cab=0;
    }

    public static void checkAll() throws InvalidPCConfigurationException{
        checkPurchase();
        checkAmountCPU();
        checkAmountGPU();
        checkAmountRAM();
        checkAmountHDD();
        checkAmountMon();
        checkAmountMou();
        checkAmountKB();
        checkAmountCab();
    }
}
