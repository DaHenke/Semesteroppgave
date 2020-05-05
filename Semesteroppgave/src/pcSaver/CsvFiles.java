package pcSaver;

import exceptions.InvalidFileEndException;
import exceptions.InvalidPCConfigurationException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import sample.*;
import sample.Package;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvFiles {
    public static void save(ObservableList<Package> packList) throws InvalidFileEndException, IOException {
        String formatted = PCFormatter.formatParts(packList);
        try{
            Path PartPath = Paths.get("Semesteroppgave\\src\\sample\\Package.csv");
            fileEnding.file(PartPath.toString());
            FileStringWriter.writeString(PartPath,formatted);
        } catch (InvalidFileEndException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setContentText("Noe gikk galt: "+e.getMessage());
            alert.showAndWait();
            System.out.println("Noe gikk galt: "+e.getMessage());
        }
    }

    static ArrayList<String> load() throws IOException, InvalidFileEndException {

        Path PartPath = Paths.get("Semesteroppgave\\src\\sample\\Package.csv");
        fileEnding.file(PartPath.toString());
        String fileToString = FilePartReader.loadFile(PartPath);
        Scanner reader = new Scanner(fileToString);
        ArrayList<String> lines = new ArrayList<>();
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();
        return lines;
    }
    public static PartRegister read() throws InvalidFileEndException, IOException, InvalidPCConfigurationException {
        ArrayList<String> lines = load();
        PartRegister newPartRegister = new PartRegister();
        for (String s : lines) {
            String[] part = s.split(";");

            Part nyPart = new Part(null, null, 0);
            String type = part[0];
            String delNavn = part[1];
            double delPris = Double.parseDouble(part[2]);

            CheckPartType.checkType(type);

            nyPart.setType(type);
            nyPart.setDelNavn(delNavn);
            nyPart.setDelPris(delPris);

            newPartRegister.registrerPCDel(type, delNavn, delPris);
        }
        return newPartRegister;
    }
}
