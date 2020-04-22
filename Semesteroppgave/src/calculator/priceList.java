package calculator;

import javafx.beans.property.SimpleDoubleProperty;
import sun.java2d.pipe.SpanShapeRenderer;

public class priceList {

    //Priser hentet ut fra komplett.no


    //CPU

    //ADM_Athlon_3000G
    public static final double CPU1 =599;
    //Intel_Pentium_Gold_G5600
    public static final double CPU2 = 979;
    //AMD_Ryzen_3_3200G
    public static final double CPU3 = 1_349;
    //Intel_Core_i5_9600
    public static final double CPU4 =2_599;

    public static SimpleDoubleProperty getCPUprice(String CPUin){
        if(CPUin.equals("AMD Athlon 3000G")){
            return new SimpleDoubleProperty(CPU1);
        }else if(CPUin.equals("Intel Pentium Gold G5600")){
            return new SimpleDoubleProperty(CPU2);
        }else if(CPUin.equals("AMD Ryzen 3 3200G")){
            return new SimpleDoubleProperty(CPU3);
        }else if(CPUin.equals("Intel Core i5-9600")){
            return new SimpleDoubleProperty(CPU4);
        }else {
            return new SimpleDoubleProperty(0.0);
        }
    }


    //GPU

    //ASUS_GeForce_GT710_1GB
    public static final double GPU1 =533;
    //Gigabyte_GeForce_GT_1030_2GB_Low_Profile
    public static final double GPU2 =1_099;
    //PNY_Quadro_P400_2GB_DVI
    public static final double GPU3 =1_889;
    //Gainward_GeForce_GTX_1650_SUPER_Pegasus_OC
    public static final double GPU4 = 2_399;


    public static SimpleDoubleProperty getGPUprice(String GPUin){
        if(GPUin.equals("ASUS GeForce GT710 1GB")){
            return new SimpleDoubleProperty(GPU1);
        }else if(GPUin.equals("Gigabyte GeForce GT 1030 2GB Low Profile")){
            return new SimpleDoubleProperty(GPU2);
        }else if(GPUin.equals("PNY Quadro P400 2GB DVI")){
            return new SimpleDoubleProperty(GPU3);
        }else if(GPUin.equals("Gainward GeForce GTX 1650 SUPER Pegasus OC")){
            return new SimpleDoubleProperty(GPU4);
        }else{
            return new SimpleDoubleProperty(0.0);
        }
    }


    //RAM

    //HyperX_Fury_DDR3_1600MHz_4GB
    public static final double RAM1 =333;
    //Crucial_DDR4_2400MHz_8GB
    public static final double RAM2 =564;
    //Kingston_Value_DDR4_3400MHz_16GB
    public static final double RAM3 =929;
    //HyperX_Fury_DDR4_2666MHZ_32GB
    public static final double RAM4 =1_949;


    public static SimpleDoubleProperty getRAMprice(String RAMin){
        if(RAMin.equals("HyperX Fury DDR3 1600MHz 4GB")){
            return new SimpleDoubleProperty(RAM1);
        }else if(RAMin.equals("Crucial DDR4 2400MHz 8GB")){
            return new SimpleDoubleProperty(RAM2);
        }else if(RAMin.equals("Kingston Value DDR4 3400MHz 16GB")){
            return new SimpleDoubleProperty(RAM3);
        }else if(RAMin.equals("HyperX Fury DDR4 2666MHZ 32GB")){
            return new SimpleDoubleProperty(RAM4);
        }else{
            return new SimpleDoubleProperty(0.0);
        }
    }


    //hard drive laptop 2.5"

    //WD_Mobile_Black_1TB_Harddisk
    public static final double harddiskL1 =807;
    //Seagate_Firecuda_2TB
    public static final double harddiskL2 =1_289;
    //Seagate_Barracuda_4TB
    public static final double harddiskL3 =2_174;


    //hard drive desktop 3.5"

    //Seagate_Barracuda_1TB
    public static final double harddiskD1 =530;
    //Seagate_Barracuda_3TB
    public static final double harddiskD2 =1_022;
    //Seagate_SkyHawk_6TB
    public static final double harddiskD3 =2_310;
    //Seagate_IronWolf_10TB
    public static final double harddiskD4 =4_486;


