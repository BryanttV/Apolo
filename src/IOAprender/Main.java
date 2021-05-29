package ioaprender;
import java.io.*;
import java.util.Scanner;

class Main {

    static int bubbleSort(int[] vector) {
        int swaps = 0;
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\ioaprender\\input1.txt"));
        int casos = sc.nextInt();
        
        for (int i = 0; i < casos; i++) {
            
            int nro_trains = sc.nextInt();
            int[] trains = new int[nro_trains];
            
            for (int j = 0; j < nro_trains; j++) {
                trains[j] = sc.nextInt();
            }
            
            System.out.println("Optimal train swapping takes " + bubbleSort(trains) + " swaps.");
        }
    }
}