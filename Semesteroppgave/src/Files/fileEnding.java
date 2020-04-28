package Files;

import exceptions.InvalidFileEndException;

public class fileEnding {
    public static String file(String filePath) throws InvalidFileEndException {
        String end = "";
        String[] split = filePath.split("\\.");
        for(int i = 1 ; !split[i].equals("") ; i++){
            if(split[i].equals("txt") || split[i].equals("jobj") || split[i].equals("xls")){
                end = split[i];
                break;
            }else{
                throw new InvalidFileEndException("Filtypen "+split[i]+" støttes ikke");
            }
        }
        return end;
    }
}
