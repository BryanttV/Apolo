package ioeditor;
import java.io.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\ioeditor\\input.txt"));

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(a+b);
	}
}