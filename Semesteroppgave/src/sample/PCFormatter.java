package sample;

import java.util.List;

public class PCFormatter {
    public static String DELIMETER = ";";

    public static String formatPart(Part part){
        return part.getType()+DELIMETER+part.getDelNavn()+DELIMETER+part.getDelPris();
    }

    public static String formatParts(List<Part> partList){
        StringBuffer str = new StringBuffer();
        for(Part part : partList){
            str.append(formatPart(part));
            str.append("\n");
        }

        return str.toString();
    }
}
