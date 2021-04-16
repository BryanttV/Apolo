package judge;
import java.io.*;
// Pega aquí tu código...
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\IOFiles\\IN1.txt"));
        int casos = sc.nextInt();
        for (int i = 0; i < casos; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a+b) +" ");
        }
    }
}