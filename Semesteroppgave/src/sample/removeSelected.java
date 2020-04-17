package sample;

public class removeSelected {
    public static int removeCPU(int counter_CPU) throws InvalidSelectedRemoval{
        if(counter_CPU == 1){
            System.out.println(counter_CPU);
            counter_CPU--;
            System.out.println(counter_CPU);
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_CPU;
    }

    public static int removeGPU(int counter_GPU) throws InvalidSelectedRemoval{
        if(counter_GPU == 1 || counter_GPU == 2){
            counter_GPU--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_GPU;
    }

    public static int removeRAM(int counter_RAM) throws InvalidSelectedRemoval{
        if(counter_RAM == 1){
            counter_RAM--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_RAM;
    }

    public static int removeHDD(int counter_HDD) throws InvalidSelectedRemoval{
        if(counter_HDD == 1  || counter_HDD == 2){
            counter_HDD--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_HDD;
    }
    public static int removeMon(int counter_Mon) throws InvalidSelectedRemoval{
        if(counter_Mon == 1){
            counter_Mon--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_Mon;
    }
    public static int removeMou(int counter_Mou) throws InvalidSelectedRemoval{
        if(counter_Mou == 1){
            counter_Mou--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_Mou;
    }
    public static int removeKB(int counter_KB) throws InvalidSelectedRemoval{
        if(counter_KB == 1){
            counter_KB--;
        }else{
            throw new InvalidSelectedRemoval("En del må være i kassen");
        }
        return counter_KB;
    }
}
