package ioFile.scan.lang;

// io package - Objects
import java.io.IOException;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RuntimeProcess {
    
    // global variables 
    private static String line;
    private static String result = " ";
    private static Runtime runtime;
    private static Process process;
    private static DataInputStream in;
    private static BufferedReader bufferRead;
    
    /*
      | Runtime Processor |
    */
    
    /**
     * 
     * @param command {String} - contains the commandline to execute the file
     * -------------------------------------------------------------
     * This method print the command to the terminal
     * And run the code execute it!
     * -------------------------------------------------------------
     * 
     * */
    public static void runTimeProcessing(String command_keyword) {
        
        try {
            
            runtime = Runtime.getRuntime();
            process = runtime.exec(command_keyword);
            in = new DataInputStream(process.getInputStream());
            bufferRead = new BufferedReader(new InputStreamReader(in));
                
            while ((line = bufferRead.readLine()) != null) {
                result += line;
            }
            
            
        } catch (IOException e) {
            
            System.out.println("runtime processing error!");
            e.printStackTrace();
        }
        
        System.out.println(result);
        
        
    }
    
}