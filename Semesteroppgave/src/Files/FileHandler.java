package Files;
/*
import javafx.stage.Stage;
import sample.FileOpener;
import sample.PartRegister;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    private enum DialogMode{Opgen, Save}

    static void saveFile(Stage stage, PartRegister register){
        File selectedFile = getFileFromFileChooser(DialogMode.Save, stage);

        if(selectedFile != null){
            String fileExt = getFileExt(selectedFile);
            File saver = null;

            switch (fileExt){
                case ".txt" : saver = new FileSaverTxt(); break;
                case ".jobj" : saver = new FileSaverJobj(); break;
                default: ErrorBox.showErrorDialog("Du kan bare lagre til endten txt eller jobj filer.");
            }

            if(saver != null){
                try {
                    saver.save(register,selectedFile.toPath());
                    ErrorBox.showSuccessDialog("Din bestilling ble sendt!");
                }catch(IOException e){
                    ErrorBox.showErrorDialog("Vi kunne ikke ta imot din bestilling grunnet: "+e.getMessage());
                }
            }
        }
    }
    static void openFile(Stage stage, PartRegister register){
        File selectedFile = getFileFromFileChooser(DialogMode.Opgen, stage);

        if(selectedFile != null){
            String fileExt = getFileExt(selectedFile);
            FileOpener opener = null;

            switch(fileExt){
                case ".txt" : opener = new FileOpenertxt();break;
            }
        }
    }
}


 */