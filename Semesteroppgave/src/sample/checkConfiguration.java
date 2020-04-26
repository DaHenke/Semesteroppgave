package sample;

import exceptions.InvalidPCConfigurationException;
        import exceptions.InvalidPartTypeException;

public class checkConfiguration {
    static int MAX_NO_OF_COMPONENTS = 0;

    public static int checkCPU(int no_CPU)throws InvalidPCConfigurationException {
        if(no_CPU == 0){
            no_CPU++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en CPU");
        }
        return no_CPU;
    }
    public static int checkGPU(int no_GPU)throws InvalidPCConfigurationException{
        if(no_GPU == 0 || no_GPU == 1){
            no_GPU++;
        }else if(no_GPU == 2){
            throw new InvalidPCConfigurationException("Du kan kun velge opp til to GPUer");
        }
        return no_GPU;
    }
    public static int checkRAM(int no_RAM)throws InvalidPCConfigurationException{
        if(no_RAM == 0){
            no_RAM++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en RAM");
        }
        return no_RAM;

    }
    public static int checkHDD(int no_HDD)throws InvalidPCConfigurationException{
        if(no_HDD == 0 || no_HDD == 1){
            no_HDD++;
        }else if(no_HDD == 2){
            throw new InvalidPCConfigurationException("Du kan kun velge opp til to HDDer/SSDer");
        }
        return no_HDD;

    }
    public static int checkKeyboard(int no_Keyboards)throws InvalidPCConfigurationException{
        if(no_Keyboards == 0){
            no_Keyboards++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge ett keyboard");
        }
        return no_Keyboards;

    }
    public static int checkMonitor(int no_Monitor)throws InvalidPCConfigurationException{
        if(no_Monitor == 0){
            no_Monitor++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en skjerm");
        }
        return no_Monitor;
    }
    public static int checkMouse(int no_Mouse)throws InvalidPCConfigurationException{
        if(no_Mouse == 0){
            no_Mouse++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge en PC-mus");
        }
        return no_Mouse;
    }
    public static int checkCabinet(int no_Cabinet)throws InvalidPCConfigurationException{
        if(no_Cabinet == 0){
            no_Cabinet++;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare velge ett kabinett");
        }
        return no_Cabinet;
    }

    public static void checkPurchase()throws  InvalidPCConfigurationException{
        if(ControllerMainPage.counter_CPU == 0 || ControllerMainPage.counter_GPU == 0 || ControllerMainPage.counter_RAM == 0 ||
                ControllerMainPage.counter_HDD == 0 || ControllerMainPage.counter_Cab == 0){
            throw new InvalidPCConfigurationException("Missing necessary parts");
        }
    }

    public static int checkAmountCPU()throws InvalidPCConfigurationException{
        if(ControllerMainPage.counter_CPU < 2){
            return ControllerMainPage.counter_CPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en CPU");
        }


    }
    public static int checkAmountGPU()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_GPU < 3) {
            return ControllerMainPage.counter_GPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha opp til to GPUer");
        }
    }
    public static int checkAmountRAM()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_RAM < 2) {
            return ControllerMainPage.counter_RAM;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en RAM-komponent");
        }
    }
    public static int checkAmountHDD()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_HDD < 3) {
            return ControllerMainPage.counter_HDD;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha opp til to HDDer");
        }
    }
    public static int checkAmountMon()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_Mon < 2) {
            return ControllerMainPage.counter_Mon;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en skjerm");
        }
    }
    public static int checkAmountMou()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_Mou < 2) {
            return ControllerMainPage.counter_GPU;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha en mus");
        }
    }
    public static int checkAmountKB()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_KB < 2) {
            return ControllerMainPage.counter_KB;
        }else{
            throw new InvalidPCConfigurationException("Du kan bare ha ett tastatur");
        }
    }
    public static int checkAmountCab()throws InvalidPCConfigurationException {
        if(ControllerMainPage.counter_Cab < 2) {
            return ControllerMainPage.counter_Cab;
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

    public static void checkAll() throws InvalidPCConfigurationException{
        checkPurchase();
        //checkComponents();
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
