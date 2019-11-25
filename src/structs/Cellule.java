package structs;

/**
 *
 * @author levi
 */
//Clase que representa o no da uma trie
public class Cellule {
    private int number;//Numero que indica final de palavra
    private Cellule left, center, right;//Referencia para os nos filhos
    private char c;//Char que guarda a letra do no
    
    //Construtor da classe
    public Cellule(){
        this.number = -1;
        this.left   = null;
        this.right  = null;
        this.center = null;
        this.c      = 0;
    }
    
    /**
     * Metodos que imprime os atribus da classe
     * Pre-condicao: Nenhuma
     * Pos-condicao: nenhuma
     */
    public void show(){
        System.out.println("Cellule: " + this.c + "\nLeft: " + this.left + "\nRight: " + this.right + "\nCenter: " + this.center);
    }
    
    //Getter da variavel number
    public int getNumber() {
        return number;
    }

    //Setter da variavel number
    public void setNumber(int number) {
        this.number = number;
    }

    //geter da letra do no
    public char getC() {
        return c;
    }

    //Setter da letra do no
    public void setC(char c) {
        this.c = c;
    }

    //getter do filho da esquerda
    public Cellule getLeft() {
        return left;
    }

    //Getter do filho da direita
    public void setLeft(Cellule left) {
        this.left = left;
    }

    //Getter do filho do meio
    public Cellule getCenter() {
        return center;
    }

    //Setter do filho do meio
    public void setCenter(Cellule center) {
        this.center = center;
    }

    //getter do filho da direita
    public Cellule getRight() {
        return right;
    }

    //Setter do filho da direita
    public void setRight(Cellule right) {
        this.right = right;
    }
    
    
    
}
