package sample;

public class checkConfiguration {

    public static int checkCPU(int no_CPU)throws InvalidPCConfigurationException{
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

}
