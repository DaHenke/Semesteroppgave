package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class ButtonMethods {

    public static void calculatePrice(TableView<Part> tv, TableColumn<Part, Double> tvClmnPrice, Label lblSum){
        double sum = 0;

        for(Part price : tv.getItems()){
            double pris = tvClmnPrice.getCellObservableValue(price).getValue();
            sum+=pris;
        }
        lblSum.setText(String.valueOf(sum));
    }

    public static void createPackage(Label lblSum,PartRegister newPartRegister,TableView tblPCdel,
                                     PackageRegister newPackageRegister,TableView tblPackage) throws IOException, ClassNotFoundException {
        double price = Double.parseDouble(lblSum.getText());

        ArrayList<String> array = new ArrayList<>();
        for(Part p : newPartRegister.getArray()){
            System.out.println(p.getDelNavn());
            array.add(p.getDelNavn());
        }
        PC pc = new PC(null,null,null,null,null,null,null,null,null,null);
        if(array.size()==8){
            pc = new PC(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4), array.get(5), array.get(6), array.get(7), "-","-");
        }else if(array.size()==9){
            pc = new PC(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4), array.get(5), array.get(6), array.get(7), array.get(8), "-");
        }else if(array.size()==10) {
            pc = new PC(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4), array.get(5), array.get(6), array.get(7), array.get(8), array.get(9));
        }
        Package newPackage = new Package(pc,price);
        newPackage.setPackagePrice(price);

        tblPCdel.setItems(newPartRegister.getArray());
        newPackageRegister.array = newPackageRegister.loadData(newPackageRegister.path);
        newPackageRegister.registrerPackage(pc,price);
        newPackageRegister.save(newPackageRegister.array,newPackageRegister.path);
        tblPackage.setItems(newPackageRegister.getArray());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kjøpt");
        alert.setHeaderText("Takk for handelen!");
        alert.setContentText("Produktet er kjøpt.");
        alert.showAndWait();
    }

    public static void saveDetails(TableView<Package> tblPackage,DetailsRegister newNewDetails) throws IOException{
        ObservableList<Package> nylist = tblPackage.getSelectionModel().getSelectedItems();

        PC nyPc = new PC(null,null,null,null,null,null,null,null,null,null);

        for (Package pack: nylist) {
            nyPc=pack.getPackageName();
        }

        newNewDetails.addToPackage(new Part("Cabinet",nyPc.getCABINET(),0.0));
        newNewDetails.addToPackage(new Part("CPU",nyPc.getCPU(),0.0));
        newNewDetails.addToPackage(new Part("GPU",nyPc.getGPU1(),0.0));
        newNewDetails.addToPackage(new Part("Memory",nyPc.getRAM(),0.0));
        newNewDetails.addToPackage(new Part("HDD",nyPc.getHDD1(),0.0));
        newNewDetails.addToPackage(new Part("Monitor",nyPc.getMONITOR(),0.0));
        newNewDetails.addToPackage(new Part("Mouse",nyPc.getMOUSE(),0.0));
        newNewDetails.addToPackage(new Part("Keyboard",nyPc.getKEYBOARD(),0.0));
        newNewDetails.addToPackage(new Part("GPU",nyPc.getGPU2(),0.0));
        newNewDetails.addToPackage(new Part("HDD",nyPc.getHDD2(),0.0));

        newNewDetails.save(newNewDetails.array,DetailsRegister.path);
        newNewDetails.removeAll();
    }
}
