
#include <stdio.h> // define header file

int main() {
    
    // name variable type {char array}
    char name[30];
    
    // output
    printf("Enter your name: ");
    
    // user input
    scanf("%s", &name);
    
    // print user input
    printf("Hello %s", name);
    
    return 0; // return value of int
    
}

