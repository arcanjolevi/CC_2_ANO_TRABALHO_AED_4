/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structs;
import static reading.Reading.isValid;
/**
 *
 * @author levi
 */
public class Trie {
    private Cellule node;
    private int number;
    private String buffer;
    
    public Cellule getNode(){
        return this.node;
    }
    
    public Trie(){
        this.node = null;
        this.number = 0;
        this.buffer = "";
    }
    
    public void showAux(Cellule r, String word){
        String aux = word;
        
        if(r != null){
               
            showAux(r.getLeft(), aux);
            
            word += String.valueOf(r.getC());
            if(r.getNumber() != -1)
                System.out.println(word);
            showAux(r.getCenter(), word);                           
            
            showAux(r.getRight(), aux); 
        }           
    }
    
    public String getDictionary(){
        this.buffer = "";
        this.getDictionary(this.node, "");
        String aux = this.buffer;
        this.buffer = "";
        return aux;
    }
    private void getDictionary(Cellule r, String word){
        String aux = word;
        if(r != null){               
            getDictionary(r.getLeft(), aux);           
            
            word += String.valueOf(r.getC());
            if(r.getNumber() != -1)
                this.buffer += word + "\n";
            getDictionary(r.getCenter(), word);                           
            
            getDictionary(r.getRight(), aux); 
        }           
    }
    
    public void show(){
        this.showAux(this.node, "");
    }
    
    public String queryWord(String word){
        return this.queryWord(this.node, word, word);
    }
    
    public String queryWord(Cellule r, String word, String query){
        
        char firstChar = word.charAt(0);
        if(r != null){               
            if(firstChar < r.getC()){
               return queryWord(r.getLeft(), word, query);
            }else if(firstChar > r.getC()){
               return queryWord(r.getRight(), word, query);
            }else{
                if(word.length() > 1){
                    word = word.substring(1);
                    return queryWord(r.getCenter(), word, query);
                }else{
                    showAux(r.getCenter(), query);
                    return "";
                }
                    
            }  
        }
        return "chegou";
    }
    
    public void insert(String word){
        word = word.toLowerCase();
        if(isValid(word)) {
            this.node = this.insertAux(this.node, word);
        } else
            System.err.println("Comtem Caracteres Invalidos");
            
    }
    
    public Cellule insertAux(Cellule r, String word){
        if(word.length() <= 0)
            return r;
        
        char newChar = word.charAt(0);
        
        if(r != null){
            if(newChar < r.getC()){
                r.setLeft(this.insertAux(r.getLeft(), word));
            }else if(newChar > r.getC()){
                r.setRight(this.insertAux(r.getRight(), word));
            }else{
                if(word.length() > 1){
                    word = word.substring(1);
                    r.setCenter(this.insertAux(r.getCenter(), word));
                }else{
                    r.setNumber(this.number);
                    this.number = this.number + 1;
                }
                
            }            
        }else{
            r = new Cellule();
            r.setC(newChar);            
            if(word.length() > 1){
                 word = word.substring(1);
                 r.setCenter(this.insertAux(r.getCenter(), word));
            }else{
                r.setNumber(this.number);
                this.number = this.number + 1;
            }         
        }
        return r;
    }
}
