package judge;
import java.io.*;

import java.util.Scanner;

public class Main {
   

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\iofiles\\input3.txt"));
        int num_estalagmitas = sc.nextInt();
        boolean apolo = true;
        for (int i = 0; i < num_estalagmitas; i++) {
            int altura = sc.nextInt();
            
            if (altura <= 3 || altura > 8) {
                apolo = false;
            }
        }
        
        if (apolo) {
            System.out.println("Si sale");
        }else{
            System.out.println("No sale");
        }
    }

}