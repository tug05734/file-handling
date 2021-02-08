/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Rajat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static boolean fileRead;
    static boolean fileWrote;
    static boolean fileAppended;
    
    public static void main(String[] args) {
        File file = new File("test.txt");
        String writeToFileText = "File has been written.";
        String appendToFileText = "File has been appended.";
        
        System.out.println("Writing to file....");
        fileWrote = writeFile(file, "File to be read.");
        if(fileWrote){System.out.println("Wrote to file successfully\n");}
        else{System.out.println("Error while writing file.\n");}
        
        System.out.println("Reading File....\nFile contents:");
        fileRead = readFile(file);
        if(fileRead){System.out.println("\nFile read successfully\n");}
        else{System.out.println("\nError while reading file.\n");}
        
        System.out.println("Writing to file....");
        fileWrote = writeFile(file, writeToFileText);
        if(fileWrote){System.out.println("Wrote to file successfully\n");}
        else{System.out.println("Error while writing file.\n");}
        
        System.out.println("Reading File....\nFile contents:");
        fileRead = readFile(file);
        if(fileRead){System.out.println("\nFile read successfully\n");}
        else{System.out.println("\nError while reading file.\n");}
        
        System.out.println("Appending File....");
        fileRead = appendFile(file, appendToFileText);
        if(fileRead){System.out.println("File appended successfully\n");}
        else{System.out.println("Error while appending file.\n");}
        
        System.out.println("Reading File....\nFile contents:");
        fileRead = readFile(file);
        if(fileRead){System.out.println("\nFile read successfully\n");}
        else{System.out.println("\nError while reading file.\n");}
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
    
    public static boolean writeFile(File fileName, String writeToFile){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(writeToFile);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean appendFile(File fileName, String appendToFile){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(" " + appendToFile);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
