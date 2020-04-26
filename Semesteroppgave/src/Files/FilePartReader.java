package Files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Path;
import java.io.FileReader;

public class FilePartReader {
    public static String loadFile(Path filePath) throws IOException{
        FileReader readFile = new FileReader(String.valueOf(filePath));
        BufferedReader br = new BufferedReader(readFile);
        StringBuffer sbr = new StringBuffer();
        String fileLoader;
        while((fileLoader = br.readLine()) != null){
            sbr.append(fileLoader+"\n");
        }
        readFile.close();
        return sbr.toString();
    }
}
