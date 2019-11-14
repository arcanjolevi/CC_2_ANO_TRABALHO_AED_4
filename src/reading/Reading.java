/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reading;

import java.io.*;

/**
 *
 * @author levi
 */
public class Reading {
    public static String[] readFile(String locationString){
        String content = "";
        String line;
        String separator = ";";
        
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
            System.err.println("Erro na leitura de arquivo");
        }
        
        
        return content.split(separator);
    }
}