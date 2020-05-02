package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.ArrayList;

import static sample.ControllerSecondPage.newPart;

public class AddElementComboBox {
    public static void addDefaultParts(ComboBox cbCPU, ComboBox cbGPU, ComboBox cbRAM, ComboBox cbHDD, ComboBox cbMon, ComboBox cbMou, ComboBox cbKB, ComboBox cbCab, ComboBox cbType) {
        cbCPU.getItems().addAll(DefaultParts.CPU1,
                DefaultParts.CPU2,
                DefaultParts.CPU3,
                DefaultParts.CPU4);

        cbGPU.getItems().addAll(DefaultParts.GPU1,
                DefaultParts.GPU2,
                DefaultParts.GPU3,
                DefaultParts.GPU4);

        cbRAM.getItems().addAll(DefaultParts.RAM1,
                DefaultParts.RAM2,
                DefaultParts.RAM3,
                DefaultParts.RAM4);

        cbHDD.getItems().addAll(DefaultParts.HDD1,
                DefaultParts.HDD2,
                DefaultParts.HDD3,
                DefaultParts.HDD4);

        cbMon.getItems().addAll(DefaultParts.MON1,
                DefaultParts.MON2,
                DefaultParts.MON3,
                DefaultParts.MON4);

        cbMou.getItems().addAll(DefaultParts.MOU1,
                DefaultParts.MOU2,
                DefaultParts.MOU3,
                DefaultParts.MOU4);

        cbKB.getItems().addAll(DefaultParts.KB1,
                DefaultParts.KB2,
                DefaultParts.KB3,
                DefaultParts.KB4);

        cbCab.getItems().addAll(DefaultParts.CAB1,
                DefaultParts.CAB2,
                DefaultParts.CAB3);

        cbType.getItems().addAll("Type", "Part", "Price");
    }

    public static void addNewParts(ComboBox cbCPU, ComboBox cbGPU, ComboBox cbRAM, ComboBox cbHDD, ComboBox cbMon, ComboBox cbMou, ComboBox cbKB, ComboBox cbCab) {
        try {
            ObservableList<Part> nyParts = newPart.loadNewParts(newPart.Path);
            ArrayList<Part> arrayParts = new ArrayList<>(nyParts);
            for (Part p : arrayParts) {
                if (CheckPartType.checkTypeCB(p.Type).matches("CPU")) {
                    cbCPU.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("GPU")) {
                    cbGPU.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("Memory")) {
                    cbRAM.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("HDD")) {
                    cbHDD.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("Monitor")) {
                    cbMon.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("Mouse")) {
                    cbMou.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("Keyboard")) {
                    cbKB.getItems().add(p);
                } else if (CheckPartType.checkTypeCB(p.Type).matches("Cabinet")) {
                    cbCab.getItems().add(p);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
