package judge;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\iofiles\\input5.txt"));

        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {
            int a = sc.nextInt();

            String op = sc.next();

            int b = sc.nextInt();

            if (op.equals(">")) {
                System.out.println("Case " + (i + 1) + ": " + (a > b));
            } else if (op.equals("<")) {
                System.out.println("Case " + (i + 1) + ": " + (a < b));
            } else if (op.equals(">=")) {
                System.out.println("Case " + (i + 1) + ": " + (a >= b));
            } else if (op.equals("<=")) {
                System.out.println("Case " + (i + 1) + ": " + (a <= b));
            } else if (op.equals("==")) {
                System.out.println("Case " + (i + 1) + ": " + (a == b));
            } else if (op.equals("!=")) {
                System.out.println("Case " + (i + 1) + ": " + (a != b));
            }
        }
    }
}