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
    
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Rajat\\Documents\\NetBeansProjects\\file-handling\\FileHandling\\test.txt");
        String writeToFileText = "The shoes had been there for as long as anyone could remember.\nIn fact, it was difficult for anyone to come up with a date they had first appeared.\nIt had seemed they'd always been there and yet they seemed so out of place.\nWhy nobody had removed them was a question that had been asked time and again, but while they all thought it, nobody had ever found the energy to actually do it.\nSo, the shoes remained on the steps, out of place in one sense, but perfectly normal in another.";
        
        System.out.println("Reading File....\nFile contents:\n");
        fileRead = readFile(file);
        if(fileRead){System.out.println("\nFile read successfully");}
        else{System.out.println("\nError while reading file.");}
        
        System.out.println("\n\nWriting to file....\n");
        boolean fileWrote = writeFile(file, writeToFileText);
        if(fileWrote){System.out.println("\nWrote to file successfully");}
        else{System.out.println("\nError while writing file.");}
        
        System.out.println("Reading File....\nFile contents:\n");
        fileRead = readFile(file);
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
}
