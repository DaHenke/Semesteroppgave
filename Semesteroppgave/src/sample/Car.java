package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Car {
    private SimpleStringProperty brand, model, supplier;
    private SimpleIntegerProperty kilometers;

    public Car(String brand, String model, String supplier, int kilometers){
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.supplier = new SimpleStringProperty(supplier);
        this.kilometers = new SimpleIntegerProperty(kilometers);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getSupplier() {
        return supplier.get();
    }

    public SimpleStringProperty supplierProperty() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

    public int getKilometers() {
        return kilometers.get();
    }

    public SimpleIntegerProperty kilometersProperty() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers.set(kilometers);
    }
}
