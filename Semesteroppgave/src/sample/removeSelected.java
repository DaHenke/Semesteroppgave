package sample;

import exceptions.InvalidSelectedRemoval;

public class removeSelected {
    public static void remove(String type) throws InvalidSelectedRemoval{
        if(type.matches("CPU")){
            ControllerMainPage.counter_CPU--;
        }else if(type.matches("GPU")){
            ControllerMainPage.counter_GPU--;
        }else if(type.matches("Memory")){
            ControllerMainPage.counter_RAM--;
        }else if(type.matches("HDD")){
            ControllerMainPage.counter_HDD--;
        }else if(type.matches("Monitor")){
            ControllerMainPage.counter_Mon--;
        }else if(type.matches("Mouse")){
            ControllerMainPage.counter_Mou--;
        }else if(type.matches("Keyboard")){
            ControllerMainPage.counter_KB--;
        }else if(type.matches("Cabinet")){
            ControllerMainPage.counter_Cab--;
        }
        else{
            throw new InvalidSelectedRemoval("Du må velge en del");
        }
    }
}
