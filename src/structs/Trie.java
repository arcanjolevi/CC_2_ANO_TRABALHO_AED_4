/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structs;

/**
 *
 * @author levi
 */
public class Trie {
    Cellule node;
    int number;
    
    public Cellule getNode(){
        return this.node;
    }
    
    public Trie(){
        this.node = null;
        this.number = 0;
    }
    
    public void showCenter(Cellule r, String word){
        String aux = word;
        
        if(r != null){
               
            showCenter(r.getLeft(), aux);
            
            word += String.valueOf(r.getC());
            if(r.getNumber() != -1)
                System.out.println(word);
            showCenter(r.getCenter(), word);                           
            
            showCenter(r.getRight(), aux); 
        }           
    }
    
    public void show(){
        this.showAux(this.node);
    }
    
    public void showAux(Cellule r){
        if(r != null){
            showAux(r.getLeft());
            
            showCenter(r, "");
            
            showAux(r.getRight());
        }        
    }
    
    public void insert(String word){
        word = word.toLowerCase();
        if(word.matches("[^~#@*+%{}<>\\[\\]|\"\\_^]*"))
            this.node = this.insertAux(this.node, word);
        else{
            System.err.println("Comtem Caracteres Invalidos");
        }
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
