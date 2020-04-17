package sample;

public class removeSelected {
    public static int removeCPU(String type, int counter_CPU) throws InvalidSelectedRemoval{
        if(type == "CPU" && counter_CPU == 1){
            counter_CPU--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen CPU");
        }
        return counter_CPU;
    }

    public static int removeGPU(String type,int counter_GPU) throws InvalidSelectedRemoval{
        if(type == "GPU" && counter_GPU <=2){
            counter_GPU--;
        }else if(type != "GPU"){
            throw new InvalidSelectedRemoval("Du må velge en del av typen GPU");
        }
        return counter_GPU;
    }

    public static int removeRAM(String type,int counter_RAM) throws InvalidSelectedRemoval{
        if(type == "Memory" && counter_RAM == 1){
            counter_RAM--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen RAM");
        }
        return counter_RAM;
    }

    public static int removeHDD(String type,int counter_HDD) throws InvalidSelectedRemoval{
        if(type == "HDD" &&counter_HDD == 1  || counter_HDD == 2){
            counter_HDD--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen HDD");
        }
        return counter_HDD;
    }
    public static int removeMon(String type,int counter_Mon) throws InvalidSelectedRemoval{
        if(type == "Monitor" &&counter_Mon == 1){
            counter_Mon--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Monitor");
        }
        return counter_Mon;
    }
    public static int removeMou(String type,int counter_Mou) throws InvalidSelectedRemoval{
        if(type == "Mouse" &&counter_Mou == 1){
            counter_Mou--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Mouse");
        }
        return counter_Mou;
    }
    public static int removeKB(String type,int counter_KB) throws InvalidSelectedRemoval{
        if(type == "Keyboard" &&counter_KB == 1){
            counter_KB--;
        }else{
            throw new InvalidSelectedRemoval("Du må velge en del av typen Keyboard");
        }
        return counter_KB;
    }
}
