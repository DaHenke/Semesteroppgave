package sample;

import exceptions.InvalidPartTypeException;

public class CheckPartType {
    public static String checkType(String part){
        if(part.matches("CPU")){
            ControllerMainPage.counter_CPU++;
            return part;
        }else if(part.matches("GPU")){
            ControllerMainPage.counter_GPU++;
            return part;
        }else if(part.matches("Memory")){
            ControllerMainPage.counter_RAM++;
            return part;
        }else if(part.matches("HDD")){
            ControllerMainPage.counter_HDD++;
            return part;
        }else if(part.matches("Monitor")){
            ControllerMainPage.counter_Mon++;
            return part;
        }else if(part.matches("Mouse")){
            ControllerMainPage.counter_Mou++;
            return part;
        } else if(part.matches("Keyboard")){
            ControllerMainPage.counter_KB++;
            return part;
        }else {
            throw new InvalidPartTypeException("Not a valid part");
        }
    }
}
