package ioFile.scan;

// util package - Objects
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// io package - Objects
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.InputStreamReader;

import ioFile.scan.lang.Executer;

public class Writer {
    
    private final Scanner scan = new Scanner(System.in);
    private File file;
    private final List<String> texts = new ArrayList<String>();
    
    /*
      | Write text |
    */
    /**
     * 
     * @param text {String} - contains text input
     * --------------------------------------------------------
     * Add text in List interface 
     * --------------------------------------------------------
     * 
     * */
    private void writeText(String text) {
         texts.add(text);
         
    }
    
    /*
       | Create file |
    */
    /**
     * 
     * @param filename {String} - contains the name of file
     * @param extension {String} - contains the extension of the file (java, txt, xml, etc...)
     * ------------------------------------------------------------
     * This method will create a file depending on the filename and extension given in the input from the arguments
     * And this input comes from the method named writeFile()
     * ------------------------------------------------------------
     * 
     * */
    private void createFile(String dir, String filename, String extension) throws IOException {
        
        String dirPath = "docs/".concat(dir);
        
        String fullFile = filename.concat(".") + extension;
        file = new File(dirPath);
        file.mkdirs();
        
        file = new File(dirPath.concat("/") + fullFile);
        
        final var fos = new FileOutputStream(file);
        final var bufferWrite = new BufferedWriter(new OutputStreamWriter(fos));
        
        try {
            
            for (String listText : texts) {
                
                bufferWrite.write(listText);
                bufferWrite.newLine();
                
            }
            
            bufferWrite.close();
            System.out.println("File is created");
            
        } catch (IOException e) {
            
            System.out.println("An error was found");
            e.printStackTrace();
            
        }
        
        System.out.println("Enter command 'cnsl - file get execute' if you want to execute the created file, enter anything if not");
        String exeKeyword = "cnsl - file get execute";
        String executiveCommand = scan.nextLine();
        
        boolean isCommandTrue = executiveCommand.toLowerCase().equals(exeKeyword);
        
        String topLine = "-";
        System.out.println(topLine.repeat(30));
        System.out.println("Output: ");
        if (isCommandTrue) {
            execute(fullFile, dirPath);
        } else {
            System.out.println("No execution..");
            return;
        }
    }
    
    /*
       | Executing the created file |
    */
    /**
     * 
     * @param fullFile {String} - contains the file
     * @param dirPath {String} - contains the directory file path
     * --------------------------------------------------------
     * This method execute the file created
     * Warning! the only thing it can execute is a programming file format
     * Use the correct extension to execute the file
     * --------------------------------------------------------
     * 
     * */
    private void execute(String fullFile, String dirPath) throws IOException {
        
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
    
    /*
      | Write file |
    */
    /**
     * 
     * --------------------------------------------------------
     * This method writes the file 
     * And this is where the filename and extension arguments come into play
     * --------------------------------------------------------
     * 
     * */
    public void writeFile() throws IOException {
        
        String filename, extension, dir, text = " ";
        String answer, command = " ";
        
        System.out.print("File directory: ");
        dir = scan.nextLine();
        
        System.out.print("Enter filename: ");
        filename = scan.nextLine(); // name of file created
        
        System.out.print("Enter file extension: ");
        extension = scan.nextLine(); // extension of file created
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("IDE:: CONSOLE");
        
        String fileFormat = String.format("File: %s", filename.concat(".") + extension);
        System.out.println(fileFormat + "\n");
            
            boolean isTextsZero = (texts.size() == 0);
            
            if (isTextsZero) {
                
                boolean isLastIndex = false;
                int list = 1;
                do {
                    
                    String lineNumber = String.valueOf(list).concat("   ");
                
                    System.out.print(lineNumber);
                    text = scan.nextLine();
                    writeText(text);
                    
                    String[] ends = {
                        "//endprogram",
                        "#endprogram",
                        "?>",
                    };
                    
                    for (String end : ends) if (texts.get(list - 1).equals(end)) isLastIndex = true;
                    list++;
                    
                    
                } while (isLastIndex == false);
                
            }
        
        String topLine = "-";
        System.out.println(topLine.repeat(30));
        System.out.println("\nDo you want to create this file?");
        answer = scan.nextLine();
        
        boolean isAnswer = (answer.toLowerCase().equals("yes"));
        
        if (isAnswer) {
            
            // write file keyword
            boolean isKeyWord = (command.toLowerCase().equals("write-io"));
            
            do {
                
                System.out.println("Enter keyword 'write-io' to create the file");
                
                command = scan.nextLine();
                
                isKeyWord = (command.toLowerCase().equals("write-io"));
            
            } while (isKeyWord == false);
            
            
            createFile(dir, filename, extension);
            
        } else {
            
            System.out.println("Then this program will be stopped....");
            System.out.println("Thanks for using");
            return;
        }
    }
    
}
