package ioeditor;
import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\ioeditor\\input.txt"));
		long a = sc.nextLong();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
	}
}