// package scanner
import java.util.Scanner;

// Class 
public class Example {
    
    // method
    public static void main(String[] args) {
        
        
        String name; // name variable type {String}
        Scanner input = new Scanner(System.in);
        
        // output
        System.out.print("Enter your name: ");
        name = input.nextLine(); // user input
        
        // print user input
        System.out.println("Hello" + name);
        
    }
}

