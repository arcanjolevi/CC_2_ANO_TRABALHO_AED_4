package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import reading.*;
/**
 *
 * @author levi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] words = Reading.readFile("/home/levi/NetBeansProjects/Trabalho4AED/arquivo.txt");
        for(String x:words)
            System.err.println(x);
        
    }
    
}
