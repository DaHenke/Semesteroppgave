package sample;

import exceptions.InvalidSelectedRemoval;

public class removeSelected {
    public static void remove(String type) throws InvalidSelectedRemoval{
        if(type.equals("CPU")){
            checkConfiguration.counter_CPU--;
        }else if(type.matches("GPU")){
            checkConfiguration.counter_GPU--;
        }else if(type.matches("Memory")){
            checkConfiguration.counter_RAM--;
        }else if(type.matches("HDD")){
            checkConfiguration.counter_HDD--;
        }else if(type.matches("Monitor")){
            checkConfiguration.counter_Mon--;
        }else if(type.matches("Mouse")){
            checkConfiguration.counter_Mou--;
        }else if(type.matches("Keyboard")){
            checkConfiguration.counter_KB--;
        }else if(type.matches("Cabinet")){
            checkConfiguration.counter_Cab--;
        }
        else{
            throw new InvalidSelectedRemoval("Du må velge en del");
        }
    }

    /*public static void remove(String type, int counterCPU, int counterGPU, int counterRAM, int counterHDD, int counterMon, int counterMou,
    int counterKB) throws InvalidSelectedRemoval{
        if(type.matches("CPU")){
            removeCPU(type);
        }else if(type.matches("GPU")){
            removeGPU(type,counterGPU);
        }else if(type.matches("Memory")){
            removeRAM(type,counterRAM);
        }else if(type.matches("HDD")){
            removeHDD(type,counterHDD);
        }else if(type.matches("Monitor")){
            removeMon(type,counterMon);
        }else if(type.matches("Mouse")){
            removeMou(type,counterMou);
        }else if(type.matches("Keyboard")){
            removeKB(type,counterKB);
        }
        else{
            throw new InvalidSelectedRemoval("Du må velge en del");
        }
    }*/
}