    public static SimpleDoubleProperty getHDDSSDprice(String HDDSSDin){
        if(HDDSSDin.equals("Seagate Barracuda 1TB")){
            return new SimpleDoubleProperty(harddiskD1);
        }else if(HDDSSDin.equals("Seagate Barracuda 3TB")){
            return new SimpleDoubleProperty(harddiskD2);
        }else if(HDDSSDin.equals("Seagate SkyHawk 6TB")){
            return new SimpleDoubleProperty(harddiskD3);
        }else if(HDDSSDin.equals("Seagate IronWolf 10TB")){
            return new SimpleDoubleProperty(harddiskD4);
        }else{
            return new SimpleDoubleProperty(0.0);
        }
    }

    //ekstern hard drive

    //Seagate_Expansion_Portable_1TB
    public static final double harddiskE1 =689;
    //ASUS_FX_External_Hard_Drive_3TB
    public static final double harddiskE2 =1_317;
    //WD_My_Book_8TB
    public static final double harddiskE3 =2_245;


    //mouse

    //Logitech_M90_Mus
    public static final double mouse1 = 109;
    //Microsoft_Mobile_Mouse_3600
    public static final double mouse2 =349;
    //Surface_ARC_mus
    public static final double mouse3 =829;
    //Logitech_MX_Master3_Adv_trådløs
    public static final double mouse4 =1_299;


    public static SimpleDoubleProperty getMousePrice(String mouseIn){
        if(mouseIn.equals("Logitech M90 Mus")){
            return new SimpleDoubleProperty(mouse1);
        }else if(mouseIn.equals("Microsoft Mobile Mouse 3600")){
            return new SimpleDoubleProperty(mouse2);
        }else if (mouseIn.equals("Surface ARC mus")){
            return new SimpleDoubleProperty(mouse3);
        }else if (mouseIn.equals("Logitech MX Master3 Adv trådløs")){
            return new SimpleDoubleProperty(mouse4);
        }else {
            return new SimpleDoubleProperty(0.0);
        }
    }

    //keyboard

    //Microsoft_Wired_Keyboard_600
    public static final double keyboard1 =199;
    //Logitech_K400_Plus_Trådløs_Tastatur
    public static final double keyboard2 =549;
    //Kanex_MultiSync_Premium_Slim_Keyboard
    public static final double keyboard3 =949;
    //Logitech_ERGO_K860_Trådløs_Tastatur
    public static final double keyboard4 = 1_399;


    public static SimpleDoubleProperty getKeyboardPrice(String keyboardIn){
        if(keyboardIn.equals("Microsoft Wired Keyboard 600")){
            return new SimpleDoubleProperty(keyboard1);
        }else if(keyboardIn.equals("Logitech K400 Plus Trådløs Tastatur")){
            return new SimpleDoubleProperty(keyboard2);
        }else if (keyboardIn.equals("Kanex MultiSync Premium Slim Keyboard")){
            return new SimpleDoubleProperty(keyboard3);
        }else if (keyboardIn.equals("Logitech ERGO K860 Trådløs Tastatur")){
            return new SimpleDoubleProperty(keyboard4);
        }else{
            return new SimpleDoubleProperty(0.0);
        }
    }

    //monitor

    //Acer_24_skjerm_KA242Y
    public static final double monitor1 =1_395;
    //Samsung_24_skjerm_S24E450F
    public static final double monitor2 = 1_695;
    //Acer_27_skjerm_KA272
    public static final double monitor3 =2_195;
    //Samsung_28_4K_LED_FreeSync_U28E570D
    public static final double monitor4 = 3_290;


    public static SimpleDoubleProperty getMonitorPrice(String monitorIn){
        if(monitorIn.equals("Acer 24 skjerm KA242Y")){
            return new SimpleDoubleProperty(monitor1);
        }else if(monitorIn.equals("Samsung 24 skjerm S24E450F")){
            return new SimpleDoubleProperty(monitor2);
        }else if (monitorIn.equals("Acer 27 skjerm KA272")){
            return new SimpleDoubleProperty(monitor3);
        }else if (monitorIn.equals("Samsung 28 4K LED FreeSync U28E570D")){
            return new SimpleDoubleProperty(monitor4);
        }else {
            return new SimpleDoubleProperty(0.0);
        }
    }

    //Phanteks Eclipse P400A RGB Black
    public static final double cabinet1 =1_099;
    //Fractal Design Focus G Sort Mid Tower
    public static final double cabinet2 = 599;
    //Chieftec Scorpion II Gaming
    public static final double cabinet3 =999;

}