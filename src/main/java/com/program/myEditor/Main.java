package com.program.myEditor;

// scan package - Objects
import ioFile.scan.Writer;
import ioFile.scan.Reader;
import ioFile.scan.Deleter;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        final var scan = new Scanner(System.in);
        
        final var writer = new Writer(); // from Writer class
        final var reader = new Reader(); // from Reader class
        final var deleter = new Deleter(); // from Deleter class
        
        String input; // userInput
        
        // commands list
        String[] commands = {
            "cnsl - create new-file",
            "cnsl - read-file",
            "cnsl - del-source",
        };
        
        input = scan.nextLine();
        
        if (input.toLowerCase().equals(commands[0])) {
            writer.writeFile();
        } else if (input.toLowerCase().equals(commands[1])) {
            reader.readFile();
        } else if (input.toLowerCase().equals(commands[2])) {
            deleter.deleteFile();
        }
        
    }
}





