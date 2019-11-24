/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Arrays;
import reading.*;
import structs.Trie;
/**
 *
 * @author levi
 */
public class Dictionary {
    private Trie dictionary;
    
    public Dictionary(){
        this.dictionary = new Trie();
    }
    
    public void insertWords(String fileLocation){
        String[] palavras = Reading.readFile(fileLocation);
        for(String x: palavras)
            this.dictionary.insert(x);
    }
    
    public void removeWords(String fileLocation){
        String[] palavras = Reading.readFile(fileLocation);
        for(String x: palavras)
            this.dictionary.removeWord(x);
    }
    
    public String queryWord(String word){
        return this.dictionary.queryWord(word);
    }
    
    public String getWord(){
        return this.dictionary.getDictionary();
    }
    
}
