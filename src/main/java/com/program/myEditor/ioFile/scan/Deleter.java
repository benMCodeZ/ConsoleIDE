package ioFile.scan;

// util package - Objects
import java.util.Scanner;
import java.util.Arrays;

import java.io.IOException;
import ioFile.scan.lang.RuntimeProcess;

/**
 * 
 * --------------------------------------------------------
 * This object deletes the file and the directory
 * By command 'del < filename > + < dir >' / 'del < dir >'
 * --------------------------------------------------------
 * 
 * */
public class Deleter {
    
    public static void deleteFile() throws IOException {
        
        final var scan = new Scanner(System.in);
        
        System.out.println("Do you want to delete a file or directory? ");
        System.out.println();
        System.out.println("Enter command to delete: ");
        System.out.println("-- command to delete file: 'del < filename > + < dir >' use this command");
        System.out.println("-- command to delete directory: 'del < dir >'");
        
        String[] readTexts = null;
        String command = scan.nextLine();
        String root = "docs/";
        String getDelete;
        
        readTexts = command.split(" ");
        
        // delete file in directory
        if (command.contains("filename") && command.contains("dir")) {
            if (readTexts[0].equals("del")) {
                getDelete = String.format("rm %s", root.concat(readTexts[6]) + "/" + readTexts[2]);
                RuntimeProcess.runTimeProcessing(getDelete);
            }
            
        // delete directory
        } else if (!command.contains("filename")) {
            if (readTexts[0].equals("del")) {
                getDelete = String.format("rm -r %s", root.concat(readTexts[2]));
                RuntimeProcess.runTimeProcessing(getDelete);
            }
        }
        
    }
}

