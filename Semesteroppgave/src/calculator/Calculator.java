package calculator;

import javafx.beans.property.SimpleDoubleProperty;
import static calculator.priceList.*;

public class Calculator {
    private static Double CPU, GPU, RAM, hardDrive, mouse, keyboard, monitor;

    public static double calculateExtraEquipment(String mouseIn, String keyboardIn, String monitorIn){
        if(mouseIn=="Logitech M90 Mus"){
            mouse=mouse1;
        }else if(mouseIn=="Microsoft Mobile Mouse 3600"){
            mouse=mouse2;
        }else if(mouseIn=="Surface ARC mus"){
            mouse=mouse3;
        }else if(mouseIn=="Logitech MX Master3 Adv trådløs"){
            mouse=mouse4;
        }else{
            mouse=0.0;
        }

        if(keyboardIn=="Microsoft Wired Keyboard 600"){
            keyboard=keyboard1;
        }else if(keyboardIn=="Logitech K400 Plus Trådløs Tastatur"){
            keyboard=keyboard2;
        }else if(keyboardIn=="Kanex MultiSync Premium Slim Keyboard"){
            keyboard=keyboard3;
        }else if(keyboardIn=="Logitech ERGO K860 Trådløs Tastatur"){
            keyboard=keyboard4;
        }else{
            keyboard=0.0;
        }

        if(monitorIn=="Acer 24 skjerm KA242Y"){
            monitor=monitor1;
        }else if(monitorIn=="Samsung 24 skjerm S24E450F"){
            monitor=monitor2;
        }else if(monitorIn=="Acer 27 skjerm KA272"){
            monitor=monitor3;
        }else if(monitorIn=="Samsung 28 4K LED FreeSync U28E570D"){
            monitor=monitor4;
        }else{
            monitor=0.0;
        }

        return mouse+keyboard+monitor;
    }

    public static double calculateDesktop(String  CPUin, String GPUin, String RAMin, String hardDriveIn,String mouseIn, String keyboardIn, String monitorIn){
        if(CPUin=="AMD Athlon 3000G"){
            CPU=CPU1;
        }else if(CPUin=="Gigabyte GeForce GT 1030 2GB Low Profile"){
            CPU=CPU2;
        }else if(CPUin=="PNY Quadro P400 2GB DVI"){
            CPU=CPU3;
        }else if(CPUin=="Gainward GeForce GTX 1650 SUPER Pegasus OC"){
            CPU=CPU4;
        }else{
            CPU = 0.0;
        }

        if(GPUin=="ASUS GeForce GT710 1GB"){
            GPU=GPU1;
        }else if(GPUin=="Gigabyte GeForce GT 1030 2GB Low Profile") {
            GPU=GPU2;
        }else if(GPUin=="PNY Quadro P400 2GB DVI"){
            GPU=GPU3;
        }else if(GPUin=="Gainward GeForce GTX 1650 SUPER Pegasus OC"){
            GPU=GPU4;
        }else{
            GPU=0.0;
        }

        if(RAMin=="HyperX Fury DDR3 1600MHz 4GB"){
            RAM=RAM1;
        }else if(RAMin=="Crucial DDR4 2400MHz 8GB"){
            RAM=RAM2;
        }else if(RAMin=="Kingston Value DDR4 3400MHz 16GB"){
            RAM=RAM3;
        }else if(RAMin=="HyperX Fury DDR4 2666MHZ 32GB"){
            RAM=RAM3;
        }else{
            RAM=0.0;
        }

        if(hardDriveIn=="WD Mobile Black 1TB Harddisk"){
            hardDrive=harddiskD1;
        }else if(hardDriveIn=="Seagate Firecuda 2TB"){
            hardDrive=harddiskD2;
        }else if(hardDriveIn=="Seagate Barracuda 4TB"){
            hardDrive=harddiskD3;
        }else{
            hardDrive=0.0;
        }

        return CPU+GPU+RAM+hardDrive+calculateExtraEquipment(mouseIn,keyboardIn,monitorIn);
    }

    public static double calculateLaptop(String  CPUin, String GPUin, String RAMin, String hardDriveIn,String mouseIn, String keyboardIn, String monitorIn){
        if(CPUin=="ADM Athlon 3000G"){
            CPU=CPU1;
        }else if(CPUin=="Gigabyte GeForce GT 1030 2GB Low Profile"){
            CPU=CPU2;
        }else if(CPUin=="PNY Quadro P400 2GB DVI"){
            CPU=CPU3;
        }else if(CPUin=="Gainward GeForce GTX 1650 SUPER Pegasus OC"){
            CPU=CPU4;
        }else{
            CPU = 0.0;
        }

        if(GPUin=="ASUS GeForce GT710 1GB"){
            GPU=GPU1;
        }else if(GPUin=="Gigabyte GeForce GT 1030 2GB Low Profile") {
            GPU=GPU2;
        }else if(GPUin=="PNY Quadro P400 2GB DVI"){
            GPU=GPU3;
        }else if(GPUin=="Gainward GeForce GTX 1650 SUPER Pegasus OC"){
            GPU=GPU4;
        }else{
            GPU=0.0;
        }

        if(RAMin=="HyperX Fury DDR3 1600MHz 4GB"){
            RAM=RAM1;
        }else if(RAMin=="Crucial DDR4 2400MHz 8GB"){
            RAM=RAM2;
        }else if(RAMin=="Kingston Value DDR4 3400MHz 16GB"){
            RAM=RAM3;
        }else if(RAMin=="HyperX Fury DDR4 2666MHZ 32GB"){
            RAM=RAM3;
        }else{
            RAM=0.0;
        }

        if(hardDriveIn=="WD Mobile Black 1TB Harddisk"){
            hardDrive=harddiskL1;
        }else if(hardDriveIn=="Seagate Firecuda 2TB"){
            hardDrive=harddiskL2;
        }else if(hardDriveIn=="Seagate Barracuda 4TB"){
            hardDrive=harddiskL3;
        }else{
            hardDrive=0.0;
        }

        return CPU+GPU+RAM+hardDrive+calculateExtraEquipment(mouseIn,keyboardIn,monitorIn);
    }

}
