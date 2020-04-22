package convert;

import javafx.beans.property.SimpleDoubleProperty;

public class fromDouble {
    public static SimpleDoubleProperty fromDouble(double number){
        return new SimpleDoubleProperty(number);
    }
}
