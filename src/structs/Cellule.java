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
public class Cellule {
    private int number;
    private Cellule left, center, right;
    private char c;    
    
    
    public Cellule(){
        this.number = -1;
        this.left   = null;
        this.right  = null;
        this.center = null;
        this.c      = 0;
    }
    
    
    public void show(){
        System.out.println("Cellule: " + this.c + "\nLeft: " + this.left + "\nRight: " + this.right + "\nCenter: " + this.center);
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Cellule getLeft() {
        return left;
    }

    public void setLeft(Cellule left) {
        this.left = left;
    }

    public Cellule getCenter() {
        return center;
    }

    public void setCenter(Cellule center) {
        this.center = center;
    }

    public Cellule getRight() {
        return right;
    }

    public void setRight(Cellule right) {
        this.right = right;
    }
    
    
    
}
