package UtilityJudge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompareAndJudge {

    public static int compareUtil(String idejercicio) {
        if (compareLength(idejercicio) && compareLines(idejercicio)) {
            return 0;
        } else if (!compareLength(idejercicio) && compareLines(idejercicio)) {
            return 1;
        }
        return 2;
    }

    static boolean compareLength(String idejercicio) {
        File file1 = new File(System.getProperty("user.dir") + "\\src\\IOfiles\\" + idejercicio + ".txt");
        File file2 = new File(System.getProperty("user.dir") + "\\src\\IOfiles\\output.txt");
        System.out.println(file1.length());
        System.out.println(file2.length());
        if (file1.length() >= file2.length() - 2L && file1.length() < file2.length() + 2L) {
            return true;
        }
        return false;
    }

    static boolean compareLines(String idejercicio) {
        boolean areEqual = false;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(System.getProperty("user.dir")
                + "\\src\\IOfiles\\" + idejercicio + ".txt"));
                BufferedReader reader2 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\IOfiles\\output.txt"))) {
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            areEqual = true;
            int lineNum = 1;
            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null) {
                    areEqual = false;
                    break;
                } else if (!line1.equals(line2.trim())) {
                    areEqual = false;
                    break;
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }
            if (areEqual) {
                System.out.println("Los dos archivos tienen el mismo contenido.");
            } else {
                System.out.println("los dos archivos difieren. en la linea " + lineNum);
                System.out.println("File1 tiene " + line1 + "\ny File2 tiene " + line2 + " en la linea " + lineNum);
            }
            reader1.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompareAndJudge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompareAndJudge.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areEqual;
    }

}
