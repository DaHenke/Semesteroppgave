package sample;

import sample.PC;

import java.util.List;

public class PCFormatter {
    public static String DELIMETER = ";";

    public static String formatPart(PC part){
        return part.getType()+DELIMETER+part.getDelNavn()+DELIMETER+part.getDelPris();
    }

    public static String formatParts(List<PC> partList){
        StringBuffer str = new StringBuffer();
        for(PC part : partList){
            str.append(formatPart(part));
            str.append("\n");
        }

        return str.toString();
    }
}
