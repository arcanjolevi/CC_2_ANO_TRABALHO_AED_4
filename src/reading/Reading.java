package reading;

import java.io.*;

/**
 *
 * @author levi
 */
//Classe para leitura de arquivos
public class Reading {
    
     /**
     * Metodo que diz se uma palavra eh valida
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
    public static boolean isValid(String a){
        char[] b = a.toCharArray();
        for(char x:b){
            if(x < 'a')               
                return false;
            if(x > 'z' && x < 'A')                
                return false;
            if(x > 'z')
               return false;              
        }
        return true;               
    }
    
     /**
     * Metodo que le arquivo de palavras
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
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