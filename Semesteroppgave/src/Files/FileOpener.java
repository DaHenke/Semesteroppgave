package Files;

import exceptions.InvalidFileEndException;
import exceptions.InvalidPCConfigurationException;
import javafx.stage.FileChooser;
import Builder.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class FileOpener {


    static ArrayList<String> load() throws IOException, InvalidFileEndException {
        FileChooser loadFile = new FileChooser();
        File chosenFile = loadFile.showOpenDialog(null);
        Path filePath = Paths.get(chosenFile.getAbsolutePath());
        fileEnding.file(filePath.toString());
        String fileToString = FilePartReader.loadFile(filePath);
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
            nyPart.setNavn(delNavn);
            nyPart.setPris(delPris);

            newPartRegister.registrerPCDel(type, delNavn, delPris);
        }
        return newPartRegister;
    }
}
