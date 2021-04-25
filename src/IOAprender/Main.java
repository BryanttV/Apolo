package ioaprender;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void Fibonacci(int n){
        int a = 0 , b = 1, suma = 0;
        for (int i = 0; i < n; i++) {
            
            suma = a + b;
            
            System.out.println(suma);
            
            a = b;
            b = suma; 
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(new File(System.getProperty("user.dir") + "\\ioaprender\\input3.txt"));
        
        int caso = lector.nextInt();
        
        Fibonacci(caso);
    }

}
