package sample;

import javafx.collections.ObservableList;

import javax.swing.plaf.IconUIResource;
import java.util.List;

public class PCFormatter {
    public static String DELIMETER = ";";

    public static String formatPackage(Package part){
        return part.getPackageName()+DELIMETER+part.getPackagePrice();
    }

    public static String formatPart(Part part){
        return part.getType()+DELIMETER+part.getDelNavn()+DELIMETER+part.getDelPris();
    }

    public static String formatParts(ObservableList<Package> packList){
        StringBuffer str = new StringBuffer();
        for(Package pack : packList){
            str.append(formatPackage(pack));
            str.append("\n");
        }

        return str.toString();
    }
}
