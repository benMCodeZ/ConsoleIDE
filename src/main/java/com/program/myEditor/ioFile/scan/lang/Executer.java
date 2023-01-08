package ioFile.scan.lang;

// io package - Objects
import java.io.IOException;

/**
 * 
 * -------------------------------------------------------
 * This program execute the file created
 * 
 * 
 * */
public class Executer extends RuntimeProcess {
    
    // global variables
    private static String command;
    
    /*
       | Java command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void javaGetExec(String fullFile, String dirPath) throws IOException {
        
            command = String.format("java %s", dirPath.concat("/") + fullFile);
            Executer.runTimeProcessing(command);
        
    }
    
    /*
       | Python command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void pythonGetExec(String fullFile, String dirPath) throws IOException {
        
            command = String.format("python %s", dirPath.concat("/") + fullFile);
            Executer.runTimeProcessing(command);
    }
    
    /*
       | PHP command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void phpGetExec(String fullFile, String dirPath) throws IOException {
            
            command = String.format("php %s", dirPath.concat("/") + fullFile);
            Executer.runTimeProcessing(command);
    }
    
    
    
    /*
       | Ruby command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void rubyGetExec(String fullFile, String dirPath) throws IOException {
        
            command = String.format("ruby %s", dirPath.concat("/") + fullFile);
            Executer.runTimeProcessing(command);
        
    }
    
    /*
       | JS command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void jsGetExec(String fullFile, String dirPath) throws IOException {
        
            command = String.format("node %s", dirPath.concat("/") + fullFile);
            Executer.runTimeProcessing(command);
        
    }
    
    /*
       | C command |
    */
    /**
     * 
     * @param fullFile {String} - contains file format
     * @param dirPath {String} - contains file directory path
     * 
     * */
    public static void cGetExec(String fullFile, String dirPath) throws IOException {
        
        String convert = "gcc " + fullFile.concat(" -o ") + fullFile.substring(0, fullFile.length() - 1).concat(".out");
        RuntimeProcess.runTimeProcessing(convert);
        
        command = "./" + fullFile.substring(0, fullFile.length() - 1).concat(".out");
        RuntimeProcess.runTimeProcessing(command);
        
    }
    
}

