package ioFile.scan;

import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import ioFile.scan.lang.Executer;
import ioFile.scan.lang.RuntimeProcess;

public class Reader {
    
    public void readFile() throws IOException {
        
        BufferedReader reader;
        String dirLocation, fileIn, command, root;
        
        final List<String> texts = new ArrayList<String>();
        final var scan = new Scanner(System.in);
        
        System.out.print("location file directory: ");
        dirLocation = scan.nextLine();
        
        System.out.print("filename in directory: ");
        fileIn = scan.nextLine();
        
        root = "docs/";
        String fullDirectory = root.concat(dirLocation) + "/";
        
        try {
            
            reader = new BufferedReader(new FileReader(fullDirectory + fileIn));
            String line = reader.readLine();
            
            while (line != null) {
                texts.add(line);
                line = reader.readLine();
            }
            
            reader.close();
            
            
        } catch(IOException e) {
            System.out.println("file reading error!");
            e.printStackTrace();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("IDE:: CONSOLE");
        String fileFormat = String.format("File: %s", fileIn);
        System.out.println(fileFormat);
        
        int lineNumber = 1;
        String formatLine;
        String indent = " ".repeat(4);
        for (String text : texts) {
            
            formatLine = String.valueOf(lineNumber).concat(indent + text);
            System.out.println(formatLine);
            lineNumber++;
        }
        
        String topLine = "-";
        System.out.println(topLine.repeat(30));
        
        System.out.println();
        System.out.println("Execute the file? ");
        System.out.println("Enter 'yes' if you want, 'anything' if not");
        String exeCommand = scan.nextLine();
        
        boolean isExecute = exeCommand.toLowerCase().equals("yes");
        
        if (isExecute) {
            System.out.println();
            System.out.println(topLine.repeat(30));
            System.out.println("Output: ");
            execute(fileIn, root.concat(dirLocation));
        } else {
            System.out.println("file has been read!");
            return;
        }
        
    
    
    }
    
    /**
     * 
     * @param fullFile {String} - contains filename and extension
     * @param dirPath {String} - contains directory path
     * 
     * */
    private static void execute(String fullFile, String dirPath) throws IOException {
                
        if (fullFile.contains(".java")) {
            Executer.javaGetExec(fullFile, dirPath);
        } else if (fullFile.contains(".py")) {
            Executer.pythonGetExec(fullFile, dirPath);
        } else if (fullFile.contains(".php")) {
            Executer.phpGetExec(fullFile, dirPath);
        } else if (fullFile.contains(".rb")) {
            Executer.rubyGetExec(fullFile, dirPath);
        } else if (fullFile.contains(".js")) {
            Executer.jsGetExec(fullFile, dirPath);
        } else if (fullFile.contains(".c")) {
            Executer.cGetExec(fullFile, dirPath);
        }
    }
    
    
}


