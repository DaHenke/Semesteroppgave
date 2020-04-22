package convert;

import javafx.beans.property.SimpleStringProperty;

public class fromSimpleString {
    public static String fromSimpleString(SimpleStringProperty string){
        return (String.valueOf(string));
    }
}
