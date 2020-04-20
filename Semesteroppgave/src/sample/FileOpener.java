package sample;

import exceptions.InvalidFileEndException;
import exceptions.InvalidPCConfigurationException;
import javafx.stage.FileChooser;

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

    public static Register read() throws InvalidFileEndException, IOException, InvalidPCConfigurationException {
        ArrayList<String> lines = load();
        Register newRegister = new Register();
        for (String s : lines) {
            String[] part = s.split(";");

            PC nyPC = new PC(null, null, 0);
            String type = part[0];
            String delNavn = part[1];
            double delPris = Double.parseDouble(part[2]);

            CheckPartType.checkType(type);
            nyPC.setType(type);
            nyPC.setDelNavn(delNavn);
            nyPC.setDelPris(delPris);

            newRegister.registrerPCDel(type, delNavn, delPris);

        }
        return newRegister;
    }
}
