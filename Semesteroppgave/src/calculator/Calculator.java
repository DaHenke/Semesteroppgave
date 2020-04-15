package calculator;

import javafx.beans.property.SimpleDoubleProperty;
import static calculator.priceList.*;

public class Calculator {
    private static Double CPU, GPU, RAM, hardDrive, mouse, keyboard, monitor;

    public static double calculateExtraEquipment(String mouseIn, String keyboardIn, String monitorIn){
        if(mouseIn.equals("Logitech M90 Mus")){
            mouse=mouse1;
        }else if(mouseIn.equals("Microsoft Mobile Mouse 3600")){
            mouse=mouse2;
        }else if(mouseIn.equals("Surface ARC mus")){
            mouse=mouse3;
        }else if(mouseIn.equals("Logitech MX Master3 Adv trådløs")){
            mouse=mouse4;
        }else{
            mouse=0.0;
        }

        if(keyboardIn.equals("Microsoft Wired Keyboard 600")){
            keyboard=keyboard1;
        }else if(keyboardIn.equals("Logitech K400 Plus Trådløs Tastatur")){
            keyboard=keyboard2;
        }else if(keyboardIn.equals("Kanex MultiSync Premium Slim Keyboard")){
            keyboard=keyboard3;
        }else if(keyboardIn.equals("Logitech ERGO K860 Trådløs Tastatur")){
            keyboard=keyboard4;
        }else{
            keyboard=0.0;
        }

        if(monitorIn.equals("Acer 24 skjerm KA242Y")){
            monitor=monitor1;
        }else if(monitorIn.equals("Samsung 24 skjerm S24E450F")){
            monitor=monitor2;
        }else if(monitorIn.equals("Acer 27 skjerm KA272")){
            monitor=monitor3;
        }else if(monitorIn.equals("Samsung 28 4K LED FreeSync U28E570D")){
            monitor=monitor4;
        }else{
            monitor=0.0;
        }

        return mouse+keyboard+monitor;
    }

    public static double calculateDesktop(String  CPUin, String GPUin, String RAMin, String hardDriveIn,String mouseIn, String keyboardIn, String monitorIn){
        if(CPUin.equals("AMD Athlon 3000G")){
            CPU=CPU1;
        }else if(CPUin.equals("Intel Pentium Gold G5600")){
            CPU=CPU2;
        }else if(CPUin.equals("AMD Ryzen 3 3200G")){
            CPU=CPU3;
        }else if(CPUin.equals("Intel Core i5-9600")){
            CPU=CPU4;
        }else{
            CPU = 0.0;
        }

        if(GPUin.equals("ASUS GeForce GT710 1GB")){
            GPU=GPU1;
        }else if(GPUin.equals("Gigabyte GeForce GT 1030 2GB Low Profile")) {
            GPU=GPU2;
        }else if(GPUin.equals("PNY Quadro P400 2GB DVI")){
            GPU=GPU3;
        }else if(GPUin.equals("Gainward GeForce GTX 1650 SUPER Pegasus OC")){
            GPU=GPU4;
        }else{
            GPU=0.0;
        }

        if(RAMin.equals("HyperX Fury DDR3 1600MHz 4GB")){
            RAM=RAM1;
        }else if(RAMin.equals("Crucial DDR4 2400MHz 8GB")){
            RAM=RAM2;
        }else if(RAMin.equals("Kingston Value DDR4 3400MHz 16GB")){
            RAM=RAM3;
        }else if(RAMin.equals("HyperX Fury DDR4 2666MHZ 32GB")){
            RAM=RAM3;
        }else{
            RAM=0.0;
        }

        if(hardDriveIn.equals("Seagate Barracuda 1TB")){
            hardDrive=harddiskD1;
        }else if(hardDriveIn.equals("Seagate Barracuda 3TB")){
            hardDrive=harddiskD2;
        }else if(hardDriveIn.equals("Seagate SkyHawk 6TB")){
            hardDrive=harddiskD3;
        }else if(hardDriveIn.equals("Seagate IronWolf 10TB")){
            hardDrive=harddiskD4;
        }else{
            hardDrive=0.0;
        }

        return CPU+GPU+RAM+hardDrive+calculateExtraEquipment(mouseIn,keyboardIn,monitorIn);
    }

    public static double calculateLaptop(String  CPUin, String GPUin, String RAMin, String hardDriveIn,String mouseIn, String keyboardIn, String monitorIn){
        if(CPUin.equals("ADM Athlon 3000G")){
            CPU=CPU1;
        }else if(CPUin.equals("Gigabyte GeForce GT 1030 2GB Low Profile")){
            CPU=CPU2;
        }else if(CPUin.equals("PNY Quadro P400 2GB DVI")){
            CPU=CPU3;
        }else if(CPUin.equals("Gainward GeForce GTX 1650 SUPER Pegasus OC")){
            CPU=CPU4;
        }else{
            CPU = 0.0;
        }

        if(GPUin.equals("ASUS GeForce GT710 1GB")){
            GPU=GPU1;
        }else if(GPUin.equals("Gigabyte GeForce GT 1030 2GB Low Profile")) {
            GPU=GPU2;
        }else if(GPUin.equals("PNY Quadro P400 2GB DVI")){
            GPU=GPU3;
        }else if(GPUin.equals("Gainward GeForce GTX 1650 SUPER Pegasus OC")){
            GPU=GPU4;
        }else{
            GPU=0.0;
        }

        if(RAMin.equals("HyperX Fury DDR3 1600MHz 4GB")){
            RAM=RAM1;
        }else if(RAMin.equals("Crucial DDR4 2400MHz 8GB")){
            RAM=RAM2;
        }else if(RAMin.equals("Kingston Value DDR4 3400MHz 16GB")){
            RAM=RAM3;
        }else if(RAMin.equals("HyperX Fury DDR4 2666MHZ 32GB")){
            RAM=RAM3;
        }else{
            RAM=0.0;
        }

        if(hardDriveIn.equals("WD Mobile Black 1TB Harddisk")){
            hardDrive=harddiskL1;
        }else if(hardDriveIn.equals("Seagate Firecuda 2TB")){
            hardDrive=harddiskL2;
        }else if(hardDriveIn.equals("Seagate Barracuda 4TB")){
            hardDrive=harddiskL3;
        }else{
            hardDrive=0.0;
        }

        return CPU+GPU+RAM+hardDrive+calculateExtraEquipment(mouseIn,keyboardIn,monitorIn);
    }

}
