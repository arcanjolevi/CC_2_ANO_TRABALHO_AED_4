/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structs;
import org.w3c.dom.css.Counter;
import static reading.Reading.isValid;
/**
 *
 * @author levi
 */
public class Trie {
    private Cellule node;
    private int number;
    private String buffer;
    private int counter;
    
    public Cellule getNode(){
        return this.node;
    }
    
    public Trie(){
        this.node = null;
        this.number = 0;
        this.buffer = "";
        this.counter = 0;
        
    }
    
    public int countWords(){
        this.counter = 0;
        this.countWords(this.node);
        return this.counter;
    }
    
    private void countWords(Cellule r){
        if(r != null){
            countWords(r.getLeft());
            countWords(r.getCenter());
            countWords(r.getRight());
            if(r.getNumber() != -1)
                this.counter = this.counter + 1;
        }
    }
    
    public void removeWord(String word){
        word = word.toLowerCase();
        if(isValid(word)) {
            this.node = this.removeWord(this.node, word);
        } else
            System.out.println("Comtem Caracteres Invalidos");
        
    }
    
    private boolean checkSoonsNull(Cellule r){
       return (r.getLeft() == null && r.getCenter() == null && r.getLeft() == null);       
    }
    
    private void setMinimum(Cellule r, Cellule minimum){
        if(r.getLeft() == null)
            r.setLeft(minimum);
        else
            setMinimum(r.getLeft(), minimum);
    }
    
    private void setMaximum(Cellule r, Cellule max){
        if(r.getRight() == null)
            r.setRight(max);
        else
            setMaximum(r.getRight(), max);
    }
    
    private Cellule removeWord(Cellule r, String word){
        if(r != null){
            if(word.charAt(0) < r.getC()){
                r.setLeft(this.removeWord(r.getLeft(), word));
            }else if(word.charAt(0) > r.getC()){
                r.setRight(this.removeWord(r.getRight(), word));
            }else{
                if(word.length() > 1){
                    r.setCenter(this.removeWord(r.getCenter(), word.substring(1)));                    
                }else if(r.getNumber() != -1){                    
                    if(r.getCenter() != null){
                       r.setNumber(-1);
                    }else{
                        return null;
                    }
                }
                if(r.getNumber() == -1){
                    if(r.getCenter() == null){
                        if(r.getRight() != null){
                            setMinimum(r.getRight(), r.getLeft());
                            return r.getRight();                    
                        }else{
                            return r.getLeft();
                        }
                    }  
                }
            }                
        }
        return r;
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
    
    
    
    private void getDictionaryLimit(Cellule r, String word){
        String aux = word;
        if(r != null && this.counter < 10){               
            getDictionaryLimit(r.getLeft(), aux);           
            
            word += String.valueOf(r.getC());
            if(r.getNumber() != -1){
                this.buffer += word + "\n";
                this.counter ++;
            }
                
            getDictionaryLimit(r.getCenter(), word);                           
            
            getDictionaryLimit(r.getRight(), aux); 
        }           
    }
    
    public void show(){
        this.showAux(this.node, "");
    }
    
    public String queryWord(String word){
        this.buffer = "";
        String aux;
        this.queryWord(this.node, word, word);
        aux = this.buffer + "\n";
        this.buffer = "";
        return aux;
    }
    
    private void queryWord(Cellule r, String word, String query){
        
        char firstChar = word.charAt(0);
        if(r != null){               
            if(firstChar < r.getC()){
               queryWord(r.getLeft(), word, query);
            }else if(firstChar > r.getC()){
               queryWord(r.getRight(), word, query);
            }else{
                if(word.length() > 1){
                    word = word.substring(1);
                    queryWord(r.getCenter(), word, query);
                }else{
                    this.counter = 0;
                    getDictionaryLimit(r.getCenter(), query);
                }                    
            }  
        }
    }
    
    public void insert(String word){
        word = word.toLowerCase();
        if(isValid(word)) {
            this.node = this.insertAux(this.node, word);
        } else
            System.out.println("Comtem Caracteres Invalidos");
            
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
    
    public String similar(String word, int n){
        this.buffer = "";
        if(n > 3)
            n = 3;
        similar(this.node, word, "", n);
        String aux = this.buffer;
        this.buffer = "";
        return aux;
    }
    
    private void similar(Cellule r, String word, String similar, int different){
        
        if(r != null && different >= 0){
            similar(r.getLeft(), word, similar, different);
            if(word.length() > 1){
                if(word.charAt(0) == r.getC())
                    similar(r.getCenter(), word.substring(1), similar + r.getC(), different);
                else
                    similar(r.getCenter(), word.substring(1), similar + r.getC(), different - 1);
            }else{
                
                if(word.charAt(0) == r.getC() && r.getNumber() != -1){
                    this.buffer += similar + r.getC() + "\n";
                    similar(r.getCenter(), word, similar + r.getC(), different);
                }else{
                    if(r.getNumber() != -1 && different > 0)
                        this.buffer += similar + r.getC() + "\n";
                    similar(r.getCenter(), word, similar + r.getC(), different - 1);
                }
                
            }
            
            similar(r.getRight(), word, similar, different);            
        }
    }
}
