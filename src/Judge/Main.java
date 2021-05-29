package judge;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\iofiles\\input16.txt"));

    Queue <String> nombres = new LinkedList<>();
    int numero = sc.nextInt();
    
    for(int i = 0; i < numero; i++){
        nombres.offer(sc.next());
    }

    int cont = 1;
    while(!nombres.isEmpty()){
        System.out.println("Puesto "+ cont + ": "+ nombres.poll());
        cont++;
    }
  }
}