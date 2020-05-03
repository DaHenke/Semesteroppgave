package sample;

import exceptions.InvalidPartTypeException;

import javax.swing.table.TableColumn;

public class CheckPartType {
    public static String checkType(String part){
        if(part.matches("CPU")){
            checkConfiguration.counter_CPU++;
            return part;
        }else if(part.matches("GPU")){
            checkConfiguration.counter_GPU++;
            return part;
        }else if(part.matches("Memory")){
            checkConfiguration.counter_RAM++;
            return part;
        }else if(part.matches("HDD")){
            checkConfiguration.counter_HDD++;
            return part;
        }else if(part.matches("Monitor")){
            checkConfiguration.counter_Mon++;
            return part;
        }else if(part.matches("Mouse")){
            checkConfiguration.counter_Mou++;
            return part;
        } else if(part.matches("Keyboard")){
            checkConfiguration.counter_KB++;
            return part;
        } else if(part.matches("Cabinet")){
            checkConfiguration.counter_Cab++;
            return part;
        }else {
            throw new InvalidPartTypeException("Not a valid part");
        }
    }
    public static String checkTypeCB(String part) {
        if (part.matches("CPU")) {
            return part;
        } else if (part.matches("GPU")) {
            return part;
        } else if (part.matches("Memory")) {
            return part;
        } else if (part.matches("HDD")) {
            return part;
        } else if (part.matches("Monitor")) {
            return part;
        } else if (part.matches("Mouse")) {
            return part;
        } else if (part.matches("Keyboard")) {
            return part;
        } else if (part.matches("Cabinet")) {
            return part;
        } else {
            throw new InvalidPartTypeException("Not a valid part");
        }
    }
}
