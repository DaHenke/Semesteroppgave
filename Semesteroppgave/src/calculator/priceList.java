package calculator;

import javafx.beans.property.SimpleDoubleProperty;

public class priceList {

    //Priser hentet ut fra komplett.no

    //prosessor
    public static final SimpleDoubleProperty ADM_Athlon_3000G = new SimpleDoubleProperty(599);
    public static final SimpleDoubleProperty Intel_Pentium_Gold_G5600 = new SimpleDoubleProperty(979);
    public static final SimpleDoubleProperty AMD_Ryzen_3_3200G = new SimpleDoubleProperty(1_349);
    public static final SimpleDoubleProperty Intel_Core_i5_9600 = new SimpleDoubleProperty(2_599);

    //skjermkort
    public static final SimpleDoubleProperty ASUS_GeForce_GT710_1GB = new SimpleDoubleProperty(533);
    public static final SimpleDoubleProperty Gigabyte_GeForce_GT_1030_2GB_Low_Profile = new SimpleDoubleProperty(1099);
    public static final SimpleDoubleProperty PNY_Quadro_P400_2GB_DVI = new SimpleDoubleProperty(1_889);
}
