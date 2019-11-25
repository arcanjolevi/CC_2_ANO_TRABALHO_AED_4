
package dictionary;

import java.util.Arrays;
import reading.*;
import structs.Trie;

/**
 *
 * @author levi
 */
//Classe que representa divionario
public class Dictionary {
    private Trie dictionary;//Atributo para trie
    
    //Construtor
    public Dictionary(){
        this.dictionary = new Trie();
    }
    
     /**
     * Metodo qe iinsere palavras no dicionario
     * Pre-condicao: Nenhuma
     * Pos-condicao: Palavras inseridas, caso validas
     */
    public void insertWords(String fileLocation){
        String[] palavras = Reading.readFile(fileLocation);
        for(String x: palavras)
            this.dictionary.insert(x);
    }
    
     /**
     * Metodo que remove palvras do dicionario
     * Pre-condicao: Nenhuma
     * Pos-condicao: palavras removidas, caso existam
     */
    public void removeWords(String fileLocation){
        String[] palavras = Reading.readFile(fileLocation);
        for(String x: palavras)
            this.dictionary.removeWord(x);
    }
    
     /**
     * Metodo que conslta no dicionario
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
    public String queryWord(String word){
        return this.dictionary.queryWord(word);
    }
    
     /**
     * Metodo que retorna conteudo do diconario
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
    public String getWords(){
        return this.dictionary.getDictionary();
    }
    
     /**
     * Metodo que procura similares
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
    public String similar(String word, int n){
        return this.dictionary.similar(word, n);
    }
    
}
