package judge;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\iofiles\\input19.txt"));
        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {

            int len = sc.nextInt();
            int[] numeros = new int[len];

            for (int j = 0; j < len; j++) {
                numeros[j] = sc.nextInt();
            }

            Arrays.sort(numeros);
            System.out.println(numeros[0] + numeros[1]);
        }
    }
}