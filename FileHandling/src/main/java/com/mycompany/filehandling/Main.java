/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author Rajat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Rajat\\Documents\\NetBeansProjects\\file-handling\\FileHandling\\test.txt");
        System.out.println("Reading File....\nFile contents:\n");
        boolean fileRead = readFile(file);
        if(fileRead){System.out.println("\nFile read successfully");}
        else{System.out.println("\nError while reading file.");}
        }

    
    
    public static boolean readFile(File fileName){
        try{
            Stream<String> stream = Files.lines(Paths.get(fileName.getPath()));
            stream.forEach(System.out::println);
            stream.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }  
}
