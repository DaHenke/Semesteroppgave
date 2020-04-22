package convert;

import javafx.beans.property.SimpleDoubleProperty;

public class fromSimpleDouble {
    public static double fromSimpleDouble(SimpleDoubleProperty number){
        return Double.parseDouble(String.valueOf(number));
    }
}
