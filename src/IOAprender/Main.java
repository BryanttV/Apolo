package ioaprender;
import java.io.*;
import java.util.*;

public class Main {
    
    public static int GaussSum(int n){
        return (n*(n+1))/2;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\ioaprender\\input3.txt"));
        
        int caso = sc.nextInt();
        
        System.out.println(GaussSum(caso));
    }

}