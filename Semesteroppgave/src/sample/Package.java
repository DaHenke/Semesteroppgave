package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Package implements Serializable {
    transient public PC packageName;
    transient public Double packagePrice;

    public Package(PC packageName, double packagePrice) {
        this.packageName = packageName;
        this.packagePrice = packagePrice;
    }

    public PC getPackageName() {
        return packageName;
    }

    public void setPackageName(PC packageName) {
        this.packageName = packageName;
    }

    public Double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(Double packagePrice) {
        this.packagePrice = packagePrice;
    }
}
