package judge;
import java.io.*;
import java.util.Scanner;

class Main {

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("C:\\Apolo\\src\\iofiles\\input20.txt"));
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] numeros = new int[N];
            for (int j = 0; j < N; j++) {
                numeros[j] = sc.nextInt();
            }
            
            int K = sc.nextInt();
            int result = binarySearch(numeros, 0, numeros.length - 1, K);
            if (result == -1) {
                System.out.println("Numero " + K + " no se encuentra en el arreglo");
            } else {
                System.out.println(result);
            }
        }
    }
}