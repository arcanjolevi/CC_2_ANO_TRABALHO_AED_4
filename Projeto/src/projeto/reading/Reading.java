package projeto.reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author levi
 */
public class Reading {
    public static String readFile(String locationString){
        String content = "";
        String line;
        String separator = "$";
        try {
            File file = new File(locationString);
            FileReader fileReader = new FileReader(file);
            BufferedReader fileBuffer = new BufferedReader(fileReader);
            
            line = fileBuffer.readLine();
            while(line != null){  
                content += line;
                content += separator;
                line = fileBuffer.readLine();                    
            }            
        } catch (IOException e) {
            System.err.println("Erro na Leitura de Arquivo");
        }
        return content;
    }
}
