package convert;

import javafx.beans.property.SimpleStringProperty;

public class fromString {
    public static SimpleStringProperty fromString(String string){
        return new SimpleStringProperty(string);
    }
}
