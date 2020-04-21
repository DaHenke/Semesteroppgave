package sample;

import exceptions.InvalidSelectedRemoval;

public class removeSelected {
    public static int removeCPU(String type) throws InvalidSelectedRemoval {
        if(type.matches("CPU")){
            ControllerMainPage.counter_CPU--;
            return ControllerMainPage.counter_CPU;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen CPU");
        }
    }

    public static int removeGPU(String type,int counter_GPU) throws InvalidSelectedRemoval{
        if(type.matches("GPU")){
            counter_GPU--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen GPU");
        }
        return counter_GPU;
    }

    public static int removeRAM(String type,int counter_RAM) throws InvalidSelectedRemoval{
        if(type.matches("Memory")){
            counter_RAM--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen RAM");
        }
        return counter_RAM;
    }

    public static int removeHDD(String type,int counter_HDD) throws InvalidSelectedRemoval{
        if(type.matches("HDD")){
            counter_HDD--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen HDD");
        }
        return counter_HDD;
    }
    public static int removeMon(String type,int counter_Mon) throws InvalidSelectedRemoval{
        if(type.matches("Monitor")){
            counter_Mon--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Monitor");
        }
        return counter_Mon;
    }
    public static int removeMou(String type,int counter_Mou) throws InvalidSelectedRemoval{
        if(type.matches("Mouse")){
            counter_Mou--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Mouse");
        }
        return counter_Mou;
    }
    public static int removeKB(String type,int counter_KB) throws InvalidSelectedRemoval{
        if(type.matches("Keyboard")){
            counter_KB--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Keyboard");
        }
        return counter_KB;
    }
}
